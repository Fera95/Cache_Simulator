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
 * Clase encargada de representar un bloque de memoria
 */
public class Bloque {
    //atributos de clase
    String Direccion;
    String Estado;
    String Dato;
    String StringDueños;
    String DireccionGuarda;
    public List<String> Dueños;
    boolean isShared;

    public Bloque(String Direccion, String Dato) {
        this.Direccion = Direccion;
        this.DireccionGuarda = "";
        this.Estado = "I";
        this.Dato = Dato;
        this.StringDueños = "";
       ArrayList<String> ListInit = new ArrayList<>(); 
        this.Dueños = ListInit;
    }

    public String getDireccionGuarda() {
        return DireccionGuarda;
    }

    public void setDireccionGuarda(String DireccionGuarda) {
        this.DireccionGuarda = DireccionGuarda;
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

   /*public void setDireccion(int index) throws InterruptedException {
        try {
            Thread.sleep(2000);
              switch (index) {
                      case 0:
                                    this.Direccion = "0000";
                                    break;
                      case 1:
                                   this.Direccion = "0001";
                                    break;
                     case 2:
                                    this.Direccion = "0010";
                                    break;
                     case 3:
                                   this.Direccion = "0011";
                                    break;
                                    
                     case 4:
                                    this.Direccion = "0100";
                                    break;
                      case 5:
                                   this.Direccion = "0101";
                                    break;
                     case 6:
                                    this.Direccion = "0110";
                                    break;
                      case 7:
                                   this.Direccion = "0111";
                                    break;
                                    
                     case 8:
                                    this.Direccion = "1000";
                                    break;
                      case 9:
                                   this.Direccion = "1001";
                                    break;
                     case 10:
                                    this.Direccion = "1010";
                                    break;
                     case 11:
                                   this.Direccion = "1011";
                                    break;
                                    
                     case 12:
                                    this.Direccion = "1100";
                                    break;
                      case 13:
                                   this.Direccion = "1101";
                                    break;
                     case 14:
                                    this.Direccion = "1110";
                                    break;
                      case 15:
                                   this.Direccion = "1111";
                                    break;
                                    
            
    }}catch(Exception e){
            System.out.println(e);
    }
        
    }*/
    
    
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }


         
    //Metodo que devuelve el estado de la memoria
    public void CrearStringDueños(){
        this.StringDueños = "";
        for (int i = 0; i < this.Dueños.size(); i++) {
            this.StringDueños = this.StringDueños + this.Dueños.get(i);
            
        }
    }

    public String getStringDueños() {
        return StringDueños;
    }

    public void setStringDueños(String StringDueños) {
        this.StringDueños = StringDueños;
    }
    
    
}
