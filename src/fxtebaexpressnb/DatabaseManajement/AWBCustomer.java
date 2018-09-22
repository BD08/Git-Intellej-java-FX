/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableColoumnName;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTransaksi;
import java.sql.Connection;
import java.util.Optional;


/**
 *
 * @author AsusX450J
 */
public class AWBCustomer extends BD08EntytyFrameWork<TableTransaksi>{
    // <editor-fold desc="Colome Static Name" defaultstate="collapsed">
    private static String ColomnId=TableColoumnName.AWBTable.ID;
    private static String ColomnCustomerId=TableColoumnName.AWBTable.CUSTOMER_ID;
    private static String ColomnAirwaybill=TableColoumnName.AWBTable.AIRWAYBILL;
    private static String ColomnToNama=TableColoumnName.AWBTable.TO_NAMA;
    private static String ColomnToAlamat=TableColoumnName.AWBTable.TO_ALAMAT;
    private static String ColomnToKecamatanId=TableColoumnName.AWBTable.TO_KECAMATAN_ID;
    private static String ColomnToKotaId=TableColoumnName.AWBTable.TO_KOTA_ID;
    private static String ColomnToTelp1=TableColoumnName.AWBTable.TO_TELP1;
    private static String ColomnToTelp2=TableColoumnName.AWBTable.TO_TELP2;
    private static String ColomnisKilo=TableColoumnName.AWBTable.ISKILO;
    private static String ColomnTotalKoli=TableColoumnName.AWBTable.TOTAL_KOLI;
    private static String ColomnTotalKil0=TableColoumnName.AWBTable.TOTAL_KILO;
    private static String ColomnCreateDate=TableColoumnName.AWBTable.CREATE_DATE;
    private static String ColomnCreateBy=TableColoumnName.AWBTable.CREATE_BY;
    private static String ColomnModifyDate=TableColoumnName.AWBTable.MODIFY_DATE;
    private static String ColomnModifyBy=TableColoumnName.AWBTable.MODIFY_BY;
    // </editor-fold>
    private Customer customerData;
    
    
    public AWBCustomer(Connection connection,Customer customer) {
        super("Transaksi", connection);
        this.customerData=customer;
        this.addDefaultFilter(new filterTable(ColomnCustomerId, ">", "0"));
    }

    @Override
    protected void setDataList() throws Exception {
        TableTransaksi item;
        while (resultSet.next()) {
            item=new TableTransaksi();
            item.setId(resultSet.getInt(ColomnId));
            item.setAirwaybill(resultSet.getString(ColomnAirwaybill));
            item.setCustomerId(resultSet.getInt(ColomnCustomerId));
            item.setToNama(resultSet.getString(ColomnToNama));
            item.setToAlamat(resultSet.getString(ColomnToAlamat));
            item.setToTelp1(resultSet.getString(ColomnToTelp1));
            item.setToTelp2(resultSet.getString(ColomnToTelp2));
            item.setToKecamatanId(resultSet.getInt(ColomnToKecamatanId));
            item.setToKotaId(resultSet.getInt(ColomnToKotaId));
            item.setIsKoli(resultSet.getBoolean(ColomnisKilo));
            item.setTotalKoli(resultSet.getInt(ColomnTotalKoli));
            item.setTotalBerat(resultSet.getInt(ColomnTotalKil0));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getString(ColomnCreateDate));
            item.setModifiedBy(resultSet.getInt(ColomnModifyBy));
            item.setModifiedDate(resultSet.getString(ColomnModifyDate));
            item.setTableCustomer(customerData.getEntityItem(item.getCustomerId()));
            DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableTransaksi e) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(ColomnId, e.getId(),true));
        dataRow.add(new ColoumnValue(ColomnAirwaybill, e.getAirwaybill()));
        dataRow.add(new ColoumnValue(ColomnCustomerId, e.getCustomerId()));
        dataRow.add(new ColoumnValue(ColomnToNama, e.getToNama()));
        dataRow.add(new ColoumnValue(ColomnToAlamat, e.getToAlamat()));
        dataRow.add(new ColoumnValue(ColomnToTelp1, e.getToTelp1()));
        dataRow.add(new ColoumnValue(ColomnToTelp2, e.getToTelp2()));
        dataRow.add(new ColoumnValue(ColomnToKecamatanId, e.getToKecamatanId()));
        dataRow.add(new ColoumnValue(ColomnToKotaId, e.getToKotaId()));
        dataRow.add(new ColoumnValue(ColomnisKilo, !e.isIsKoli()));
        dataRow.add(new ColoumnValue(ColomnTotalKil0, e.getTotalBerat()));
        dataRow.add(new ColoumnValue(ColomnTotalKoli, e.getTotalKoli()));
        dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifiedBy()));
        dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifiedDate()));
        
    }

    @Override
    protected TableTransaksi getEntityItem(Object id) {
        TableTransaksi result=null;
        for (TableTransaksi tableAWBCus : getListDataFromDB()) {
            if(tableAWBCus.getId()==(int)id){
                result=tableAWBCus;
                break;
            }
        }
        return result;
    }

    @Override
    protected void newRowsIdPlot(TableTransaksi e, Object o) {
        e.setId(o.hashCode());
    }

}
