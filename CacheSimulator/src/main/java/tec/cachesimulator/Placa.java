/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

/**
 * 
 * @author esteban
 *Clase encargada en empaquetar todos los componentes del sistema, tambien de 
 * ser la interface con la interfaz gráfica. 
 */
public class Placa {
      public Clock clock;
      public Chip chip0;
      public Chip chip1;
      public LogManager log; 
      public MemoriesManager memmanager;
      public Memoria memprincipal;
      
     

    public Placa(Clock clock) {
        this.clock = clock;
          
        
       //Se instancian los componentes dentro de la placa
       
       
       //Se inicializa el Log manager para escritura del archivo de logs
       
      LogManager Log_init;
      Log_init = new LogManager();
      this.log = Log_init;
      

      
      //Se inicializa la memoria principal
      
      Memoria MemPrincipal_init;
      MemPrincipal_init = new Memoria(16,"Memoria Principal");
      this.memprincipal = MemPrincipal_init;
      
     // Se inicializa el memmanager
     
        MemoriesManager MemoriesManager_init;
        MemoriesManager_init  = new MemoriesManager(this.log,this.memprincipal);
       this.memmanager = MemoriesManager_init;
      
        //Se inicializa 
        //Se instancian los chips
    
    Chip chip0_init = new Chip("Chip 0",this.clock,this.log,this.memmanager);
    this.chip0 = chip0_init;
    
    Chip chip1_init = new Chip("Chip 1",this.clock,this.log,this.memmanager);
    this.chip1 = chip1_init;
    
    // Se setean los set del memmanager
    
     this.memmanager.setCacheL1_1_p0(this.chip0.cacheL1_1);
     this.memmanager.setCacheL1_1_p1(this.chip0.cacheL1_2);
     
     this.memmanager.setCacheL1_2_p0(this.chip1.cacheL1_1);
     this.memmanager.setCacheL1_2_p1(this.chip1.cacheL1_2);
   
     //Caches L2
     
     this.memmanager.setCacheL2_1(this.chip0.cacheL2);
     this.memmanager.setCacheL2_2(this.chip1.cacheL2);
     
    
      
    }
     
      public  void Start(){
        chip0.run();
        chip1.run();  
        }
    
      
}
