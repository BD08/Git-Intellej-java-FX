/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author AsusX450J
 */
public abstract class BD08EntytyFrameWork<E>{
    private String tableName;
    private Connection connection;
    private Statement statement;
    
    private boolean _isChange;
    
    protected List<E> DataList;
    protected ResultSet resultSet;
    
    protected List<ColoumnValue> dataRow;
    
    private List<filterTable> filterRow;
    
    public BD08EntytyFrameWork(String tableName,Connection connection) {
        try{
            this.connection=connection;
            statement=connection.createStatement();
            _isChange=true;
            this.tableName=tableName;
            dataRow = new ArrayList<>();
            filterRow = new ArrayList<>();
        }catch(Exception e){
            System.out.print(e);
        }
        DataList = new ArrayList<>();
    }
    
    protected abstract void setDataList() throws Exception;
    
    protected abstract void newRowsIdPlot(E e,Object o);
    
    void addDefaultFilter (filterTable coloumnValue) {
        this.filterRow.add(coloumnValue);
    }
    
    public List<E> getListDataFromDB(){
        try{
            if(_isChange){
                DataList.clear();
                String sqlCode="SELECT * FROM "+ tableName;
                if(filterRow.size()>0){
                    for(int i=0;i<filterRow.size();i++){
                        if(i == 0) {
                            sqlCode+=" WHERE ";
                        }
                        sqlCode+=" "+filterRow.get(i).ColoumnName+" "+filterRow.get(i).FilterParameter+" "+filterRow.get(i).Value;
                    }
                }
                resultSet=statement.executeQuery(sqlCode);
                setDataList();
                _isChange=false;
            }
        }catch(Exception e){
            System.out.print(tableName+" Get Data Error : "+e);
        }
        return DataList;
    }
    
    public Stream<E> getStream () {
        return this.getListDataFromDB().stream();
    }
    
    /**
     * Untuk menambahkan data pada database dan row
     * @param e  Class Data yang sudah di inputs
     */
    public E addRow (E e) throws Exception {
        String SqlAddRow=null;
        try{            
            DataList.add(e);
            CheckColoumnPlot(e);
            SqlAddRow="Insert INTO "+tableName+" SET ";
            for(int i=0;i<dataRow.size();i++){
                if(!dataRow.get(i).isPrimary
                        &&dataRow.get(i).Value!=null){
                    SqlAddRow+=" "+dataRow.get(i).ColoumnName+" = '"+dataRow.get(i).Value+"' ";
                    
                }
                if(!dataRow.get(i).isPrimary
                        &&(i!=dataRow.size()-1)){
                    if(dataRow.get(i + 1).Value != null) {
                        SqlAddRow+=" , ";
                    }
                }
            }
            PreparedStatement preStatement=connection.prepareStatement(SqlAddRow, Statement.RETURN_GENERATED_KEYS);
            preStatement.executeUpdate();
            _isChange=true;
            ResultSet newRow=preStatement.getGeneratedKeys();
            if(newRow.next()) {
                newRowsIdPlot(e,newRow.getObject(1));
                return e;
            }
            //return newRow.getObject(1);
        }catch (SQLException sQLException){
            System.out.print(tableName+" Insert Error : "+sQLException +" \n "+SqlAddRow);
            throw new Exception("Error Insert database ");
        }
        return null;
        //return null;
    }
    
    public void editRow (E e) throws Exception {
        try{

            CheckColoumnPlot(e);
            String SqlAddRow="UPDATE "+tableName+" SET ";

            for(int i=0;i<dataRow.size();i++){
                if(!dataRow.get(i).isPrimary
                        &&dataRow.get(i).Value!=null){
                    SqlAddRow+=" "+dataRow.get(i).ColoumnName+" = '"+dataRow.get(i).Value+"' ";
                    if(i!=dataRow.size()-1){
                        SqlAddRow+=" , ";
                    }
                }
            }
            for(ColoumnValue coloumnValue:dataRow){
                if(coloumnValue.isPrimary) {
                    SqlAddRow+=" WHERE "+coloumnValue.ColoumnName+" = "+coloumnValue.Value;
                }
            }
            statement.execute(SqlAddRow);
            _isChange=true;
        }catch (SQLException sQLException){
            System.out.print("Update Error : " + sQLException.getSQLState());
            throw new Exception("Update Error : " + sQLException.getSQLState());
        }
    }
    
    public void RemoveRow(E e){
        try{
           
            CheckColoumnPlot(e);
            String SqlAddRow="DELETE "+tableName;
            for(ColoumnValue coloumnValue:dataRow){
                if(coloumnValue.isPrimary) {
                    SqlAddRow+=" WHERE "+coloumnValue.ColoumnName+" = "+coloumnValue.Value;
                }
            }
            statement.execute(SqlAddRow);
             _isChange=true;
        }catch (SQLException sQLException){
            System.out.print("Delete Error : "+sQLException);
        }
    }
    
    /**
     * Plot Untuk Row Yang akan di mappring ke database
     * @param e 
     */
    protected abstract void RowPlot(E e);    
    
    private void CheckColoumnPlot(E e){
        if(!(dataRow.size()>0)){
            RowPlot(e);
        }
    }
    
    /**
     * Pencarian dengan Primary Key
     * @param id
     * @return item yang dipilih
     */
    protected abstract E getEntityItem(Object id);
     
    
    /**
     * Apakah List Berubah
     * @return 
     */
    public boolean isChange(){
        return _isChange;
    }
    
    private int Count () {
        return this.getListDataFromDB().size();
    }
    
    /**
     * Untuk Membuat ObservableList yang di gunakan di java fx 
     * @param page halam keberapa
     * @param bucketSize tampilan yang akan di tampilkan
     * @return hasil tinggal di tancepin ke fx aja
     */
    public ObservableList<E> generateDummyData(int page,int bucketSize) {
        int skipdata=(page-1)*bucketSize;
        ObservableList<E> dummyData = FXCollections.observableArrayList();
        getListDataFromDB().stream().skip(0).limit(bucketSize).forEach(listData -> dummyData.add(listData));
        return dummyData;
    }
    
    public int AvailablePage(int bucketSize){
        int res=Count()/bucketSize;
        res++; 
        return res;
    }
    
    protected class ColoumnValue{
        private String ColoumnName;
        private Object Value;
        private boolean isPrimary;

        public ColoumnValue(String ColoumnName, Object Value, boolean isPrimary) {
            this.ColoumnName = ColoumnName;
            this.Value = Value;
            this.isPrimary = isPrimary;
        }
        public ColoumnValue(String ColoumnName, Object Value) {
            this.ColoumnName = ColoumnName;
            this.Value = Value;
            this.isPrimary=false;
        }

        public String getColoumnName() {
            return ColoumnName;
        }

        public void setColoumnName(String ColoumnName) {
            this.ColoumnName = ColoumnName;
        }

        public Object getValue() {
            return Value;
        }

        public void setValue(Object Value) {
            this.Value = Value;
        }
        public boolean isPrimarys(){
            return this.isPrimary;
        }
        
    }
    
    protected class filterTable{
        private String ColoumnName;
        private String FilterParameter;
        private Object Value;
    
        filterTable (String ColoumnName, String FilterParameter, Object Value) {
            this.ColoumnName = ColoumnName;
            this.FilterParameter = FilterParameter;
            this.Value = Value;
        }

        public String getColoumnName() {
            return ColoumnName;
        }

        public void setColoumnName(String ColoumnName) {
            this.ColoumnName = ColoumnName;
        }

        public String getFilterParameter() {
            return FilterParameter;
        }

        public void setFilterParameter(String FilterParameter) {
            this.FilterParameter = FilterParameter;
        }

        public Object getValue() {
            return Value;
        }

        public void setValue(Object Value) {
            this.Value = Value;
        }
        
    }
}
