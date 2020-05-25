/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 * Clase encargada de observar los cambios de estado de las cache L2
 * y ejecutar los cambio pertinentes ya sea en L2 o memoria principal
 * 
 */
public class Direcctorio extends Observador {
    public Cache cacheL2_1;
    public Cache cacheL2_2;
    public Memoria memprincipal;
    public LogManager Log;
    public MemStatus memstatus;


 //Creado para debugear
    public int Ciclo;
    public Direcctorio(Cache cacheL2_1,Cache cacheL2_2,  Memoria memprincipal,LogManager Log,MemStatus memstatus){
        this.cacheL2_1 = cacheL2_1;
        this.cacheL2_2 = cacheL2_2;
        this.memprincipal = memprincipal;
        this.Log = Log;  
        this.memstatus = memstatus;
        this.Ciclo = 1;
    }  
    @Override
    public void actualizar(Instruccion instruccion){
       
        //Prueba Se verifica si hay un escritura en P0 con un checkmiss Veo instruccion escribo , modifico , leo , memprincipal
        
        
        //Nucleo -> Instruccion -> CacheL1 ese nucleo -> Notifica observado Monitor(MSI) -> Cache L2 -> Notifica Observer Directorio (Protocolo) -> Memprincipal -> Se liberan mems
        
        instruccion.print_info();
      if("WRITE".equals(instruccion.Operacion) && "P0".equals(instruccion.Numero_nucleo)){
         this.cacheL2_1.checkMiss(instruccion.Direccion_memoria);
         this.Log.setLastLog(this.cacheL2_1.devolverLog());
         this.Log.WriteLastLog();
      }
      
    
      // Se liberan las memorias 
      this.cacheL2_1.UnlockMemory();
      this.cacheL2_2.UnlockMemory();
    }




}
