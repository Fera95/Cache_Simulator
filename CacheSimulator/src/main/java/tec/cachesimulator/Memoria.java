/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    
    

    public Memoria(int Tamaño_memoria,String Nombre) {
        this.Tamaño_memoria = Tamaño_memoria;
        this.Bloques_memoria = new ArrayList<>();
        for (int i = 0; i < Tamaño_memoria; i++) {
            String dir;
            dir = Memoria.ListaDirecciones.get(i);
            Bloque bloque = new Bloque(dir, "0");
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
            observador.actualizar(this.Instruccion_Actual);
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
     
    
    //Funcion encargada de procesar una instruccion esta ejecutara la petición
    // y devolvera un log con lo ocurrido en forma de string debera pasarse a monitor y director
    
    
    public void ejecutarInstruccion(Instruccion instruccion)
    {
        //Se capturan los datos pertinentes de la instruccion para trabajarlos
        
        String Numero_nucleo = instruccion.getNumero_nucleo();
        String Numero_chip = instruccion.getNumero_chip();
        String Operacion  = instruccion.getOperacion();
        String Direccion_memoria = instruccion.getDireccion_memoria();
        String Dato = instruccion.getDato();

        //Convirtiendo la direccion de memoria a un número en base 10
        
        int index = Integer.parseInt(Direccion_memoria, 2);
        
        //Si la opeción que entra a memoria es un write
        if("WRITE".equals(Operacion)){
            this.escribirDato(index,Numero_nucleo,Numero_chip,Direccion_memoria,Dato);
            this.devolverLog();   
        }else{
            this.leerDato(index,Numero_nucleo,Numero_chip,Direccion_memoria,Dato);
            this.devolverLog();   
        }
    }
                 
    //Metodo encargado de escribir a memoria 
    
    public void escribirDato(int Index,String Numero_nucleo,String Numero_chip,String Direccion_memoria,String Dato){
        Bloque bloque = new Bloque(Direccion_memoria,Dato);
        this.Bloques_memoria.remove(Index);
        this.Bloques_memoria.add(Index, bloque);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        
        
         this.Log = "En " +this.Nombre+ " el nucleo: "+Numero_nucleo+" del chip: "+Numero_chip+" escribio: "
                 +Dato + " en la dirección "+ Direccion_memoria +" "+ timeStamp;

    }
    
    //Metodo encargado de leer la memoria este escribe en log y devuelve el dato en forma de 
    
    public void leerDato(int Index,String Numero_nucleo,String Numero_chip,String Direccion_memoria,String Dato){
        Bloque bloque = this.Bloques_memoria.get(Index);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
         this.Log = "En " +this.Nombre+ " el nucleo: "+Numero_nucleo+" del chip: "+Numero_chip+" leyo : "
                 +bloque.Dato + " en la dirección "+ bloque.Direccion +" "+ timeStamp;
        
    }
     
  
    //Metodo que recibe posición de memoria y cambia estado de ese bloque
    public void modificarEstado(int Index,String Estado){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        this.Log = "En " +this.Nombre+ " se modifico el estado de " + this.Bloques_memoria.get(Index).Direccion 
        + "de "+ this.Bloques_memoria.get(Index).Estado+ " a " + Estado + " " + timeStamp;
        this.Bloques_memoria.get(Index).setEstado(Estado);
    }
    
    //Metodo que recibe posición de memoria y cambia el valor del dato de ese bloque
    public void modificarDato(int Index,String Dato){
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	LocalDateTime now = LocalDateTime.now();
	String timeStamp = dtf.format(now);
        this.Log = "En " +this.Nombre+ " se modifico el valor de " + this.Bloques_memoria.get(Index).Direccion 
        + "de "+ this.Bloques_memoria.get(Index).Dato+ " a " + Dato + " " + timeStamp;
        this.Bloques_memoria.get(Index).setDato(Dato);
    }
    
    //Metodo que devuelve el log escrito por alguno de los métodos anteriores
    public String devolverLog(){
        return this.Log;
    }
    
    //Metodo para chequear si hay un miss de una dereccion de algun bloque de memoria
    public String checkMiss(String Direccion){
        String result="MISS";
        for(int i=0; i< this.Tamaño_memoria;i++){
            String Dir = this.Bloques_memoria.get(i).Direccion;
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	     LocalDateTime now = LocalDateTime.now();
	     String timeStamp = dtf.format(now);
            if("Direccion".equals(Dir)){
                result = "HIT";
            
           this.Log = "En " +this.Nombre+ " Se hubo un miss  buscando la direccion " + Direccion + " " + timeStamp;
            }else{
             this.Log = "En " +this.Nombre+ " Se hubo un hit  buscando la direccion " + Direccion + " " + timeStamp;
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
}
