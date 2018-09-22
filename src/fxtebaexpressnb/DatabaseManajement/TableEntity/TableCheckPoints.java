/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

import java.util.Date;

/**
 *
 * @author AsusX450J
 */
public class TableCheckPoints {
    private int Id;
    private int TransaksiId;
    private int UserId;
    private Date CreateDate;
    private int CreateBy;
    private Date ModifyDate;
    private int ModifyBy;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTransaksiId() {
        return TransaksiId;
    }

    public void setTransaksiId(int TransaksiId) {
        this.TransaksiId = TransaksiId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(int CreateBy) {
        this.CreateBy = CreateBy;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public int getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(int ModifyBy) {
        this.ModifyBy = ModifyBy;
    }
    
}
