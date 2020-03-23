/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author esteban clase encargada de mantener un log de las actividades
 * del sistema 
 */
public class LogManager {
    public String LastLog;

    public LogManager() {
    }
    
    public void WriteLastLog(){
        try {
      FileWriter myWriter = new FileWriter("Log.txt");
      myWriter.write(this.LastLog +"\n");
      System.out.println(this.LastLog);
      myWriter.close();
      //se limpia el último log 
      this.setLastLog(" ");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }

    public String getLastLog() {
        return LastLog;
    }

    public void setLastLog(String LastLog) {
        this.LastLog = LastLog;
    }
    
    
}
