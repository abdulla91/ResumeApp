/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Abdulla.Maxsudov
 */
public abstract class AbstractConnectDao {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "123456789";        
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
