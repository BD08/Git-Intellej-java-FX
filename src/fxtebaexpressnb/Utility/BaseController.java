/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.Utility;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.validation.RequiredFieldValidator;
import fxtebaexpressnb.DatabaseManajement.DBContext;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    protected ViewMode viewMode;

    private BaseControllerModel baseControllerModel;

    private JFXButton buttonSave;
    private JFXButton buttonCencel;
    private JFXButton buttonReset;

    public abstract void PageFistLoad();
    
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
    private boolean isFirstLoad;
    public void setBaseControllerModel(BaseControllerModel baseControllerModel) {
        this.baseControllerModel = baseControllerModel;
        this.isFirstLoad=true;
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

            getCenterPane().getChildren().setAll(anchorPane);
            //getBorderPane().setCenter(anchorPane);
        }catch (IOException ioEx){
            System.err.print("File Data Tidak ada "+ioEx.getMessage());
        }catch (Exception ioEx){
            System.err.print("Exeption "+ioEx.getMessage());
        }
        return fXMLLoader;
    }
    
    public FXMLLoader changeCenter (FileFXML fileFXML, BorderPane borderPane) {
        FXMLLoader fXMLLoader=null;
        try {
            fXMLLoader=new FXMLLoader(getFileUrl(fileFXML));
            AnchorPane anchorPane= fXMLLoader.load();
            getCenterPane().getChildren().setAll(anchorPane);
            //borderPane.setCenter(anchorPane);
        }catch (IOException ioEx){
            System.out.print("File Data Tidak ada "+ioEx.getMessage());
        }catch (Exception ioEx){
            System.out.print("Exeption "+ioEx.getMessage());
        }
        return fXMLLoader;
    }
    
    protected DBContext getDBContext(){
        return baseControllerModel.getDBContext();
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

    protected boolean isEditableMode(){
        if(viewMode!=null){
            return viewMode!=ViewMode.VIEW;
        }
        return false;
    }

    protected boolean isNotEditableMode(){
        if(viewMode!=null)
        {
            return viewMode==ViewMode.VIEW;
        }
        return false;
    }
    /**
     * Untuk Merubah semua tulisan di Button yang Dari View Dan Di panggil dalam sekali
     * @param buttonSave Button Save dari FXML nya
     * @param buttonCencel Button Edit dari FXML nya
     * @param buttonReset Button Reset Dari FXML
     */
    protected void setButtonActionViewMode(JFXButton buttonSave,JFXButton buttonCencel,JFXButton buttonReset){

        this.buttonSave=buttonSave;
        this.buttonCencel=buttonCencel;
        this.buttonReset=buttonReset;

        if(isFirstLoad){
            buttonSave.setMnemonicParsing(true);
            buttonCencel.setMnemonicParsing(true);
            buttonReset.setMnemonicParsing(true);
            isFirstLoad=false;
        }
        switch (viewMode){
            case NEW:
                buttonSave.setText("_Save");
                buttonCencel.setText("_Cancel");
                buttonReset.setText("_New Data");
                break;
            case EDIT:
                buttonSave.setText("_Save");
                buttonCencel.setText("_Cancel");
                buttonSave.setText("_Reset");
                break;
            case VIEW:
                buttonSave.setText("_Edit");
                buttonReset.setText("_New Data");
                buttonCencel.setText("_Back To List");
                buttonCencel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        loadListView();
                    }
                });
                break;
        }
    }

    protected abstract void loadListView();


    protected void setComboBoxKota(JFXComboBox comboBoxKota){
        comboBoxKota.getItems().add(TableKota.defaultTableKota());
        comboBoxKota.getItems().addAll(this.getBaseControllerModel().getDBContext().getKota().getAllData());
        comboBoxKota.getSelectionModel().select(TableKota.defaultTableKota());
    }

    /**
     * set Cild Combobox dengan List yang Sudah Di sediakan parent ato dia buat sendiri
     * @param comboBoxKecamatan
     * @param listTableKecamatans boleh null
     */
    protected void setComboBoxKecamatan(JFXComboBox comboBoxKecamatan,List<TableKecamatan> listTableKecamatans){
        comboBoxKecamatan.getItems().clear();
        comboBoxKecamatan.getItems().add(TableKecamatan.defaultTableKecamatan());
        if(listTableKecamatans==null)
            comboBoxKecamatan.getItems().addAll(this.getBaseControllerModel().getDBContext().getKecamatan().getAllData());
        else
            comboBoxKecamatan.getItems().addAll(listTableKecamatans);
        comboBoxKecamatan.getSelectionModel().select(TableKecamatan.defaultTableKecamatan());
    }

    /**
     * untuk memberikan sebuah Kota Kecamatan yang tersync dengan baik
     * @param comboboxKota Combo Box Kota Yang Di Inginkan
     * @param comboBoxKecamatan Combobox Kecamatan Yang di inginkan
     */
    protected void setComboBoxKotaKecamatanAsyn(JFXComboBox comboboxKota,JFXComboBox comboBoxKecamatan){

        setComboBoxKota(comboboxKota);
        setComboBoxKecamatan(comboBoxKecamatan,null);
        comboBoxKecamatan.showingProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                TableKecamatan selectTableKecamatan= (TableKecamatan) comboBoxKecamatan.getSelectionModel().getSelectedItem();
                if(selectTableKecamatan.getId()!=TableKecamatan.defaultTableKecamatan().getId()){
                    comboboxKota.getSelectionModel().select(selectTableKecamatan.getTableKota());
                }
            }
        });
        comboboxKota.showingProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                TableKota selectedItem= (TableKota) comboboxKota.getSelectionModel().getSelectedItem();
                if(selectedItem.getId()!=TableKota.defaultTableKota().getId()){
                    setComboBoxKecamatan(comboBoxKecamatan,selectedItem.getListAvalibleKecamatan());
                }else{
                    setComboBoxKecamatan(comboBoxKecamatan,null);
                }
                comboBoxKecamatan.getSelectionModel().select(0);
            }
        });
    }

    protected void setNextFocusObject(javafx.scene.control.Control FirstObject,javafx.scene.control.Control NextObject){
    	FirstObject.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent event) {
			    if(event.getCode()== KeyCode.ENTER||event.getCode()==KeyCode.TAB){
			    	NextObject.requestFocus();
			    }
		    }
	    });
    }
    private boolean isFormValid;
    protected void setValidatingForm(){
        if(this.viewMode==ViewMode.NEW||this.viewMode==ViewMode.EDIT){
            this.buttonSave.setDisable(!isFormValid);
        }
    }

    protected void addValidationString(JFXTextField jfxTextField){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
//        validator.setStyle();
        jfxTextField.getValidators().add(validator);

        jfxTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                jfxTextField.validate();
            }
        });
    }

    protected enum selectedMenu{
        Dashboard,
        Pengirim,
        Customer,
        Tarif,
        Transaction
    }
    protected List<buttonMainMenu> listMainMenu;
    protected void disableMainMenu(selectedMenu m){
        listMainMenu.stream().forEach(buttonMainMenu -> {
            buttonMainMenu.getButtonMenu().setDisable(buttonMainMenu.getSelectedMenu()==m);
        });
    }

    protected class buttonMainMenu{
        private JFXButton buttonMenu;
        private selectedMenu selectedMenu;

        public buttonMainMenu(JFXButton buttonMenu, BaseController.selectedMenu selectedMenu) {
            this.buttonMenu = buttonMenu;
            this.selectedMenu = selectedMenu;
        }

        public JFXButton getButtonMenu() {
            return buttonMenu;
        }

        public void setButtonMenu(JFXButton buttonMenu) {
            this.buttonMenu = buttonMenu;
        }

        public BaseController.selectedMenu getSelectedMenu() {
            return selectedMenu;
        }

        public void setSelectedMenu(BaseController.selectedMenu selectedMenu) {
            this.selectedMenu = selectedMenu;
        }
    }

}
