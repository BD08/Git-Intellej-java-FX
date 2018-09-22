/**
 * Sample Skeleton for 'UserAccountList.fxml' Controller Class
 */

package fxtebaexpressnb.View;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableUserManager;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.StaticValue;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.function.Function;

public class UserAccountListController extends BaseController{
    
    //region From FXML Model Table
    @FXML // fx:id="basePane"
    private AnchorPane bodyPane; // Value injected by FXMLLoader
    
    static void LoadUserAccountList (BaseController baseControllerFromParent) {
        FXMLLoader fXMLLoader=null;
        fXMLLoader=baseControllerFromParent.changeCenter(FileFXML.USER_ACCOUNT_LIST_VIEW);
        UserAccountListController controller=fXMLLoader.<UserAccountListController>getController();
        controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
        controller.PageFistLoad();
    }

    @FXML // fx:id="btnAddUser"
    private JFXButton btnAddUser; // Value injected by FXMLLoader

    @FXML // fx:id="treeTableView"
    private JFXTreeTableView<TableUserManager> treeTableView; // Value injected by FXMLLoader

    @FXML // fx:id="idColoumn"
    private JFXTreeTableColumn<TableUserManager, Integer> idColoumn; // Value injected by FXMLLoader
    
    @FXML // fx:id="firstNameColumn"
    private JFXTreeTableColumn<TableUserManager, String> firstNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameColumn"
    private JFXTreeTableColumn<TableUserManager, String> lastNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="emailColumn"
    private JFXTreeTableColumn<TableUserManager, String> emailColumn; // Value injected by FXMLLoader

    @FXML // fx:id="usernameColumn"
    private JFXTreeTableColumn<TableUserManager, String> usernameColumn; // Value injected by FXMLLoader
    @FXML // fx:id="statusColumn"
    private JFXTreeTableColumn<TableUserManager, String> statusColumn; // Value injected by FXMLLoader

    @FXML // fx:id="actionColumn"
    private JFXTreeTableColumn<TableUserManager, Integer> actionColumn; // Value injected by FXMLLoader

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
    private AnchorPane centerPaneAchore;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton btnSeach;
    //endregion

    @Override
    public void PageFistLoad() {
        //TODO make load user account
        idColoumn.setVisible(false);
        setupCellValueFactory(idColoumn, (t) -> t.getIpId().asObject()); //To change body of generated lambdas, choose Tools | Templates.
        setupCellValueFactory(firstNameColumn, TableUserManager::getSpFirstName); //To change body of generated lambdas, choose Tools | Templates.
        setupCellValueFactory(lastNameColumn, TableUserManager::getSpLastName); //To change body of generated lambdas, choose Tools | Templates.
        setupCellValueFactory(emailColumn, TableUserManager::getSpEmail); //To change body of generated lambdas, choose Tools | Templates.
        setupCellValueFactory(usernameColumn, TableUserManager::getSpUsername); //To change body of generated lambdas, choose Tools | Templates.
        setupCellValueFactory(statusColumn, TableUserManager::getSpNamaCabang); //To change body of generated lambdas, choose Tools | Templates.
        Page = 0;
        bucketSize = StaticValue.bucketSize;
        ChangePage();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ChangePage () {
        ObservableList<TableUserManager> dummyData = getDBContext().getUserManagers().generateDummyData(Page, bucketSize);
        treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        treeTableView.setShowRoot(false);
        txtPage.setText(String.valueOf(Page));
        
    }

    @Override
    public AnchorPane getCenterPane() {
        return bodyPane;
    }

    @Override
    public URL getFileUrl(FileFXML fXML) {
        return getClass().getResource(fXML.toString());
    }

    @FXML
    void addUserOnAction(ActionEvent event) {
        InsertUserAccountController.loadInsertTransactionController(this);
    }

    @Override
    public void PageFistLoad(Object object, ViewMode mode) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Untuk Load Dengan ID User Yang Sudah Ada
     * @param object 
     */
    @Override
    public void PageFistLoad(Object object) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setViewMode (ViewMode mode) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private <T> void setupCellValueFactory(JFXTreeTableColumn<TableUserManager, T> column, Function<TableUserManager, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<TableUserManager, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @FXML
    void searchItemAction(ActionEvent event) {

    }

    @FXML
    void searchOnChange(InputMethodEvent event) {

    }
    
}
