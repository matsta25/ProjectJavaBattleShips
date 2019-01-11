/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static projectjava.Authentication.choice;

/**
 *
 * @author mastanczak
 */
class Game {

    public static final void secoundMessage(String message){
        System.out.println(message);
         
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            
        }
    }
    
        
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
        
        int NumberOfLines = 100;
        
        for (int i=0; i<NumberOfLines; i++){
             System.out.println();
        }//NumberOfLines is the number of lines you DOS windows has
    }
    
    
    
    public static void menu() {
        
        System.out.println(" New game \t [ n / N ]");
//        System.out.println(" Resume game \t [ r / R ]");
        System.out.println(" Exit \t\t [ e / E ]");

        Scanner odczyt = new Scanner(System.in);
        choice = odczyt.next().charAt(0);

        switch (choice) {
            case 'n':
            case 'N': {
                newGame();
                break;
            }
            case 'R':
            case 'r': {
//                resumeGame();
                break;
            }
            case 'E':
            case 'e': {
                System.out.println("exit");
                break;
            }
            default: {
                secoundMessage("Error  - not valid choice.");
                menu();
            }
        }
    }
    
    static void newGame(){
        Board board = new Board();
        board.placeShipsInit();
        board.printBoard();
        do{
            if(board.makeShot()){
                secoundMessage("HIT");
            }else{
                secoundMessage("MISS");
            }
            clearConsole();
            board.printBoard();
        }while(board.isGameOver());
    }
    
}
