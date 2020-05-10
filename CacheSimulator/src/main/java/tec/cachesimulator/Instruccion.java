/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 * Clase para hacer una lista de intrucciones en el sistema 
 */
public class Instruccion {
    
    String Numero_nucleo;
    String Numero_chip;
    String Operacion;
    String Direccion_memoria;
    String Dato;
    //Caso especial para saber si la intrucción modificara un dato en memoria 
    String separador;
    
    //Constructor
    public Instruccion(String numero_nucleo,String numero_chip,String operacion,
            String direccion_memoria, String dato){
        
        this.Numero_nucleo = numero_nucleo;
        this.Numero_chip = numero_chip;
        this.Operacion= operacion;
        this.Direccion_memoria = direccion_memoria;
        this.Dato = dato;
        
        if(operacion == "WRITE"){
            this.separador = ";";
        }
        else{
             this.separador = " ";
        }
        
       
    }
    //Constructor para instrucciones READ y CALC
    public Instruccion(String numero_nucleo,String numero_chip,String operacion,
            String direccion_memoria){
        
        this.Numero_nucleo = numero_nucleo;
        this.Numero_chip = numero_chip;
        this.Operacion= operacion;
        this.Direccion_memoria = direccion_memoria;
        this.Dato = "0";
       
    }

    public String getNumero_nucleo() {
        return Numero_nucleo;
    }

    public void setNumero_nucleo(String Numero_nucleo) {
        this.Numero_nucleo = Numero_nucleo;
    }

    public String getNumero_chip() {
        return Numero_chip;
    }

    public void setNumero_chip(String Numero_chip) {
        this.Numero_chip = Numero_chip;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }

    public String getDireccion_memoria() {
        return Direccion_memoria;
    }

    public void setDireccion_memoria(String Direccion_memoria) {
        this.Direccion_memoria = Direccion_memoria;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato= Dato;
    }
    
    //Metodo para imprimir dato de la instruccion
    public void print_info(){
        if(this !=null){
            System.out.println(this.Numero_nucleo + ","+ this.Numero_chip + ":"+
                this.Operacion + " "+ this.Direccion_memoria + this.separador + this.Dato);
            
        }
            
        
    }
}
