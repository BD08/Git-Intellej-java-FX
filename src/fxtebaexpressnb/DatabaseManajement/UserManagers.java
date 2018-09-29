/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;


import fxtebaexpressnb.DatabaseManajement.BD08EntytyFrameWork;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableColoumnName;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;
import fxtebaexpressnb.Utility.FilterParameter;

import java.sql.Connection;
/**
 *
 * @author AsusX450J
 */
public class UserManagers extends BD08EntytyFrameWork<TableUserManager>{
    
    //<editor-fold defaultstate="collapsed" desc="Colomen Name ">
    private static String ColoumId=TableColoumnName.UserManagers.ID;
    private static String ColoumFirstName=TableColoumnName.UserManagers.FIRST_NAME;
    private static String ColoumLastName=TableColoumnName.UserManagers.LAST_NAME;
    private static String ColoumEmail=TableColoumnName.UserManagers.EMAIL;
    private static String ColoumUsername=TableColoumnName.UserManagers.USERNAME;
    private static String ColoumAlamat=TableColoumnName.UserManagers.ALAMAT;
    private static String ColoumPhoneNumber=TableColoumnName.UserManagers.PHONE_NUMBER;
    private static String ColoumCabangId=TableColoumnName.UserManagers.CABANG_ID;
    private static String ColoumPassword=TableColoumnName.UserManagers.PASSWORD;
    //</editor-fold>    
    
    public UserManagers(Connection connection) {
        super("UserManager",connection);
    }
    
    @Override
    protected void setDataList() throws Exception{
        TableUserManager itemSql=null;
        itemSql=new TableUserManager();
        while (resultSet.next()) {
            itemSql=new TableUserManager();
            itemSql.setAlamat(resultSet.getString(ColoumAlamat));
            itemSql.setCabangId(resultSet.getInt(ColoumCabangId));
            itemSql.setEmail(resultSet.getString(ColoumEmail));
            itemSql.setFirstName(resultSet.getString(ColoumFirstName));
            itemSql.setId(resultSet.getInt(ColoumId));
            itemSql.setLastName(resultSet.getString(ColoumLastName));
            itemSql.setPassword(resultSet.getString(ColoumPassword));
            itemSql.setUsername(resultSet.getString(ColoumUsername));
            itemSql.setPhoneNumber(resultSet.getString(ColoumPhoneNumber));
            this.DataList.add(itemSql);
        }
    }

//    public void createFilterAllStringRowData(String filter){
//        filterTable filterTable=new filterTable(ColoumFirstName, FilterParameter.LIKE,filter);
//        this.filterRow.add(filterTable);
//        filterTable=new filterTable(ColoumLastName," LIKE ",filter);
//    }

    @Override
    protected void RowPlot(TableUserManager e) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(ColoumId, e.getId(),true));
        dataRow.add(new ColoumnValue(ColoumFirstName, e.getFirstName()));
        dataRow.add(new ColoumnValue(ColoumLastName, e.getLastName()));
        dataRow.add(new ColoumnValue(ColoumEmail, e.getEmail()));
        dataRow.add(new ColoumnValue(ColoumAlamat, e.getAlamat()));
        dataRow.add(new ColoumnValue(ColoumPhoneNumber, e.getPhoneNumber()));
        dataRow.add(new ColoumnValue(ColoumCabangId, e.getCabangId()));
        dataRow.add(new ColoumnValue(ColoumUsername, e.getUsername()));
        dataRow.add(new ColoumnValue(ColoumPassword, e.getPassword()));
    }

    @Override
    protected TableUserManager getEntityItem(Object id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TableUserManager manager=null;
        for (TableUserManager tableUserManager : getListDataFromDB()) {
            if(tableUserManager.getId()==(int)id){
                manager=tableUserManager;
                break;
            }
        }
        return manager;
    }

    @Override
    protected void initializationFilterString(String filterString) {
        addDefaultFilter(new FilterTable(ColoumFirstName,FilterParameter.LIKE,filterString));
        addDefaultFilter(new FilterTable(ColoumLastName,FilterParameter.LIKE,filterString));
        addDefaultFilter(new FilterTable(ColoumUsername,FilterParameter.LIKE,filterString));
        addDefaultFilter(new FilterTable(ColoumAlamat,FilterParameter.LIKE,filterString));
        addDefaultFilter(new FilterTable(ColoumEmail,FilterParameter.LIKE,filterString));
        addDefaultFilter(new FilterTable(ColoumPhoneNumber,FilterParameter.LIKE,filterString));
    }

    @Override
    protected void newRowsIdPlot(TableUserManager e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    protected boolean CheckColomnValue(String collomnName, Object value, TableUserManager e) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        switch(collomnName){
//            case TableColoumnName.UserManagers.FIRST_NAME:
//                return e.getFirstName().contains(value.toString());
//            case TableColoumnName.UserManagers.CABANG_ID:
//                return e.getCabangId()==(int) value;
//            case TableColoumnName.UserManagers.EMAIL:
//                return e.getEmail().contains(value.toString());
//            case TableColoumnName.UserManagers.ALAMAT:
//                return e.getAlamat().contains(value.toString());
//            case TableColoumnName.UserManagers.LAST_NAME:
//                return e.getLastName().contains(value.toString());
//            case TableColoumnName.UserManagers.PASSWORD:
//                return e.getPassword().contains(value.toString());
//            case TableColoumnName.UserManagers.USERNAME:
//                return e.getUsername().contains(value.toString());
//            case TableColoumnName.UserManagers.PHONE_NUMBER:
//                return e.getPhoneNumber().contains(value.toString());
//            default:
//                return false;
//        }
//    }
    
}
