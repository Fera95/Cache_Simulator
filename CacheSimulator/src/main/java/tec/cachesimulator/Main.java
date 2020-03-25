package tec.cachesimulator;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.Type.APPEND;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author esteban
 */
public class Main {
    
public static void main(String[] args) throws InterruptedException, IOException{

     Clock  clk = new Clock();
     Chip chip1 = new Chip("0",clk);
     clk.start();
     chip1.Start();
     
 
       
       
       
}
    
    
    
}
