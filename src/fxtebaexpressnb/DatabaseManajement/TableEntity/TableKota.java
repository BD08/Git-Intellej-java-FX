/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AsusX450J
 */
public class TableKota {
    private int Id;
    private String Nama;
    private String NicName;
    private Date CreateDate;
    private int CreateBy;
    private Date ModifyDate;
    private int ModifyBy;
    private List<TableKecamatan> listAvalibleKecamatan;

    public static TableKota defaultTableKota(){
        TableKota defaultTableKota=new TableKota();
        defaultTableKota.setNicName("--Select--");
        defaultTableKota.setId(-8008);
        return defaultTableKota;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNicName() {
        return NicName;
    }

    public void setNicName(String NicName) {
        this.NicName = NicName;
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

    public void addKecamatan(TableKecamatan tableKecamatan){
        if(this.listAvalibleKecamatan==null)
            this.listAvalibleKecamatan=new ArrayList<>();
        this.listAvalibleKecamatan.add(tableKecamatan);
    }

    public List<TableKecamatan> getListAvalibleKecamatan(){
        return listAvalibleKecamatan;
    }
    @Override
    public String toString() {
        if(getNama()==null)
            return getNicName();
        if(getNicName()==null)
            return getNama();
        return getNama()+" "+getNicName();
    }
    
    
}
