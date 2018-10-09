package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.BaseControllerModel;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;

public class MainMenuController extends BaseController<BaseControllerModel> {

    @Override
    public void PageFistLoad(Object object, ViewMode mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PageFistLoad(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setViewMode (ViewMode mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private enum selectedMenu{
        Dashboard,
        Pengirim,
        Customer,
        Tarif
    }
    private selectedMenu menuSelect;
    
    private void loadData(selectedMenu m){
        menuSelect=m;
        btnDashboard.setDisable(menuSelect==selectedMenu.Dashboard);
        btnPengiriman.setDisable(menuSelect==selectedMenu.Pengirim);
        btnCustomer.setDisable(menuSelect==selectedMenu.Customer);
        btnTarif.setDisable(menuSelect==selectedMenu.Tarif);
    }


    //region From FXML Desain
    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnPengiriman;

    @FXML
    public AnchorPane centerPane;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnTarif;
    //endregion

    @FXML
    void btnDashboardAction(ActionEvent event) {
        loadData(selectedMenu.Dashboard);
        DashboardController.loadDashboardController(this);
    }

    @FXML
    void btnPengirimanAction(ActionEvent event) {
        loadData(selectedMenu.Pengirim);
        //InsertUserAccountController.loadInsertTransactionController(this);
        UserAccountListController.LoadUserAccountList(this);
    }
    @FXML
    void initialize() {
        setLoginData("Asu Anjing");
        DashboardController.loadDashboardController(this,borderPane);
        super.setBorderPane(borderPane);
        loadData(selectedMenu.Dashboard);
    }

    @Override
    public AnchorPane getCenterPane() {
        return centerPane;
    }

    @Override
    public URL getFileUrl(FileFXML fXML) {
        return getClass().getResource(fXML.toString());
    }

    @Override
    public void PageFistLoad() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    void btnCustomer(ActionEvent event) {
        loadData(selectedMenu.Customer);
        CustomerListController.LoadCustomerList(this);
    }

    @FXML
    void btnTarifOnclick(ActionEvent event) {
        loadData(selectedMenu.Tarif);
        TarifListController.LoadTarifListController(this);
    }

    @Override
    protected void loadListView() {
    }
    
}

