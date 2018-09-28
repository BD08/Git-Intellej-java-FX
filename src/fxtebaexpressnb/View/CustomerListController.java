package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import fxtebaexpressnb.DatabaseManajement.Customer;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

public class CustomerListController extends BaseController<TableCustomer> {

	public static void LoadCustomerList(BaseController baseControllerFromParent){
		FXMLLoader fxmlLoader;
		try {
			fxmlLoader=baseControllerFromParent.changeCenter(FileFXML.USER_ACCOUNT_LIST_VIEW);
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
	private JFXButton btnAddUser;

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
	private JFXTreeTableView<?> treeTableView;

	@FXML
	private JFXTreeTableColumn<?, ?> idColoumn;

	@FXML
	private JFXTreeTableColumn<?, ?> coloumnName;

	@FXML
	private JFXTreeTableColumn<?, ?> coloumnAdress;

	@FXML
	private JFXTreeTableColumn<?, ?> colomnContactPerson;

	@FXML
	private JFXTreeTableColumn<?, ?> colomnContactPersonAdress;

	@FXML
	private JFXTreeTableColumn<?, ?> coloumnTypePerusahaan;

	@FXML
	private JFXTreeTableColumn<?, ?> colomnKotaKecamatan;
	//endregion

	@FXML
	void addUserOnAction(ActionEvent event) {

	}

	@FXML
	void searchItemAction(ActionEvent event) {

	}

	@FXML
	void searchOnChange(InputMethodEvent event) {

	}

	@Override
	public void PageFistLoad() {
		idColoumn.setVisible(false);
		setupCellValueFactory(coloumnName,tableCustomer -> tableCustomer);
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
