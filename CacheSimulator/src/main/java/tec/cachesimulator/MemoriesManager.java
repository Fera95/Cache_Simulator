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
    public Cache cacheL2_on_use;
    public Memoria memprincipal;
    
    
    public Directorio Directorio0000;
    public Directorio Directorio0001;
    public Directorio Directorio0010;
    public Directorio Directorio0011;
    public Directorio Directorio0100;
    public Directorio Directorio0101;
    public Directorio Directorio0110;
    public Directorio Directorio0111;
    
    public Directorio Directorio1000;
    public Directorio Directorio1001;
    public Directorio Directorio1010;
    public Directorio Directorio1011;
    public Directorio Directorio1100;
    public Directorio Directorio1101;
    public Directorio Directorio1110;
    public Directorio Directorio1111;

  
   
    
  
    public MemoriesManager(LogManager Log, Memoria memprincipal){
        this.Log = Log;  
        this.memprincipal = memprincipal;
       
        
        Directorio Directorio0000init = new Directorio("0000");
        this.Directorio0000 = Directorio0000init;
     
        Directorio Directorio0001init = new Directorio("0001");
        this.Directorio0001 = Directorio0001init;
        
        Directorio Directorio0010init = new Directorio("0010");
        this.Directorio0010 = Directorio0010init;
        
        Directorio Directorio0011init = new Directorio("0011");
        this.Directorio0011 = Directorio0011init;
        
        Directorio Directorio0100init = new Directorio("0100");
        this.Directorio0100 = Directorio0100init;
        
        Directorio Directorio0101init = new Directorio("0101");
        this.Directorio0101 = Directorio0101init;
       
        Directorio Directorio0110init = new Directorio("0110");
        this.Directorio0110 = Directorio0110init;
        
        Directorio Directorio0111init = new Directorio("0111");
        this.Directorio0111 = Directorio0111init;
        
        Directorio Directorio1000init = new Directorio("1000");
        this.Directorio1000 = Directorio1000init;
     
        Directorio Directorio1001init = new Directorio("1001");
        this.Directorio0001 = Directorio1001init;
        
        Directorio Directorio1010init = new Directorio("1010");
        this.Directorio1010 = Directorio1010init;
        
        Directorio Directorio1011init = new Directorio("1011");
        this.Directorio1011 = Directorio1011init;
        
        Directorio Directorio1100init = new Directorio("1100");
        this.Directorio1100 = Directorio1100init;
        
        Directorio Directorio1101init = new Directorio("1101");
        this.Directorio1101 = Directorio1101init;
       
        Directorio Directorio1110init = new Directorio("1110");
        this.Directorio1110 = Directorio1110init;
        
        Directorio Directorio1111init = new Directorio("1111");
        this.Directorio1111 = Directorio1111init;
     
     
    }  
    @Override
    public void actualizar(Instruccion instruccion,String Nombre){
     
     
        
    //Se chequea el tipo de cache por el nombre si es L1 o L2?
    
    if("CacheL1_2".equals(Nombre) | "CacheL1_1".equals(Nombre)){
        
        //Se chequea cuales seran las caches con las que se trabajaran en monitor

        System.out.println("Se entra level 1");
    
       
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
            Thread.sleep(2000);
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_local,instruccion);
                                    Thread.sleep(500);
                                    this.snoop_write(this.cacheL1_snoop,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_local,instruccion);
                                    Thread.sleep(500);
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

        
        
   if("Chip 0".equals(instruccion.Numero_chip)){
      this.cacheL2_on_use = this.cacheL2_1;
    }
    else{
        this.cacheL2_on_use = this.cacheL2_2;
    }
        
        
        
        
        //Aplicar ógica de Directorio
        
       
        
        
        //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(2000);
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.write_Director(cacheL2_on_use, instruccion);
                                    Thread.sleep(500);
                                      
                                    break;
                      case "READ":
                                    
                                    Thread.sleep(500);
                                 
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
           instruccion.Dato = "New Dato";
           this.cacheL2_used.setInstruccion_Actual(instruccion);
         }
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
      
    public void local_write(Cache cacheinput,Instruccion instruccion){
        //Se escribe el dato
        cacheinput.escribirDato(instruccion.Numero_nucleo, instruccion.Numero_chip, instruccion.Direccion_memoria, instruccion.Dato);
        //Se hace un Write-throught
        this.cacheL2_used.setInstruccion_Actual(instruccion);
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
    
  
    
    
    // Metodos de nivel 2
    
    public void write_Director(Cache cacheinput,Instruccion instruccion){
        instruccion.print_info();
        System.out.println(instruccion.Dato);
        cacheinput.escribirDato(instruccion.Numero_nucleo, instruccion.Numero_chip, instruccion.Direccion_memoria, instruccion.Dato);
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
        System.out.println("Write_Director");
    }
    
    public void read_Director(Cache cacheinput,Instruccion instruccion){
        System.out.println("Read_Director");
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
