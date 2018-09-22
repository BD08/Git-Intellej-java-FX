/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

import fxtebaexpressnb.DatabaseManajement.Kecamatan;

/**
 *
 * @author AsusX450J
 */
public class TableTransaksi {
    private int id;
    private int customerId;
    private String Airwaybill;
    private String SendNama;
    private String SendAlamat;
    private String SendKelurahanId;
    private int SendKecamatanId;
    private int SendKotaId;
    private String SendTelp1;
    private String SendTelp2;
    private String ToNama;
    private String ToAlamat;
    private int ToKeluarahanId;
    private int ToKecamatanId;
    private int ToKotaId;
    private String ToTelp1;
    private String ToTelp2;
    private int TotalKoli;
    private int TotalBerat;
    private int NilaiBarang;
    private int HargaPerKilo;
    private int HargaPerKoli;
    private int Packing;
    private int Asuransi;
    private int PPN;
    private int Discon;
    private int Total;
    private boolean isKoli;
    private String NOTES;
    private int CreateBy;
    private String CreateDate;
    private int ModifiedBy;
    private String ModifiedDate;
    private TableKecamatan SendKecamatan=null;
    private TableKota SendKota=null;
    private TableKecamatan ToKecamatan=null;
    private TableKota ToKota=null;
    private TableCustomer tableCustomer=null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAirwaybill() {
        return Airwaybill;
    }

    public void setAirwaybill(String Airwaybill) {
        this.Airwaybill = Airwaybill;
    }

    public String getSendNama() {
        return SendNama;
    }

    public void setSendNama(String SendNama) {
        this.SendNama = SendNama;
    }

    public String getSendAlamat() {
        return SendAlamat;
    }

    public void setSendAlamat(String SendAlamat) {
        this.SendAlamat = SendAlamat;
    }

    public String getSendKelurahanId() {
        return SendKelurahanId;
    }

    public void setSendKelurahanId(String SendKelurahanId) {
        this.SendKelurahanId = SendKelurahanId;
    }

    public int getSendKecamatanId() {
        return SendKecamatanId;
    }

    public void setSendKecamatanId(int SendKecamatanId) {
        this.SendKecamatanId = SendKecamatanId;
    }

    public int getSendKotaId() {
        return SendKotaId;
    }

    public void setSendKotaId(int SendKotaId) {
        this.SendKotaId = SendKotaId;
    }

    public String getSendTelp1() {
        return SendTelp1;
    }

    public void setSendTelp1(String SendTelp1) {
        this.SendTelp1 = SendTelp1;
    }

    public String getSendTelp2() {
        return SendTelp2;
    }

    public void setSendTelp2(String SendTelp2) {
        this.SendTelp2 = SendTelp2;
    }

    public String getToNama() {
        return ToNama;
    }

    public void setToNama(String ToNama) {
        this.ToNama = ToNama;
    }

    public String getToAlamat() {
        return ToAlamat;
    }

    public void setToAlamat(String ToAlamat) {
        this.ToAlamat = ToAlamat;
    }

    public int getToKeluarahanId() {
        return ToKeluarahanId;
    }

    public void setToKeluarahanId(int ToKeluarahanId) {
        this.ToKeluarahanId = ToKeluarahanId;
    }

    public int getToKecamatanId() {
        return ToKecamatanId;
    }

    public void setToKecamatanId(int ToKecamatanId) {
        this.ToKecamatanId = ToKecamatanId;
    }

    public int getToKotaId() {
        return ToKotaId;
    }

    public void setToKotaId(int ToKotaId) {
        this.ToKotaId = ToKotaId;
    }

    public String getToTelp1() {
        return ToTelp1;
    }

    public void setToTelp1(String ToTelp1) {
        this.ToTelp1 = ToTelp1;
    }

    public String getToTelp2() {
        return ToTelp2;
    }

    public void setToTelp2(String ToTelp2) {
        this.ToTelp2 = ToTelp2;
    }

    public int getTotalKoli() {
        return TotalKoli;
    }

    public void setTotalKoli(int TotalKoli) {
        this.TotalKoli = TotalKoli;
    }

    public int getTotalBerat() {
        return TotalBerat;
    }

    public void setTotalBerat(int TotalBerat) {
        this.TotalBerat = TotalBerat;
    }

    public int getNilaiBarang() {
        return NilaiBarang;
    }

    public void setNilaiBarang(int NilaiBarang) {
        this.NilaiBarang = NilaiBarang;
    }

    public int getHargaPerKilo() {
        return HargaPerKilo;
    }

    public void setHargaPerKilo(int HargaPerKilo) {
        this.HargaPerKilo = HargaPerKilo;
    }

    public int getHargaPerKoli() {
        return HargaPerKoli;
    }

    public void setHargaPerKoli(int HargaPerKoli) {
        this.HargaPerKoli = HargaPerKoli;
    }

    public int getPacking() {
        return Packing;
    }

    public void setPacking(int Packing) {
        this.Packing = Packing;
    }

    public int getAsuransi() {
        return Asuransi;
    }

    public void setAsuransi(int Asuransi) {
        this.Asuransi = Asuransi;
    }

    public int getPPN() {
        return PPN;
    }

    public void setPPN(int PPN) {
        this.PPN = PPN;
    }

    public int getDiscon() {
        return Discon;
    }

    public void setDiscon(int Discon) {
        this.Discon = Discon;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public boolean isIsKoli() {
        return isKoli;
    }

    public void setIsKoli(boolean isKoli) {
        this.isKoli = isKoli;
    }

    public String getNOTES() {
        return NOTES;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
    }

    public int getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(int CreateBy) {
        this.CreateBy = CreateBy;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public int getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(int ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public TableKecamatan getSendKecamatan() {
        return SendKecamatan;
    }
    
    public TableKota getSendKota() {
        return SendKota;
    }

    public void setSendKecamatan(TableKecamatan SendKecamatan) {
        this.SendKecamatanId=SendKecamatan.getId();
        this.SendKecamatan = SendKecamatan;
    }

    public void setSendKota(TableKota SendKota) {
        this.SendKotaId=SendKota.getId();
        this.SendKota = SendKota;
    }

    public TableKecamatan getToKecamatan() {
        return ToKecamatan;
    }

    public void setToKecamatan(TableKecamatan ToKecamatan) {
        this.ToKecamatan = ToKecamatan;
    }

    public TableKota getToKota() {
        return ToKota;
    }

    public void setToKota(TableKota ToKota) {
        this.ToKota = ToKota;
    }

    public TableCustomer getTableCustomer() {
        return tableCustomer;
    }

    public void setTableCustomer(TableCustomer tableCustomer) {
        if(tableCustomer!=null){
            SendAlamat=tableCustomer.getAlamat();
            SendNama=tableCustomer.getNama();
            SendTelp1=tableCustomer.getPhoneNumber();
            setSendKota(tableCustomer.getKota());
            setSendKecamatan(tableCustomer.getKecamatan());
        }
        this.tableCustomer = tableCustomer;
    }
    
}
