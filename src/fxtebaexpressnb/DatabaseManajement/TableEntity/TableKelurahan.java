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
public class TableKelurahan {
    private int Id;
    private String Nama;
    private int KodePost;
    private int KecamatanId;
    private Date CreateDate;
    private int CreateBy;
    private Date ModifyDate;
    private int ModifyBy;

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getKodePost() {
        return KodePost;
    }

    public void setKodePost(int KodePost) {
        this.KodePost = KodePost;
    }

    public int getKecamatanId() {
        return KecamatanId;
    }

    public void setKecamatanId(int KecamatanId) {
        this.KecamatanId = KecamatanId;
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
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return getNama();
    }
    
}
