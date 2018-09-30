package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKodeMaster;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
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
	private JFXComboBox<TableKodeMaster> comboBoxTypePerusahaan;

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
		switch (viewMode){
			case NEW:
				this.curentModel=TableCustomer.defaultTableCustomer();
				this.setViewMode(ViewMode.NEW);
				MappingData(curentModel);
				break;
			case EDIT:
				MappingData(curentModel);
				this.setViewMode(ViewMode.VIEW);
				break;
		}
	}

	@FXML
	void btnResetAction(ActionEvent event) {
		switch (viewMode)
		{
			case VIEW :
			case NEW:
				this.curentModel=TableCustomer.defaultTableCustomer();
				this.setViewMode(ViewMode.NEW);
				MappingData(curentModel);
				break;
			case EDIT:
				this.setViewMode(ViewMode.EDIT);
				MappingData(curentModel);
				break;
		}
	}

	@FXML
	void btnSaveAction(ActionEvent event) {
		try {
			if(viewMode == ViewMode.VIEW) {
				setViewMode(ViewMode.EDIT);
				return;
			} else {
				curentModel = MappingData();
				if(viewMode == ViewMode.NEW) {
					curentModel = this.getDBContext().getCustomer().addRow(curentModel);
				} else {
					this.getDBContext().getCustomer().editRow(curentModel);
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

	@Override
	public void PageFistLoad() {
		comboBoxPreparation();
		setViewMode(ViewMode.NEW);
		this.setButtonActionViewMode(btnSave,btnReset,btnCancel);
		this.curentModel=TableCustomer.defaultTableCustomer();
		MappingData(this.curentModel);
	}

	private void comboBoxPreparation(){
		this.comboBoxTypePerusahaan.getItems().add(TableKodeMaster.defaultTableKodeMaster());
		this.comboBoxTypePerusahaan.getItems().addAll(this.getBaseControllerModel().getDBContext().getTypePerusahaan().getAllData());
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
		comboBoxPreparation();
		this.curentModel=this.getBaseControllerModel().getDBContext().
				getCustomer().getStream().
				filter(tableCustomer -> tableCustomer.getId()==object.hashCode()).findFirst().get();
		this.setButtonActionViewMode(btnSave,btnReset,btnCancel);
		this.setViewMode(ViewMode.VIEW);
		MappingData(curentModel);
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
		res.setNama(txtNamaPerusahaan.getText());
		res.setPhoneNumber(txtPhoneNumber.getText());
		res.setAlamat(txtAlamat.getText());
		res.setInvoiceMail(txtInvoiceEmail.getText());
		res.setEmail(txtEmail.getText());
		res.setContactPersonInvoice(txtContactPerson.getText());
		res.setKota(comboboxKota.getValue());
		res.setKecamatan(comboboxKecamatan.getValue());
		res.setTypePerusahanKode(comboBoxTypePerusahaan.getValue());
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
		if(model.getId()==TableCustomer.defaultTableCustomer().getId()){
			txtPhoneNumber.setText("");
			txtNamaPerusahaan.setText("");
			txtAlamat.setText("");
			txtInvoiceEmail.setText("");
			txtEmail.setText("");
			txtContactPerson.setText("");
			comboBoxTypePerusahaan.getSelectionModel().select(0);
			comboboxKota.getSelectionModel().select(0);
			comboboxKecamatan.getSelectionModel().select(0);
			return;
		}
		txtPhoneNumber.setText(model.getPhoneNumber());
		txtNamaPerusahaan.setText(model.getNama());
		txtAlamat.setText(model.getAlamat());
		txtInvoiceEmail.setText(model.getInvoiceMail());
		txtEmail.setText(model.getEmail());
		txtContactPerson.setText(model.getContactPersonInvoice());
		if(model.getKotaId()>0)
			comboboxKota.getSelectionModel().select(model.getKota());
		else
			comboboxKota.getSelectionModel().select(TableKota.defaultTableKota());

		if(model.getKecamatanId()>0)
			comboboxKecamatan.getSelectionModel().select(model.getKecamatan());
		else
			comboboxKecamatan.getSelectionModel().select(TableKecamatan.defaultTableKecamatan());
		if(model.getTypePerusahaan().isEmpty())
			comboBoxTypePerusahaan.getSelectionModel().select(TableKodeMaster.defaultTableKodeMaster());
		else
			comboBoxTypePerusahaan.getSelectionModel().select(model.getTypePerusahanKode());
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
