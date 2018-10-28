/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb;

import java.io.IOException;
import java.util.List;

import fxtebaexpressnb.DatabaseManajement.ConnectionSetting;
import fxtebaexpressnb.Utility.BD08MappingDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author AsusX450J
 */
public class FXTebaExpressNB extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("View/MainMenuView.fxml"));
        primaryStage.setTitle("Teba Express");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
