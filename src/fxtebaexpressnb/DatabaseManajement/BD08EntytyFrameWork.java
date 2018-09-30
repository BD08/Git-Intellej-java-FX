/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.Utility.FilterParameter;
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
    
    protected List<FilterTable> filterRow;
    
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
    
    protected void addDefaultFilter (FilterTable coloumnValue) {
        this.filterRow.add(coloumnValue);
    }

    private String FilterParameterConvert(FilterTable filterTable){
        switch (filterTable.filterParameter){
            case LIKE:
                return " "+filterTable.ColoumnName+" "+filterTable.filterParameter.toString()+" % "+filterTable.Value+" % ";
            case SAMA_DENGAN:
                return " "+filterTable.ColoumnName+" "+filterTable.filterParameter.toString()+" "+filterTable.Value;
            default:
                return "";
        }
    }

    /**
     * Get Data dengan Filter yang sudah di apply
     * @return
     */
    public List<E> getListDataFromDB(){
        try{
            if(_isChange){
                DataList.clear();
                String sqlCode="SELECT * FROM "+ tableName;
                if(filterRow.size()>0){
                    for(int i=0;i<filterRow.size();i++){
                        if(i == 0) {
                            sqlCode+=" WHERE "+FilterParameterConvert(filterRow.get(i));
                        }else{
                            sqlCode+=" AND "+FilterParameterConvert(filterRow.get(i));
                        }
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

    /**
     * Mendapatkan Semua Data yang ada di database tanpa ada filter dan menghapus semua filter yang sudah di apply
     * @return
     */
    public List<E> getAllData(){
        if(filterRow.size()>0) {
            _isChange = true;
            filterRow.clear();
        }
        return getListDataFromDB();
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
    public abstract E getEntityItem(Object id);

    protected abstract void initializationFilterString(String filterString);
    
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
    private ObservableList<E> generateDummyData(int page,int bucketSize) {
        int skipdata=(page-1)*bucketSize;
        if(skipdata<0)
            skipdata=0;
        ObservableList<E> dummyData = FXCollections.observableArrayList();
        getListDataFromDB().stream().skip(skipdata).limit(bucketSize).forEach(listData -> dummyData.add(listData));
        return dummyData;
    }

    /**
     * Untuk Membuat ObservableList yang di gunakan di java fx
     * @param page halam keberapa
     * @param bucketSize tampilan yang akan di tampilkan
     * @return hasil tinggal di tancepin ke fx aja
     */
    public ObservableList<E> generateDummyData(int page,int bucketSize,String filter){
        if(filter.isEmpty())
        {
            this.filterRow.clear();
            return generateDummyData(page,bucketSize);
        }
        this.initializationFilterString(filter);
        int skipdata=(page-1)*bucketSize;
        if(skipdata<0)
            skipdata=0;
        ObservableList<E> dummyData = FXCollections.observableArrayList();
        getListDataFromDB().stream().skip(skipdata).limit(bucketSize).forEach(listData -> dummyData.add(listData));
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
    
    protected class FilterTable{
        private String ColoumnName;
        private FilterParameter filterParameter;
        private Object Value;

        public FilterTable() {
        }

        public FilterTable(String coloumnName, FilterParameter filterParameter, Object value) {
            ColoumnName = coloumnName;
            this.filterParameter = filterParameter;
            Value = value;
        }

        public String getColoumnName() {
            return ColoumnName;
        }

        public void setColoumnName(String coloumnName) {
            ColoumnName = coloumnName;
        }
    }
}
