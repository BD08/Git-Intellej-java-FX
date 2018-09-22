package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCabangManager;
import java.sql.Connection;
import java.util.Iterator;


public class CabangManager extends BD08EntytyFrameWork<TableCabangManager>{

    private static String ColomnId="Id";
    private static String ColomnUserId="UserId";
    private static String ColomnNamaCabang="NamaCabang";
    private static String ColomnKeterangan="Keterangan";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    
    public CabangManager(Connection connection) {
        super("Cabang", connection);
    }

    @Override
    protected void setDataList() throws Exception {
        TableCabangManager item;
        while(resultSet.next()){
            item=new TableCabangManager();
            item.setId(resultSet.getInt(ColomnId));
            item.setUserId(resultSet.getInt(ColomnUserId));
            item.setNamaCabang(resultSet.getString(ColomnNamaCabang));
            item.setKeterangan(resultSet.getString(ColomnKeterangan));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getDate(ColomnCreateDate));
            item.setModifiedBy(resultSet.getInt(ColomnModifyBy));
            item.setModifiedDate(resultSet.getDate(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableCabangManager e) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(ColomnId, e.getId(), true));
        dataRow.add(new ColoumnValue(ColomnUserId, e.getUserId()));
        dataRow.add(new ColoumnValue(ColomnNamaCabang, e.getNamaCabang()));
        dataRow.add(new ColoumnValue(ColomnKeterangan, e.getKeterangan()));
        dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifiedBy()));
        dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifiedDate()));       
    }

    @Override
    public TableCabangManager getEntityItem(Object id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableCabangManager item=null;
        for (Iterator<TableCabangManager> it = getListDataFromDB().iterator(); it.hasNext();) {
            TableCabangManager tableCabangManager = it.next();
            if(tableCabangManager.getId()==(int)id){
                item=tableCabangManager;
                break;
            }
        }
        return item;
    }

    @Override
    protected void newRowsIdPlot(TableCabangManager e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
