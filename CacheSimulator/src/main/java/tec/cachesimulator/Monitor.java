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
public class Monitor extends Observador{
    public Cache cacheL1_1;
    public Cache cacheL1_2;
    public Cache cacheL2;
    public LogManager Log;
    public MemStatus memstatus;
    public Cache cachelocal;
    public Cache cachesnoop;
    
  
    public Monitor(Cache cacheL1_1,Cache cacheL1_2,  Cache cacheL2,LogManager Log,MemStatus memstatus){
        this.cacheL1_1 = cacheL1_1;
        this.cacheL1_2 = cacheL1_2;
        this.cacheL2 = cacheL2;
        this.Log = Log;  
        this.memstatus = memstatus;
     
    }  
    @Override
    public void actualizar(Instruccion instruccion,String Nombre){
     
        
        //Se setea quien sera el local y quien sera el snoop(fisgon)
        
        if("CacheL1_1".equals(Nombre)){
            this.cachelocal= this.cacheL1_1;
            this.cachesnoop= this.cacheL1_2;
        }
         if("CacheL1_2".equals(Nombre)){
            this.cachelocal= this.cacheL1_2;
            this.cachesnoop= this.cacheL1_1;
        }
     
        
         
        //Se ve el tipo de intrucción
      instruccion.print_info();
      if("WRITE".equals(instruccion.Operacion)){
         this.local_write(this.cachelocal,instruccion);
         this.snoop_write(this.cachesnoop,instruccion);
   
      }
      
      
      if("READ".equals(instruccion.Operacion)){
           this.local_read(this.cachelocal,instruccion);
           this.snoop_read(this.cachesnoop,instruccion);
   
      }
      
      if("CALC".equals(instruccion.Operacion)){
         
   
      }
      
          
      

      
      
      
      
      //Se setea para el gui
      this.cacheL2.SetearDatos();
      this.cacheL1_1.SetearDatos();
      this.cacheL1_2.SetearDatos();
      // Se liberan las memorias 
      this.cacheL1_1.UnlockMemory();
      this.cacheL1_2.UnlockMemory();
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
    
    public void write_back(){
        
    }
    
    
    
    
}
