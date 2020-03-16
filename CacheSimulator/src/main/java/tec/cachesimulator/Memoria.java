/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author esteban
 * Clase encargada de abstraer los diferentes tipos de memoria
 */
public class Memoria implements Constantes{
    
    //Atributos 
    int Tamaño_memoria;
    List<Bloque> Bloques_memoria ;

    public Memoria(int Tamaño_memoria) {
        this.Tamaño_memoria = Tamaño_memoria;
        this.Bloques_memoria = new ArrayList<>();
        for (int i = 0; i < Tamaño_memoria; i++) {
              
            String dir;
            dir = Memoria.ListaDirecciones.get(i);
           
            Bloque bloque = new Bloque(dir,"I", "0", false);
            this.Bloques_memoria.add(bloque);
        
        
        }
    }

    public int getTamaño_memoria() {
        return Tamaño_memoria;
    }

    public List<Bloque> getBloques_memoria() {
        return Bloques_memoria;
    }
     
    
    public void getDatos(){
        for (int i = 0; i < Tamaño_memoria; i++) {  
            Bloque bloque = this.Bloques_memoria.get(i);
            System.out.println("Dato: " +bloque.Dato);
            System.out.println("Direccion: " +bloque.Direccion);
            System.out.println("Estado : " +bloque.Estado);
            System.out.println("isShare : " +bloque.isShared);
        }
    }
    
    
}
