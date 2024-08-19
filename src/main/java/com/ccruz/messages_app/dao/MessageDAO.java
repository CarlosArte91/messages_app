package com.ccruz.messages_app.dao;

import com.ccruz.messages_app.DBConnection;
import com.ccruz.messages_app.entity.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlos_cruz
 */
public class MessageDAO {
    public static int create(Message message) {
        DBConnection conn = new DBConnection();
        
        try (Connection connection = conn.getConnection()) {
            String query = "INSERT INTO messages (message, author, message_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, message.getMessage());
            statement.setString(2, message.getAuthor());
            statement.setTimestamp(3, message.getMessageDate());
            
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public static ArrayList<Message> list() {
        DBConnection conn = new DBConnection();
        ArrayList<Message> messages = new ArrayList<Message>();
        
        try (Connection connection = conn.getConnection()) {
            String query = "SELECT * FROM messages";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultset = statement.executeQuery();
            
            while (resultset.next()) {
                Message message = new Message(
                        resultset.getInt("id_message"),
                        resultset.getString("message"),
                        resultset.getString("author"),
                        resultset.getTimestamp("message_date")
                );
                
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return messages;
    }
    
    public static int update(Message message) {
        DBConnection conn = new DBConnection();
        
        try (Connection connection = conn.getConnection()) {
            String query = "UPDATE messages SET message = ? WHERE id_message = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, message.getMessage());
            statement.setInt(2, message.getIdMessage());
            
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
    
    public static int delete(int idMessage) {
        DBConnection conn = new DBConnection();
        
        try (Connection connection = conn.getConnection()) {
            String query = "DELETE FROM messages WHERE id_message = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idMessage);
            
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}
