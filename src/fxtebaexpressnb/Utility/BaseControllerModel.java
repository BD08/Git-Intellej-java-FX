/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.Utility;

import fxtebaexpressnb.DatabaseManajement.DBContext;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author AsusX450J
 */
public class BaseControllerModel {
    private String dataCoba;
    private BorderPane borderPane;
    private DBContext bContext;
//    private 
    
    public String getDataCoba() {
        return dataCoba;
    }

    public void setDataCoba(String dataCoba) {
        this.dataCoba = dataCoba;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public DBContext getbContext() {
        if(bContext==null){
            bContext=new DBContext();
        }
        return bContext;
    }
    
    
    
}
