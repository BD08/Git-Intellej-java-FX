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
import fxtebaexpressnb.Utility.TableManajemen;

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

    }

    /**
     * Pencarian dengan Primary Key
     *
     * @param id
     * @return item yang dipilih
     */
    @Override
    public TableTransactionModel getEntityItem(Object id) {
        return null;
    }

    @Override
    protected void initializationFilterString(String filterString) {

    }
}

