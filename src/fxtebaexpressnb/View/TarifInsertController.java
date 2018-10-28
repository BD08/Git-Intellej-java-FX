package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKecamatan;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKota;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTarif;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

public class TarifInsertController  extends BaseController<TableTarif> {

	public static void LoadNewTarifInsertController(BaseController baseController){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseController.changeCenter(FileFXML.TARIF_EDIT_VIEW);
			TarifInsertController tarifInsertController=fxmlLoader.<TarifInsertController>getController();
			tarifInsertController.setBaseControllerModel(baseController.getBaseControllerModel());
			tarifInsertController.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Cannot Load new tarif Insert Controller "+ex);
		}
	}

	public static void LoadNewTarifInsertController(BaseController baseController,int TarifId){
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=baseController.changeCenter(FileFXML.TARIF_EDIT_VIEW);
			TarifInsertController tarifInsertController=fxmlLoader.<TarifInsertController>getController();
			tarifInsertController.setBaseControllerModel(baseController.getBaseControllerModel());
			tarifInsertController.PageFistLoad(TarifId);
		}catch (Exception ex){
			System.err.print("Canot Load Edit Tarif Update Controller "+ex);
		}
	}

	//region From FXML Load
	@FXML // fx:id="ParentPane"
	private AnchorPane ParentPane; // Value injected by FXMLLoader

	@FXML // fx:id="btnSave"
	private JFXButton btnSave; // Value injected by FXMLLoader

	@FXML // fx:id="btnCancel"
	private JFXButton btnCancel; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private JFXButton btnReset; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb13"
	private Text labelInsetAwb13; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb123"
	private Text labelInsetAwb123; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxFromKota"
	private JFXComboBox<TableKota> comboBoxFromKota; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb1221"
	private Text labelInsetAwb1221; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxFromKecamatan1"
	private JFXComboBox<TableKecamatan> comboBoxFromKecamatan1; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb131"
	private Text labelInsetAwb131; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb1231"
	private Text labelInsetAwb1231; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxToKota"
	private JFXComboBox<TableKota> comboBoxToKota; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb12211"
	private Text labelInsetAwb12211; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxToKecamatan"
	private JFXComboBox<TableKecamatan> comboBoxToKecamatan; // Value injected by FXMLLoader

	@FXML // fx:id="labelInsetAwb211"
	private Text labelInsetAwb211; // Value injected by FXMLLoader

	@FXML // fx:id="txtHargaPerKilo"
	private JFXTextField txtHargaPerKilo; // Value injected by FXMLLoader

	@FXML // fx:id="label"
	private Text label; // Value injected by FXMLLoader

	@FXML // fx:id="txtPricePerKoli"
	private JFXTextField txtPricePerKoli; // Value injected by FXMLLoader
	//endregion

	@FXML
	private void btnCancelAction(ActionEvent event) {

	}

	@FXML
	private void btnResetAction(ActionEvent event) {

	}

	@FXML
	private void initialize(){
		comboBoxFromKota.requestFocus();
		this.setNextFocusObject(comboBoxFromKota,comboBoxFromKecamatan1);
		this.setNextFocusObject(comboBoxFromKecamatan1,comboBoxToKota);
		this.setNextFocusObject(comboBoxToKota,comboBoxToKecamatan);
		this.setNextFocusObject(comboBoxToKecamatan,txtHargaPerKilo);
		this.setNextFocusObject(txtHargaPerKilo,txtPricePerKoli);
	}

	@FXML
	private void btnSaveAction(ActionEvent event) {
		try{
			if(this.viewMode==ViewMode.VIEW){
				setViewMode(ViewMode.EDIT);
				return;
			}
			this.curentModel.setKotaTo(comboBoxToKota.getValue());
			this.curentModel.setKotaFrom(comboBoxFromKota.getValue());
			this.curentModel.setKecamatanTo(comboBoxToKecamatan.getValue());
			this.curentModel.setKecamatanFrom(comboBoxFromKecamatan1.getValue());
			this.curentModel.setHargaPerKoli(Integer.parseInt(txtPricePerKoli.getText()));
			this.curentModel.setHargaPerKilo(Integer.parseInt(txtHargaPerKilo.getText()));
			if(this.viewMode==ViewMode.EDIT){
				this.getDBContext().getTarif().editRow(curentModel);
			}
			if(this.viewMode==ViewMode.NEW){
				this.getDBContext().getTarif().addRow(curentModel);
			}
			setViewMode(ViewMode.VIEW);
		}catch (Exception ex){
			System.err.print("Terdapat error Saat Save");
		}
	}

	@Override
	public void PageFistLoad() {
		curentModel=new TableTarif();
		this.setViewMode(ViewMode.NEW);
	}



	/**
	 * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad(Object object) {
		this.curentModel=getDBContext().getTarif().getEntityItem(object);
		this.setViewMode(ViewMode.VIEW);

	}

	@Override
	public void setViewMode(ViewMode mode) {
		this.viewMode=mode;
		setButtonActionViewMode(btnSave,btnCancel,btnReset);
		this.comboBoxFromKecamatan1.setDisable(isNotEditableMode());
		this.comboBoxFromKota.setDisable(isNotEditableMode());
		this.comboBoxToKecamatan.setDisable(isNotEditableMode());
		this.comboBoxToKota.setDisable(isNotEditableMode());
		this.txtPricePerKoli.setDisable(isNotEditableMode());
		this.txtHargaPerKilo.setDisable(isNotEditableMode());
		MappingData();
	}

	private void MappingData(){
		if (this.viewMode==ViewMode.VIEW&&curentModel==null){
			setViewMode(ViewMode.NEW);
		}
		if(this.viewMode==ViewMode.NEW)
			curentModel=TableTarif.NewTableTarif();
		this.setComboBoxKotaKecamatanAsyn(comboBoxFromKota,comboBoxFromKecamatan1);
		this.setComboBoxKotaKecamatanAsyn(comboBoxToKota,comboBoxToKecamatan);
		this.txtHargaPerKilo.setText(String.valueOf(curentModel.getHargaPerKilo()));
		this.txtPricePerKoli.setText(String.valueOf(curentModel.getHargaPerKoli()));
		this.comboBoxFromKota.getSelectionModel().select(curentModel.getKotaFrom());
		this.comboBoxToKota.getSelectionModel().select(curentModel.getKotaTo());
		this.comboBoxFromKecamatan1.getSelectionModel().select(curentModel.getKecamatanFrom());
		this.comboBoxToKecamatan.getSelectionModel().select(curentModel.getKecamatanTo());
	}

	/**
	 * Untuk Mengatur Center AnchorPane Pada setiap Anak BaseController
	 *
	 * @return
	 */
	@Override
	public AnchorPane getCenterPane() {
		return this.ParentPane;
	}

	/**
	 * Untuk Mendapatkan membuat URL data yang lebih Sepesifik
	 *
	 * @param fXML
	 * @return
	 */
	@Override
	public URL getFileUrl(FileFXML fXML) {
		return null;
	}

	@Override
	protected void loadListView() {
		TarifListControllerList.LoadTarifListController(this);
	}
}
