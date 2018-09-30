package fxtebaexpressnb.View;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.StaticValue;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

public class CustomerListController extends BaseController<TableCustomer> {

	public static void LoadCustomerList(BaseController baseControllerFromParent){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseControllerFromParent.changeCenter(FileFXML.CUSTOMER_LIST_VIEW);
			CustomerListController controller=fxmlLoader.<CustomerListController>getController();
			controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
			controller.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Tidak Dapat Customer List Load "+ex.getMessage());
		}
	}
	// TODO: 9/26/2018 Untuk Membut Controller Customer List 
	//region From FXML
	@FXML
	private AnchorPane bodyPane;

	@FXML
	private JFXButton btnAddCustomer;

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
	private JFXTreeTableView<TableCustomer> treeTableView;

	@FXML
	private JFXTreeTableColumn<TableCustomer, Integer> idColoumn;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> coloumnName;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> coloumnAdress;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> colomnContactPerson;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> colomnContactPersonAdress;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> coloumnTypePerusahaan;

	@FXML
	private JFXTreeTableColumn<TableCustomer, String> colomnKotaKecamatan;
	//endregion

	@FXML
	void addCutomerOnAction(ActionEvent event) {
		InsertCustomerController.OpenInsertCustomer(this);
	}

	@FXML
	void searchItemAction(ActionEvent event) {

	}

	@FXML
	void searchOnChange(InputMethodEvent event) {

	}
	private int Page;
	@Override
	public void PageFistLoad() {
		idColoumn.setVisible(false);
		setupCellValueFactory(idColoumn, (t) -> t.getIpId().asObject());
		setupCellValueFactory(colomnContactPerson,TableCustomer::getSimpleStringPropertyNamaContactPerson);
		setupCellValueFactory(coloumnName,TableCustomer::getSimpleStringPropertyName);
		setupCellValueFactory(coloumnAdress,TableCustomer::getSimpleStringPropertyAlamat);
		setupCellValueFactory(coloumnTypePerusahaan,TableCustomer::getSimpleStringPropertyTypePerusahaan);
		setupCellValueFactory(colomnContactPersonAdress,TableCustomer::getSimpleStringPropertyPhoneNumber);
		setupCellValueFactory(colomnKotaKecamatan,TableCustomer::getSimpleStringPropertyKota);
		Page=0;
		bucketSize=StaticValue.bucketSize;
		treeTableView.setOnMouseClicked(event -> {
			if(event.getClickCount()==2){
				TreeItem<TableCustomer> tableUserManagerTreeItem=treeTableView.getSelectionModel().getSelectedItem();
				TableCustomer tmp=tableUserManagerTreeItem.getValue();
				InsertCustomerController.OpenInsertCustomer(this,tmp.getId());
			}
		});
		ChangePage();
	}

	private void ChangePage(){
		ObservableList<TableCustomer> dummyData = getDBContext().getCustomer().generateDummyData(Page, bucketSize,txtSearch.getText());
		treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
		treeTableView.setShowRoot(false);
		txtPage.setText(String.valueOf(Page));

	}

	//region Not Use In List
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

	}

	@Override
	public void setViewMode(ViewMode mode) {

	}
	//endregion


	//region Basic Programming
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
	//endregion
}
