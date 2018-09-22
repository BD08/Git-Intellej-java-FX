package fxtebaexpressnb.DatabaseManajement.TableEntity;


import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableUserManager extends RecursiveTreeObject<TableUserManager>{
    
    private int Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Username;
    private String Password;
    private String Alamat;
    private String PhoneNumber;
    private int CabangId;
    private TableCabangManager cabangManager;
    
    
    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public int getCabangId() {
        return CabangId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setCabangId(int CabangId) {
        this.CabangId = CabangId;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public TableCabangManager getCabangManager() {
        return cabangManager;
    }

    public void setCabangManager(TableCabangManager cabangManager) {
        this.cabangManager = cabangManager;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Untuk Membuat Table List View">
    public SimpleIntegerProperty getIpId() {
        return new SimpleIntegerProperty(Id);
    }

    public SimpleStringProperty getSpLastName() {
        return new SimpleStringProperty(LastName);
    }

    public SimpleStringProperty getSpFirstName() {
        return new SimpleStringProperty(FirstName);
    }

    public SimpleStringProperty getSpEmail() {
        return new SimpleStringProperty(Email);
    }

    public SimpleStringProperty getSpUsername() {
        return new SimpleStringProperty(Username);
    }

    public SimpleStringProperty getSpPassword() {
        return new SimpleStringProperty(Password);
    }

    public SimpleStringProperty getSpAlamat() {
        return new SimpleStringProperty(Alamat);
    }

    public SimpleStringProperty getSpPhoneNumber() {
        return new SimpleStringProperty(PhoneNumber);
    }

    public SimpleIntegerProperty getIpCabangId() {
        return new SimpleIntegerProperty(CabangId);
    }
    public SimpleStringProperty getSpNamaCabang(){
        return new SimpleStringProperty("Coa");
    }
    //</editor-fold>

   
    //TODO Cabang Belom ada kelasnya
}
