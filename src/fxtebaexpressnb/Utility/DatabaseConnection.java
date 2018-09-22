/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.Utility;

import java.sql.*;
/**
 *
 * @author AsusX450J
 */
public class DatabaseConnection {
    
    private Connection connection;
    private Statement statement;
    private String databaseLocation;
    private String dbName;
    private String usernameDB;
    private String passwordDB;
    
    public DatabaseConnection(){
        databaseLocation = "139.99.6.110";
        dbName = "tebaexpr_exps";
        usernameDB = "tebaexpr";
        passwordDB = "Teba778899!@#";
    }
    
    public Connection getConnection() throws Exception{
        if(connection==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return null;
            }
            try {
                connection=DriverManager.getConnection("jdbc:mysql://"+databaseLocation+"/"+dbName,usernameDB,
                        passwordDB);
            } catch (SQLException e) {
                System.err.println("Connection Failed! Check output console");
		e.printStackTrace();
		return null;
            }
            if(connection==null){
                System.err.println("db Cannot Connect");
                throw new Exception("Cannot Connect DB");
            }
        }
        return connection;
    }
    /**
     * Untuk Membuat Statement Standart SQL Di Java
     * @return
     * @throws Exception 
     */
    public Statement getStatement() throws Exception{
        if(statement==null){
            try {
                statement=connection.createStatement();   
            } catch (SQLException ex) {
                System.err.println("Statement Canot Create "+ex);
                throw new Exception("Canot Create Statement");
            }
        }
        return statement;
    }
    /**
     * Untuk Mmebuat ResultSet Yang Di butuhkan untuk mendapatkan data dari database
     * @param statement String untuk sql select
     * @return Result set yang bakal dirubah menjadi list di proses yang di database manajemen
     */
    public ResultSet getResultSet(String statement){
        ResultSet resultSet=null;
        try {
            resultSet=getStatement().executeQuery(statement);
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultSet;
    }
    /**
     * untuk Insert Data Ke DB
     * @param sqlChange SQL yang mau di lakukan entah insert delete dan update
     * @return Berhasil Ato Tidak
     */
    public boolean ChangeTheDB(String sqlChange){
        try {
            getStatement().execute(sqlChange);
            return true;
        } catch (Exception e) {
            System.err.println("Tedapat Error Merubah DB "+e);
            return false;
        }
    }
    
}
