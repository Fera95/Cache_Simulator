/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 * Clase abstracta encargada de ver los cambios en los observables 
 */
public abstract class Observador {
    protected Cache cacheL1_1;
    protected Cache cacheL1_2;
    protected Cache cacheL2;
    
    public abstract void actualizar(Instruccion instruccion,String Nombre);
    
}
