/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author esteban
 * Clase encargada de abstraer los diferentes tipos de memoria ademas de 
 * brindar métodos para leer o escribir sobre esta
 */
public class Memoria implements Constantes{
    
   
    
    //se crea lista de observadores
    private final ArrayList<Observador> observadores = new ArrayList<>();
    

    //Atributos 
    public  int Tamaño_memoria;
    public List<Bloque> Bloques_memoria ;
    public String Log;
    public String Nombre;
    //atributo para saber si la memoria fue secuestrada
    public boolean Locked;
    //atributo para saber que instruccion se le está asignando a la memoria
    public  Instruccion Instruccion_Actual;
    
    public int LastHIT;
    
    
    //atributo con todos los datos de la memoria en formato para ser enviados a
    // interfaz gráfica.
    
     public List<String[]> DataGui;
     

    public Memoria(int Tamaño_memoria,String Nombre) {
        this.Tamaño_memoria = Tamaño_memoria;
        this.Bloques_memoria = new ArrayList<>();
        for (int i = 0; i < Tamaño_memoria; i++) {
            String dir;
            dir = Memoria.ListaDirecciones.get(i);
            Bloque bloque = new Bloque(dir, "0000");
            this.Bloques_memoria.add(bloque);
        }
        this.Nombre = Nombre;
        this.Locked = false;
       
    }

    
    
     
            
    //metodo para agregar un observador
    public void agregarObserver(Observador observador){
       observadores.add(observador);
    }
    
    
    public boolean isLocked() {
        return Locked;
    }

    public void setLocked(boolean Locked) {
        this.Locked = Locked;
    }
    
    public Instruccion getInstruccion_Actual() {
        return Instruccion_Actual;
    }

    public void setInstruccion_Actual(Instruccion Instruccion_Actual) {
        this.Instruccion_Actual = Instruccion_Actual;
        //Se bloquea memoria
        this.setLocked(true);
          observadores.forEach((observador) -> {
            observador.actualizar(this.Instruccion_Actual,this.Nombre);
        });
    }
    public void UnlockMemory(){
    
        //Se desbloquea memoria
        this.setLocked(false);
    }
    
   
    public int getTamaño_memoria() {
        return Tamaño_memoria;
    }

    public List<Bloque> getBloques_memoria() {
        return Bloques_memoria;
    }
     
    

                 
    //Metodo encargado de escribir a memoria 
    
    public void escribirDato(String Numero_nucleo,String Numero_chip,String Direccion_memoria,String Dato){
        boolean hay_I = false;
        boolean hay_S = false;
        
        
        
        
        
         for(int i=0; i< this.Tamaño_memoria;i++){
            String estado = this.Bloques_memoria.get(i).getEstado();
            Bloque bloque = new Bloque(this.Bloques_memoria.get(i).Direccion,Dato);
            bloque.setDireccionGuarda(Direccion_memoria);
            bloque.setEstado("M");
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String timeStamp = dtf.format(now);
            this.Log = timeStamp + " , " + Numero_chip + " ," + Numero_nucleo + " , " + " Detalle: "
            +"Se escribio el dato : " + bloque.getDato() + "que apunta a la dirección de mem " + bloque.getDireccionGuarda() + " de " + this.Nombre + " en la posición " + i;
            
            if("I".equals(estado)){
                this.Bloques_memoria.remove(i);
                this.Bloques_memoria.add(i, bloque);
                hay_I=true;
                break;
            }
          
         }
        
         if(hay_I==false){
             
            for(int i=0; i< this.Tamaño_memoria;i++){
            
             String estado = this.Bloques_memoria.get(i).getEstado();
            Bloque bloque = new Bloque(this.Bloques_memoria.get(i).Direccion,Dato);
            bloque.setDireccionGuarda(Direccion_memoria);
            bloque.setEstado("M");   
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String timeStamp = dtf.format(now);
            this.Log = timeStamp + " , " + Numero_chip + " ," + Numero_nucleo + " , " + " Detalle: "
            +"Se escribio el dato : " + bloque.getDato() + "que apunta a la dirección de mem " + bloque.getDireccionGuarda() + " de " + this.Nombre + " en la posición " + i;
   
             
            if("S".equals(estado)){
                this.Bloques_memoria.remove(i);
                this.Bloques_memoria.add(i, bloque);
                hay_S=true;
                break;
            }
          
            }
         }
         
         if(hay_I == false && hay_S==false){
            
            Bloque bloque = new Bloque(this.Bloques_memoria.get(0).Direccion,Dato);
            bloque.setDireccionGuarda(Direccion_memoria);
            bloque.setEstado("M");
             this.Bloques_memoria.remove(0);
             this.Bloques_memoria.add(0, bloque);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            String timeStamp = dtf.format(now);
              this.Log = timeStamp + " , " + Numero_chip + " ," + Numero_nucleo + " , " + " Detalle: "
               +"Se escribio el dato : " + bloque.getDato() + "que apunta a la dirección de mem " + bloque.getDireccionGuarda() + " de " + this.Nombre + " en la posición " + 0;
         }
        
        
        
    
        
        
       
         
        

    }
    
    //Metodo encargado de leer la memoria este escribe en log y devuelve el dato en forma de 
    
    public void leerDato(int Index,String Numero_nucleo,String Numero_chip){
        Bloque bloque = this.Bloques_memoria.get(Index);
        
        
        
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        this.Log = timeStamp + " , " + Numero_chip + " ," + Numero_nucleo + " , " + " Detalle: "
               +"Se leyo el dato : " + bloque.getDato() + "que apunta a la dirección de mem " + bloque.getDireccionGuarda() + " de " + this.Nombre + " en la posición " + Index;
        
    }
     
  
    //Metodo que recibe posición de memoria y cambia estado de ese bloque
    public void modificarEstado(int Index,String Estado){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        
        
        this.Log = timeStamp + " , " + this.Instruccion_Actual.Numero_chip + " ," + this.Instruccion_Actual.Numero_nucleo + " , " + " Detalle: "
                + "En " +this.Nombre+ " se modifico el estado de " + this.Bloques_memoria.get(Index).Direccion + "de "+ this.Bloques_memoria.get(Index).Estado+ " a " + Estado;
    
        
        
        this.Bloques_memoria.get(Index).setEstado(Estado);
    }
    
    //Metodo que recibe posición de memoria y cambia el valor del dato de ese bloque
    public void modificarDato(int Index,String Dato){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        
           this.Log = timeStamp + " , " + this.Instruccion_Actual.Numero_chip + " ," + this.Instruccion_Actual.Numero_nucleo + " , " + " Detalle: "
           + "En " +this.Nombre+ " se modifico el valor de " + this.Bloques_memoria.get(Index).Direccion 
        + "de "+ this.Bloques_memoria.get(Index).Dato+ " a " + Dato;
           
       
        this.Bloques_memoria.get(Index).setDato(Dato);
    }
    
    //Metodo que devuelve el log escrito por alguno de los métodos anteriores
    public String devolverLog(){
        return this.Log;
    }
    
    
    //Metodo para obtener dato basado en direccion (usado solo en memprincipal)
    
    public String datobydir(String Direccion){
        String Dato = null;
       for(int i=0; i< this.Tamaño_memoria;i++){
            String Dir = this.Bloques_memoria.get(i).Direccion;
             
            if(Dir.equals(Direccion)){
               
             Dato = this.Bloques_memoria.get(i).Dato;
            }
        
        
    }
       return Dato;
    }
    
    
    
    
    //Metodo para chequear si hay un miss de una dereccion de algun bloque de memoria
    public String checkMiss(String Direccion){
        String result="MISS";
        for(int i=0; i< this.Tamaño_memoria;i++){
            String Dir = this.Bloques_memoria.get(i).DireccionGuarda;
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	     LocalDateTime now = LocalDateTime.now();
	     String timeStamp = dtf.format(now);
            if(Dir.equals(Direccion)){
                result = "HIT";
                this.LastHIT = i;
            this.Log = timeStamp + " , " + this.Instruccion_Actual.Numero_chip + " ," + this.Instruccion_Actual.Numero_nucleo + " , " + " Detalle: "
            + "En " +this.Nombre+ " Se hubo un hit  buscando la direccion guardada " + Direccion;
                
        
            }else{
         
              this.Log = timeStamp + " , " + this.Instruccion_Actual.Numero_chip + " ," + this.Instruccion_Actual.Numero_nucleo + " , " + " Detalle: "
            + "En " +this.Nombre+ " Se hubo un miss  buscando la direccion guardada " + Direccion;
            }       
        }

        return result;
    }
    
    
    
    
     //Metodo que imprime el log escrito por alguno de los métodos anteriores
    public void printLog(){
         System.out.println(this.Log);
    }
    //Metodo que devuelve el estado de la memoria
    public void mostrarMemoria(){
        System.out.printf("%-20s%-20s \n", "Direccion","Dato");
        for(int i=0; i< this.Tamaño_memoria;i++){
            
            System.out.printf("%-20s%-20s \n", this.Bloques_memoria.get(i).Direccion,
                    this.Bloques_memoria.get(i).Dato);
        }
    }
    
     //Metodo actualiza el estado de la memoria debe ser utilizado por Monitor y Director
    public void SetearDatos(){
        List<String[]> Datos;
        Datos = new ArrayList<>();
 
        for(int i=0; i< this.Tamaño_memoria;i++){
            
            Bloque bloqueactual = this.Bloques_memoria.get(i);
            bloqueactual.CrearStringDueños();
            String[] Dato = {bloqueactual.Direccion,bloqueactual.Estado, bloqueactual.StringDueños,bloqueactual.Dato};
            Datos.add(Dato);
            
        }
        this.DataGui = Datos;
    }

    public List<String[]> getDataGui() {
        return DataGui;
    }

 
     //Metodo para obtener los datos de la memoria en forma de string
    // para ser pasados como parametro para el GUI
    /* public String getData(){
      
          for (int i = 0; i < this.getDataGui().size(); i++) {
   
             this.Data = this.Data + Arrays.toString(this.getDataGui().get(i));
         }
          return Data;
     }*/
    
    
    
}
