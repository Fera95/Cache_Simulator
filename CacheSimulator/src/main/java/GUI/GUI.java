import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import tec.cachesimulator.Chip;
import tec.cachesimulator.Clock;
import tec.cachesimulator.Placa;

public class GUI extends JPanel
{
     JTable MemoriaPrincipal;
     JTable jt2;
 
     // Constructors are usually used to initialize components in classes. 
     // That's it. This example is a bad practice. Use functions instead for 
     // production code
     public GUI()
     {
     
          String[] columnsMemPrincipal = {"Dirección", "Estado", "Dueño(s)","Dato"};
          
       
          String[][] data = {{"John", "18", "Male","0"}};
  
          // Creates Table
          MemoriaPrincipal = new JTable(data, columnsMemPrincipal)
          {
               // Determines if data can be entered by users
               @Override
               public boolean isCellEditable(int data, int columnsMemPrincipal)
               {
                   return false;
               }
   
               //  Creates cells for the table         
               @Override
               public Component prepareRenderer(
                            TableCellRenderer r, int data, int columnsMemPrincipal)
               {
                   Component c = super.prepareRenderer(r, data, columnsMemPrincipal);
                  
                   // Every even numbers
                   if (data % 2 == 0)
                       c.setBackground(Color.WHITE);
    
                   else
                       c.setBackground(Color.LIGHT_GRAY);
    
                   return c;
               }
         };
          
          
  
  
         // Set size of table     
         MemoriaPrincipal.setPreferredScrollableViewportSize(new Dimension(450, 63));
         
        

         // This will resize the height of the table automatically 
         // to all data without scrolling. 
         MemoriaPrincipal.setFillsViewportHeight(true);
    

         JScrollPane jps = new JScrollPane(MemoriaPrincipal);
 
         add(jps);
            
     }
 
     // Creates Window
     public static void main(String[] args) throws InterruptedException
     {
         JFrame jf = new JFrame("Cache Simulator");
         GUI t = new GUI();
         jf.setSize( 1388,1080);
         jf.setVisible(true);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jf.add(t);
        
         


        //Se agregan los componentes de la logica   
         
         Clock  clk = new Clock();
         Placa placa = new Placa(clk);
         
         
         clk.start();
         placa.Start();
         
         try {
         
     
         placa.chip0.nucleo0.join();
         placa.chip0.nucleo1.join();
         placa.chip1.nucleo0.join();
         placa.chip1.nucleo1.join();
         clk.join();
         
      } catch ( InterruptedException e) {
         System.out.println("Interrupted");
      }
     
     }
}