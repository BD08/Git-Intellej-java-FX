/**
 * Sample Skeleton for 'TransactionCheckpointModelView.fxml' Controller Class
 */

package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;

import fxtebaexpressnb.DatabaseManajement.TableEntity.RelationViewTransactionList.PengirimanTransactionModel;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TransactionCheckpointModelController extends BaseController<PengirimanTransactionModel> {

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

	@FXML // fx:id="coloumnLastSync1"
	private JFXTreeTableColumn<PengirimanTransactionModel, String> coloumnLastSync1; // Value injected by FXMLLoader

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
		idColoumn.setVisible(false);
		setupCellValueFactory(idColoumn,(t) -> t.getSimpleIntegerPropertyIdCheckPoint().asObject());
		setupCellValueFactory(coloumnAWB,pengirimanTransactionModel -> pengirimanTransactionModel.getSimpleStringPropertyAWB());
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
}
