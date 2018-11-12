package fxtebaexpressnb.View;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTarif;
import fxtebaexpressnb.Utility.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.net.URL;

public class TarifListControllerList extends BaseController<TableTarif> implements IControllerViewList<TableTarif> {

	public static void LoadTarifListController(BaseController base){
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=base.changeCenter(FileFXML.TARIF_LIST_VIEW);
			TarifListControllerList tarifListController=fxmlLoader.<TarifListControllerList>getController();
			tarifListController.disableMainMenu(selectedMenu.Tarif);
			tarifListController.setBaseControllerModel(base.getBaseControllerModel());
			tarifListController.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Tidak Bisa Load"+ex);
		}
	}


	//region From FXML Load
	@FXML
	private AnchorPane bodyPane;

	@FXML
	private JFXButton btnAddTarif;

	@FXML
	private JFXButton btnFirst;

	@FXML
	private JFXButton btnBefore;

	@FXML
	private JFXTextField txtPage;

	@FXML
	private Text txtMaxPage;

	@FXML
	private JFXButton btnNext;

	@FXML
	private JFXButton btnLast;

	@FXML
	private AnchorPane centerPaneAchore;

	@FXML
	private JFXTextField txtSearch;

	@FXML
	private JFXButton btnSeach;

	@FXML
	private JFXTreeTableView<TableTarif> treeTableView;

	@FXML
	private JFXTreeTableColumn<TableTarif, Integer> idColoumn;

	@FXML
	private JFXTreeTableColumn<TableTarif, String> coloumnFrom;

	@FXML
	private JFXTreeTableColumn<TableTarif, String> colomnTo;

	@FXML
	private JFXTreeTableColumn<TableTarif, Integer> colomnPrice;

	@FXML
	private JFXTreeTableColumn<TableTarif, Integer> colomnSatuan;
	//endregion
	@Override
	public void PageFistLoad() {
		idColoumn.setVisible(false);
		setupCellValueFactory(idColoumn,tableTarif -> tableTarif.getSimpleId().asObject());
		setupCellValueFactory(colomnPrice,tableTarif -> tableTarif.getSimpleTarifPerKilo().asObject());
		setupCellValueFactory(colomnSatuan,tableTarif -> tableTarif.getSimpleIntegerPropertyPerKoli().asObject());
		setupCellValueFactory(colomnTo,tableTarif -> tableTarif.getTo());
		setupCellValueFactory(coloumnFrom,tableTarif -> tableTarif.getFrom());
		Page=0;
		bucketSize= StaticValue.bucketSize;
		ChangePage();
	}

	private void ChangePage(){
		ObservableList<TableTarif> dummyData=getDBContext().getTarifKonvesional().generateDummyData(Page,bucketSize,txtSearch.getText());
		treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
		treeTableView.setShowRoot(false);
		txtPage.setText((Page+1)+"");
		treeTableView.setOnMouseClicked(event -> {
			if(event.getClickCount()==2){
				TreeItem<TableTarif> tableTarifTreeItem=treeTableView.getSelectionModel().getSelectedItem();
				TableTarif tmp=tableTarifTreeItem.getValue();
				TarifInsertController.LoadNewTarifInsertController(this,tmp.getId());
			}
		});
	}
	@FXML
	private void addTarifOnAction(ActionEvent event) {
		TarifInsertController.LoadNewTarifInsertController(this);
	}

	@FXML
	private void searchItemAction(ActionEvent event) {
		ChangePage();
	}

	@FXML
	private void searchOnChange(InputMethodEvent event) {
		ChangePage();
	}

	@FXML
	void backPage(ActionEvent event) {
		if(Page>0){
			Page--;
			ChangePage();
		}
	}

	@FXML
	void firstPage(ActionEvent event) {
		Page=0;
	}

	@FXML
	void lastpage(ActionEvent event) {
		Page=getDBContext().getTarif().getMaximumPage();
		ChangePage();
	}

	@FXML
	void nextPage(ActionEvent event) {
		if(Page<getDBContext().getTarif().getMaximumPage()){
			Page++;
			ChangePage();
		}
	}

	@FXML
	void txtPageChange(ActionEvent event) {
		int txtpage=Integer.parseInt(txtPage.getText());
		if(txtpage>0&&txtpage<=getDBContext().getTarif().getMaximumPage()){
			Page=txtpage-1;
			ChangePage();
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
		return this.bodyPane;
	}

	/**
	 * Untuk Mendapatkan membuat URL data yang lebih Sepesifik
	 *
	 * @param fXML
	 * @return
	 */
	@Override
	public URL getFileUrl(FileFXML fXML) {
		return this.getClass().getResource(fXML.toString());
	}

	@Override
	protected void loadListView() {

	}

	/**
	 * Untuk Load Data Dan harus Memanggil List yang harus di buat di Controller
	 * seperti load database dan di plot pada list
	 */
	@Override
	public void getDataForTable() {

	}

	/**
	 * untuk memuat select data yang di ambil langsung dari list saja jangan dari database
	 *
	 * @param rowSelect
	 * @return Item yang di pilih
	 */
	@Override
	public TableTarif getSinggleSelectData(int rowSelect) {
		return null;
	}
}
