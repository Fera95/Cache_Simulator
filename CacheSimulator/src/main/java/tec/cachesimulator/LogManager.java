/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec.cachesimulator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.List;
import javax.swing.JOptionPane;

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
       File archivo;
       FileWriter escritor;
       BufferedWriter buffer;
       PrintWriter printer;
       
       try{
           
           archivo = new File("Log.txt");
           escritor = new FileWriter(archivo,true);
           buffer = new BufferedWriter(escritor);
           printer = new PrintWriter(buffer);
           printer.append("\n");
           printer.append(this.LastLog);
           printer.close();
           buffer.close();
           
       }catch(IOException e){
           JOptionPane.showMessageDialog(null,"error"+e);
                   
       }
       
       
       
    }

    public String getLastLog() {
        return LastLog;
    }

    public void setLastLog(String LastLog) {
        this.LastLog = LastLog;
    }
    
    
}
