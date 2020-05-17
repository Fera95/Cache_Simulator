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
    
    //Creado para debugear
    public int Ciclo;
    public Monitor(Cache cacheL1_1,Cache cacheL1_2,  Cache cacheL2,LogManager Log,MemStatus memstatus){
        this.cacheL1_1 = cacheL1_1;
        this.cacheL1_2 = cacheL1_2;
        this.cacheL2 = cacheL2;
        this.Log = Log;  
        this.memstatus = memstatus;
        this.Ciclo = 1;
    }  
    @Override
    public void actualizar(Instruccion instruccion){
     
        //Prueba Se verifica si hay un escritura en P0 con un checkmiss
        instruccion.print_info();
      if("WRITE".equals(instruccion.Operacion)){
         this.cacheL1_1.checkMiss(instruccion.Direccion_memoria);
      
         this.Log.setLastLog(this.cacheL1_1.devolverLog());
         this.Log.WriteLastLog();
         
      }
          
        try {
            this.cacheL1_1.Bloques_memoria.get(0).setDato("AAAA");
            this.cacheL1_2.Bloques_memoria.get(1).setDato("AAAA");
            Thread.sleep(1000);
            this.cacheL1_1.Bloques_memoria.get(0).setDato("BBBB");
             this.cacheL1_2.Bloques_memoria.get(1).setDato("BBBB");
        } catch (InterruptedException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      
      
      //Se testea GUI modificando valor de memcache para gui
      
      
      
      
      this.cacheL2.SetearDatos();
      this.cacheL1_1.SetearDatos();
      this.cacheL1_2.SetearDatos();
      // Se liberan las memorias 
      this.cacheL1_1.UnlockMemory();
      this.cacheL1_2.UnlockMemory();
    }
}
