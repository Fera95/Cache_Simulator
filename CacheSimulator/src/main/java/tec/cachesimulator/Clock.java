/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 *
 * @author esteban
 * Clase encargada de manejar el tiempo que se le da a cada procesador
 * en el sistema
 */
public class Clock extends Thread {
     //Atributos de la clase
    
      //reloj
     public int clk;
      //tiempo para dormir hilo
     public int tiempo;
     
     //Log del sistema
     
     public LogManager Log;

     //constructor 
    public Clock() {
        this.clk =0;
        this.tiempo=5;
    }
     
    // funcion que correra el hilo 
     
     @Override
	public void run() {

            while(true){
                //si el clock está activo se llama a LogManager
                if(this.isActive()){
               
                }
               
                    //Se modifica el clk y se duerne el hilo
                    this.clk = (this.clk + 1 ) % 2;
                    this.esperarXsegundos(tiempo);
                
              
            }
	}
     
     //Funcion para dormir hilo 
    private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
    
    //Funcion para verificar si está activo
    public boolean isActive(){
      return this.clk==1;
    }
    
    //Funcion para esperar hasta que se active
    public void WaitUntilActive(){
        while(!this.isActive()){
          //divida la vara por 10 porque si no va a esperar un segundo haga que espere por lo menos la decima parte
            this.esperarXsegundos(tiempo);
        }
    }
    
    //Funcion para esperar que se desactive
    
    public void WaitUntilNotActive(){
        while(this.isActive()){
          //divida la vara por 10 porque si no va a esperar un segundo haga que espere por lo menos la decima parte
            this.esperarXsegundos(tiempo);
        }
    }
}