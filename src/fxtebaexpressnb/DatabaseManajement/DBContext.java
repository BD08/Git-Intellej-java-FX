/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKurir;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bd08
 */
public class DBContext{   
//    // <editor-fold desc="not Use" defaultstate="collapsed">
    //private String ConnectionDatabaseLocation;
//    private String ConnectionUser;
//    private String ConnectionPassword;
//    private String tableName;
//    private String ConnectionDB;
    // </editor-fold>
    private Connection connection;
    private TableUserManager userLogin;
    private AWBCustomer aWBCustomer;
    private Kurir kurir;
    
    public String getDate(){
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dt);
    }
    
    public int getUserLoginId(){
        return userLogin.getId();
    }
    public DBContext() {
        try{            
            connection=ConnectionSetting.getConnection();
            userLogin=new TableUserManager();
            userLogin.setId(-1);
            Reset();
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public void setLoginUser(TableUserManager userLogin){
        this.userLogin=userLogin;
    }
    
    private void Reset(){
        userManagers=new UserManagers(connection);
        cabangManager=new CabangManager(connection);
        checkPoint=new CheckPoint(connection);
        kota=new Kota(connection);
        kecamatan=new Kecamatan(connection);
        customer=new Customer(connection, getKota(), getKecamatan());
        tarif=new Tarif(connection, getKecamatan(), getKota());
        tarifKonvesional=new Tarif(getKecamatan(), connection, getKota());
        customerPrice =new CustomerPrice(connection,getTarif());
        aWBCustomer=new AWBCustomer(connection,customer);
        kurir=new Kurir(connection, userManagers);
    }
    
    private UserManagers userManagers;
    private CabangManager cabangManager;
    private CheckPoint checkPoint;
    private Customer customer;
    private CustomerPrice customerPrice;
    private Kecamatan kecamatan;
    private Kelurahan kelurahan;
    private Tarif tarif;
    private Tarif tarifKonvesional;

    public Tarif getTarifKonvesional() {
        return tarifKonvesional;
    }

    public void setTarifKonvesional(Tarif tarifKonvesional) {
        this.tarifKonvesional = tarifKonvesional;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }
    
    // <editor-fold desc="Not Use" defaultstate="collapsed">
//    public String getConnectionDatabaseLocation() {
//        return ConnectionDatabaseLocation;
//    }
//
//    public void setConnectionDatabaseLocation(String ConnectionDatabaseLocation) {
//        this.ConnectionDatabaseLocation = ConnectionDatabaseLocation;
//    }
//
//    public String getConnectionUser() {
//        return ConnectionUser;
//    }
//
//    public void setConnectionUser(String ConnectionUser) {
//        this.ConnectionUser = ConnectionUser;
//    }
//
//    public String getConnectionPassword() {
//        return ConnectionPassword;
//    }
//
//    public void setConnectionPassword(String ConnectionPassword) {
//        this.ConnectionPassword = ConnectionPassword;
//    }
//
//    public String getTableName() {
//        return tableName;
//    }
//
//    public void setTableName(String tableName) {
//        this.tableName = tableName;
//    }
//
//    public String getConnectionDB() {
//        return ConnectionDB;
//    }
//
//    public void setConnectionDB(String ConnectionDB) {
//        this.ConnectionDB = ConnectionDB;
//    }
    // </editor-fold>

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CabangManager getCabangManager() {
        return cabangManager;
    }

    public void setCabangManager(CabangManager cabangManager) {
        this.cabangManager = cabangManager;
    }

    public CheckPoint getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(CheckPoint checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerPrice getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(CustomerPrice customerPrice) {
        this.customerPrice = customerPrice;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Kelurahan getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(Kelurahan kelurahan) {
        this.kelurahan = kelurahan;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }
    private Kota kota;
    public UserManagers getUserManagers() {
        return userManagers;
    }

    public TableUserManager getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(TableUserManager userLogin) {
        this.userLogin = userLogin;
    }

    public AWBCustomer getaWBCustomer() {
        return aWBCustomer;
    }

    public void setaWBCustomer(AWBCustomer aWBCustomer) {
        this.aWBCustomer = aWBCustomer;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }
    
    
    
}