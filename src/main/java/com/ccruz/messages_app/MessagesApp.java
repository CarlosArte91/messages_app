package com.ccruz.messages_app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author carlos_cruz
 */
public class MessagesApp {
    
    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        
        try (Connection connection = conn.getConnection()) {
            //
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }    
}
