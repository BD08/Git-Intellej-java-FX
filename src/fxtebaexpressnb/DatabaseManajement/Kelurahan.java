/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKelurahan;
import fxtebaexpressnb.Utility.FilterParameter;

import java.sql.Connection;

/**
 *
 * @author AsusX450J
 */
public class Kelurahan extends BD08EntytyFrameWork<TableKelurahan>{

    
    private static String ColomnId="Id";
    private static String ColomnName="Nama";
    private static String ColomnKodePost="KodePost";
    private static String ColomnKecamatan_id="Kecamatan_id";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    public Kelurahan(Connection connection) {
        super("Kelurahan", connection);
    }

    @Override
    protected void setDataList() throws Exception {
        TableKelurahan item;
        while(resultSet.next()){
            item=new TableKelurahan();
            item.setId(resultSet.getInt(ColomnId));
            item.setKodePost(resultSet.getInt(ColomnKodePost));
            item.setNama(resultSet.getString(ColomnName));
            item.setKecamatanId(resultSet.getInt(ColomnKecamatan_id));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getDate(ColomnCreateDate));
            item.setModifyBy(resultSet.getInt(ColomnModifyBy));
            item.setModifyDate(resultSet.getDate(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableKelurahan e) {
        this.dataRow.clear();
        this.dataRow.add(new ColoumnValue(ColomnId, e.getId(),true));
        this.dataRow.add(new ColoumnValue(ColomnName, e.getNama()));
        this.dataRow.add(new ColoumnValue(ColomnKodePost, e.getKodePost()));
        this.dataRow.add(new ColoumnValue(ColomnKecamatan_id, e.getKecamatanId()));
        this.dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        this.dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        this.dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifyBy()));
        this.dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifyDate()));  
    }

    @Override
    public TableKelurahan getEntityItem(Object id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableKelurahan kelurahan=null;
        for (TableKelurahan tableKelurahan : getListDataFromDB()) {
            if(tableKelurahan.getId()==(int)id){
                kelurahan=tableKelurahan;
                break;
            }
        }
        return kelurahan;
    }

    @Override
    protected void initializationFilterString(String filterString) {
        this.addDefaultFilter(new FilterTable(ColomnName, FilterParameter.LIKE,filterString));
    }

    @Override
    protected void newRowsIdPlot(TableKelurahan e, Object o) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
