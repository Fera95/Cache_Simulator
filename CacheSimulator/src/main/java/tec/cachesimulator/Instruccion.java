/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 */
public class Instruccion {
    
    String Numero_nucleo;
    String Numero_chip;
    String Operacion;
    String Direccion_memoria;
    String Dato_escribir;
    boolean isWrite;
    String separador;
    
    
    public Instruccion(String numero_nucleo,String numero_chip,String operacion,
            String direccion_memoria, String dato_escribir,boolean isWrite){
        
        this.Numero_nucleo = numero_nucleo;
        this.Numero_chip = numero_chip;
        this.Operacion= operacion;
        this.Direccion_memoria = direccion_memoria;
        this.Dato_escribir = dato_escribir;
        if(isWrite){
            this.separador = ";";
        }
        else{
            this.separador = " ";
        }
       
        
        
    }
    
    public void print_info(){
        System.out.println(this.Numero_nucleo + ","+ this.Numero_chip + ":"+
                this.Operacion + " "+ this.Direccion_memoria + this.separador + this.Dato_escribir);
    }
}
