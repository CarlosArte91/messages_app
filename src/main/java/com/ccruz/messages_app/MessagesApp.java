package com.ccruz.messages_app;

import com.ccruz.messages_app.services.MessageServices;
import java.util.Scanner;

/**
 *
 * @author carlos_cruz
 */
public class MessagesApp {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in) ;
        int optionSelected = 0;
        
        do {
            System.out.println("----------------------------");
            System.out.println("  WELCOME TO MESSAGES APP   ");
            System.out.println("1. Create message");
            System.out.println("2. Edit message");
            System.out.println("3. Show all messages");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");
            System.out.println("----------------------------");
            
            optionSelected = reader.nextInt();
            
            switch (optionSelected) {
                case 1:
                    MessageServices.create();
                    break;
                case 2:
                    MessageServices.update();
                    break;
                case 3:
                    MessageServices.list();
                    break;
                case 4:
                    MessageServices.delete();
                    break;
                default:
                    break;
            }
        } while (optionSelected != 5);
    }    
}
