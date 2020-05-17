/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import tec.cachesimulator.Clock;
import tec.cachesimulator.Placa;

@SuppressWarnings("serial")
public class Interfaz  extends JFrame {
     private final JPanel Jpanel1;
     private JScrollPane Jscrollpanel1;
     private JScrollPane Jscrollpanel2;
 

   
    private JTable MemoriaCacheL1_1_Procesador0;
    private JTable MemoriaCacheL1_2_Procesador0;
    
    // Valores para cacheL1_1_Procesador0

    public String MemoriaCacheL1_1_Procesador0_direccion0 = "";
    public String MemoriaCacheL1_1_Procesador0_direccion1 = "";

    public String MemoriaCacheL1_1_Procesador0_estado0 = "";
    public String MemoriaCacheL1_1_Procesador0_estado1 = "";
    
    public String MemoriaCacheL1_1_Procesador0_direccionguardada0 = "";
    public String MemoriaCacheL1_1_Procesador0_direccionguardada1 = "";
    
    public String MemoriaCacheL1_1_Procesador0_dato0 = "";
    public String MemoriaCacheL1_1_Procesador0_dato1 = "";
    
    
    // Valores para cacheL1_2_Procesador0

    public String MemoriaCacheL1_2_Procesador0_direccion0 = "";
    public String MemoriaCacheL1_2_Procesador0_direccion1 = "";

    public String MemoriaCacheL1_2_Procesador0_estado0 = "";
    public String MemoriaCacheL1_2_Procesador0_estado1 = "";
    
    public String MemoriaCacheL1_2_Procesador0_direccionguardada0 = "";
    public String MemoriaCacheL1_2_Procesador0_direccionguardada1 = "";
    
    public String MemoriaCacheL1_2_Procesador0_dato0 = "";
    public String MemoriaCacheL1_2_Procesador0_dato1 = "";
    
 
    
    public Placa placa;
    public Clock clk;
    
     public Interfaz(Placa placa, Clock clk) {
        Jpanel1 = new JPanel();
        Jscrollpanel1 = new JScrollPane(getMemoriaCacheL1_1_Procesador0());
        Jscrollpanel2 = new JScrollPane(getMemoriaCacheL1_2_Procesador0());
        
        this.placa = placa;
        this.clk = clk;
        
        Jscrollpanel1.setPreferredSize(new Dimension(400,75));
        Jscrollpanel1.setBorder(BorderFactory.createTitledBorder ("Cache L1 1 Procesador0"));
        
        Jscrollpanel2.setPreferredSize(new Dimension(400,75));
        Jscrollpanel2.setBorder(BorderFactory.createTitledBorder ("Cache L1 2 Procesador0"));
        
        Jpanel1.add(Jscrollpanel1);
        Jpanel1.add(Jscrollpanel2);
        
        this.add(Jpanel1);
    }

   
    private MemoriaCacheL1_1_Procesador0Model MemoriaCacheL1_1_Procesador0Model;
    private MemoriaCacheL1_2_Procesador0Model MemoriaCacheL1_2_Procesador0Model;
    
   
    public class MemoriaCacheL1_1_Procesador0Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL1_1_Procesador0_direccion0,MemoriaCacheL1_1_Procesador0_estado0, MemoriaCacheL1_1_Procesador0_direccionguardada0,MemoriaCacheL1_1_Procesador0_dato0},
      {MemoriaCacheL1_1_Procesador0_direccion1,MemoriaCacheL1_1_Procesador0_estado1, MemoriaCacheL1_1_Procesador0_direccionguardada1,MemoriaCacheL1_1_Procesador0_dato1}
       };
        @Override
        public String getColumnName(int column) {
            return header[column];
        }
        @Override
        public int getRowCount() {
            return table.length;
        }
        @Override
        public int getColumnCount() {
            return header.length;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return table[rowIndex][columnIndex];
        }
        public void setMemoriaCacheL1_1_Procesador0(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip0.cacheL1_1.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip0.cacheL1_1.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
            table[rowIndex][2] = placa.chip0.cacheL1_1.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip0.cacheL1_1.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 3);
        }
    }
    
       
    public class MemoriaCacheL1_2_Procesador0Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL1_2_Procesador0_direccion0,MemoriaCacheL1_2_Procesador0_estado0, MemoriaCacheL1_2_Procesador0_direccionguardada0,MemoriaCacheL1_2_Procesador0_dato0},
      {MemoriaCacheL1_2_Procesador0_direccion1,MemoriaCacheL1_2_Procesador0_estado1, MemoriaCacheL1_2_Procesador0_direccionguardada1,MemoriaCacheL1_2_Procesador0_dato1}
       };
        @Override
        public String getColumnName(int column) {
            return header[column];
        }
        @Override
        public int getRowCount() {
            return table.length;
        }
        @Override
        public int getColumnCount() {
            return header.length;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return table[rowIndex][columnIndex];
        }
        public void setMemoriaCacheL1_2_Procesador0(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip0.cacheL1_2.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip0.cacheL1_2.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
            table[rowIndex][2] = placa.chip0.cacheL1_2.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip0.cacheL1_2.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 3);
        }
    }

private JTable getMemoriaCacheL1_1_Procesador0() {
        MemoriaCacheL1_1_Procesador0Model = new MemoriaCacheL1_1_Procesador0Model();
        MemoriaCacheL1_1_Procesador0 = new JTable(MemoriaCacheL1_1_Procesador0Model);
        return MemoriaCacheL1_1_Procesador0;
    }

private JTable getMemoriaCacheL1_2_Procesador0() {
        MemoriaCacheL1_2_Procesador0Model = new MemoriaCacheL1_2_Procesador0Model();
        MemoriaCacheL1_2_Procesador0 = new JTable(MemoriaCacheL1_2_Procesador0Model);
        return MemoriaCacheL1_2_Procesador0;
    }


























































    public static void main(String[] args) {
        Clock clk =new Clock();
        Placa placa = new Placa(clk);
        clk.start();
        placa.Start();
        final Interfaz serverGUI = new Interfaz(placa,clk);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                serverGUI.setTitle("Cache coherence simulator");
                serverGUI.setSize(1080, 720);
                serverGUI.setLocationRelativeTo(null);
                serverGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                serverGUI.setVisible(true);
                
            }
        });

        // Dummy thread that simulates user connecting and disconnecting randomly.
        Timer t = new Timer(1, (ActionEvent e) -> {
            
            for (int i = 0; i < serverGUI.MemoriaCacheL1_1_Procesador0Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL1_1_Procesador0Model.setMemoriaCacheL1_1_Procesador0(i,serverGUI.placa);
            }
            
            for (int i = 0; i < serverGUI.MemoriaCacheL1_2_Procesador0Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL1_2_Procesador0Model.setMemoriaCacheL1_2_Procesador0(i,serverGUI.placa);
            }
            
        } );
        t.start();
    }


}
    

