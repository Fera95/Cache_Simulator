/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author esteban
 * Clase encargada de abstraer los diferentes tipos de memoria ademas de 
 * brindar métodos para leer o escribir sobre esta
 */
public class Memoria implements Constantes{
    
    //Atributos 
    int Tamaño_memoria;
    List<Bloque> Bloques_memoria ;
    public String Log;

    public Memoria(int Tamaño_memoria) {
        this.Tamaño_memoria = Tamaño_memoria;
        this.Bloques_memoria = new ArrayList<>();
        for (int i = 0; i < Tamaño_memoria; i++) {
              
            String dir;
            dir = Memoria.ListaDirecciones.get(i);
           
            Bloque bloque = new Bloque(dir, "0");
            this.Bloques_memoria.add(bloque);
        
        
        }
    }

    public int getTamaño_memoria() {
        return Tamaño_memoria;
    }

    public List<Bloque> getBloques_memoria() {
        return Bloques_memoria;
    }
     
    
    //Funcion encargada de procesar una instruccion esta ejecutara la petición
    // y devolvera un log con lo ocurrido en forma de string 
    
    
    public void ejecutarInstruccion(Instruccion instruccion)
    {
    
    //Se capturan los datos pertinentes de la instruccion para trabajarlos
        
        String Numero_nucleo = instruccion.getNumero_nucleo();
        String Numero_chip = instruccion.getNumero_chip();
        String Operacion  = instruccion.getOperacion();
        String Direccion_memoria = instruccion.getDireccion_memoria();
        String Dato = instruccion.getDato();
        //Caso especial para saber si la intrucción modificara un dato en memoria 
  
        
        //Convirtiendo la direccion de memoria a un número en base 10
        
        int index = Integer.parseInt(Direccion_memoria, 2);
        
        //Si la opeción que entra a memoria es un write
        if(Operacion == "WRITE"){
            this.escribirDato(index,Numero_nucleo,Numero_chip,Direccion_memoria,Dato);
            
            this.devolverLog();   
        }else{
            if(Operacion== "READ"){
                this.leerDato();
                this.devolverLog();
            }else{
                this.calcDato();
                this.devolverLog();
            }     
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
        
         this.Log = "El nucleo: "+Numero_nucleo+" del chip: "+Numero_chip+" escribio: "
                 +Dato + " en la dirección "+ Direccion_memoria +" "+ timeStamp;
         
         this.mostrarMemoria();
    }
    
    //Metodo encargado de leer la memoria 
    
    public void leerDato(){
        
    }
    
    //Metodo encargado de "calcular" la instrucción
    public void calcDato(){
        
    }
    
    //Metodo que devuelve el log escrito por alguno de los métodos anteriores
    public String devolverLog(){
        return this.Log;
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
