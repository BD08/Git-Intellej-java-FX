/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

import fxtebaexpressnb.DatabaseManajement.DBContext;
import fxtebaexpressnb.DatabaseManajement.UserManagers;

/**
 *
 * @author BD08 BangDolla08
 */
public class TableKurir {
    // <editor-fold desc="Colomn Data" defaultstate="collapsed">
    private int Id;
    private int UserManagerId;
    private String TypeKendaraan;
    private String NoPolisi;
    private String CreateDate;
    private int CreateId;
    private String ModifyDate;
    private int ModifyId;
    private TableUserManager userManagers;
    // </editor-fold>
    
    // <editor-fold desc="Getter Setter" defaultstate="collapsed">
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getUserManagerId() {
        return UserManagerId;
    }

    public void setUserManagerId(int UserManagerId) {
        this.UserManagerId = UserManagerId;
    }

    public String getTypeKendaraan() {
        return TypeKendaraan;
    }

    public void setTypeKendaraan(String TypeKendaraan) {
        this.TypeKendaraan = TypeKendaraan;
    }

    public String getNoPolisi() {
        return NoPolisi;
    }

    public void setNoPolisi(String NoPolisi) {
        this.NoPolisi = NoPolisi;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getCreateId() {
        return CreateId;
    }

    public void setCreateId(int CreateId) {
        this.CreateId = CreateId;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public int getModifyId() {
        return ModifyId;
    }

    public void setModifyId(int ModifyId) {
        this.ModifyId = ModifyId;
    }
    
    public TableUserManager getUserManagers(DBContext dbc) {
        if(userManagers==null){
            userManagers=dbc.getUserManagers().getListDataFromDB().stream().filter(user->user.getId()==getUserManagerId()).findFirst().orElse(null);
        }
        return userManagers;
    }
    
    // </editor-fold>    
}
