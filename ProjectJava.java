/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import projectjava.Authentication;

/**
 *
 * @author mastanczak
 */
public class ProjectJava {

    static final boolean AUTH = true;
    
    static void init()
    {
        Authentication.menu();
    }
    
    static void initGame(){
        Game.menu();
    }
    
    public static void main(String[] args) {
        
        if(AUTH){
            init();
        }else{
            initGame();
        }
       
    }
    
}
