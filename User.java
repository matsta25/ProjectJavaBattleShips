/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mastanczak
 */
public class User {
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;        
        this.password = password;
    }
    
    public boolean insertUserToDb(){
        FileWriter file;
        try {
            file = new FileWriter("db.txt", true);
            BufferedWriter out = new BufferedWriter(file);
            out.write(this.username + ":" + this.password + "\n");
            out.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public boolean isCredentialsValid(String username, String password) 
    {
        try {
            File file = new File("db.txt");
            Scanner in = new Scanner(file);
            
            String zdanie;
            
            while(in.hasNextLine()){
                zdanie = in.nextLine();
                if(zdanie.equals(username + ":" + password))
                    return true;
            }
            return false;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}
