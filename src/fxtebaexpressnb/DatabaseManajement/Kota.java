/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
import java.sql.Connection;

/**
 *
 * @author AsusX450J
 */
public class Kota extends BD08EntytyFrameWork<TableKota>{
    private static String ColomnId="Id";
    private static String ColomnName="Nama";
    private static String ColomnNicName="NicName";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    public Kota(Connection connection) {
        super("Kota", connection);
    }

    @Override
    protected void setDataList() throws Exception {
        TableKota item;
        while(resultSet.next()){
            item=new TableKota();
            item.setId(resultSet.getInt(ColomnId));
            item.setNama(resultSet.getString(ColomnName));
            item.setNicName(resultSet.getString(ColomnNicName));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getDate(ColomnCreateDate));
            item.setModifyBy(resultSet.getInt(ColomnModifyBy));
            item.setModifyDate(resultSet.getDate(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableKota e) {
        this.dataRow.clear();
        this.dataRow.add(new ColoumnValue(ColomnId, e.getId(),true));
        this.dataRow.add(new ColoumnValue(ColomnName, e.getNama()));
        this.dataRow.add(new ColoumnValue(ColomnNicName, e.getNicName()));
        this.dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        this.dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        this.dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifyBy()));
        this.dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifyDate()));  
    }

    @Override
    protected TableKota getEntityItem(Object id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableKota kota=null;
        for (TableKota tableKota : getListDataFromDB()) {
            if(tableKota.getId()==(int)id){
                kota=tableKota;
                break;
            }
        }
        return kota;        
    }

    @Override
    protected void newRowsIdPlot(TableKota e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
