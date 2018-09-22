package fxtebaexpressnb.DatabaseManajement.TableEntity;

import java.sql.Date;

/**
 *
 * @author AsusX450J
 */
public class TableTransactionModel  {
    //<editor-fold defaultstate="collapsed" desc="Final Static Nama Nama Colomn Dalam Database">
    public final static String COLOUMN_ID="Id";
    public final static String COLOUMN_ID_CUSTOMER="idCustomer";
    public final static String COLOUMN_AIRWAYBILL="Airwaybill";
    public final static String COLOUMN_SendNama="SendNama";
    public final static String COLOUMN_SendAlamat="SendAlamat";
    public final static String COLOUMN_SendKelurahanId="SendKelurahanId";
    public final static String COLOUMN_SendKecamatan="SendKecamatan";
    public final static String COLOUMN_SendKotaId="SendKotaId";
    public final static String COLOUMN_SendTelp1="SendTelp1";
    public final static String COLOUMN_SendTelp2="SendTelp2";
    public final static String COLOUMN_ToNama="ToNama";
    public final static String COLOUMN_ToAlamat="ToAlamat";
    public final static String COLOUMN_ToKelurahanId="ToKelurahanId";
    public final static String COLOUMN_ToKecamatan="ToKecamatan";
    public final static String COLOUMN_ToKotaId="ToKotaId";
    public final static String COLOUMN_ToTelp1="ToTelp1";
    public final static String COLOUMN_ToTelp2="ToTelp2";
    public final static String COLOUMN_TotalKoli="TotalKoli";
    public final static String COLOUMN_TotalBerat="TotalBerat";
    public final static String COLOUMN_NilaiBarang="NilaiBarang";
    public final static String COLOUMN_HargaPerKoli="HargaPerKoli";
    public final static String COLOUMN_HargaPerKilo="HargaPerKilo";
    public final static String COLOUMN_TOTAL="TOTAL";
    public final static String COLOUMN_isKoli="isKoli";
    public final static String COLOUMN_Packing="Packing";
    public final static String COLOUMN_Asuransi="Asuransi";
    public final static String COLOUMN_PPN="PPN";
    public final static String COLOUMN_Discon="Discon";
    public final static String COLOUMN_NOTES="NOTES";
    public final static String COLOUMN_CreateDate="CreateDate";
    public final static String COLOUMN_CreateBy="CreateBy";
    public final static String COLOUMN_ModifyDate="ModifyDate";
    public final static String COLOUMN_ModifyBy="ModifyBy";
    
    //</editor-fold>
    
    /**
     * untuk Entytys nya disimpan
     * 
     */
    //<editor-fold defaultstate="collapsed" desc="Isi Dari Class Ini">
    private int ID;
    private int ID_CUSTOMER;
    private String AIRWAYBILL;
    private String SendNama;
    private String SendAlamat;
    private int SendKelurahanId;
    private int SendKecamatan;
    private int SendKotaId;
    private String SendTelp1;
    private String SendTelp2;
    private String ToNama;
    private String ToAlamat;
    private int ToKelurahanId;
    private int ToKecamatan;
    private int ToKotaId;
    private String ToTelp1;
    private String ToTelp2;
    private int TotalKoli;
    private int TotalBerat;
    private int NilaiBarang;
    private int HargaPerKoli;
    private int HargaPerKilo;
    private int TOTAL;
    private boolean isKoli;
    private int Packing;
    private int Asuransi;
    private int PPN;
    private int Discon;
    private String NOTES;
    private Date CreateDate;
    private int CreateBy;
    private Date ModifyDate;
    private int ModifyBy;
    //</editor-fold>
    public  TableTransactionModel(){
        
    }
    /**
     * Untuk Mencari didalam database dengan id yang sudah ada
     * @param Id dari database
     */
    public TableTransactionModel(int Id){
        
    }
    
    /**
     * Untuk Mengisi semua data Table untuk membuat baru
     * @param ID Transaction ID
     * @param ID_CUSTOMER ID Customer Nya
     * @param AIRWAYBILL
     * @param SendNama
     * @param SendAlamat
     * @param SendKelurahanId
     * @param SendKecamatan
     * @param SendKotaId
     * @param SendTelp1
     * @param SendTelp2
     * @param ToNama
     * @param ToAlamat
     * @param ToKelurahanId
     * @param ToKecamatan
     * @param ToKotaId
     * @param ToTelp1
     * @param ToTelp2
     * @param TotalKoli
     * @param TotalBerat
     * @param NilaiBarang
     * @param HargaPerKoli
     * @param HargaPerKilo
     * @param TOTAL
     * @param isKoli
     * @param Packing
     * @param Asuransi
     * @param PPN
     * @param Discon
     * @param NOTES
     * @param CreateDate
     * @param CreateBy
     * @param ModifyDate
     * @param ModifyBy 
     */
       
    public TableTransactionModel(int ID, int ID_CUSTOMER, String AIRWAYBILL, String SendNama, String SendAlamat, int SendKelurahanId, int SendKecamatan, int SendKotaId, String SendTelp1, String SendTelp2, String ToNama, int ToKelurahanId, int ToKecamatan, int ToKotaId, String ToTelp1, String ToTelp2, int TotalKoli, int TotalBerat, int NilaiBarang, int HargaPerKoli, int HargaPerKilo, int TOTAL, boolean isKoli, int Packing, int Asuransi, int PPN, int Discon, String NOTES, Date CreateDate, int CreateBy, Date ModifyDate, int ModifyBy) {
        this.ID = ID;
        this.ID_CUSTOMER = ID_CUSTOMER;
        this.AIRWAYBILL = AIRWAYBILL;
        this.SendNama = SendNama;
        this.SendAlamat = SendAlamat;
        this.SendKelurahanId = SendKelurahanId;
        this.SendKecamatan = SendKecamatan;
        this.SendKotaId = SendKotaId;
        this.SendTelp1 = SendTelp1;
        this.SendTelp2 = SendTelp2;
        this.ToNama = ToNama;
        this.ToKelurahanId = ToKelurahanId;
        this.ToKecamatan = ToKecamatan;
        this.ToKotaId = ToKotaId;
        this.ToTelp1 = ToTelp1;
        this.ToTelp2 = ToTelp2;
        this.TotalKoli = TotalKoli;
        this.TotalBerat = TotalBerat;
        this.NilaiBarang = NilaiBarang;
        this.HargaPerKoli = HargaPerKoli;
        this.HargaPerKilo = HargaPerKilo;
        this.TOTAL = TOTAL;
        this.isKoli = isKoli;
        this.Packing = Packing;
        this.Asuransi = Asuransi;
        this.PPN = PPN;
        this.Discon = Discon;
        this.NOTES = NOTES;
        this.CreateDate = CreateDate;
        this.CreateBy = CreateBy;
        this.ModifyDate = ModifyDate;
        this.ModifyBy = ModifyBy;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Untuk Setter dan Getter Data">
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_CUSTOMER() {
        return ID_CUSTOMER;
    }

    public void setID_CUSTOMER(int ID_CUSTOMER) {
        this.ID_CUSTOMER = ID_CUSTOMER;
    }

    public String getAIRWAYBILL() {
        return AIRWAYBILL;
    }

    public void setAIRWAYBILL(String AIRWAYBILL) {
        this.AIRWAYBILL = AIRWAYBILL;
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

    public int getSendKelurahanId() {
        return SendKelurahanId;
    }

    public void setSendKelurahanId(int SendKelurahanId) {
        this.SendKelurahanId = SendKelurahanId;
    }

    public int getSendKecamatan() {
        return SendKecamatan;
    }

    public void setSendKecamatan(int SendKecamatan) {
        this.SendKecamatan = SendKecamatan;
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

    public int getToKelurahanId() {
        return ToKelurahanId;
    }

    public void setToKelurahanId(int ToKelurahanId) {
        this.ToKelurahanId = ToKelurahanId;
    }

    public int getToKecamatan() {
        return ToKecamatan;
    }

    public void setToKecamatan(int ToKecamatan) {
        this.ToKecamatan = ToKecamatan;
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

    public int getHargaPerKoli() {
        return HargaPerKoli;
    }

    public void setHargaPerKoli(int HargaPerKoli) {
        this.HargaPerKoli = HargaPerKoli;
    }

    public int getHargaPerKilo() {
        return HargaPerKilo;
    }

    public void setHargaPerKilo(int HargaPerKilo) {
        this.HargaPerKilo = HargaPerKilo;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    public boolean isIsKoli() {
        return isKoli;
    }

    public void setIsKoli(boolean isKoli) {
        this.isKoli = isKoli;
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

    public String getNOTES() {
        return NOTES;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
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
    //</editor-fold>
}
