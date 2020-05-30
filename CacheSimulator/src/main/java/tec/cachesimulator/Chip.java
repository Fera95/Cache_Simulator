/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.graalvm.compiler.asm.amd64.AMD64BaseAssembler.OperandSize.PD;

/**
 *
 * @author esteban
 * Clase encargada de contener los nucleos , el monitor y la memoria L2
 * versión 1.0 donde se ensambla todo en chip(deberia ensablarse todo en una más grande)
 * 
 */
public class Chip {
    
    public Clock clock;
    public String id_Chip;
    public LogManager log;
   
 
    public Cache cacheL1_1;
    public Cache cacheL1_2;
    public Cache cacheL2;
    public MemoriesManager memmanager;
 
    public Nucleo nucleo0;
    public Nucleo nucleo1;
   
    
    public Chip(String id_Chip,Clock clock,LogManager logmanager,MemoriesManager memmanager) {
      this.id_Chip = id_Chip;
      this.clock = clock;
      this.log = logmanager;
      this.memmanager = memmanager;

      
       
      //Se  instancian objetos
     
      
      Cache CacheL1_1_init = new Cache(2,"CacheL1_1");
      this.cacheL1_1 = CacheL1_1_init;
      
      Cache CacheL1_2_init = new Cache(2,"CacheL1_2");
      this.cacheL1_2 = CacheL1_2_init;
      
   
      
      Cache CacheL2_init = new Cache(4,"CacheL2");
      this.cacheL2 = CacheL2_init;
      
   
      
      Nucleo nucleo0_init;
      nucleo0_init = new Nucleo("Procesador 0",this.id_Chip,this.cacheL1_1,this.clock);
      this.nucleo0= nucleo0_init;
      
      Nucleo nucleo1_init;
      nucleo1_init = new Nucleo("Procesador 1",this.id_Chip,this.cacheL1_2,this.clock);
      this.nucleo1= nucleo1_init;
      

      
      
      //Se agrega observador
      
      this.cacheL1_1.agregarObserver(this.memmanager);
      this.cacheL1_2.agregarObserver(this.memmanager);
      this.cacheL2.agregarObserver(this.memmanager);
      
    
      
      
     
    }
    
   

          
    
     public void run() {
      
       
        try {
             nucleo0.start();
             
            Thread.sleep(1000);
            nucleo1.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Chip.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }
}