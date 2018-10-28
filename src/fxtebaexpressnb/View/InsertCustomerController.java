package fxtebaexpressnb.View;

import com.jfoenix.controls.*;
import com.jfoenix.svg.SVGGlyph;
import fxtebaexpressnb.DatabaseManajement.Kecamatan;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;

public class InsertCustomerController extends BaseController<TableCustomer> {

	@FXML
	private Label titleLabel;

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
	private JFXButton backButton;
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
	private JFXTextField txtNamaPerusahaan;

	@FXML
	private JFXTextArea txtAlamat;

	@FXML
	private JFXComboBox<TableKota> comboboxKota;

	@FXML
	private Text labelInsetAwb122;

	@FXML
	private JFXComboBox<TableKecamatan> comboboxKecamatan;

	@FXML
	private JFXTextField txtContactPerson;

	@FXML
	private Text labelInsetAwb2;

	@FXML
	private JFXTextField txtPhoneNumber;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private JFXTextField txtInvoiceEmail;

	@FXML
	private JFXScrollPane scroll;

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
	private void initialize() {
		SVGGlyph arrow = new SVGGlyph(0,
				"FULLSCREEN",
				"M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 "
						+ "24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 "
						+ "12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z",
				Color.WHITE);
		arrow.setSize(20, 16);
		backButton.setGraphic(arrow);
		JFXScrollPane.smoothScrolling((ScrollPane) scroll.getChildren().get(0));
		comboBoxTypePerusahaan.requestFocus();
		this.setNextFocusObject(comboBoxTypePerusahaan,txtNamaPerusahaan);
		this.setNextFocusObject(txtNamaPerusahaan,txtAlamat);
		this.setNextFocusObject(txtAlamat,comboboxKota);
		this.setNextFocusObject(comboboxKota, comboboxKecamatan);
		this.setNextFocusObject(comboboxKecamatan,txtContactPerson);
		this.setNextFocusObject(txtContactPerson,txtPhoneNumber);
		this.setNextFocusObject(txtPhoneNumber,txtEmail);
		this.setNextFocusObject(txtEmail,txtInvoiceEmail);
		this.addValidationString(txtNamaPerusahaan);
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
		titleLabel.setText("Coba Dari COntroller Customer");
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

	/**
	 * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad(Object object){
		try {
			setViewMode(ViewMode.VIEW);
			comboBoxPreparation();
			this.curentModel = this.getBaseControllerModel().getDBContext().
					getCustomer().getStream().
					filter(tableCustomer -> tableCustomer.getId() == object.hashCode()).findFirst().get();
			if(curentModel.getId()==TableCustomer.defaultTableCustomer().getId()) {
				PageFistLoad();
			}
			this.setButtonActionViewMode(btnSave, btnReset, btnCancel);
			MappingData(curentModel);
		}catch (Exception ex)
		{
			System.err.print("Error Load PageFirstLoad"+ex);
		}
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
		comboboxKecamatan.setDisable(isNotEditableMode());
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
	@Override
	protected void loadListView() {
		CustomerListController.LoadCustomerList(this);
	}
	//endregion
}
