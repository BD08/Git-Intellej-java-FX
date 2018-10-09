/**
 * Sample Skeleton for 'TransactionListView.fxml' Controller Class
 */

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

public class TransactionListController {


	//region Transaction From FXML
	@FXML // fx:id="bodyPane"
	private AnchorPane bodyPane; // Value injected by FXMLLoader

	@FXML // fx:id="btnAddCustomer"
	private JFXButton btnAddCustomer; // Value injected by FXMLLoader

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

	@FXML // fx:id="centerPaneAchore"
	private AnchorPane centerPaneAchore; // Value injected by FXMLLoader

	@FXML // fx:id="txtSearch"
	private JFXTextField txtSearch; // Value injected by FXMLLoader

	@FXML // fx:id="btnSeach"
	private JFXButton btnSeach; // Value injected by FXMLLoader

	@FXML // fx:id="treeTableView"
	private JFXTreeTableView<?> treeTableView; // Value injected by FXMLLoader

	@FXML // fx:id="idColoumn"
	private JFXTreeTableColumn<?, ?> idColoumn; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAWB"
	private JFXTreeTableColumn<?, ?> coloumnAWB; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnNamaPengirim"
	private JFXTreeTableColumn<?, ?> coloumnNamaPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAlamatPengirim"
	private JFXTreeTableColumn<?, ?> coloumnAlamatPengirim; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnNamaPenerima"
	private JFXTreeTableColumn<?, ?> coloumnNamaPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnAlamatPenerima"
	private JFXTreeTableColumn<?, ?> coloumnAlamatPenerima; // Value injected by FXMLLoader

	@FXML // fx:id="coloumnLastSync"
	private JFXTreeTableColumn<?, ?> coloumnLastSync; // Value injected by FXMLLoader
	//endregion

	@FXML
	void addCutomerOnAction(ActionEvent event) {

	}

	@FXML
	void searchItemAction(ActionEvent event) {

	}

	@FXML
	void searchOnChange(InputMethodEvent event) {

	}

}
