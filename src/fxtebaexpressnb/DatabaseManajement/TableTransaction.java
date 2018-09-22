/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTransactionModel;
import fxtebaexpressnb.Utility.DatabaseConnection;
import fxtebaexpressnb.Utility.TableManajemen;
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

public class TableTransaction extends TableManajemen<TableTransactionModel>{
    private TableTransactionModel tableTransactionModel;
    private ArrayList<TableTransactionModel> listTableTransaction;

    public TableTransaction(DatabaseConnection connection) {
        super(connection);
    }


    @Override
    protected void MappingTable(String coloumnName, Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean isSame(String coloumnString, Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void MappingTable(ResultSet resultSet) throws SQLException{
        tableTransactionModel=new TableTransactionModel();
        tableTransactionModel.setAIRWAYBILL(resultSet.getString(TableTransactionModel.COLOUMN_AIRWAYBILL));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        
        tableTransactionModel.setCreateBy(resultSet.getInt(TableTransactionModel.COLOUMN_CreateBy));
        tableTransactionModel.setCreateDate(resultSet.getDate(TableTransactionModel.COLOUMN_CreateDate));
        tableTransactionModel.setDiscon(resultSet.getInt(TableTransactionModel.COLOUMN_Discon));
        tableTransactionModel.setHargaPerKilo(resultSet.getInt(TableTransactionModel.COLOUMN_HargaPerKilo));
        tableTransactionModel.setHargaPerKoli(resultSet.getInt(TableTransactionModel.COLOUMN_HargaPerKoli));
        tableTransactionModel.setID(resultSet.getInt(TableTransactionModel.COLOUMN_ID));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
        tableTransactionModel.setAsuransi(resultSet.getInt(TableTransactionModel.COLOUMN_Asuransi));
    }
    
    
}

