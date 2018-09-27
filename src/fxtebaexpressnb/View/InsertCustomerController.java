package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;

public class InsertCustomerController extends BaseController<TableCustomer> {

	public static void OpenInsertCustomer(BaseController baseController){

	}

	public static void OpenInsertCustomer(BaseController baseController, int primaryKeyCustomer){

	}

	//region From FXML Parents
	@FXML
	private AnchorPane ParentPane;

	@FXML
	private JFXButton btnSave;

	@FXML
	private JFXButton btnCancel;

	@FXML
	private JFXButton btnReset;

	@FXML
	private Text labelInsetAwb;

	@FXML
	private JFXTextField txtTypePerusahaan;

	@FXML
	private Text labelInsetAwb1;

	@FXML
	private JFXTextField txtNamaPerusahaan;

	@FXML
	private Text labelInsetAwb11;

	@FXML
	private JFXTextArea txtAlamat;

	@FXML
	private Text labelInsetAwb12;

	@FXML
	private JFXComboBox<?> comboboxKota;

	@FXML
	private Text labelInsetAwb122;

	@FXML
	private JFXComboBox<?> comboboxKecamatan;

	@FXML
	private Text labelInsetAwb121;

	@FXML
	private JFXPasswordField txtContactPerson;

	@FXML
	private Text labelInsetAwb2;

	@FXML
	private JFXTextField txtPhoneNumber;

	@FXML
	private Text labelInsetAwb21;

	@FXML
	private JFXTextField txtEmail;

	@FXML
	private Text labelInsetAwb211;

	@FXML
	private JFXTextField txtInvoiceEmail;
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

	@Override
	public void PageFistLoad() {

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

	}

	@Override
	public void setViewMode(ViewMode mode) {

	}

//	private void mapping

	//region Basic Panel
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
	//endregion
}
