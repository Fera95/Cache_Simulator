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
       
       
       CacheL1 memoria1 = new CacheL1(11,"CacheL1 0P0");
       Instruccion instruccion1 = new Instruccion("P0","0","WRITE","0000","2");
       memoria1.ejecutarInstruccion(instruccion1);
       memoria1.printLog();
      
       
       memoria1.mostrarMemoria();
       
       memoria1.modificarEstado(0,"M");
       memoria1.printLog();
       memoria1.modificarDato(3,"Nalgas");
       memoria1.printLog();
       
       
       memoria1.mostrarMemoria();
     
       
}
    
    
    
}
