
package tec.cachesimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author esteban
 * Clase encargada de realizar las instrucciones al azar con distrubución
 * de Poisson   Y de ejecutarlas 
 */
public class Nucleo extends Thread{

     //Atributos de la clase
    public String Id_Nucleo;
    public String Id_Chip;
    List<Instruccion> Cola_Instrucciones ;
    
   //Listas para instrucciones
    String[] operaciones = {"WRITE","CALC","READ"};
    List<String> ListaOperaciones = Arrays.asList(operaciones);

    String[] direcciones = {"0000","0001","0010","0011","0100","0101",
    "0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
    List<String> ListaDirecciones = Arrays.asList(direcciones);    
    
    
    
    //Constructor
    
  public Nucleo(String id,String Id_Chip) {
    this.Id_Nucleo=id;
    this.Id_Chip = Id_Chip;
    this.Cola_Instrucciones = new ArrayList<>();
  }
    
  
  /*
  Cuando se corra el hilo se estara creando instrucciones infinitas con un sleep
  */
   
  @Override
	public void run() {


		while (true) { 
                        
                        
			this.esperarXsegundos(5);
                        //Se genera el primer random 0 a 2 distribuido
                        double  lamda1 =  1.0;
                        int random1 = this.getPoisson2(lamda1);
                        //Se genera el segundo random 0 a 15 distribuido
                        double lamda2 = 4.0;
                        int random2 = this.getPoisson15(lamda2);
                        
                        //Se capturan los datos 
                        
                        
                        String operacion_tomada = this.ListaOperaciones.get(random1);
                        String direccion_tomada = this.ListaDirecciones.get(random2);
                        
                        String dato_well_known;
                        boolean isWrite;
                        
                        if(operacion_tomada == "CALC" || operacion_tomada == "READ"){
                            //Dato well known por el momento
                         dato_well_known = " ";
                         isWrite = false;
                        }
                        else{
                              dato_well_known = "4A3B";
                               isWrite = true;
                        }
                        
                        
                        
                        //Se crea el objeto instruccion
                                
                        
                        Instruccion  instruccion= new Instruccion(this.Id_Nucleo,this.Id_Chip,operacion_tomada,
                                                                  direccion_tomada, dato_well_known,isWrite);
                        
                        //Se agrega el objeto en la lista
                        
                        instruccion.print_info();
                        
                        this.Cola_Instrucciones.add(instruccion);
                        
		}

		
	}
  
  

    
    
    
    /*
     * funcion encargada de generar un número aleatorio
    * tomado de: https://naps.com.mx/blog/simulacion-en-java-distribucion-poisson/ 
    *pero adaptado a números entre 0 y 2 se requiere una entrada de alrededor de 4
    * en el lamda
    */
    
public  int getPoisson2 (double lambda){
  double L = Math.exp(-lambda);
  double p = 2.0;
  int k = 0;
  do{
     k++;
     p *= Math.random();
  } while (p > L);
  int result= k-1;
   if(result>=3){
          result = getPoisson2 (lambda);
   }
   
       return result; 
}


//Variación de la función  anterior pero de 0 a 16 con un lamda de 4

public  int getPoisson15 (double lambda){
  double L = Math.exp(-lambda);
  double p = 15.0;
  int k = 0;
  do{
     k++;
     p *= Math.random();
  } while (p > L);
  int result = k-1;
  if(result>=16){
      return getPoisson15(lambda);
  }
  else{
      return  result;
  }
  
  
 
   
}
      
/*
Funcion para dormir el hilo
*/

private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
    
}
