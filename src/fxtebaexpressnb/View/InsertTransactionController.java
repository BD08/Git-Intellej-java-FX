/**
 * Sample Skeleton for 'InsertTransaction.fxml' Controller Class
 */

package fxtebaexpressnb.View;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTransactionModel;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.IControllerViewInput;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class InsertTransactionController extends BaseController<TableTransactionModel> implements IControllerViewInput<TableTransactionModel> {



	public static void InsertTransactionControllerLoad(BaseController baseController){
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=baseController.changeCenter(FileFXML.INSERT_TRANSACTION);
			InsertTransactionController insertTransactionController=fxmlLoader.<InsertTransactionController>getController();
			insertTransactionController.disableMainMenu(selectedMenu.Transaction);
			insertTransactionController.setBaseControllerModel(baseController.getBaseControllerModel());
			insertTransactionController.PageFistLoad();
		}catch (Exception e){
			System.err.println("Tidak Bisa Load Insert Transaction \n"+e);
		}
	}


	public static void InsertTransactionControllerLoad(BaseController baseController,int idTransaction){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseController.changeCenter(FileFXML.INSERT_TRANSACTION);
			InsertTransactionController insertTransactionController=fxmlLoader.<InsertTransactionController>getController();
			insertTransactionController.disableMainMenu(selectedMenu.Transaction);
			insertTransactionController.setBaseControllerModel(baseController.getBaseControllerModel());
			insertTransactionController.PageFistLoad(idTransaction);
		}catch (Exception e){
			System.err.println("Tidak Bisa Load Insert Transaction");
		}
	}


	//region FXML Load
	@FXML
	private HBox savebuttonPanel;


	@FXML
	private JFXTreeTableView treeTableView;
	
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
	private JFXComboBox<TableKota> comboboxKotaPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKecamatanPengirim"
	private JFXComboBox<TableKecamatan> comboboxKecamatanPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim"
	private JFXTextField txtPhoneNumberPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim2"
	private JFXTextField txtPhoneNumberPengirim2; // Value injected by FXMLLoader

	@FXML // fx:id="txtNamaPenerima"
	private JFXTextField txtNamaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtAlamatPenerima"
	private JFXTextArea txtAlamatPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKotaPenerima"
	private JFXComboBox<TableKota> comboboxKotaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxKecamatanPenerima"
	private JFXComboBox<TableKecamatan> comboboxKecamatanPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPenerima"
	private JFXTextField txtPhoneNumberPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="txtPhoneNumberPengirim21"
	private JFXTextField txtPhoneNumberPengirim21; // Value injected by FXMLLoader

	@FXML // fx:id="txtHargaPerkoli"
	private JFXTextField txtHargaPerkoli; // Value injected by FXMLLoader

	@FXML // fx:id="txtHargaPerkilo"
	private JFXTextField txtHargaPerkilo; // Value injected by FXMLLoader

	@FXML // fx:id="spinerKoli"
	private Spinner<Integer> spinerKoli; // Value injected by FXMLLoader

	@FXML // fx:id="spinerKilo"
	private Spinner<Integer> spinerKilo; // Value injected by FXMLLoader

	@FXML // fx:id="txtDiscount"
	private JFXTextField txtDiscount; // Value injected by FXMLLoader

	@FXML // fx:id="txtPPN"
	private JFXTextField txtPPN; // Value injected by FXMLLoader

	@FXML // fx:id="txtNote"
	private JFXTextArea txtNote; // Value injected by FXMLLoader
	//endregion

	@FXML
	void btnCancelAction(ActionEvent event) {
		if(viewMode==ViewMode.EDIT)
			setViewMode(ViewMode.VIEW);
		else
			this.mappingView();
	}

	@FXML
	void btnResetAction(ActionEvent event) {
		this.mappingView();

	}

	@FXML
	void btnSaveAction(ActionEvent event) {
		if(viewMode==ViewMode.VIEW){
			this.mappingView();
		}else if(viewMode==ViewMode.EDIT){
			// TODO: 10/20/2018 Untuk Membuat  Edit Methode
		}else if(viewMode== ViewMode.NEW){
			// TODO: 10/20/2018 Untuk Membuat edit Methode
		}
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

	/**
	 * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad(Object object) {
		curentModel=this.getBaseControllerModel().getDBContext().getTableTransaction().getEntityItem(object);
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
		mappingView();
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

	@Override
	public void mappingView() {
		if(this.viewMode==ViewMode.EDIT){
			if(curentModel==null){
				this.setViewMode(ViewMode.NEW);
			}
		}else if(this.viewMode==ViewMode.NEW){
			this.curentModel=new TableTransactionModel();
		}else {
			return;
		}
		this.txtAWB.setText(curentModel.getAIRWAYBILL());
		this.txtNamaPengirim.setText(curentModel.getSendNama());
		this.comboboxKotaPengirim.getSelectionModel().select(curentModel.getSendKota());
		this.comboboxKecamatanPengirim.getSelectionModel().select(curentModel.getSendKecamatan());
		this.txtPhoneNumberPengirim.setText(curentModel.getSendTelp1());
		this.txtPhoneNumberPengirim2.setText(curentModel.getSendTelp2());
		this.txtAlamatPengirim.setText(curentModel.getSendAlamat());
		this.txtNamaPenerima.setText(curentModel.getToNama());
		this.comboboxKotaPenerima.getSelectionModel().select((curentModel.getToKota()));
		this.comboboxKecamatanPenerima.getSelectionModel().select(curentModel.getToKecamatan());
		this.txtPhoneNumberPenerima.setText(curentModel.getToTelp1());
		this.txtPhoneNumberPengirim21.setText(curentModel.getToTelp2());
		this.txtAlamatPenerima.setText(curentModel.getToAlamat());
		this.txtHargaPerkoli.setText(curentModel.getHargaPerKoli()+" ");
		this.txtHargaPerkilo.setText(curentModel.getHargaPerKilo()+" ");
		this.txtPPN.setText(curentModel.getPPN()+" ");
		this.txtDiscount.setText(curentModel.getDiscon()+"");
		this.spinerKoli.getValueFactory().setValue(curentModel.getTotalKoli());
		this.spinerKilo.getValueFactory().setValue(curentModel.getTotalBerat());
		txtNote.setText(curentModel.getNOTES());
	}

	@Override
	public TableTransactionModel mappingData() {
		curentModel.setAIRWAYBILL(txtAWB.getText());
		curentModel.setSendNama(txtNamaPengirim.getText());
		curentModel.setSendKecamatan(this.comboboxKecamatanPengirim.getSelectionModel().getSelectedItem());
		curentModel.setSendKota(this.comboboxKotaPengirim.getSelectionModel().getSelectedItem());
		curentModel.setSendAlamat(this.txtAlamatPengirim.getText());
		curentModel.setSendTelp1(this.txtPhoneNumberPengirim.getText());
		curentModel.setSendTelp2(this.txtPhoneNumberPengirim2.getText());
		curentModel.setToNama(this.txtNamaPenerima.getText());
		curentModel.setToKecamatan(this.comboboxKecamatanPenerima.getSelectionModel().getSelectedIndex());
		curentModel.setToKota(this.comboboxKotaPenerima.getSelectionModel().getSelectedItem());
		curentModel.setToAlamat(this.txtAlamatPenerima.getText());
		curentModel.setToTelp1(this.txtPhoneNumberPenerima.getText());
		curentModel.setToTelp2(this.txtPhoneNumberPengirim21.getText());
		curentModel.setHargaPerKoli(Integer.getInteger(this.txtHargaPerkoli.getText()));
		curentModel.setHargaPerKilo(Integer.getInteger(this.txtHargaPerkoli.getText()));
		curentModel.setTotalKoli(this.spinerKoli.getValue());
		curentModel.setTotalBerat(this.spinerKilo.getValue());
		curentModel.setPPN(Integer.getInteger(txtPPN.getText()));
		curentModel.setDiscon(Integer.getInteger(txtDiscount.getText()));
		curentModel.setNOTES(txtNote.getText());
		return curentModel;
	}
}
