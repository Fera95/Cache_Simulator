
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
public class Nucleo extends Thread implements Constantes{

     //Atributos de la clase
    public String Id_Nucleo;
    public String Id_Chip;
    List<Instruccion> Cola_Instrucciones ;
    public Cache cache;
    public Clock clk;
    public String generated;
   
    //Constructor
    
  public Nucleo(String id,String Id_Chip,Cache cacheL1,Clock clk) {
    this.Id_Nucleo=id;
    this.Id_Chip = Id_Chip;
    this.Cola_Instrucciones = new ArrayList<>();
    this.cache = cacheL1;
    this.clk = clk;
    this.generated = "0";
    
  }
    
  
  /*
  Cuando se corra el hilo se estara creando instrucciones infinitas con un sleep
  */

    /**
     *
     */

   
  
    @Override
	public synchronized  void run() {
		try{while (true) { 
                        if(this.clk.isActive() && this.cache.Locked==false){
                            this.generarInstruccion();
                            this.clk.WaitUntilNotActive();
                        }else{
                           
                            this.clk.WaitUntilActive();
                          
                        }     
		}}
                 catch(Exception e){
                    System.out.println(e);
                  
                }
	}
  
  
        //metodo que genera una instruccion random
public void generarInstruccion(){
    //Se genera el primer random 0 a 2 distribuido
                        double  lamda1 =  1.0;
                        int random1 = this.getPoisson2(lamda1);
                        //Se genera el segundo random 0 a 15 distribuido
                        double lamda2 = 4.0;
                        int random2 = this.getPoisson15(lamda2);
                        
                        //Se capturan los datos 
                        String operacion_tomada = Nucleo.ListaOperaciones.get(random1);
                        String direccion_tomada = Nucleo.ListaDirecciones.get(random2);
                        
                        String dato_well_known;
                        boolean isWrite;
                        
                        if("CALC".equals(operacion_tomada) || "READ".equals(operacion_tomada)){
                            //Dato well known por el momento
                         dato_well_known = " ";
                         isWrite = false;
                        }
                        else{
                            //Tiene que cambiarse por lista random de datos de 32 bits
                            
                            // Se crea un random en decimal 
                            
                             double random_double = Math.random() * (65535 - 0 + 1) + 0; 
                             int value = (int)random_double;
                             String Hex=Integer.toHexString(value);
                             
                              dato_well_known = Hex.toUpperCase();
                               isWrite = true;
                        }
                        
                        //Se crea el objeto instruccion
                               
                        Instruccion  instruccion= new Instruccion(this.Id_Nucleo,this.Id_Chip,operacion_tomada,
                                                                  direccion_tomada, dato_well_known);
                        
                      
                        instruccion.print_info();
                        
                        //Se le envía la instrucción a la clase cache
                        this.cache.setInstruccion_Actual(instruccion);
}
    
    
    
    /*
     * funcion encargada de generar un número aleatorio
    * tomado de: https://naps.com.mx/blog/simulacion-en-java-distribucion-poisson/ 
    *pero adaptado a números entre 0 y 2 se requiere una entrada de alrededor de 1
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


//Variación de la función  anterior pero de 0 a 16 se recomienda un lamda de 4

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
      

    
}
