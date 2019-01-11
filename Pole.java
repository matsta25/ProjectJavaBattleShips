/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author mastanczak
 */
public class Pole {
    public String znak;
    
    public Pole(){
        znak = "[ ]";
    }
    
    public void setShipPole(){
        znak = "[O]";
    }
    
    public void setShipHitPole(){
        znak = "[X]";
    }
    
    public void setShipMissPole(){
        znak = "[.]";
    }
    
    public void printPole(){
        System.out.print( "\t" + znak);
    }

    String getZnak() {
        return znak;
    }
    
}
