/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableColoumnName;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKurir;
import fxtebaexpressnb.Utility.FilterParameter;

import java.sql.Connection;

/**
 *
 * @author BD08 BangDolla08
 */
public class Kurir extends BD08EntytyFrameWork<TableKurir>{

    private UserManagers managersUser;
    public Kurir(Connection connection,UserManagers managers) {
        super("Kurir", connection);
        this.managersUser=managers;
    }

    @Override
    protected void setDataList() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableKurir item;
        while(resultSet.next()){
            item=new TableKurir();
            item.setId(resultSet.getInt(TableColoumnName.KurirTable.ID));
            item.setUserManagerId(resultSet.getInt(TableColoumnName.KurirTable.USER_MANAGER_ID));
            item.setTypeKendaraan(resultSet.getString(TableColoumnName.KurirTable.TYPE_KENDARAAN));
            item.setNoPolisi(resultSet.getString(TableColoumnName.KurirTable.NOMOR_POLISI));
            item.setCreateId(resultSet.getInt(TableColoumnName.KurirTable.CREATE_BY));
            item.setCreateDate(resultSet.getString(TableColoumnName.KurirTable.CREATE_DATE));
            item.setModifyId(resultSet.getInt(TableColoumnName.KurirTable.MODIFY_BY));
            item.setModifyDate(resultSet.getString(TableColoumnName.KurirTable.MODIFY_DATE));
            DataList.add(item);
        }
    }

    @Override
    protected void newRowsIdPlot(TableKurir e, Object o) {
        e.setId((int)o);
    }

    @Override
    protected void RowPlot(TableKurir e) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.ID, e.getId(),true));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.USER_MANAGER_ID,e.getUserManagerId()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.TYPE_KENDARAAN, e.getTypeKendaraan()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.NOMOR_POLISI, e.getNoPolisi()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.CREATE_BY, e.getCreateId()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.CREATE_DATE, e.getCreateDate()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.MODIFY_BY, e.getModifyId()));
        dataRow.add(new ColoumnValue(TableColoumnName.KurirTable.MODIFY_DATE, e.getModifyDate()));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected TableKurir getEntityItem(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializationFilterString(String filterString) {
        this.addDefaultFilter(new FilterTable(TableColoumnName.KurirTable.NOMOR_POLISI, FilterParameter.LIKE,filterString));
    }

}
