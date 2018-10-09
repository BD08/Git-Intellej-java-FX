/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKodeMaster;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTarif;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTransactionModel;
import fxtebaexpressnb.Utility.DatabaseConnection;
import fxtebaexpressnb.Utility.FilterParameter;
import fxtebaexpressnb.Utility.TableManajemen;
import fxtebaexpressnb.View.TransactionListController;
import javafx.scene.control.Tab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AsusX450J
 */

/**
     * class untuk Table Transaksi dimasukkan kedalam class biar keren
     */

public class TableTransaction extends BD08EntytyFrameWork<TableTransactionModel>{

    private Kota kota;
    private Kecamatan kecamatan;

    public TableTransaction(Connection connection,Kota kota,Kecamatan kecamatan) {
        super("Transaksi", connection);
        this.kota=kota;
        this.kecamatan=kecamatan;
    }

    @Override
    protected void setDataList() throws Exception {
        TableTransactionModel item;
        while (resultSet.next()){
            item=new TableTransactionModel();
            item.setAIRWAYBILL(resultSet.getString(TableTransactionModel.COLOUMN_AIRWAYBILL));
            item.setSendNama(resultSet.getString(TableTransactionModel.COLOUMN_SendNama));
            item.setSendAlamat(resultSet.getString(TableTransactionModel.COLOUMN_SendAlamat));
            item.setSendKecamatanId(resultSet.getInt(TableTransactionModel.COLOUMN_SendKecamatan));
            item.setSendKecamatan(kecamatan.getEntityItem(item.getSendKecamatanId()));
            item.setSendKotaId(resultSet.getInt(TableTransactionModel.COLOUMN_SendKotaId));
            item.setSendKota(kota.getEntityItem(item.getSendKotaId()));
            item.setSendTelp1(resultSet.getString(TableTransactionModel.COLOUMN_SendTelp1));
            item.setSendTelp2(resultSet.getString(TableTransactionModel.COLOUMN_SendTelp2));
            item.setToNama(resultSet.getString(TableTransactionModel.COLOUMN_ToNama));
            item.setToAlamat(resultSet.getString(TableTransactionModel.COLOUMN_ToAlamat));
            item.setToKecamatan(resultSet.getInt(TableTransactionModel.COLOUMN_ToKelurahanId));
            item.setToKecamatan(kecamatan.getEntityItem(item.getToKecamatanId()));
            item.setToKotaId(resultSet.getInt(TableTransactionModel.COLOUMN_ToKotaId));
            item.setToKota(kota.getEntityItem(item.getToKotaId()));
            item.setToTelp1(resultSet.getString(TableTransactionModel.COLOUMN_ToTelp1));
            item.setToTelp2(resultSet.getString(TableTransactionModel.COLOUMN_ToTelp2));
            item.setTotalBerat(resultSet.getInt(TableTransactionModel.COLOUMN_TotalBerat));
            item.setTotalKoli(resultSet.getInt(TableTransactionModel.COLOUMN_TotalKoli));
            item.setNilaiBarang(resultSet.getInt(TableTransactionModel.COLOUMN_NilaiBarang));
            item.setHargaPerKilo(resultSet.getInt(TableTransactionModel.COLOUMN_HargaPerKilo));
            item.setHargaPerKoli(resultSet.getInt(TableTransactionModel.COLOUMN_HargaPerKoli));
            item.setTOTAL(resultSet.getInt(TableTransactionModel.COLOUMN_TOTAL));
            item.setIsKoli(resultSet.getBoolean(TableTransactionModel.COLOUMN_isKoli));
            item.setPacking(resultSet.getInt(TableTransactionModel.COLOUMN_Packing));
            item.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
            item.setPPN(resultSet.getInt(TableTransactionModel.COLOUMN_PPN));
            item.setDiscon(resultSet.getInt(TableTransactionModel.COLOUMN_Discon));
            item.setNOTES(resultSet.getString(TableTransactionModel.COLOUMN_NOTES));
            item.setCreateBy(resultSet.getInt(TableTransactionModel.COLOUMN_CreateBy));
            item.setCreateDate(resultSet.getDate(TableTransactionModel.COLOUMN_CreateDate));
            item.setModifyBy(resultSet.getInt(TableTransactionModel.COLOUMN_ModifyBy));
            item.setCreateDate(resultSet.getDate(TableTransactionModel.COLOUMN_ModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void newRowsIdPlot(TableTransactionModel tableTransactionModel, Object o) {

    }

    /**
     * Plot Untuk Row Yang akan di mappring ke database
     *
     * @param tableTransactionModel
     */
    @Override
    protected void RowPlot(TableTransactionModel tableTransactionModel) {
        dataRow.clear();
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ID,tableTransactionModel.getID(),true));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_AIRWAYBILL,tableTransactionModel.getAIRWAYBILL()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendNama,tableTransactionModel.getNamaPengirim()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendAlamat,tableTransactionModel.getSendAlamat()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendKecamatan,tableTransactionModel.getSendKecamatanId()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendKotaId,tableTransactionModel.getSendKotaId()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendTelp1,tableTransactionModel.getSendTelp1()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_SendTelp2,tableTransactionModel.getSendTelp2()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToNama,tableTransactionModel.getToNama()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToAlamat,tableTransactionModel.getToAlamat()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToKecamatan,tableTransactionModel.getToKecamatanId()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToKotaId,tableTransactionModel.getToKotaId()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToTelp1,tableTransactionModel.getToTelp1()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_ToTelp2,tableTransactionModel.getToTelp2()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_TotalKoli,tableTransactionModel.getTotalKoli()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_TotalBerat,tableTransactionModel.getTotalBerat()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_NilaiBarang,tableTransactionModel.getNilaiBarang()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_HargaPerKilo,tableTransactionModel.getHargaPerKilo()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_HargaPerKoli,tableTransactionModel.getHargaPerKoli()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_TOTAL,tableTransactionModel.getTOTAL()));
//        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_isKoli,tableTransactionModel.isIsKoli()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_Packing,tableTransactionModel.getPacking()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_Asuransi,tableTransactionModel.getAsuransi()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_PPN,tableTransactionModel.getPPN()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_Discon,tableTransactionModel.getDiscon()));
        dataRow.add(new ColoumnValue(TableTransactionModel.COLOUMN_NOTES,tableTransactionModel.getNOTES()));

    }

    /**
     * Pencarian dengan Primary Key
     *
     * @param id
     * @return item yang dipilih
     */
    @Override
    public TableTransactionModel getEntityItem(Object id) {
        return this.getAllData().stream().filter(tt -> tt.getID()==id.hashCode()).findFirst().get();
    }

    @Override
    protected void initializationFilterString(String filterString) {
        this.addDefaultFilter(new FilterTable(TableTransactionModel.COLOUMN_ToNama, FilterParameter.LIKE, filterString));
        this.addDefaultFilter(new FilterTable(TableTransactionModel.COLOUMN_SendNama, FilterParameter.LIKE, filterString));
        this.addDefaultFilter(new FilterTable(TableTransactionModel.COLOUMN_AIRWAYBILL, FilterParameter.LIKE, filterString));
        this.addDefaultFilter(new FilterTable(TableTransactionModel.COLOUMN_ToAlamat, FilterParameter.LIKE, filterString));
        this.addDefaultFilter(new FilterTable(TableTransactionModel.COLOUMN_SendAlamat, FilterParameter.LIKE, filterString));
    }
}

