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
    
public static void main(String[] args){

       /*Nucleo nucleo1 = new Nucleo("P0","0");
       nucleo1.start();*/
       
       
       Memoria memoria1 = new Memoria(16);
       Instruccion instruccion1 = new Instruccion("P0","0","WRITE","0000","2");
       memoria1.ejecutarInstruccion(instruccion1);
       memoria1.printLog();
       
       Instruccion instruccion2 = new Instruccion("P0","0","WRITE","1010","4");
       memoria1.ejecutarInstruccion(instruccion2);
       memoria1.printLog();
       
       
}
    
    
    
}
