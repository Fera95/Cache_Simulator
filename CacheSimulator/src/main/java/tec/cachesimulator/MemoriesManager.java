/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esteban
 * Clase encargada de observar los cambios de estado de las cache L1
 * y ejecutar los cambio pertinentes ya sea en L1 o L2
 * 
 */
public class MemoriesManager extends Observador{
   // Parte de monitor
    
    public Cache cacheL1_1_p0;
    public Cache cacheL1_2_p0;
    public Cache cacheL1_1_p1;
    public Cache cacheL1_2_p1;
    
    
    public LogManager Log;
   
    public Cache cachelocal;
    public Cache cachesnoop;
    
    
    //Parte de Directorio
    public Cache cacheL2_1;
    public Cache cacheL2_2;
    public Memoria memprincipal;
  
   
    
  
    public MemoriesManager(LogManager Log, Memoria memprincipal){
        this.Log = Log;  
        this.memprincipal = memprincipal;
     
    }  
    @Override
    public void actualizar(Instruccion instruccion,String Nombre){
     
        instruccion.print_info();
        
            // System.out.println("Despues de L2");
            //Se pasa la instruccion directamente a L2 (tambien para probar locks
            
            //this.cacheL2.setInstruccion_Actual(instruccion);
            
            
            //Se setea quien sera el local y quien sera el snoop(fisgon) , usando nombre y procesador
            
             

      try {
            this.cacheL1_1_p0.Bloques_memoria.get(0).setDato("AAAA");
            this.cacheL1_2_p0.Bloques_memoria.get(1).setDato("AAAA");
            Thread.sleep(1000);
            this.cacheL1_1_p0.Bloques_memoria.get(0).setDato("BBBB");
             this.cacheL1_2_p0.Bloques_memoria.get(1).setDato("BBBB");
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
      
      
      
      //Se setea para el gui
      
      
      
    this.cacheL1_1_p0.SetearDatos();
    this.cacheL1_2_p0.SetearDatos();
    this.cacheL1_1_p1.SetearDatos();
    this.cacheL1_2_p1.SetearDatos();
    this.cacheL2_1.SetearDatos();
    this.cacheL2_2.SetearDatos();
    this.memprincipal.SetearDatos();
      
      
      
      // Se liberan las memorias 
    
    this.cacheL1_1_p0.UnlockMemory();
    this.cacheL1_2_p0.UnlockMemory();
    this.cacheL1_1_p1.UnlockMemory();
    this.cacheL1_2_p1.UnlockMemory();
    this.cacheL2_1.UnlockMemory();
    this.cacheL2_2.UnlockMemory();
    this.memprincipal.UnlockMemory();
       
      
    }
    
    //Funciones para manipular las caches
    
    public void snoop_read(Cache cacheinput,Instruccion instruccion){
        
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
    
    public void snoop_write(Cache cacheinput,Instruccion instruccion){
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
     
    public void local_read(Cache cacheinput,Instruccion instruccion){
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
      
    public void local_write(Cache cacheinput,Instruccion instruccion){
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
    
    public void write_next(Cache cacheinput,Instruccion instruccion,Cache cacheoutput){
        
    }

    public Cache getCacheL1_1_p0() {
        return cacheL1_1_p0;
    }

    public void setCacheL1_1_p0(Cache cacheL1_1_p0) {
        this.cacheL1_1_p0 = cacheL1_1_p0;
    }

    public Cache getCacheL1_2_p0() {
        return cacheL1_2_p0;
    }

    public void setCacheL1_2_p0(Cache cacheL1_2_p0) {
        this.cacheL1_2_p0 = cacheL1_2_p0;
    }

    public Cache getCacheL1_1_p1() {
        return cacheL1_1_p1;
    }

    public void setCacheL1_1_p1(Cache cacheL1_1_p1) {
        this.cacheL1_1_p1 = cacheL1_1_p1;
    }

    public Cache getCacheL1_2_p1() {
        return cacheL1_2_p1;
    }

    public void setCacheL1_2_p1(Cache cacheL1_2_p1) {
        this.cacheL1_2_p1 = cacheL1_2_p1;
    }

    public Cache getCacheL2_1() {
        return cacheL2_1;
    }

    public void setCacheL2_1(Cache cacheL2_1) {
        this.cacheL2_1 = cacheL2_1;
    }

    public Cache getCacheL2_2() {
        return cacheL2_2;
    }

    public void setCacheL2_2(Cache cacheL2_2) {
        this.cacheL2_2 = cacheL2_2;
    }

    public Memoria getMemprincipal() {
        return memprincipal;
    }

    public void setMemprincipal(Memoria memprincipal) {
        this.memprincipal = memprincipal;
    }


    

    
    
    
}
