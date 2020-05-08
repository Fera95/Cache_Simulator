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
      public Direcctorio directorio;
      public Memoria memprincipal;
      public MemStatus memstatus;
      

    public Placa(Clock clock) {
        this.clock = clock;
          
        
       //Se instancian los componentes dentro de la placa
       
       
       //Se inicializa el Log manager para escritura del archivo de logs
       
      LogManager Log_init;
      Log_init = new LogManager();
      this.log = Log_init;
      
      
      //Se incializa el memstatus para la comunicación con la interfaz 
      
      MemStatus MemStatus_init;
      MemStatus_init = new MemStatus();
      this.memstatus = MemStatus_init;
      
      
      //Se inicializa la memoria principal
      
      Memoria MemPrincipal_init;
      MemPrincipal_init = new Memoria(16,"Memoria Principal");
      this.memprincipal = MemPrincipal_init;
      
      
      
      //Se incializa el Directorio
      
      Direcctorio Directorio_init;
      Directorio_init = new Direcctorio(this.chip0.cacheL2,this.chip1.cacheL2,this.memprincipal,this.log);
      this.directorio = Directorio_init;
      
      //Se inicializa 
        //Se instancian los chips
    
    Chip chip0_init = new Chip("Chip 0",this.clock,this.log,this.directorio);
    this.chip0 = chip0_init;
    
    Chip chip1_init = new Chip("Chip 1",this.clock,this.log,this.directorio);
    this.chip1 = chip1_init;
    
    
    //Se agrega observador
    
   this.memprincipal.agregarObserver(this.directorio);
      
    }
      
  
    
    
    
      public void Start() throws InterruptedException{
        this.chip0.Start();
        this.chip1.Start();
        }
    
      
}
