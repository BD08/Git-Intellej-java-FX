package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import java.sql.Connection;

/**
 *
 * @author AsusX450J
 */
public class Kecamatan extends BD08EntytyFrameWork<TableKecamatan>{

    private static String ColomnId="Id";
    private static String ColomnName="Name";
    private static String ColomnKota_id="Kota_id";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    public Kecamatan(Connection connection) {
        super("Kecamatan", connection);
    }

    @Override
    protected void setDataList() throws Exception {
        TableKecamatan item;
        while(resultSet.next()){
            item=new TableKecamatan();
            item.setId(resultSet.getInt(ColomnId));
            item.setName(resultSet.getString(ColomnName));
            item.setKota_Id(resultSet.getInt(ColomnKota_id));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getDate(ColomnCreateDate));
            item.setModifyBy(resultSet.getInt(ColomnModifyBy));
            item.setModifyDate(resultSet.getDate(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableKecamatan e) {
        this.dataRow.clear();
        this.dataRow.add(new ColoumnValue(ColomnId, e.getId(),true));
        this.dataRow.add(new ColoumnValue(ColomnName, e.getName()));
        this.dataRow.add(new ColoumnValue(ColomnKota_id, e.getKota_Id()));
        this.dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        this.dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        this.dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifyBy()));
        this.dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifyDate()));  
    }

    @Override
    protected TableKecamatan getEntityItem(Object id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableKecamatan kecamatan=null;
        for (TableKecamatan tableKecamatan : getListDataFromDB()) {
             if(tableKecamatan.getId()==(int)id){
                 kecamatan=tableKecamatan;
                 break;
             }
        }
        return kecamatan;
    }

    @Override
    protected void newRowsIdPlot(TableKecamatan e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
