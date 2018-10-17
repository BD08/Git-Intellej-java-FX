/**
 * Sample Skeleton for 'InsertTransaction.fxml' Controller Class
 */

package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTransactionModel;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;

public class InsertTransactionController extends BaseController<TableTransactionModel> {

	public static void InsertTransactionControllerLoad(BaseController baseController){
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=baseController.changeCenter(FileFXML.INSERT_TRANSACTION);
			InsertTransactionController insertTransactionController=fxmlLoader.<InsertTransactionController>getController();
			insertTransactionController.PageFistLoad();
		}catch (Exception e){
			System.err.println("Tidak Bisa Load Insert Transaction \n"+e);
		}
	}


	public static void InsertTransactionControllerLoad(BaseController baseController,int idTransaction){

	}


	//region FXML Load
	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="ParentPane"
	private AnchorPane ParentPane; // Value injected by FXMLLoader

	@FXML // fx:id="btnSave"
	private JFXButton btnSave; // Value injected by FXMLLoader

	@FXML // fx:id="btnCancel"
	private JFXButton btnCancel; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private JFXButton btnReset; // Value injected by FXMLLoader

	@FXML // fx:id="txtAWB"
	private JFXTextField txtAWB; // Value injected by FXMLLoader

	@FXML // fx:id="txtNamaPengirim"
	private JFXTextField txtNamaPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="txtAlamatPengirim"
	private JFXTextArea txtAlamatPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKotaPengirim"
	private JFXComboBox<?> comboboxKotaPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKecamatanPengirim"
	private JFXComboBox<?> comboboxKecamatanPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim"
	private JFXTextField txtPhoneNumberPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim2"
	private JFXTextField txtPhoneNumberPengirim2; // Value injected by FXMLLoader

	@FXML // fx:id="txtNamaPenerima"
	private JFXTextField txtNamaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtAlamatPenerima"
	private JFXTextArea txtAlamatPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKotaPenerima"
	private JFXComboBox<?> comboboxKotaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKecamatanPenerima"
	private JFXComboBox<?> comboboxKecamatanPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPenerima"
	private JFXTextField txtPhoneNumberPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim21"
	private JFXTextField txtPhoneNumberPengirim21; // Value injected by FXMLLoader

	@FXML // fx:id="txtHargaPerkoli"
	private JFXTextField txtHargaPerkoli; // Value injected by FXMLLoader

	@FXML // fx:id="txtHargaPerkilo"
	private JFXTextField txtHargaPerkilo; // Value injected by FXMLLoader

	@FXML // fx:id="spinerKoli"
	private Spinner<?> spinerKoli; // Value injected by FXMLLoader

	@FXML // fx:id="spinerKilo"
	private Spinner<?> spinerKilo; // Value injected by FXMLLoader

	@FXML // fx:id="txtDiscount"
	private JFXTextField txtDiscount; // Value injected by FXMLLoader

	@FXML // fx:id="txtPPN"
	private JFXTextField txtPPN; // Value injected by FXMLLoader

	@FXML // fx:id="txtNote"
	private JFXTextArea txtNote; // Value injected by FXMLLoader
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

	// Load Initialize
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		txtAWB.requestFocus();
		this.setNextFocusObject(txtAWB,txtNamaPengirim);
		this.setNextFocusObject(txtNamaPengirim,comboboxKotaPengirim);
		this.setNextFocusObject(comboboxKotaPengirim,comboboxKecamatanPengirim);
		this.setNextFocusObject(comboboxKecamatanPengirim,txtPhoneNumberPengirim);
		this.setNextFocusObject(txtPhoneNumberPengirim,txtPhoneNumberPengirim2);
		this.setNextFocusObject(txtPhoneNumberPengirim2,txtNamaPenerima);
		this.setNextFocusObject(txtNamaPenerima,comboboxKotaPenerima);
		this.setNextFocusObject(comboboxKotaPenerima,comboboxKecamatanPenerima);
		this.setNextFocusObject(comboboxKecamatanPenerima,txtPhoneNumberPenerima);
		this.setNextFocusObject(txtPhoneNumberPenerima,txtPhoneNumberPengirim21);
		this.setNextFocusObject(txtPhoneNumberPengirim21,spinerKilo);
		this.setNextFocusObject(spinerKilo,spinerKoli);
		this.setNextFocusObject(spinerKoli,txtDiscount);
		this.setNextFocusObject(txtDiscount,txtPPN);
		this.setNextFocusObject(txtPPN,txtNote);
	}

	@Override
	public void PageFistLoad() {
		this.setViewMode(ViewMode.NEW);
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
		this.setViewMode(ViewMode.VIEW);
	}

	@Override
	public void setViewMode(ViewMode mode) {
		this.viewMode=mode;
		txtAWB.setDisable(isNotEditableMode());
		txtNamaPenerima.setDisable(isNotEditableMode());
		txtNamaPengirim.setDisable(isNotEditableMode());
		txtAlamatPenerima.setDisable(isNotEditableMode());
		txtAlamatPengirim.setDisable(isNotEditableMode());
		txtPhoneNumberPenerima.setDisable(isNotEditableMode());
		txtPhoneNumberPengirim.setDisable(isNotEditableMode());
		txtPhoneNumberPengirim2.setDisable(isNotEditableMode());
		txtPhoneNumberPengirim21.setDisable(isNotEditableMode());
		comboboxKecamatanPenerima.setDisable(isNotEditableMode());
		comboboxKecamatanPengirim.setDisable(isNotEditableMode());
		comboboxKotaPenerima.setDisable(isNotEditableMode());
		comboboxKotaPengirim.setDisable(isNotEditableMode());
		spinerKilo.setDisable(isNotEditableMode());
		spinerKoli.setDisable(isNotEditableMode());
		txtNote.setDisable(isNotEditableMode());
		txtDiscount.setDisable(isNotEditableMode());
		txtPPN.setDisable(isNotEditableMode());
		txtHargaPerkilo.setDisable(isNotEditableMode());
		txtHargaPerkoli.setDisable(isNotEditableMode());

	}

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
		TransactionListController.TransactionListControllerLoad(this);
	}
}
