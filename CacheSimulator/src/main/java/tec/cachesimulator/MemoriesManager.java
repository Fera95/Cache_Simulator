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
    
    //Chip 0
    public Cache cacheL1_1_p0;
    public Cache cacheL1_1_p1;
    
  
    
    //Chip1
    public Cache cacheL1_2_p0;
    public Cache cacheL1_2_p1;
    
    
    
    public LogManager Log;
   
    public Cache cacheL1_local;
    public Cache cacheL1_snoop;
    public Cache cacheL2_used;
    
    
    
    //Parte de Directorio
    public Cache cacheL2_1;
    public Cache cacheL2_2;
    public Cache cacheL2_on_use;
    public Cache cacheL2_other;
    public Memoria memprincipal;
    public boolean L2Flag;
    
    
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
        this.cacheL1_local = null;
        this.cacheL1_snoop= null;
        
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

        /*
        
           //Chip 0
    public Cache cacheL1_1_p0;
    public Cache cacheL1_1_p1;
    
  
    
    //Chip1
    public Cache cacheL1_2_p0;
    public Cache cacheL1_2_p1;
        
        
        */
       
    if("Chip 0".equals(instruccion.Numero_chip)){
      
        if("Procesador 0".equals(instruccion.Numero_nucleo)){
          
         
            this.cacheL2_used = this.cacheL2_1;
            
            
            
               //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(3000);
             
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_1_p0,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_write(this.cacheL1_1_p1,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_1_p0,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_read(this.cacheL1_1_p1,instruccion);      
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
        
            
            
            
           
        }else{
           
       

            
            
            
               
             //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(3000);
             
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_1_p1,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_write(this.cacheL1_1_p0,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_1_p1,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_read(this.cacheL1_1_p0,instruccion);      
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
        
            
            
            
        }
    }
    else{
         if("Procesador 0".equals(instruccion.Numero_nucleo)){
          
          
             this.cacheL2_used = this.cacheL2_2;
             
             
             
             //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(3000);
             
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_2_p0,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_write(this.cacheL1_2_p1,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_2_p0,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_read(this.cacheL1_2_p1,instruccion);      
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
        
           
             
             
             
        }else{
            
            
          
            
            
            
            
        //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(3000);
             
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.local_write(this.cacheL1_2_p1,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_write(this.cacheL1_2_p0,instruccion);      
                                    break;
                      case "READ":
                                    this.local_read(this.cacheL1_2_p1,instruccion);
                                    Thread.sleep(2000);
                                    this.snoop_read(this.cacheL1_2_p0,instruccion);      
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
        
            
            
            
            
        }
    }
     
    
              //Se setea para el gui
      
      
    //Limpiar los caches locales y snoop

              
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
      this.cacheL2_other = this.cacheL2_2;
      this.L2Flag = true;
    }
    else{
        this.cacheL2_on_use = this.cacheL2_2;
         this.cacheL2_other = this.cacheL2_1;
         this.L2Flag=false;
    }
        
        
        
        
        //Aplicar ógica de Directorio
        
       
        
        
        //Se chequea el tipo de instrucción y se hace MSI(falta chequear estados y que hacer)  o se llama a Directorio
        try {
            Thread.sleep(2000);
              switch (instruccion.Operacion) {
                      case "WRITE":
                                    this.write_Director(cacheL2_on_use, instruccion);
                                    Thread.sleep(2000);
                                      
                                    break;
                      case "READ":
                                    this.read_Director(cacheL2_on_use, instruccion);
                                    Thread.sleep(2000);
                                 
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
             if("M".equals(cacheinput.Bloques_memoria.get(cacheinput.LastHIT).Estado)){
              //Write-Back
                 this.cacheL2_used.escribirDato(instruccion.Numero_nucleo, instruccion.Numero_chip, instruccion.Direccion_memoria, instruccion.Dato);
                 //Se para a I
                 cacheinput.modificarEstado(cacheinput.LastHIT, "S");
             }
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
             if("M".equals(cacheinput.Bloques_memoria.get(cacheinput.LastHIT).Estado)){
                 //Write-Back
                 this.cacheL2_used.escribirDato(instruccion.Numero_nucleo, instruccion.Numero_chip, instruccion.Direccion_memoria, instruccion.Dato);
                 //Se para a I
                 cacheinput.modificarEstado(cacheinput.LastHIT, "I");
             }
             //Se pasa a I
             cacheinput.modificarEstado(cacheinput.LastHIT, "I");
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
             String Estado = cacheinput.Bloques_memoria.get(cacheinput.LastHIT).Estado;
             
             if("I".equals(Estado)){
                 this.read_to_L2(cacheinput,this.cacheL2_used,instruccion.Direccion_memoria,instruccion);
             }
             else{
              cacheinput.leerDato(cacheinput.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
              this.Log.setLastLog(cacheinput.devolverLog());
               this.Log.WriteLastLog();
               
            
              //Se cambia estado a S
              cacheinput.modificarEstado(cacheinput.LastHIT, "S");
             }
         }else{
             
          this.read_to_L2(cacheinput,this.cacheL2_used,instruccion.Direccion_memoria,instruccion);
         }
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
    }
      
    public void local_write(Cache cacheinput,Instruccion instruccion){
        //Se escribe el dato
        cacheinput.escribirDato(instruccion.Numero_nucleo, instruccion.Numero_chip, instruccion.Direccion_memoria, instruccion.Dato);
         this.Log.setLastLog(cacheinput.devolverLog());
         this.Log.WriteLastLog();
        
         //Se hace un Write-throught
        this.cacheL2_used.setInstruccion_Actual(instruccion);
        
    }
    
  
    
    
    // Metodos de nivel 2
    
    public void write_Director(Cache cacheinput,Instruccion instruccion){
            
        // el input es la cache L2 de la instrucion actual 
        
        try {
            Thread.sleep(2000);
            
           
              switch (instruccion.Direccion_memoria) {
                      case "0000":
                                   
                                    Chequeo_Write_Director(this.Directorio0000,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0001":
                                    Chequeo_Write_Director(this.Directorio0001,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0010":
                                    Chequeo_Write_Director(this.Directorio0010,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0011":
                                     Chequeo_Write_Director(this.Directorio0011,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0100":
                                    Chequeo_Write_Director(this.Directorio0100,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0101":
                                    Chequeo_Write_Director(this.Directorio0101,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0110":
                                   Chequeo_Write_Director(this.Directorio0110,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0111":
                                    Chequeo_Write_Director(this.Directorio0111,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1000":
                                     Chequeo_Write_Director(this.Directorio1000,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1001":
                                    Chequeo_Write_Director(this.Directorio1001,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1010":
                                   Chequeo_Write_Director(this.Directorio1010,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1011":
                                   Chequeo_Write_Director(this.Directorio1011,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1100":
                                     Chequeo_Write_Director(this.Directorio1100,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1101":
                                  Chequeo_Write_Director(this.Directorio1101,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1110":
                                    Chequeo_Write_Director(this.Directorio1110,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1111":
                                    Chequeo_Write_Director(this.Directorio1111,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
            
              }
        } catch (Exception ex) {
            System.out.println(ex);
        }
 
    }
    
    //Funcion auxliar de local read
    public void read_to_L2(Cache cacheL1,Cache cacheL2,String Direccion,Instruccion instruccion){
        
        

      //check en L2
        String chequeo = cacheL2.checkMiss(Direccion);
        
        this.Log.setLastLog(cacheL2.devolverLog());
         this.Log.WriteLastLog();
 
         if("HIT".equals(chequeo)){
             //Aqui se sube el dato de L2 a L1
           
               cacheL1.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip,instruccion.Direccion_memoria,cacheL2.Bloques_memoria.get(cacheL2.LastHIT).Dato);
               this.Log.setLastLog(cacheL1.devolverLog());
               this.Log.WriteLastLog();
               
               
             //Se vuelve a hacer chequeo en L1 para tener lastHit
              String chequeo2 = cacheL1.checkMiss(Direccion);
              cacheL1.leerDato(cacheL1.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
              this.Log.setLastLog(cacheL1.devolverLog());
               this.Log.WriteLastLog();
               
            
              //Se cambia estado a S
              cacheL1.modificarEstado(cacheL1.LastHIT, "S");
         }else{
            
            //Se llama a esta funcion para subirlo de mem a L2 y L1 
            this.read_to_Mem(cacheL1,cacheL2,Direccion,instruccion);
            
            //Se vuelve a hacer chequeo en L1 para tener lastHit
              String chequeo2 = cacheL1.checkMiss(Direccion);
              cacheL1.leerDato(cacheL1.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
              this.Log.setLastLog(cacheL1.devolverLog());
               this.Log.WriteLastLog();
               
            
              //Se cambia estado a S
              cacheL1.modificarEstado(cacheL1.LastHIT, "S");
               this.Log.setLastLog(cacheL1.devolverLog());
               this.Log.WriteLastLog();
         }
    }
    
    
     public void read_to_Mem(Cache cacheL1,Cache cacheL2,String Direccion,Instruccion instruccion){
        
         
       //check en memoria principal solo por el Last Hit en mem principa;
       String Dato = this.memprincipal.datobydir(Direccion);
        
       
       // Se arma lo que se va a escribir
       
       instruccion.Dato = Dato;
       
       // Se sube el dato a L2 y se pasa a S
       
       this.local_write(cacheL1, instruccion);
       
       String chequeo1 = cacheL2.checkMiss(Direccion);
       cacheL2.leerDato(cacheL2.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
       this.Log.setLastLog(cacheL2.devolverLog());
       this.Log.WriteLastLog();
        //Se cambia estado a S
       cacheL2.modificarEstado(cacheL2.LastHIT, "S");
       this.Log.setLastLog(cacheL2.devolverLog());
       this.Log.WriteLastLog();
       
        // Se sube el dato a L1 y se pasa a S
        
        
        this.write_Director(cacheL2, instruccion);
        
        String chequeo2 = cacheL1.checkMiss(Direccion);
        cacheL1.leerDato(cacheL1.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
        this.Log.setLastLog(cacheL1.devolverLog());
        this.Log.WriteLastLog();
          //Se cambia estado a S
       cacheL1.modificarEstado(cacheL1.LastHIT, "S");
       this.Log.setLastLog(cacheL1.devolverLog());
       this.Log.WriteLastLog(); 
        
     }
    
    
    
    
    
    public void read_Director(Cache cacheinput,Instruccion instruccion){
           try {
           Thread.sleep(2000);
            
           
              switch (instruccion.Direccion_memoria) {
                      case "0000":
                                   
                                    Chequeo_Read_Director(this.Directorio0000,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0001":
                                    Chequeo_Read_Director(this.Directorio0001,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0010":
                                    Chequeo_Read_Director(this.Directorio0010,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0011":
                                     Chequeo_Read_Director(this.Directorio0011,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0100":
                                    Chequeo_Read_Director(this.Directorio0100,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0101":
                                    Chequeo_Read_Director(this.Directorio0101,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "0110":
                                   Chequeo_Read_Director(this.Directorio0110,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "0111":
                                    Chequeo_Read_Director(this.Directorio0111,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1000":
                                     Chequeo_Read_Director(this.Directorio1000,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1001":
                                    Chequeo_Read_Director(this.Directorio1001,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1010":
                                   Chequeo_Read_Director(this.Directorio1010,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1011":
                                   Chequeo_Read_Director(this.Directorio1011,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1100":
                                     Chequeo_Read_Director(this.Directorio1100,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1101":
                                  Chequeo_Read_Director(this.Directorio1101,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
                      case "1110":
                                    Chequeo_Read_Director(this.Directorio1110,instruccion);
                                    Thread.sleep(1500);
                                      
                                    break;
                      case "1111":
                                    Chequeo_Read_Director(this.Directorio1111,instruccion);
                                    Thread.sleep(1500);
                                 
                                    break;
            
              }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
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


    
    //Funciones auxiliares de directorio.
    public void Chequeo_Write_Director(Directorio directorio,Instruccion instruccion ){
        
        String dump = directorio.getdump();
        
            /* 
            
            this.cacheL2_on_use = this.cacheL2_1;
            this.cacheL2_other = this.cacheL1_2;
            this.L2Flag = true;
   
            this.cacheL2_on_use = this.cacheL2_2;
            this.cacheL2_other = this.cacheL1_1;
            this.L2Flag=false;
            
            */ 
        
        
        
        
         try {
         switch (dump) {
                      case "000":
                                   //Se verifica cual es la L2 local para actualizar el directorio al final 
                                   //Se escribe
                                   //Se actualiza directorio
                                   if(this.L2Flag){
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("1");
                                        directorio.setPresencia_en_CacheL2_2("0");
                                    }else{
                                         this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                         this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                         this.Log.WriteLastLog(); 
                                           directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("0");
                                        directorio.setPresencia_en_CacheL2_2("1");
                                    }
                                      
                                    break;

                      case "110":
                                     if(this.L2Flag){
                                         //Se hace wrteback en memoria principal
                                        int index  = Integer.parseInt(instruccion.Direccion_memoria, 2);
                                        this.memprincipal.Bloques_memoria.get(index).Dato = instruccion.Dato;
                                        String Dueño = this.cacheL2_on_use.Instruccion_Actual.Numero_chip;
                                        this.memprincipal.Bloques_memoria.get(index).Dueños.add(Dueño);
                                        this.memprincipal.Bloques_memoria.get(index).CrearStringDueños();
                                       
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("1");
                                        directorio.setPresencia_en_CacheL2_2("0");
                                        
                                         
                                    }else{
                                         
                                         //Se invalida el otro dato en cache L2 
                                        String chequeo = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                                        this.cacheL2_other.modificarEstado(this.cacheL2_other.LastHIT, "I");
                                        this.Log.setLastLog(cacheL2_other.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("0");
                                        directorio.setPresencia_en_CacheL2_2("1");
                                    }
                                 
                                    break;
                      case "101":
                                    if(this.L2Flag){
                                        
                                            //Se invalida el otro dato en cache L2 
                                        String chequeo = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                                        this.cacheL2_other.modificarEstado(this.cacheL2_other.LastHIT, "I");
                                        this.Log.setLastLog(cacheL2_other.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("1");
                                        directorio.setPresencia_en_CacheL2_2("0");
                                        
                                    }else{
                                        
                                          //Se hace wrteback en memoria principal
                                        int index  = Integer.parseInt(instruccion.Direccion_memoria, 2);
                                        this.memprincipal.Bloques_memoria.get(index).Dato = instruccion.Dato;
                                     
                                        String Dueño = this.cacheL2_on_use.Instruccion_Actual.Numero_chip;
                                        this.memprincipal.Bloques_memoria.get(index).Dueños.add(Dueño);
                                        this.memprincipal.Bloques_memoria.get(index).CrearStringDueños();
                                       
                                       
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("0");
                                        directorio.setPresencia_en_CacheL2_2("1");
                                        
                                    }
                                    break;
                      case "011":
                                    if(this.L2Flag){
                                            //Se invalida el otro dato en cache L2 
                                        String chequeo = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                                        this.cacheL2_other.modificarEstado(this.cacheL2_other.LastHIT, "I");
                                        this.Log.setLastLog(cacheL2_other.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("1");
                                        directorio.setPresencia_en_CacheL2_2("0");
                                    }else{
                                            //Se invalida el otro dato en cache L2 
                                        String chequeo = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                                        this.cacheL2_other.modificarEstado(this.cacheL2_other.LastHIT, "I");
                                        this.Log.setLastLog(cacheL2_other.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se escribe en L2 
                                        this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,instruccion.Dato);
                                        this.Log.setLastLog(cacheL2_on_use.devolverLog());
                                        this.Log.WriteLastLog(); 
                                        
                                        //Se actualiza directorio
                                        directorio.setDirty_Bit("1");
                                        directorio.setPresencia_en_CacheL2_1("0");
                                        directorio.setPresencia_en_CacheL2_2("1");
                                    }
                                    break;
                     
         }}
         catch (Exception ex) {
            System.out.println(ex);
        }
    }
 public void Chequeo_Read_Director(Directorio directorio,Instruccion instruccion){
         String dump = directorio.getdump();
  
        
            /* 
            
            this.cacheL2_on_use = this.cacheL2_1;
            this.cacheL2_other = this.cacheL1_2;
            this.L2Flag = true;
   
            this.cacheL2_on_use = this.cacheL2_2;
            this.cacheL2_other = this.cacheL1_1;
            this.L2Flag=false;
            
            */ 
        
        
        
        
         try {
         switch (dump) {
             case "000":
                 
                  int index  = Integer.parseInt(instruccion.Direccion_memoria, 2);
                 
                  //Se escribe en L2 a partir de mem principal
                   this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,this.memprincipal.Bloques_memoria.get(index).Dato);
                   this.Log.setLastLog(cacheL2_on_use.devolverLog());
                   this.Log.WriteLastLog(); 
                   
                   //Se lee dato 
                   
                    String chequeo = cacheL2_on_use.checkMiss(instruccion.Direccion_memoria);
                    cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                    this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                   
                      
                      
                      if(this.L2Flag){
                   //Se actualiza directorio
                    directorio.setDirty_Bit("1");
                    directorio.setPresencia_en_CacheL2_1("0");
                    directorio.setPresencia_en_CacheL2_2("1");
                  }
                  
                  else{
                       //Se actualiza directorio
                    directorio.setDirty_Bit("1");
                    directorio.setPresencia_en_CacheL2_1("1");
                    directorio.setPresencia_en_CacheL2_2("0");
                  }
                      
                   
                 break;
             case "110":
                  if(this.L2Flag){
                      
                      //Se copia dato de la otra memoria
                      String chequeo2 = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                      String Dato_hermano1 = this.cacheL2_other.Bloques_memoria.get(this.cacheL2_other.LastHIT).Dato;
                      this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,Dato_hermano1);
                      this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                      
                      
                      //Se lee
                      cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                      this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                      
                        //Se actualiza directorio
                    directorio.setDirty_Bit("0");
                    directorio.setPresencia_en_CacheL2_1("1");
                    directorio.setPresencia_en_CacheL2_2("1");
                  
                  }
                  
                  else{
                          
                    String chequeo2 = cacheL2_on_use.checkMiss(instruccion.Direccion_memoria);
                    cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                    this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                   
                      
                      
                      
                  }
               case "101":
                  if(this.L2Flag){
                       
                    String cheque3 = cacheL2_on_use.checkMiss(instruccion.Direccion_memoria);
                    cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                    this.Log.setLastLog(cacheL2_on_use.devolverLog());
                    this.Log.WriteLastLog();
                   
                  }
                  
                  else{
                      //Se copia dato de la otra memoria
                      String chequeo2 = this.cacheL2_other.checkMiss(instruccion.Direccion_memoria);
                      String Dato_hermano1 = this.cacheL2_other.Bloques_memoria.get(this.cacheL2_other.LastHIT).Dato;
                      this.cacheL2_on_use.escribirDato(instruccion.Numero_nucleo,instruccion.Numero_chip ,instruccion.Direccion_memoria ,Dato_hermano1);
                      this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                      
                      
                      //Se lee
                      cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                      this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                      
                        //Se actualiza directorio
                    directorio.setDirty_Bit("0");
                    directorio.setPresencia_en_CacheL2_1("1");
                    directorio.setPresencia_en_CacheL2_2("1");
                  }
             
               case "011":
            
   
                      //Se lee
                      cacheL2_on_use.leerDato(cacheL2_on_use.LastHIT, instruccion.Numero_nucleo, instruccion.Numero_chip);
                      this.Log.setLastLog(cacheL2_on_use.devolverLog());
                      this.Log.WriteLastLog();
                 break;
         }
         }
         catch(Exception e){
                 System.out.println(e);
                 }
    }
    
    
    
}
