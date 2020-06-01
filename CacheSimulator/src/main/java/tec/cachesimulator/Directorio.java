/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;


public class Directorio {

String Direccion_Memoria;
String Dirty_Bit;
String Presencia_en_CacheL2_1;
String Presencia_en_CacheL2_2;
   
 public Directorio(String Direccion_Memoria){
     this.Direccion_Memoria = Direccion_Memoria;
     this.Dirty_Bit = "0";
     this.Presencia_en_CacheL2_1 = "0";
     this.Presencia_en_CacheL2_2 = "0";
 }

    public String getDirty_Bit() {
        return Dirty_Bit;
    }

    public void setDirty_Bit(String Dirty_Bit) {
        this.Dirty_Bit = Dirty_Bit;
    }

    public String getPresencia_en_CacheL2_1() {
        return Presencia_en_CacheL2_1;
    }

    public void setPresencia_en_CacheL2_1(String Presencia_en_CacheL2_1) {
        this.Presencia_en_CacheL2_1 = Presencia_en_CacheL2_1;
    }

    public String getPresencia_en_CacheL2_2() {
        return Presencia_en_CacheL2_2;
    }

    public void setPresencia_en_CacheL2_2(String Presencia_en_CacheL2_2) {
        this.Presencia_en_CacheL2_2 = Presencia_en_CacheL2_2;
    }
    

     public String getdump(){
         String dump = this.Dirty_Bit + this.Presencia_en_CacheL2_1 + this.Presencia_en_CacheL2_2 ;
         
         return dump;
    }

}
