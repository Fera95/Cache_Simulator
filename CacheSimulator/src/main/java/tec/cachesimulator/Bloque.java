/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 * Clase encargada de representar un bloque de memoria
 */
public class Bloque {
    //atributos de clase
    String Direccion;
    String Estado;
    String Dato;
    boolean isShared;

    public Bloque(String Direccion, String Estado, String Dato, boolean isShared) {
        this.Direccion = Direccion;
        this.Estado = Estado;
        this.Dato = Dato;
        this.isShared = isShared;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getEstado() {
        return Estado;
    }

    public String getDato() {
        return Dato;
    }

    public boolean isIsShared() {
        return isShared;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }
    
         
    
    
    
}
