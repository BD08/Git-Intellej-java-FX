/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.Info;

import fxtebaexpressnb.DatabaseManajement.DBContext;
import fxtebaexpressnb.DatabaseManajement.Kurir;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKurir;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;


/**
 *
 * @author BD08 BangDolla08
 */
public class KurirInfo{
    
    private DBContext dbContext;
    private TableKurir selectedKurir;
    private TableUserManager selectedTableUserManager;
    
    public KurirInfo(DBContext context){
        this.dbContext=context;
    }
    
    public KurirInfo(DBContext context,int Id){
        this.dbContext=context;
        selectedKurir=dbContext.getKurir().getListDataFromDB().stream().filter(kurir->kurir.getId()==Id).findFirst().orElse(null);
    }
    
    public TableKurir getBaseEntity(){
        if(selectedKurir==null){
            selectedKurir=new TableKurir();
            selectedKurir.setCreateDate(dbContext.getDate());
            selectedKurir.setCreateId(dbContext.getUserLoginId());
        }
        return selectedKurir;
    }
    
    public TableUserManager getTableUserManager(){
        if(selectedTableUserManager==null)
            selectedTableUserManager=getBaseEntity().getUserManagers(dbContext);
        return selectedTableUserManager;
    }
    
    public String FirstNameKurir(){
        return getTableUserManager().getFirstName();
    }
    
    public String LastNameKurir(){
        return getTableUserManager().getLastName();
    }
    
    public String getTypeKendaraan(){
        return getBaseEntity().getTypeKendaraan();
    }
    
    public String getNoPolisi(){
        return getBaseEntity().getNoPolisi();
    }
    
}
