/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 * @param <ex>
 */
public abstract class TableManajemen<ex> {
    
    protected ArrayList<ex> listData;
    protected DatabaseConnection connection;
    
    public TableManajemen(DatabaseConnection connection){
        listData=new ArrayList<>();
        this.connection=connection;
    }
    
    protected abstract void MappingTable(ResultSet resultSet) throws SQLException;
    
    protected abstract void MappingTable(String coloumnName,Object data);
    
    public List<ex> getDataList(){
        return listData;
    }
    
    public ArrayList<ex> getDataArrayList(){
        return listData;
    }
    /**
     * Primarykey yang dicari dengan persamaan
     * @param primaryKey Primarikey Data
     * @return 
     */
    public ex getObjectData(Object primaryKey){
        return listData.get(0);
    }
    /**
     * Pencarian data yang sudah ada di dalam data untuk mencari data yang sudah ada 
     * @param dataYangDiFilter yang dicari
     * @param coloumnName coloumn yang di cari
     * @return 
     */
    public ex getObjectData(Object dataYangDiFilter,String coloumnName){
        return listData.get(0);
    }
    
    /**
     * menyamakan data yang sudah ada ke database yang mau di cari
     * @param coloumnString
     * @param data
     * @return 
     */
    protected abstract boolean isSame(String coloumnString,Object data);
    
    
    
}
