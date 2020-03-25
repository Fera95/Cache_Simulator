/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

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
    
    //Creado para debugear
    public int Ciclo;
    public Monitor(Cache cacheL1_1,Cache cacheL1_2,  Cache cacheL2,LogManager Log){
        this.cacheL1_1 = cacheL1_1;
        this.cacheL1_2 = cacheL1_2;
        this.cacheL2 = cacheL2;
        this.Log = Log;  
        this.Ciclo = 1;
    }  
    @Override
    public void actualizar(Instruccion instruccion){
       
        //Prueba Se verifica si hay un escritura en P0 con un checkmiss
        instruccion.print_info();
      if("WRITE".equals(instruccion.Operacion) && "P0".equals(instruccion.Numero_nucleo)){
         this.cacheL1_1.checkMiss(instruccion.Direccion_memoria);
         this.Log.setLastLog(this.cacheL1_1.devolverLog());
         this.Log.WriteLastLog();
      }
      
    
      
      this.cacheL1_1.UnlockMemory();
    }
}
