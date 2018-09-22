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
public class TableTarif {
    
    
    
    
    private int Id;
    private int KotaFromId;
    private int KecamatanFromId;
    private int KotaToId;
    private int KecamatanToId;
    private int HargaPerKilo;
    private int HargaPerKoli;
    private int CreateBy;
    private String CreateDate;
    private int ModifiedBy;
    private String ModifiedDate;
    private TableKota KotaFrom;
    private TableKota KotaTo;
    private TableKecamatan kecamatanFrom;
    private TableKecamatan kecamatanTo;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getKotaFromId() {
        return KotaFromId;
    }

    public void setKotaFromId(int KotaFromId) {
        this.KotaFromId = KotaFromId;
    }

    public int getKecamatanFromId() {
        return KecamatanFromId;
    }

    public void setKecamatanFromId(int KecamatanFromId) {
        this.KecamatanFromId = KecamatanFromId;
    }

    public int getKotaToId() {
        return KotaToId;
    }

    public void setKotaToId(int KotaToId) {
        this.KotaToId = KotaToId;
    }

    public int getKecamatanToId() {
        return KecamatanToId;
    }

    public void setKecamatanToId(int KecamatanToId) {
        this.KecamatanToId = KecamatanToId;
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
    

    public TableKota getKotaFrom() {
        return KotaFrom;
    }

    public void setKotaFrom(TableKota KotaFrom) {
        this.KotaFromId=KotaFrom.getId();
        this.KotaFrom = KotaFrom;
    }

    public TableKota getKotaTo() {
        return KotaTo;
    }

    public void setKotaTo(TableKota KotaTo) {
        this.KotaToId=KotaTo.getId();
        this.KotaTo = KotaTo;
    }

    public TableKecamatan getKecamatanFrom() {
        return kecamatanFrom;
    }

    public void setKecamatanFrom(TableKecamatan kecamatanFrom) {
        this.KecamatanFromId=kecamatanFrom.getId();
        this.kecamatanFrom = kecamatanFrom;
    }

    public TableKecamatan getKecamatanTo() {
        return kecamatanTo;
    }

    public void setKecamatanTo(TableKecamatan kecamatanTo) {
        this.KecamatanToId=kecamatanTo.getId();
        this.kecamatanTo = kecamatanTo;
    }

    @Override
    public String toString() {
        return String.valueOf(getHargaPerKoli());
    }
    
}
