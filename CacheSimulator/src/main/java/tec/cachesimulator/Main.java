package tec.cachesimulator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author esteban
 */
public class Main {
    
public static void main(String[] args) throws InterruptedException{

     Clock  clk = new Clock();
     Chip chip1 = new Chip("0",clk);
     clk.start();
     chip1.Start();
   
       

       
       
}
    
    
    
}
