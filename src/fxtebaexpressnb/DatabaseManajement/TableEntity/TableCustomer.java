/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AsusX450J
 */
public class TableCustomer extends RecursiveTreeObject<TableCustomer> {
    private int Id;
    private String Nama;
    private String TypePerusahaan;
    private String Alamat;
    private int KotaId;
    private TableKota Kota;
    private String PhoneNumber;
    private String Email;
    private String ContactPersonInvoice;
    private String InvoiceMail;
    private String CreateDate;
    private int CreateBy;
    private String ModifyDate;
    private int ModifyBy;
    private TableKecamatan kecamatan;
    private int KecamatanId;

    public int getKecamatanId() {
        return KecamatanId;
    }

    public void setKecamatanId(int KecamatanId) {
        this.KecamatanId = KecamatanId;
    }

    public TableKecamatan getKecamatan() {
        
        return kecamatan;
    }

    public void setKecamatan(TableKecamatan kecamatan) {
        this.kecamatan = kecamatan;
        this.setKecamatanId(kecamatan.getId());
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getTypePerusahaan() {
        return TypePerusahaan;
    }

    public void setTypePerusahaan(String TypePerusahaan) {
        this.TypePerusahaan = TypePerusahaan;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public int getKotaId() {
        return KotaId;
    }

    public void setKotaId(int KotaId) {
        this.KotaId = KotaId;
    }

    public TableKota getKota() {
        return Kota;
    }

    public void setKota(TableKota Kota) {
        this.KotaId=Kota.getId();
        this.Kota = Kota;
    }

    public String getKotaToString(){
        if(getKota()==null)
            return "";
        return getKota().toString();
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContactPersonInvoice() {
        return ContactPersonInvoice;
    }

    public void setContactPersonInvoice(String ContactPersonInvoice) {
        this.ContactPersonInvoice = ContactPersonInvoice;
    }

    public String getInvoiceMail() {
        return InvoiceMail;
    }

    public void setInvoiceMail(String InvoiceMail) {
        this.InvoiceMail = InvoiceMail;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public int getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(int CreateBy) {
        this.CreateBy = CreateBy;
    }

    public int getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(int ModifyBy) {
        this.ModifyBy = ModifyBy;
    }



    @Override
    public String toString() {
        return getNama(); //To change body of generated methods, choose Tools | Templates.
    }

    public SimpleIntegerProperty getSimpleIntegerPropertyId(){
        return new SimpleIntegerProperty(getId());
    }

    public SimpleStringProperty getSimpleStringPropertyName(){
        return new SimpleStringProperty(this.getNama());
    }

    public SimpleStringProperty getSimpleStringPropertyEmail(){
        return new SimpleStringProperty(this.getEmail());
    }

    public SimpleStringProperty getSimpleStringPropertyAlamat(){
        return new SimpleStringProperty(this.getAlamat());
    }

    public SimpleStringProperty getSimpleStringPropertyKota(){
        return new SimpleStringProperty(this.getKotaToString());
    }

    public SimpleStringProperty getSimpleStringPropertyNamaContactPerson(){
        return  new SimpleStringProperty(this.getContactPersonInvoice());
    }

    public SimpleStringProperty getSimpleStringPropertyPhoneNumber(){
        return new SimpleStringProperty(this.getPhoneNumber());
    }

    public SimpleStringProperty getSimpleStringPropertyTypePerusahaan(){
        return new SimpleStringProperty(this.getTypePerusahaan());
    }
}
