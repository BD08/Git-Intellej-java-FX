/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import java.sql.Connection;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCheckPoints;


/**
 *
 * @author AsusX450J
 */
public class CheckPoint extends BD08EntytyFrameWork<TableCheckPoints>{

    private static String ColomnId="Id";
    private static String ColomnTransaksiId="TransaksiId";
    private static String ColomnUserId="UserId";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    
    public CheckPoint(Connection connection) {
        super("CheckPoint", connection);
    }

    @Override
    protected void setDataList() throws Exception {
        TableCheckPoints item;
        while(resultSet.next()){
            item=new TableCheckPoints();
            item.setId(resultSet.getInt(ColomnId));
            item.setTransaksiId(resultSet.getInt(ColomnTransaksiId));
            item.setUserId(resultSet.getInt(ColomnUserId));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getDate(ColomnCreateDate));
            item.setModifyBy(resultSet.getInt(ColomnModifyBy));
            item.setModifyDate(resultSet.getDate(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableCheckPoints e) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(ColomnId, e.getId(), true));
        dataRow.add(new ColoumnValue(ColomnUserId, e.getUserId()));
        dataRow.add(new ColoumnValue(ColomnTransaksiId, e.getTransaksiId()));
        dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifyBy()));
        dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifyDate()));  
    }

    @Override
    public TableCheckPoints getEntityItem(Object id) {
        TableCheckPoints checkPoints=null;
        for (TableCheckPoints tableCheckPoints : getListDataFromDB()) {
            if(tableCheckPoints.getId()==(int)id){
                checkPoints=tableCheckPoints;
                break;
            }
        }
        return checkPoints;
    }

    @Override
    protected void newRowsIdPlot(TableCheckPoints e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
