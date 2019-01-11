/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;
import static projectjava.Authentication.choice;

/**
 *
 * @author mastanczak
 */
class Board {
    
    public Pole[][] board = new Pole[10][10];
    
    public Board(){
        for(int i = 0; i < board.length ; i ++){
            for(int j = 0; j < board[i].length ; j ++){
                board[i][j] = new Pole();
            }
        }
    }
    
    public void printBoard() {
            
        
        System.out.println("\t");
        for (int c=65; c<75; c++) {
            System.out.print("\t" + (char)c + " ");
        } 
        System.out.println("\n");
        
        for(int i = 0; i < board.length ; i ++){
            for(int j = 0; j < board[i].length ; j ++){
                if(j == 0)
                    System.out.print(i+1);
                board[i][j].printPole();
            }
            System.out.println("\n");
        }
    }
    
    public void placeShipsInit(){
        String startPoint;
        String endPoint;
        Scanner read = new Scanner(System.in);
            
        System.out.println("Please type with this convention,");
        System.out.println("<upper case letter><number>");        
        System.out.println("eg. C5");
 
//        int i = 4;
        for(int i = 4 ; i >= 1 ; i--) {
            for( int j = 1 ; j <= 5-i ; j ++){
                
                System.out.println("Type start point of ship with " + i + " mast.");

                if(i == 1){
                    System.out.println("POINT of " + i + " mast ship: ");
                    startPoint = read.nextLine();
                    endPoint = startPoint;
                }else{
                    System.out.println("START point of " + i + " mast ship: ");
                    startPoint = read.nextLine();

                    System.out.println("END point of " + i + " mast ship: ");
                    endPoint = read.nextLine();
                }
                
                if(placeShip(startPoint,endPoint,i)){
                    Game.secoundMessage("Ship placed successfully.");
                }else{
                    Game.secoundMessage("Ship placed FAILED.");
                    Game.newGame();
                }
                
            }
        }
        
        
        
    }
    
    public boolean placeShip(String startPoint, String endPoint, int checkMast){
        
        int startPointLetter = (int)startPoint.charAt(0) - 65;
        int endPointLetter = (int) endPoint.charAt(0) - 65;
        
        int startNumber = Integer.parseInt(startPoint.substring(1, startPoint.length()));
        int endNumber = Integer.parseInt(endPoint.substring(1, endPoint.length()));
        
        if(Math.abs(endNumber - startNumber) + 1 == checkMast || Math.abs(endPointLetter - startPointLetter) + 1 == checkMast){
            if( startPointLetter == endPointLetter){
                for(int i = startNumber-1; i < endNumber; i++ ){
                    board[i][startPointLetter].setShipPole();
                }
            } else if (startNumber == endNumber) {
                for(int i = startPointLetter; i < endPointLetter+1; i++ ){
                    board[startNumber-1][i].setShipPole();
                } 
            }
            return true;
        }else{
            Game.secoundMessage("Error in mast count. Start again.");
            return false;
        }   
    }
    
    public boolean isGameOver()
    {
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[i].length ; j++){
                if(board[i][j].getZnak().equals("[O]")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean makeShot() {
        String shotPoint = "";
        Scanner read = new Scanner(System.in);
        System.out.println("Type a point:");
        shotPoint = read.nextLine();
        
        int shotPointLetter = (int)shotPoint.charAt(0) - 65;
        int shotPointNumber = Integer.parseInt(shotPoint.substring(1, shotPoint.length())) - 1;
        
        if( !((shotPointLetter >= 0 && shotPointLetter < 10) && (shotPointNumber >= 0 && shotPointNumber < 10) )){
            Game.secoundMessage("Invalid point. Try again.");
            makeShot();
        }
        
        if(board[shotPointNumber][shotPointLetter].znak == "[O]"){
            board[shotPointNumber][shotPointLetter].setShipHitPole();
            return true;
        }else if(board[shotPointNumber][shotPointLetter].znak == "[X]"){
            Game.secoundMessage("You already take a shot here.");
            return false;
        }else{
            board[shotPointNumber][shotPointLetter].setShipMissPole();
            return false;
        }

    }
}
