/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

/**
 *
 * @author AsusX450J
 */
public class TableAWBCus {
    //<editor-fold defaultstate="collapsed" desc="Parameter Data">

    //</editor-fold>
    
    // <editor-fold desc="Collomn values" defaultstate="collapsed">
    private int Id;
    private String AWBnumber;
    private int CustomerId;
    private int TotalKilo;
    private int TotalKoli;
    private String NamaPenerima;
    private String Alamat;
    private int KecamatanId;
    private int KotaId;
    private String PhoneNumber1;
    private String PhoneNumber2;        
    private boolean isKilo;
    private String CreateDate;
    private int CreateBy;
    private String ModifyDate;
    private int ModifyBy;
    private TableCustomer customer;
    private TableCustomerPrice customerPrice;
    private TableKota tableKota;
    private TableKecamatan tableKecamatan; 
    // </editor-fold>
    
    @Override
    public String toString() {
        return AWBnumber;
    }

    public TableKota getTableKota() {
        return tableKota;
    }

    public void setTableKota(TableKota tableKota) {
        this.tableKota = tableKota;
    }

    public TableKecamatan getTableKecamatan() {
        return tableKecamatan;
    }

    public void setTableKecamatan(TableKecamatan tableKecamatan) {
        this.tableKecamatan = tableKecamatan;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }

    public TableCustomerPrice getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(TableCustomerPrice customerPrice) {
        this.customerPrice = customerPrice;
    }

    public boolean isIsKilo() {
        return isKilo;
    }

    public void setIsKilo(boolean isKilo) {
        this.isKilo = isKilo;
    }
    
    public int getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(int ModifyBy) {
        this.ModifyBy = ModifyBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String ModifyDate) {
        this.ModifyDate = ModifyDate;
    }
    
    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(int CreateBy) {
        this.CreateBy = CreateBy;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAWBnumber() {
        return AWBnumber;
    }

    public void setAWBnumber(String AWBnumber) {
        this.AWBnumber = AWBnumber;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getNamaPenerima() {
        return NamaPenerima;
    }

    public void setNamaPenerima(String NamaPenerima) {
        this.NamaPenerima = NamaPenerima;
    }
    
    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public int getKecamatanId() {
        return KecamatanId;
    }

    public void setKecamatanId(int KecamatanId) {
        this.KecamatanId = KecamatanId;
    }

    public int getKotaId() {
        return KotaId;
    }

    public void setKotaId(int KotaId) {
        this.KotaId = KotaId;
    }

    public String getPhoneNumber1() {
        return PhoneNumber1;
    }

    public void setPhoneNumber1(String PhoneNumber1) {
        this.PhoneNumber1 = PhoneNumber1;
    }

    public String getPhoneNumber2() {
        return PhoneNumber2;
    }

    public void setPhoneNumber2(String PhoneNumber2) {
        this.PhoneNumber2 = PhoneNumber2;
    }

    public int getTotalKilo() {
        return TotalKilo;
    }

    public void setTotalKilo(int TotalKilo) {
        this.TotalKilo = TotalKilo;
    }

    public int getTotalKoli() {
        return TotalKoli;
    }

    public void setTotalKoli(int TotalKoli) {
        this.TotalKoli = TotalKoli;
    }
}
