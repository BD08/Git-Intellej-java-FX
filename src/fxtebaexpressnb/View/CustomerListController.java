package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CustomerListController {

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

}
