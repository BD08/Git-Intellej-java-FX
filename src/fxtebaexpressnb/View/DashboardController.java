package fxtebaexpressnb.View;

import com.jfoenix.controls.JFXButton;
import fxtebaexpressnb.Utility.BaseController;
import fxtebaexpressnb.Utility.BaseControllerModel;
import fxtebaexpressnb.Utility.FileFXML;
import fxtebaexpressnb.Utility.ViewMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.net.URL;

public class DashboardController extends BaseController<BaseControllerModel> {
    
    //<editor-fold desc="Create From parameter From FXML">
    @FXML
    private AnchorPane bodyPane;

    /**
     * Untuk load Dashboard langsung tampil pada getCenterPane()
     * @param baseControllerFromParent parentClass
     */
    static void loadDashboardController (BaseController baseControllerFromParent) {
        FXMLLoader fXMLLoader;
        try {
            fXMLLoader = baseControllerFromParent.changeCenter(FileFXML.DASHBOARDFILE);
            DashboardController controller = fXMLLoader.<DashboardController>getController();
            controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
            controller.PageFistLoad();
        } catch (Exception e) {
            System.err.println("Terjadi error Saat Load FXMLLoader Eroor");
        }
        
    }
    
    /**
     * Untuk Load Baru Sekali
     * @param baseControllerFromParent
     * @param borderPane
     */
    static void loadDashboardController (BaseController baseControllerFromParent, BorderPane borderPane) {
        FXMLLoader fXMLLoader;
        try {
            fXMLLoader = baseControllerFromParent.changeCenter(FileFXML.DASHBOARDFILE, borderPane);
            DashboardController controller = fXMLLoader.<DashboardController>getController();
            controller.setBaseControllerModel(baseControllerFromParent.getBaseControllerModel());
            controller.PageFistLoad();
        } catch (Exception e) {
            System.out.println("Terjadi error Saat Load FXMLLoader Eroor");
        }
        
    }
    @FXML
    private JFXButton btnTxt;
    @FXML
    private Text txtCobaDataS;
    //</editor-fold>

    @FXML
    private void btnText(ActionEvent event) {
        txtCobaDataS.setText(getLoginData());
        //LoadPage.LOADPAGE(getClass(),FileFXML.USER_ACCOUNT_CREATE_EDIT_VIEW,bodyPane);
    }

    @Override
    public AnchorPane getCenterPane() {
        return bodyPane;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getFileUrl(FileFXML fXML) {
        return getClass().getResource(fXML.toString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadListView() {

    }

    @Override
    public void PageFistLoad() {
        txtCobaDataS.requestFocus();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    @Override
    public void PageFistLoad(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setViewMode (ViewMode mode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
