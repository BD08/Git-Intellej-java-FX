/**
 * Sample Skeleton for 'TransactionCheckpointModelView.fxml' Controller Class
 */

package fxtebaexpressnb.View;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fxtebaexpressnb.DatabaseManajement.TableEntity.RelationViewTransactionList.PengirimanTransactionModel;
import fxtebaexpressnb.Utility.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TransactionCheckpointModelController extends BaseController<PengirimanTransactionModel> {

	public static void loadTransactionCheckpointModelController(BaseController base){
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=base.changeCenter(FileFXML.VIEW_TRANSACTION_CHECPOINT);
			TransactionCheckpointModelController tarifListController=fxmlLoader.<TransactionCheckpointModelController>getController();
//			tarifListController.disableMainMenu(selectedMenu.Tarif);
			tarifListController.setBaseControllerModel(base.getBaseControllerModel());
			tarifListController.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Tidak Bisa Load"+ex);
		}
	}

	private BD08MappingDatabase mappingDatabase;
	private DataTableResult<PengirimanTransactionModel> dataTableResult;

	@FXML
	private JFXTextField txtSearch;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="treeTableView"
	private JFXTreeTableView<PengirimanTransactionModel> treeTableView; // Value injected by FXMLLoader

	@FXML // fx:id="idColoumn"
	private JFXTreeTableColumn<PengirimanTransactionModel, Integer> idColoumn; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAWB"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnAWB; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnNamaPengirim"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnNamaPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAlamatPengirim"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnAlamatPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnNamaPenerima"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnNamaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAlamatPenerima"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnAlamatPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnLastSync"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnLastSync; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnNamaPembawa"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnNamaPembawa; // Value injected by FXMLLoader

	@FXML // fx:id="btnFirst"
	private JFXButton btnFirst; // Value injected by FXMLLoader

	@FXML // fx:id="btnBefore"
	private JFXButton btnBefore; // Value injected by FXMLLoader

	@FXML // fx:id="txtPage"
	private JFXTextField txtPage; // Value injected by FXMLLoader

	@FXML // fx:id="txtMaxPage"
	private Text txtMaxPage; // Value injected by FXMLLoader

	@FXML // fx:id="btnNext"
	private JFXButton btnNext; // Value injected by FXMLLoader

	@FXML // fx:id="btnLast"
	private JFXButton btnLast; // Value injected by FXMLLoader

	@FXML
	private AnchorPane parentPanel;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

	}

	@Override
	public void PageFistLoad() {
		try {
			this.dataTableResult=new DataTableResult<PengirimanTransactionModel>();

			this.mappingDatabase=new BD08MappingDatabase(this.getDBContext().getConnection());
		}catch (Exception e){

		}
		idColoumn.setVisible(false);
		setupCellValueFactory(idColoumn,(t) -> t.getSimpleIntegerPropertyIdCheckPoint().asObject());
		setupCellValueFactory(coloumnAWB,pengirimanTransactionModel -> pengirimanTransactionModel.getSimpleStringPropertyAWB());
		setupCellValueFactory(coloumnNamaPenerima,t->t.getSimpleStringPropertyNamaPenerima());
		setupCellValueFactory(coloumnNamaPengirim,t->t.getSimpleStringPropertyNamaPengirim());
		setupCellValueFactory(coloumnAlamatPenerima,pengirimanTransactionModel -> pengirimanTransactionModel.getSimpleStringPropertyAlamatPenerima());
		setupCellValueFactory(coloumnAlamatPengirim,pengirimanTransactionModel -> pengirimanTransactionModel.getSimpleStringPropertyAlamatPengirim());
		setupCellValueFactory(coloumnLastSync,t->t.getSimpleStringPropertyTanggalCheckIn());
		setupCellValueFactory(coloumnNamaPembawa,t->t.getSimpleStringPropertyPembawa());
		ChangePage();
	}

	private void ChangePage(){
		try{
			String condition=txtSearch.getText();
			if(condition.isEmpty())
				condition="";
			else
				condition=String.format("WHERE T.SendName LIKE '%%s%' AND " +
						"T.ToNama LIKE '%%s%' AND " +
						"T.SendAlamat LIKE '%%s%' AND " +
						"T.ToAlamat LIKE '%%s%' AND " +
						"T.Airwaybill LIKE '%%s%' AND " +
						"U.FirstName LIKE '%%s%' ",condition);

			String stringSql="SELECT " +
					"T.Id AS idTransaction, " +
					"T.SendNama AS namaPengirim, " +
					"T.ToNama AS namaPenerima, " +
					"T.SendAlamat AS alamatPengirim, " +
					"T.ToAlamat AS alamatPenerima, " +
					"C.Id AS idCheckPoint, " +
					"C.TypeCheckPoint AS typeCheckPointInt, " +
					"T.CreateDate AS tanggalKirim, " +
					"C.CreateDate AS tanggalCheckIn, " +
					"U.FirstName AS namaPembawa, " +
					"T.Airwaybill AS NOAWB " +
					"FROM Transaksi T " +
					"INNER JOIN CheckPoint C ON T.Id=C.TransaksiId " +
					"INNER JOIN UserManager U ON C.CreateBy=U.Id "+condition;
			dataTableResult=this.mappingDatabase.getDataTableResult(stringSql,PengirimanTransactionModel.class,dataTableResult,true);
			treeTableView.setRoot(new RecursiveTreeItem<>(dataTableResult.getObservableList(), RecursiveTreeObject::getChildren));
			treeTableView.setShowRoot(false);
			txtPage.setText((dataTableResult.getCurrentPage()+1)+"");
		}catch (Exception ex){
			System.err.print(ex);
		}
	}

	/**
	 * untuk Load Data yang sudah ada dan otomatis menjadi View Mode
	 *
	 * @param object
	 */
	@Override
	public void PageFistLoad(Object object) {
	}

	@Override
	public void setViewMode(ViewMode mode) {

	}

	/**
	 * Untuk Mengatur Center AnchorPane Pada setiap Anak BaseController
	 *
	 * @return
	 */
	@Override
	public AnchorPane getCenterPane() {
		return parentPanel;
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

	}

	@FXML
	private void btnLastOnaction(ActionEvent actionEvent) {
		this.dataTableResult.lastPage();
		this.ChangePage();
	}

	@FXML
	private void btnNextOnAction(ActionEvent actionEvent) {
		this.dataTableResult.nextPage();
		this.ChangePage();
	}

	@FXML
	private void btnBeforeOnaction(ActionEvent actionEvent) {
		this.dataTableResult.previousPage();
		this.ChangePage();
	}

	@FXML
	private void btnFirstOnAction(ActionEvent actionEvent) {
		this.dataTableResult.firstPage();
		this.ChangePage();
	}

	@FXML
	private void searchItemAction(ActionEvent actionEvent) {

	}

	@FXML
	private void onKeyPress(KeyEvent keyEvent) {
		if(keyEvent.getCode()== KeyCode.ENTER){
			this.ChangePage();
		}
	}
}
