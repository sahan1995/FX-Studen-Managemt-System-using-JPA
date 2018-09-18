/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.db;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Sahan Rajakaruna
 */
public class DbConnection {

    private static DbConnection getConnection;
    private Connection conn;

    private DbConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        File dbPropertifile = new File("resource/application.properties");
        
        FileReader myfile = new FileReader(dbPropertifile);

        Properties dbProperties = new Properties();
        dbProperties.load(myfile);

        String ip = dbProperties.getProperty("ip");
        String port = dbProperties.getProperty("port");
        String uname = dbProperties.getProperty("username");
        String pass = dbProperties.getProperty("pass");
        String url = "jdbc:mysql://127.0.0.1:3306/newStu";
        System.out.println(url);
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newStu", "root", "");
    }

    public static DbConnection getInstance() throws Exception {
        if (getConnection == null) {
            getConnection = new DbConnection();
        }
        return getConnection;

    }

    public Connection getConnection() {
        return conn;
    }
}
