/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.util.ArrayList;

/**
 *
 * @author esteban
 * Clase encargada de prindar métodos de lectura y escritura de la cache L1
 * extiende de memoria esta es observable por las clases monitor y la clase
 * directorio
 */
public class Cache extends Memoria{
    
    //se crea lista de observadores
    private final ArrayList<Observador> observadores = new ArrayList<>();
            
    //metodo para agregar un observador
    @Override
    public void agregarObserver(Observador observador){
        observadores.add(observador);
    }
    
    @Override
    public void setInstruccion_Actual(Instruccion Instruccion_Actual) {
    
        this.Instruccion_Actual = Instruccion_Actual;
        this.setLocked(true);
        observadores.forEach((observador) -> {
            observador.actualizar(this.Instruccion_Actual,this.Nombre);
        });
    }
    
    public Cache(int Tamaño_memoria, String Nombre) {
        super(Tamaño_memoria, Nombre);
    }
    
    
    @Override
    public void mostrarMemoria(){
        System.out.printf("%-20s%-20s%-10s \n", "Direccion","Dato","Estado");
        for(int i=0; i< this.Tamaño_memoria;i++){
            
            System.out.printf("%-20s%-20s%-10s \n", this.Bloques_memoria.get(i).Direccion,
                    this.Bloques_memoria.get(i).Dato,this.Bloques_memoria.get(i).Estado);
        }
    }
    
}
