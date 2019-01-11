/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mastanczak
 */
public class Authentication {
    static char choice;
    
    static void menu()
    {
        
           Game.clearConsole();
           
           System.out.println(" Login \t\t [ l / L ]");
           System.out.println(" Register \t [ r / R ]");
           System.out.println(" Exit \t\t [ e / E ]");
           
           Scanner odczyt = new Scanner(System.in);
           choice = odczyt.next().charAt(0);
           
           switch(choice)
           {
               case 'L':
               case 'l':
               {
                   login();
                   break;
               }
               case 'R':
               case 'r':
               {
                   register();
                   break;
               }
               case 'E':
               case 'e':
               {
                   System.out.println("exit");
                   break;
               }
               default: 
               {
                   secoundMessage("Error  - not valid choice.");
                   menu();
               }
           }
  
    }
    
    public static final void secoundMessage(String message){
         System.out.println(message);
         
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            
        }
    }
    
    public static void login()
    {
        Scanner read = new Scanner(System.in);
        String username, password;
        
        System.out.println("Username: ");
        username = read.nextLine();
        
        System.out.println("Password: ");
        password = read.nextLine();
        
        User checkUser = new User(username,password);
        
        if(checkUser.isCredentialsValid(username, password)){
            secoundMessage("Login succesfull.");
            ProjectJava.initGame();
        }else{
            secoundMessage("Login failed.");
            menu();
        }
    }
    
    
    public static void register()
    {   
        Scanner read = new Scanner(System.in);
        String username, password;
        
        System.out.println("Username: ");
        username = read.nextLine();      
        
        System.out.println("Password: ");
        password = read.nextLine();
        
        User newUser = new User(username,password);
        
        if(newUser.insertUserToDb()){   
            secoundMessage("Registration succesfull.");
            menu();
        }else{
            secoundMessage("Registration failed.");
        }
        
    }
    
    
    public static void main(String[] args) 
    {
       menu();
    }
}
