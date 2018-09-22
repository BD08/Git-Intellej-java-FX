/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author AsusX450J
 */
public class ConnectionSetting {
    
    public static Connection getConnection(){
        String ConnectionDatabaseLocation;
        String ConnectionUser;
        String ConnectionPassword;
        String ConnectionDB;
        Connection connection = null;
	    try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    ConnectionDatabaseLocation = "139.99.6.110:3306";
		    ConnectionUser = "tebaexpr";
		    ConnectionDB = "tebaexpr_exps";
		    ConnectionPassword = "Teba778899!@#";
		    connection = DriverManager.getConnection("jdbc:mysql://" + ConnectionDatabaseLocation + "/" + ConnectionDB + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", ConnectionUser, ConnectionPassword);
            //DefaultLogin
        }catch(Exception e){
            System.out.print(e);
        }
        return connection;
    }
}
