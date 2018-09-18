/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.sms.db.DbConnection;

/**
 *
 * @author Sahan Rajakaruna
 */
public class CrudUtil {

    private static PreparedStatement getPreStatement(String query, Object... args) throws Exception {
        PreparedStatement pre = DbConnection.getInstance().getConnection().prepareStatement(query);
        for (int i = 0; i < args.length; i++) {
            pre.setObject(i + 1, args[i]);

        }

        return pre;
    }

    public static boolean executeUpdate(String query, Object... args) throws Exception {
        return getPreStatement(query, args).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(String query, Object... args) throws Exception {
        return getPreStatement(query, args).executeQuery();
    }
}
