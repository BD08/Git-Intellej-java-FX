/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.View;

import com.jfoenix.controls.*;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.STRING_COLLECTION;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

/**
 * FXML Controller class
 *
 * @author AsusX450J
 */
public class InsertUserAccountController extends BaseController<TableUserManager> {
	

	//region From FXML Controller Model
    @FXML
    private JFXButton btnSave;
    @FXML
    private Text labelInsetAwb;
    @FXML
    private AnchorPane ParentPane;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnReset;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private Text labelInsetAwb1;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private Text labelInsetAwb11;
    @FXML
    private JFXTextArea txtAlamat;
    @FXML
    private Text labelInsetAwb12;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private Text labelInsetAwb122;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private Text labelInsetAwb121;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Text labelInsetAwb2;
    @FXML
    private JFXTextField txtPhoneNumber;
    @FXML
    private Text labelInsetAwb21;
    @FXML
    private JFXComboBox<?> txtKantorCabang;
	//endregion
	
	public static void loadInsertTransactionController (BaseController baseControllerFromParent) {
		FXMLLoader fXMLLoader ;
		fXMLLoader = baseControllerFromParent.changeCenter(FileFXML.USER_ACCOUNT_CREATE_EDIT_VIEW);
		InsertUserAccountController controller = fXMLLoader.<InsertUserAccountController>getController();
		controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
		controller.setViewMode(ViewMode.NEW);
		controller.PageFistLoad();
	}
	
	public static void loadInsertTransactionController (BaseController baseControllerFromParent, Object primaryKey) {
		FXMLLoader fXMLLoader;
		fXMLLoader = baseControllerFromParent.changeCenter(FileFXML.USER_ACCOUNT_CREATE_EDIT_VIEW);
		InsertUserAccountController controller = fXMLLoader.<InsertUserAccountController>getController();
		controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
		controller.setViewMode(ViewMode.VIEW);
		controller.PageFistLoad(primaryKey);
	}
    /**
     * Initializes the controller class.
     */
    @FXML
    void initialize() {
    	this.txtFirstName.requestFocus();
    	this.setNextFocusObject(this.txtFirstName,this.txtLastName);
    	this.setNextFocusObject(this.txtLastName,this.txtAlamat);
    	this.setNextFocusObject(this.txtAlamat,this.txtEmail);
    	this.setNextFocusObject(this.txtEmail,this.txtUsername);
    	this.setNextFocusObject(this.txtUsername,this.txtPassword);
    	this.setNextFocusObject(this.txtPassword,this.txtPhoneNumber);
    	this.setNextFocusObject(this.txtPhoneNumber,this.txtKantorCabang);
    }

    @Override
    public AnchorPane getCenterPane() {
	    return ParentPane;
    }

    @Override
    public URL getFileUrl(FileFXML fXML) {
        return getClass().getResource(fXML.toString());
    }

    @Override
    public void PageFistLoad() {
	    setViewMode(ViewMode.NEW);
	    curentModel = new TableUserManager();
	    MappingData(curentModel);
//        labelInsetAwb.setText(getLoginData());
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
	    try {
		    if(viewMode == ViewMode.VIEW) {
			    setViewMode(ViewMode.EDIT);
			    return;
		    } else {
			    curentModel = MappingData();
			    if(viewMode == ViewMode.NEW) {
				    curentModel = this.getDBContext().getUserManagers().addRow(curentModel);
			    } else {
				    this.getDBContext().getUserManagers().editRow(curentModel);
			    }
			    if(curentModel == null) {
				    this.setViewMode(ViewMode.VIEW);
			    }
			    showInformation(STRING_COLLECTION.TITLE_DATABERHASIL_DISIMPAN, STRING_COLLECTION.DATA_BEBERHASIL_DISIMPAN);
			    setViewMode(ViewMode.VIEW);
		    }
	    } catch (Exception ex) {
		    System.out.print("Error Save : " + ex.toString());
		    showAlertWarning(STRING_COLLECTION.TITLE_DATA_GAGAL_DISIMPAN, STRING_COLLECTION.DATA_GAGAL_DISIMPAN);
	    }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {

    }

    @FXML
    private void btnResetAction(ActionEvent event) {

    }

    @Override
    public void PageFistLoad(Object object, ViewMode mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	/**
	 * Page Fist Load Untuk Data yang sudah ada datanya
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad (Object object) {
		TableUserManager res = getDBContext()
				                       .getUserManagers().getStream().filter(tableUserManager ->
						                                                             tableUserManager.getId() == object.hashCode()).findFirst().get();
		MappingData(res);
	}
	
	@Override
	public void setViewMode (ViewMode mode) {
		viewMode = mode;
		if(curentModel == null && viewMode == ViewMode.VIEW) {
			setViewMode(ViewMode.NEW);
		}
		txtAlamat.setEditable(viewMode != ViewMode.VIEW);
		txtEmail.setEditable(viewMode != ViewMode.VIEW);
		txtFirstName.setEditable(viewMode != ViewMode.VIEW);
		txtKantorCabang.setEditable(viewMode != ViewMode.VIEW);
		txtLastName.setEditable(viewMode != ViewMode.VIEW);
		txtPassword.setEditable(viewMode != ViewMode.VIEW);
		txtPhoneNumber.setEditable(viewMode != ViewMode.VIEW);
		txtUsername.setEditable(viewMode != ViewMode.VIEW);
		btnCancel.setVisible(viewMode != ViewMode.VIEW);
		setButtonActionViewMode(btnSave,btnCancel,btnReset);
	}
	
	/**
	 * Mengambil data Table user manajer yang telah di mapping dari fild yang telah di isi
	 *
	 * @return data yang sudah jadi
	 */
	private TableUserManager MappingData () {
		TableUserManager res = new TableUserManager();
		if(viewMode == ViewMode.EDIT) {
			res.setId(curentModel.getId());
		}
		res.setFirstName(txtFirstName.getText());
		res.setLastName(txtLastName.getText());
		res.setAlamat(txtAlamat.getText());
		res.setEmail(txtEmail.getText());
		res.setPhoneNumber(txtPhoneNumber.getText());
		res.setUsername(txtUsername.getText());
		res.setPassword(txtPassword.getText());
		return res;
	}
	
	/**
	 * Mapping Data Untuk mengambil data yang sudah di berikan kepada model untuk menjadikan nya sebuah data yang sudah jadi
	 *
	 * @param model
	 */
	private void MappingData (TableUserManager model) {
		txtFirstName.setText(model.getFirstName());
		txtLastName.setText(model.getLastName());
		txtUsername.setText(model.getUsername());
		txtPhoneNumber.setText(model.getPhoneNumber());
		txtPassword.setText(model.getPassword());
		txtAlamat.setText(model.getAlamat());
		txtEmail.setText(model.getEmail());
		this.curentModel = model;
	}

	@Override
	protected void loadListView() {
		UserAccountListController.LoadUserAccountList(this);
	}
	
}
