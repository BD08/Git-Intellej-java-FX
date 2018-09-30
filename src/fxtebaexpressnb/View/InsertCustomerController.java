package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

public class InsertCustomerController extends BaseController<TableCustomer> {

	public static void OpenInsertCustomer(BaseController baseControllerFromParent){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseControllerFromParent.changeCenter(FileFXML.CUSTOMER_UPDATE_VIEW);
			InsertCustomerController controller=fxmlLoader.<InsertCustomerController>getController();
			controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
			controller.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Tidak Dapat Load "+ex.getMessage());
		}
	}

	public static void OpenInsertCustomer(BaseController baseControllerFromParent, int primaryKeyCustomer){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseControllerFromParent.changeCenter(FileFXML.CUSTOMER_UPDATE_VIEW);
			InsertCustomerController controller=fxmlLoader.<InsertCustomerController>getController();
			controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
			controller.PageFistLoad(primaryKeyCustomer);
		}catch (Exception ex){
			System.err.print("Tidak Dapat Load "+ex.getMessage());
		}
	}

	//region From FXML Parents
	@FXML
	private AnchorPane ParentPane;

	@FXML
	private JFXButton btnSave;

	@FXML
	private JFXButton btnCancel;

	@FXML
	private JFXButton btnReset;

	@FXML
	private Text labelInsetAwb;

	@FXML
	private JFXComboBox<String> comboBoxTypePerusahaan;

	@FXML
	private Text labelInsetAwb1;

	@FXML
	private JFXTextField txtNamaPerusahaan;

	@FXML
	private Text labelInsetAwb11;

	@FXML
	private JFXTextArea txtAlamat;

	@FXML
	private Text labelInsetAwb12;

	@FXML
	private JFXComboBox<TableKota> comboboxKota;

	@FXML
	private Text labelInsetAwb122;

	@FXML
	private JFXComboBox<TableKecamatan> comboboxKecamatan;

	@FXML
	private Text labelInsetAwb121;

	@FXML
	private JFXPasswordField txtContactPerson;

	@FXML
	private Text labelInsetAwb2;

	@FXML
	private JFXTextField txtPhoneNumber;

	@FXML
	private Text labelInsetAwb21;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private Text labelInsetAwb211;

	@FXML
	private JFXTextField txtInvoiceEmail;
	//endregion

	@FXML
	void btnCancelAction(ActionEvent event) {

	}

	@FXML
	void btnResetAction(ActionEvent event) {

	}

	@FXML
	void btnSaveAction(ActionEvent event) {

	}

	@Override
	public void PageFistLoad() {
		setViewMode(ViewMode.NEW);
		this.setComboBoxKotaKecamatanAsyn(comboboxKota,comboboxKecamatan);
	}

	@Override
	public void PageFistLoad(Object object, ViewMode mode) {

	}

	/**
	 * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad(Object object) {
		this.curentModel=this.getBaseControllerModel().getDBContext().getCustomer().getEntityItem(object);
		this.setViewMode(ViewMode.VIEW);
	}

	//region Untuk Mapping Data Get menjadi Tbale Customer Ato Dari Table Customer Menjadi View
	/**
	 * Mengambil data Table user manajer yang telah di mapping dari fild yang telah di isi
	 *
	 * @return data yang sudah jadi
	 */
	private TableCustomer MappingData () {
		TableCustomer res = new TableCustomer();
		if(viewMode == ViewMode.EDIT) {
			res.setId(curentModel.getId());
		}
//		res.setFirstName(txtFirstName.getText());
//		res.setLastName(txtLastName.getText());
//		res.setAlamat(txtAlamat.getText());
//		res.setEmail(txtEmail.getText());
//		res.setPhoneNumber(txtPhoneNumber.getText());
//		res.setUsername(txtUsername.getText());
//		res.setPassword(txtPassword.getText());
		return res;
	}

	/**
	 * Mapping Data Untuk mengambil data yang sudah di berikan kepada model untuk menjadikan nya sebuah data yang sudah jadi
	 *
	 * @param model
	 */
	private void MappingData (TableCustomer model) {
		txtPhoneNumber.setText(model.getPhoneNumber());
		txtNamaPerusahaan.setText(model.getNama());
		txtAlamat.setText(model.getAlamat());
		txtInvoiceEmail.setText(model.getInvoiceMail());
		txtEmail.setText(model.getEmail());
		txtContactPerson.setText(model.getContactPersonInvoice());
		if(model.getKotaId()>0)
			comboboxKota.getSelectionModel().select(0);
		else
			comboboxKota.getSelectionModel().select(model.getKota());
		if(model.getKecamatanId()>0)
			comboboxKecamatan.getSelectionModel().select(0);
		else
			comboboxKecamatan.getSelectionModel().select(model.getKecamatan());
		// TODO: 9/30/2018 Untuk Membuat Mapping Data

	}
	//endregion

	@Override
	public void setViewMode(ViewMode mode) {
		this.viewMode=mode;
		txtNamaPerusahaan.setDisable(isNotEditableMode());
		comboBoxTypePerusahaan.setDisable(isNotEditableMode());
		comboboxKota.setDisable(isNotEditableMode());
		comboboxKecamatan.setEditable(isNotEditableMode());
		txtInvoiceEmail.setDisable(isNotEditableMode());
		txtEmail.setDisable(isNotEditableMode());
		txtContactPerson.setDisable(isNotEditableMode());
		txtAlamat.setDisable(isNotEditableMode());
		txtPhoneNumber.setDisable(isNotEditableMode());
		setButtonActionViewMode(btnSave,btnCancel,btnReset);
	}

//	private void mapping

	//region Basic Panel
	/**
	 * Untuk Mengatur Center AnchorPane Pada setiap Anak BaseController
	 *
	 * @return
	 */
	@Override
	public AnchorPane getCenterPane() {
		return ParentPane;
	}

	/**
	 * Untuk Mendapatkan membuat URL data yang lebih Sepesifik
	 *
	 * @param fXML
	 * @return
	 */
	@Override
	public URL getFileUrl(FileFXML fXML) {
		return getClass().getResource(fXML.toString());
	}
	//endregion
}
