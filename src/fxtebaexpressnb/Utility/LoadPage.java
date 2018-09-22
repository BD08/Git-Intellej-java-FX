package fxtebaexpressnb.Utility;

import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;

public class LoadPage {
    public static void LOADPAGE(Class parent, FileFXML fileFXML, AnchorPane beforeAnchorPane){
        try {
            AnchorPane anchorPane= FXMLLoader.load(parent.getResource(fileFXML.toString()));
            beforeAnchorPane.getChildren().setAll(anchorPane);
        }catch (Exception ioEx){
            System.out.print("File Data Tidak ada "+ioEx.getMessage());
        }
    }
}
