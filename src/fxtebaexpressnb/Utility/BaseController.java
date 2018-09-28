/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.Utility;

import com.jfoenix.controls.JFXTreeTableColumn;
import fxtebaexpressnb.DatabaseManajement.DBContext;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.function.Function;

/**
 *
 * @author bang Dolla
 */

/**
 * @param <O> Parameter Untuk Table Yang Sedang Di Proses
 */
public abstract class BaseController<O> {
    
    protected O curentModel;
    
    private BaseControllerModel baseControllerModel;
    
    public abstract void PageFistLoad();
    
    public abstract void PageFistLoad(Object object,ViewMode mode);
    /**
     * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
     * @param object 
     */
    public abstract void PageFistLoad(Object object);
    
    public abstract void setViewMode (ViewMode mode);
    
    public BaseControllerModel getBaseControllerModel() {
        if(baseControllerModel == null) {
            baseControllerModel = new BaseControllerModel();
        }
        return baseControllerModel;
    }
    
    public void setBaseControllerModel(BaseControllerModel baseControllerModel) {
        this.baseControllerModel = baseControllerModel;
//        loginData=baseControllerModel.getDataCoba();
    }
    
    private BorderPane getBorderPane () {
        return baseControllerModel.getBorderPane();
    }
    
    protected void setBorderPane (BorderPane borderPane) {
        baseControllerModel.setBorderPane(borderPane);
    }
    
    
    protected String getLoginData(){
        return baseControllerModel.getDataCoba();
    }
    
    protected void setLoginData (String loginData) {
        getBaseControllerModel().setDataCoba(loginData);
    }
    
    /**
     * Untuk Mengatur Center AnchorPane Pada setiap Anak BaseController
     * @return 
     */
    public abstract AnchorPane getCenterPane();
    
    /**
     * Untuk Mendapatkan membuat URL data yang lebih Sepesifik
     * @param fXML
     * @return 
     */
    public abstract URL getFileUrl(FileFXML fXML);
    
    /**
     * Fungsi Ini Untuk loading file di Anchorpane yang file 
     * @param fileFXML Lokasi File Nya
     * @return Hasil Nya Untuk Di ambil Contrroller nya pada Static yang harus ada di setiap anaknya
     * Cotoh Bisa Dilihat Di dashboard Controller dan Main Menu
     * @Author BangDolla08
     * 
     * Contoh Penggunaan:
     *      public static void loadDashboardController(BaseController load){
     *          FXMLLoader fXMLLoader=null;
     *          fXMLLoader=load.changeCenter(FileFXML.DASHBOARDFILE);
     *          DashboardController namaClass Anakan nya
     *          fXMLLoader.<DashboardController>getController().setBaseControllerModel(load.getBaseControllerModel());
     *      }
     * 
     * dan penggunaaan tinggal di pakek aja dengan cara memanggil static tersebut contoh
     * DashboardController.loadDashboardController(this);
     * tujuan nya kenapa agar tidak ruwet Guys Manggil nya 
     * semua View Dan Controller Di taruh 1 Folder
     */
    public FXMLLoader changeCenter(FileFXML fileFXML){
        FXMLLoader fXMLLoader=null;
        try {
            fXMLLoader=new FXMLLoader(getFileUrl(fileFXML));
            AnchorPane anchorPane= fXMLLoader.load();
            //getCenterPane().getChildren().setAll(anchorPane);
            getBorderPane().setCenter(anchorPane);
        }catch (IOException ioEx){
            System.out.print("File Data Tidak ada "+ioEx.getMessage());
        }catch (Exception ioEx){
            System.out.print("Exeption "+ioEx.getMessage());
        }
        return fXMLLoader;
    }
    
    public FXMLLoader changeCenter (FileFXML fileFXML, BorderPane borderPane) {
        FXMLLoader fXMLLoader=null;
        try {
            fXMLLoader=new FXMLLoader(getFileUrl(fileFXML));
            AnchorPane anchorPane= fXMLLoader.load();
            //getCenterPane().getChildren().setAll(anchorPane);
            borderPane.setCenter(anchorPane);
        }catch (IOException ioEx){
            System.out.print("File Data Tidak ada "+ioEx.getMessage());
        }catch (Exception ioEx){
            System.out.print("Exeption "+ioEx.getMessage());
        }
        return fXMLLoader;
    }
    
    protected DBContext getDBContext(){
        return baseControllerModel.getbContext();
    }
    
    protected int Page=0;
    protected int bucketSize=10;
    
    // Show a Warning Alert with default header Text
    protected void showAlertWarning (String warningTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning alert");
        if(warningTitle.isEmpty()) {
            alert.setHeaderText(warningTitle);
        }
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    protected void showAlertError (String errorTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        if(errorTitle.isEmpty()) {
            alert.setHeaderText(errorTitle);
        }
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    protected void showInformation (String informationTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        if(informationTitle.isEmpty()) {
            alert.setHeaderText(informationTitle);
        }
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    protected void showSuksesDialog (String suksesTitle, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sukses");
        if(suksesTitle.isEmpty()) {
            alert.setHeaderText(suksesTitle);
        }
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    /**
     * Setup Cell Value factory Untuk Membuat colomn Dan datanya
     *
     * @param column
     * @param mapper
     * @param <T>
     */
    protected <T> void setupCellValueFactory (JFXTreeTableColumn<O, T> column, Function<O, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<O, T> param) -> {
            if(column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    
}
