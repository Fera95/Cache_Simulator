/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author esteban
 * Interfaz creada para el uso de constantes
 */
public interface Constantes {
    
    
     //Listas para instrucciones
    String[] operaciones = {"WRITE","CALC","READ"};
    List<String> ListaOperaciones = Arrays.asList(operaciones);

    String[] direcciones = {"0000","0001","0010","0011","0100","0101",
    "0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
    List<String> ListaDirecciones = Arrays.asList(direcciones); 
}
