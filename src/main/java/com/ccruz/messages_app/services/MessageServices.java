package com.ccruz.messages_app.services;

import com.ccruz.messages_app.dao.MessageDAO;
import com.ccruz.messages_app.entity.Message;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlos_cruz
 */
public class MessageServices {
    public static void create() {
        Scanner reader = new Scanner(System.in);
        String messageReaded;
        String author;
        Timestamp messageDate = new Timestamp(System.currentTimeMillis());
        
        System.out.println("\nEnter the message");
        messageReaded = reader.nextLine();
        
        System.out.println("\nEnter your name");
        author = reader.nextLine();
        
        Message message = new Message();
        message.setMessage(messageReaded);
        message.setAuthor(author);
        message.setMessageDate(messageDate);
        
        if (MessageDAO.create(message) > 0) {
            System.out.println("\n☻☻☻☻☻ Message created successfully ☻☻☻☻☻");
        }
    }
    
    public static void list() {
        ArrayList<Message> messages = MessageDAO.list();
        
        System.out.println("\n-------- Messages List --------");        
        messages.forEach(message -> System.out.println(message.toString()));
    }
    
    public static void update() {
        Scanner reader = new Scanner(System.in);
        int idMessage;
        String newMessage;
        
        System.out.println("\nEnter id of message to update");
        idMessage = reader.nextInt();
        
        System.out.println("\nEnter new message");
        reader.nextLine();
        newMessage = reader.nextLine();
        
        Message message = new Message();
        message.setIdMessage(idMessage);
        message.setMessage(newMessage);
        
        if (MessageDAO.update(message) > 0) {
            System.out.println("\n☻☻☻☻☻ Message updated successfully ☻☻☻☻☻");
        }
    }
    
    public static void delete() {
        Scanner reader = new Scanner(System.in);
        int idMessage;
        
        System.out.println("\nEnter id of message to delete");        
        idMessage = reader.nextInt();
        
        if (MessageDAO.delete(idMessage) > 0) {
            System.out.println("\n☻☻☻☻☻ Message deleted successfully ☻☻☻☻☻");
        }
    }
}
