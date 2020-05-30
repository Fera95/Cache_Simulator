/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
   
    public Cache cacheL1_local;
    public Cache cacheL1_snoop;
    public Cache cacheL2_used;
    
    
    
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
     
     
        
    //Se chequea el tipo de cache por el nombre si es L1 o L2?
    
    if("CacheL1_2".equals(Nombre) | "CacheL1_1".equals(Nombre)){
        
        //Se chequea cuales seran las caches con las que se trabajaran en monitor

    
       
    if("Chip 0".equals(instruccion.Numero_chip)){
        if("Procesador 0".equals(instruccion.Numero_nucleo)){
            this.cacheL1_local = this.cacheL1_1_p0;
            this.cacheL1_snoop = this.cacheL1_1_p1;
            this.cacheL2_used = this.cacheL2_1;
        }else{
            this.cacheL1_local = this.cacheL1_1_p1;
            this.cacheL1_snoop = this.cacheL1_1_p0;
            this.cacheL2_used = this.cacheL2_1;
        }
    }
    else{
         if("Procesador 0".equals(instruccion.Numero_nucleo)){
            this.cacheL1_local = this.cacheL1_2_p0;
            this.cacheL1_snoop = this.cacheL1_2_p1;
             this.cacheL2_used = this.cacheL2_2;
        }else{
            this.cacheL1_local = this.cacheL1_2_p1;
            this.cacheL1_snoop = this.cacheL1_2_p0;
            this.cacheL2_used = this.cacheL2_2;
        }
    }
     
    
        //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(1000);
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_local,instruccion);
                                    this.snoop_write(this.cacheL1_snoop,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_local,instruccion);
                                    this.snoop_read(this.cacheL1_snoop,instruccion);      
                                    break;
                      case "CALC":
                                  
                                     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
                                     LocalDateTime now = LocalDateTime.now();
	                             String timeStamp = dtf.format(now);
                                    String log = timeStamp + " , " + instruccion.Numero_chip + " ," + instruccion.Numero_nucleo + " , " + " Detalle: "
                                    +" Calculó el dato : " + instruccion.Dato + "que apunta a la dirección de mem " +  instruccion.Direccion_memoria;  
                                     this.Log.setLastLog(log);
                                     this.Log.WriteLastLog();
                                     break;
    }
        } catch (Exception ex) {
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
    else{

        
        
        
        
        
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




    
      
      

      
    }
    
    //Funciones para manipular las caches
    
    public void snoop_read(Cache cacheinput,Instruccion instruccion){
        //Se chequea si el dato está en caché , (agregar chequear estado y todo eso)
         String chequeo=  cacheinput.checkMiss(instruccion.Direccion_memoria);
     
         //Se escribe un log 
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
         
         //Si el dato está se lee(se hace un log)
         if("HIT".equals(chequeo)){
             cacheinput.leerDato(cacheinput.LastHIT,instruccion.Numero_nucleo,instruccion.Numero_chip,instruccion.Direccion_memoria,instruccion.Dato);
         }else{
             // el protocolo sigue en caso de no estar en este nivel siendo un snoop chequando
         }
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
    
    public void snoop_write(Cache cacheinput,Instruccion instruccion){
          //Se chequea si el dato está en caché , (agregar chequear estado y todo eso)
         String chequeo=  cacheinput.checkMiss(instruccion.Direccion_memoria);
         
         //Se escribe un log 
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
         
         //Si el dato está se lee(se hace un log)
         if("HIT".equals(chequeo)){
             cacheinput.leerDato(cacheinput.LastHIT,instruccion.Numero_nucleo,instruccion.Numero_chip,instruccion.Direccion_memoria,instruccion.Dato);
         }else{
             // el protocolo sigue en caso de no estar en este nivel siendo un snoop chequando
         }
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
     
    public void local_read(Cache cacheinput,Instruccion instruccion){
          //Se chequea si el dato está en caché , (agregar chequear estado y todo eso)
         String chequeo=  cacheinput.checkMiss(instruccion.Direccion_memoria);
     
         //Se escribe un log 
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
         
         //Si el dato está se lee(se hace un log)
         if("HIT".equals(chequeo)){
             cacheinput.leerDato(cacheinput.LastHIT,instruccion.Numero_nucleo,instruccion.Numero_chip,instruccion.Direccion_memoria,instruccion.Dato);
         }else{
             // el protocolo sigue en caso de no estar en este nivel siendo un snoop chequando
             System.out.println("Testeo level 2");
             this.cacheL2_used.setInstruccion_Actual(instruccion);
             
         }
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
      
    public void local_write(Cache cacheinput,Instruccion instruccion){
         //Se chequea si el dato está en caché , (agregar chequear estado y todo eso)
         String chequeo=  cacheinput.checkMiss(instruccion.Direccion_memoria);
        
         //Se escribe un log 
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
         
         //Si el dato está se lee(se hace un log)
         if("HIT".equals(chequeo)){
             // Si el dato está 
             cacheinput.leerDato(cacheinput.LastHIT,instruccion.Numero_nucleo,instruccion.Numero_chip,instruccion.Direccion_memoria,instruccion.Dato);
         }else{
             // el protocolo sigue en caso de no estar en este nivel siendo un snoop chequando
         }
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
