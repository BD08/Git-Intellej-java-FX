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
public class TableKecamatan {
    private int Id;
    private String Name;
    private int Kota_Id;
    private Date CreateDate;
    private TableKota tableKota;


    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }
    private int CreateBy;
    private Date ModifyDate;
    private int ModifyBy;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getKota_Id() {
        return Kota_Id;
    }

    public void setKota_Id(int Kota_Id) {
        this.Kota_Id = Kota_Id;
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

    public TableKota getTableKota() {
        return tableKota;
    }

    public void setTableKota(TableKota tableKota) {
        this.setKota_Id(tableKota.getId());
        this.tableKota = tableKota;
    }

    @Override
    public String toString() {
        return getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
