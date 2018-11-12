package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.svg.SVGGlyph;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.BaseControllerModel;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ArrayList;

public class MainMenuController extends BaseController<BaseControllerModel> {

    @FXML
    private Label titleLabel;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXScrollPane scroll;
    @FXML
    private StackPane root;
    @FXML
    private AnchorPane ParentPane;



    @Override
    public void PageFistLoad(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setViewMode (ViewMode mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @FXML
    private JFXButton btnTransaction;
    //endregion

    @FXML
    void btnDashboardAction(ActionEvent event) {
        disableMainMenu(selectedMenu.Dashboard);
        DashboardController.loadDashboardController(this);
    }

    @FXML
    void btnPengirimanAction(ActionEvent event) {
        disableMainMenu(selectedMenu.Pengirim);
        //InsertUserAccountController.loadInsertTransactionController(this);
        UserAccountListController.LoadUserAccountList(this);
    }

    @FXML
    void initialize() {
        SVGGlyph arrow = new SVGGlyph(0,
                "FULLSCREEN",
                "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 "
                        + "24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 "
                        + "12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z",
                Color.WHITE);
        arrow.setSize(20, 16);
        backButton.setGraphic(arrow);
        JFXScrollPane.smoothScrolling((ScrollPane) scroll.getChildren().get(0));
        setLoginData("Asu Anjing");
        DashboardController.loadDashboardController(this,borderPane);
        //region Region For Button
        this.listMainMenu=new ArrayList<>();
        this.listMainMenu.add(new buttonMainMenu(btnDashboard,selectedMenu.Dashboard));
        this.listMainMenu.add(new buttonMainMenu(btnPengiriman,selectedMenu.Pengirim));
        this.listMainMenu.add(new buttonMainMenu(btnCustomer,selectedMenu.Pengirim));
        this.listMainMenu.add(new buttonMainMenu(btnTarif,selectedMenu.Tarif));
        this.listMainMenu.add(new buttonMainMenu(btnTransaction,selectedMenu.Transaction));
        //endregion
        this.titleLabel.setText("Coba Dulu");
        super.setBorderPane(borderPane);
        disableMainMenu(selectedMenu.Dashboard);
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
        disableMainMenu(selectedMenu.Customer);
//        CustomerListController.LoadCustomerList(this);
        TransactionCheckpointModelController.loadTransactionCheckpointModelController(this);
    }

    @FXML
    void btnTarifOnclick(ActionEvent event) {
        TarifListControllerList.LoadTarifListController(this);
    }

    @Override
    protected void loadListView() {
    }



    @FXML
    void btnTransactionOnclick(ActionEvent event) {
        TransactionListController.TransactionListControllerLoad(this);
    }
    
}

