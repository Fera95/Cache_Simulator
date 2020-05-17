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
     private JScrollPane Jscrollpanel3;
     private JScrollPane Jscrollpanel4;
     private JScrollPane Jscrollpanel5;
     private JScrollPane Jscrollpanel6;
     private JScrollPane Jscrollpanel7;
 
 

   
    private JTable MemoriaCacheL1_1_Procesador0;
    private JTable MemoriaCacheL1_2_Procesador0;
    private JTable MemoriaCacheL1_1_Procesador1;
    private JTable MemoriaCacheL1_2_Procesador1;
    private JTable MemoriaCacheL2_Procesador0;
    private JTable MemoriaCacheL2_Procesador1;
    private JTable MemoriaPrincipal;
    
    
    
    
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
    
 // Valores para cacheL1_1_Procesador1

    public String MemoriaCacheL1_1_Procesador1_direccion0 = "";
    public String MemoriaCacheL1_1_Procesador1_direccion1 = "";

    public String MemoriaCacheL1_1_Procesador1_estado0 = "";
    public String MemoriaCacheL1_1_Procesador1_estado1 = "";
    
    public String MemoriaCacheL1_1_Procesador1_direccionguardada0 = "";
    public String MemoriaCacheL1_1_Procesador1_direccionguardada1 = "";
    
    public String MemoriaCacheL1_1_Procesador1_dato0 = "";
    public String MemoriaCacheL1_1_Procesador1_dato1 = "";
    
    
    // Valores para cacheL1_2_Procesador1

    public String MemoriaCacheL1_2_Procesador1_direccion0 = "";
    public String MemoriaCacheL1_2_Procesador1_direccion1 = "";

    public String MemoriaCacheL1_2_Procesador1_estado0 = "";
    public String MemoriaCacheL1_2_Procesador1_estado1 = "";
    
    public String MemoriaCacheL1_2_Procesador1_direccionguardada0 = "";
    public String MemoriaCacheL1_2_Procesador1_direccionguardada1 = "";
    
    public String MemoriaCacheL1_2_Procesador1_dato0 = "";
    public String MemoriaCacheL1_2_Procesador1_dato1 = "";
    
    
    
    // Valores para cacheL2_Procesador0

    public String MemoriaCacheL2_Procesador0_direccion0 = "";
    public String MemoriaCacheL2_Procesador0_direccion1 = "";
    public String MemoriaCacheL2_Procesador0_direccion2 = "";
    public String MemoriaCacheL2_Procesador0_direccion3 = "";

    public String MemoriaCacheL2_Procesador0_estado0 = "";
    public String MemoriaCacheL2_Procesador0_estado1 = "";
    public String MemoriaCacheL2_Procesador0_estado2 = "";
    public String MemoriaCacheL2_Procesador0_estado3 = "";
    
    public String MemoriaCacheL2_Procesador0_direccionguardada0 = "";
    public String MemoriaCacheL2_Procesador0_direccionguardada1 = "";
    public String MemoriaCacheL2_Procesador0_direccionguardada2 = "";
    public String MemoriaCacheL2_Procesador0_direccionguardada3 = "";
   
    public String MemoriaCacheL2_Procesador0_dato0 = "";
    public String MemoriaCacheL2_Procesador0_dato1 = "";
    public String MemoriaCacheL2_Procesador0_dato2 = "";
    public String MemoriaCacheL2_Procesador0_dato3 = "";
    
    public String MemoriaCacheL2_Procesador0_dueño0 = "";
    public String MemoriaCacheL2_Procesador0_dueño1 = "";
    public String MemoriaCacheL2_Procesador0_dueño2 = "";
    public String MemoriaCacheL2_Procesador0_dueño3 = "";
    
    // Valores para cacheL2_Procesador1

    public String MemoriaCacheL2_Procesador1_direccion0 = "";
    public String MemoriaCacheL2_Procesador1_direccion1 = "";
    public String MemoriaCacheL2_Procesador1_direccion2 = "";
    public String MemoriaCacheL2_Procesador1_direccion3 = "";

    public String MemoriaCacheL2_Procesador1_estado0 = "";
    public String MemoriaCacheL2_Procesador1_estado1 = "";
    public String MemoriaCacheL2_Procesador1_estado2 = "";
    public String MemoriaCacheL2_Procesador1_estado3 = "";
    
    public String MemoriaCacheL2_Procesador1_direccionguardada0 = "";
    public String MemoriaCacheL2_Procesador1_direccionguardada1 = "";
    public String MemoriaCacheL2_Procesador1_direccionguardada2 = "";
    public String MemoriaCacheL2_Procesador1_direccionguardada3 = "";
   
    public String MemoriaCacheL2_Procesador1_dato0 = "";
    public String MemoriaCacheL2_Procesador1_dato1 = "";
    public String MemoriaCacheL2_Procesador1_dato2 = "";
    public String MemoriaCacheL2_Procesador1_dato3 = "";
    
    public String MemoriaCacheL2_Procesador1_dueño0 = "";
    public String MemoriaCacheL2_Procesador1_dueño1 = "";
    public String MemoriaCacheL2_Procesador1_dueño2 = "";
    public String MemoriaCacheL2_Procesador1_dueño3 = "";
    
    
    
      // Valores para MemoriaPrincipal

    public String MemoriaPrincipal_direccion0 = "";
    public String MemoriaPrincipal_direccion1 = "";
    public String MemoriaPrincipal_direccion2 = "";
    public String MemoriaPrincipal_direccion3 = "";
    public String MemoriaPrincipal_direccion4 = "";
    public String MemoriaPrincipal_direccion5 = "";
    public String MemoriaPrincipal_direccion6 = "";
    public String MemoriaPrincipal_direccion7 = "";
    public String MemoriaPrincipal_direccion8 = "";
    public String MemoriaPrincipal_direccion9 = "";
    public String MemoriaPrincipal_direccion10 = "";
    public String MemoriaPrincipal_direccion11 = "";
    public String MemoriaPrincipal_direccion12 = "";
    public String MemoriaPrincipal_direccion13 = "";
    public String MemoriaPrincipal_direccion14 = "";
    public String MemoriaPrincipal_direccion15 = "";

    public String MemoriaPrincipal_estado0 = "";
    public String MemoriaPrincipal_estado1 = "";
    public String MemoriaPrincipal_estado2 = "";
    public String MemoriaPrincipal_estado3 = "";
    public String MemoriaPrincipal_estado4 = "";
    public String MemoriaPrincipal_estado5 = "";
    public String MemoriaPrincipal_estado6 = "";
    public String MemoriaPrincipal_estado7 = "";
    public String MemoriaPrincipal_estado8 = "";
    public String MemoriaPrincipal_estado9 = "";
    public String MemoriaPrincipal_estado10 = "";
    public String MemoriaPrincipal_estado11 = "";
    public String MemoriaPrincipal_estado12 = "";
    public String MemoriaPrincipal_estado13 = "";
    public String MemoriaPrincipal_estado14 = "";
    public String MemoriaPrincipal_estado15 = "";
    
    public String MemoriaPrincipal_direccionguardada0 = "";
    public String MemoriaPrincipal_direccionguardada1 = "";
    public String MemoriaPrincipal_direccionguardada2 = "";
    public String MemoriaPrincipal_direccionguardada3 = "";
    public String MemoriaPrincipal_direccionguardada4 = "";
    public String MemoriaPrincipal_direccionguardada5 = "";
    public String MemoriaPrincipal_direccionguardada6 = "";
    public String MemoriaPrincipal_direccionguardada7 = "";
    public String MemoriaPrincipal_direccionguardada8 = "";
    public String MemoriaPrincipal_direccionguardada9 = "";
    public String MemoriaPrincipal_direccionguardada10 = "";
    public String MemoriaPrincipal_direccionguardada11 = "";
    public String MemoriaPrincipal_direccionguardada12 = "";
    public String MemoriaPrincipal_direccionguardada13 = "";
    public String MemoriaPrincipal_direccionguardada14 = "";
    public String MemoriaPrincipal_direccionguardada15 = "";
   
    public String MemoriaPrincipal_dato0 = "";
    public String MemoriaPrincipal_dato1 = "";
    public String MemoriaPrincipal_dato2 = "";
    public String MemoriaPrincipal_dato3 = "";
    public String MemoriaPrincipal_dato4 = "";
    public String MemoriaPrincipal_dato5 = "";
    public String MemoriaPrincipal_dato6 = "";
    public String MemoriaPrincipal_dato7 = "";
    public String MemoriaPrincipal_dato8 = "";
    public String MemoriaPrincipal_dato9 = "";
    public String MemoriaPrincipal_dato10 = "";
    public String MemoriaPrincipal_dato11 = "";
    public String MemoriaPrincipal_dato12 = "";
    public String MemoriaPrincipal_dato13 = "";
    public String MemoriaPrincipal_dato14 = "";
    public String MemoriaPrincipal_dato15 = "";
    
    
    public String MemoriaPrincipal_dueño0 = "";
    public String MemoriaPrincipal_dueño1 = "";
    public String MemoriaPrincipal_dueño2 = "";
    public String MemoriaPrincipal_dueño3 = "";
    public String MemoriaPrincipal_dueño4 = "";
    public String MemoriaPrincipal_dueño5 = "";
    public String MemoriaPrincipal_dueño6 = "";
    public String MemoriaPrincipal_dueño7 = "";
    public String MemoriaPrincipal_dueño8 = "";
    public String MemoriaPrincipal_dueño9 = "";
    public String MemoriaPrincipal_dueño10 = "";
    public String MemoriaPrincipal_dueño11 = "";
    public String MemoriaPrincipal_dueño12 = "";
    public String MemoriaPrincipal_dueño13 = "";
    public String MemoriaPrincipal_dueño14 = "";
    public String MemoriaPrincipal_dueño15 = "";
    
    public Placa placa;
    public Clock clk;
    
     public Interfaz(Placa placa, Clock clk) {
        Jpanel1 = new JPanel();
        Jscrollpanel1 = new JScrollPane(getMemoriaCacheL1_1_Procesador0());
        Jscrollpanel2 = new JScrollPane(getMemoriaCacheL1_2_Procesador0());
        Jscrollpanel3 = new JScrollPane(getMemoriaCacheL1_1_Procesador1());
        Jscrollpanel4= new JScrollPane(getMemoriaCacheL1_2_Procesador1());
        Jscrollpanel5= new JScrollPane(getMemoriaCacheL2_Procesador0());
        Jscrollpanel6= new JScrollPane(getMemoriaCacheL2_Procesador1());
        Jscrollpanel7= new JScrollPane(getMemoriaPrincipal());
        
        this.placa = placa;
        this.clk = clk;
        
        Jscrollpanel1.setPreferredSize(new Dimension(400,75));
        Jscrollpanel1.setBorder(BorderFactory.createTitledBorder ("Cache L1 1 Procesador0"));
        
        Jscrollpanel2.setPreferredSize(new Dimension(400,75));
        Jscrollpanel2.setBorder(BorderFactory.createTitledBorder ("Cache L1 2 Procesador0"));
        
        
        Jscrollpanel3.setPreferredSize(new Dimension(400,75));
        Jscrollpanel3.setBorder(BorderFactory.createTitledBorder ("Cache L1 1 Procesador1"));
        
        Jscrollpanel4.setPreferredSize(new Dimension(400,75));
        Jscrollpanel4.setBorder(BorderFactory.createTitledBorder ("Cache L1 2 Procesador1"));
        
        
        Jscrollpanel5.setPreferredSize(new Dimension(400,110));
        Jscrollpanel5.setBorder(BorderFactory.createTitledBorder ("Cache L2 Chip 0"));
        
        Jscrollpanel6.setPreferredSize(new Dimension(400,110));
        Jscrollpanel6.setBorder(BorderFactory.createTitledBorder ("Cache L2 Chip 1"));
        
        Jscrollpanel7.setPreferredSize(new Dimension(550,300));
        Jscrollpanel7.setBorder(BorderFactory.createTitledBorder ("Memoria Principal"));
        
        Jpanel1.add(Jscrollpanel1);
        Jpanel1.add(Jscrollpanel3);
        Jpanel1.add(Jscrollpanel2);
        
        Jpanel1.add(Jscrollpanel4);
        Jpanel1.add(Jscrollpanel5);
        Jpanel1.add(Jscrollpanel6);
         Jpanel1.add(Jscrollpanel7);
        
        this.add(Jpanel1);
    }

   
    private MemoriaCacheL1_1_Procesador0Model MemoriaCacheL1_1_Procesador0Model;
    private MemoriaCacheL1_2_Procesador0Model MemoriaCacheL1_2_Procesador0Model;
    private MemoriaCacheL1_1_Procesador1Model MemoriaCacheL1_1_Procesador1Model;
    private MemoriaCacheL1_2_Procesador1Model MemoriaCacheL1_2_Procesador1Model;
    private MemoriaCacheL2_Procesador0Model MemoriaCacheL2_Procesador0Model;
    private MemoriaCacheL2_Procesador1Model MemoriaCacheL2_Procesador1Model;
     private MemoriaPrincipalModel MemoriaPrincipalModel;
    
   
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

    
    
    public class MemoriaCacheL1_1_Procesador1Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL1_1_Procesador1_direccion0,MemoriaCacheL1_1_Procesador1_estado0, MemoriaCacheL1_1_Procesador1_direccionguardada0,MemoriaCacheL1_1_Procesador1_dato0},
      {MemoriaCacheL1_1_Procesador1_direccion1,MemoriaCacheL1_1_Procesador1_estado1, MemoriaCacheL1_1_Procesador1_direccionguardada1,MemoriaCacheL1_1_Procesador1_dato1}
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
        public void setMemoriaCacheL1_1_Procesador1(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip1.cacheL1_1.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip1.cacheL1_1.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
            table[rowIndex][2] = placa.chip1.cacheL1_1.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip1.cacheL1_1.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 3);
        }
    }
    
       
    public class MemoriaCacheL1_2_Procesador1Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL1_2_Procesador1_direccion0,MemoriaCacheL1_2_Procesador1_estado0, MemoriaCacheL1_2_Procesador1_direccionguardada0,MemoriaCacheL1_2_Procesador1_dato0},
      {MemoriaCacheL1_2_Procesador1_direccion1,MemoriaCacheL1_2_Procesador1_estado1, MemoriaCacheL1_2_Procesador1_direccionguardada1,MemoriaCacheL1_2_Procesador1_dato1}
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
        public void setMemoriaCacheL1_2_Procesador1(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip1.cacheL1_2.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip1.cacheL1_2.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
            table[rowIndex][2] = placa.chip1.cacheL1_2.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip1.cacheL1_2.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 3);
        }
    }
    
    
    
    public class MemoriaCacheL2_Procesador0Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Dueño","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL2_Procesador0_direccion0,MemoriaCacheL2_Procesador0_estado0,MemoriaCacheL2_Procesador0_dueño0, MemoriaCacheL2_Procesador0_direccionguardada0,MemoriaCacheL2_Procesador0_dato0},
      {MemoriaCacheL2_Procesador0_direccion1,MemoriaCacheL2_Procesador0_estado1,MemoriaCacheL2_Procesador0_dueño1, MemoriaCacheL2_Procesador0_direccionguardada1,MemoriaCacheL2_Procesador0_dato1},
      {MemoriaCacheL2_Procesador0_direccion2,MemoriaCacheL2_Procesador0_estado2,MemoriaCacheL2_Procesador0_dueño2, MemoriaCacheL2_Procesador0_direccionguardada2,MemoriaCacheL2_Procesador0_dato2},
      {MemoriaCacheL2_Procesador0_direccion3,MemoriaCacheL2_Procesador0_estado3,MemoriaCacheL2_Procesador0_dueño3, MemoriaCacheL2_Procesador0_direccionguardada3,MemoriaCacheL2_Procesador0_dato3}
            
            
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
        public void setMemoriaCacheL2_Procesador0(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip0.cacheL2.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip0.cacheL2.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
             table[rowIndex][2] = placa.chip0.cacheL2.Bloques_memoria.get(rowIndex).getStringDueños();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip0.cacheL2.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 3);
            
            table[rowIndex][4] = placa.chip0.cacheL2.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 4);
            
           
        }
    }
    
    
    public class MemoriaCacheL2_Procesador1Model extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Dueño","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaCacheL2_Procesador1_direccion0,MemoriaCacheL2_Procesador1_estado0,MemoriaCacheL2_Procesador1_dueño0, MemoriaCacheL2_Procesador1_direccionguardada0,MemoriaCacheL2_Procesador1_dato0},
      {MemoriaCacheL2_Procesador1_direccion1,MemoriaCacheL2_Procesador1_estado1,MemoriaCacheL2_Procesador1_dueño1, MemoriaCacheL2_Procesador1_direccionguardada1,MemoriaCacheL2_Procesador1_dato1},
      {MemoriaCacheL2_Procesador1_direccion2,MemoriaCacheL2_Procesador1_estado2,MemoriaCacheL2_Procesador1_dueño2, MemoriaCacheL2_Procesador1_direccionguardada2,MemoriaCacheL2_Procesador1_dato2},
      {MemoriaCacheL2_Procesador1_direccion3,MemoriaCacheL2_Procesador1_estado3,MemoriaCacheL2_Procesador1_dueño3, MemoriaCacheL2_Procesador1_direccionguardada3,MemoriaCacheL2_Procesador1_dato3}
            
            
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
        public void setMemoriaCacheL2_Procesador1(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.chip1.cacheL2.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.chip1.cacheL2.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
             table[rowIndex][2] = placa.chip1.cacheL2.Bloques_memoria.get(rowIndex).getStringDueños();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.chip1.cacheL2.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 3);
            
            table[rowIndex][4] = placa.chip1.cacheL2.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 4);
            
           
        }
    }
    
    public class MemoriaPrincipalModel extends AbstractTableModel {
        private String[] header = { "Direccion Cache","Estado","Dueño","Memoria", "Dato" };
        private String[][] table = { 
      {MemoriaPrincipal_direccion0,MemoriaPrincipal_estado0,MemoriaPrincipal_dueño0, MemoriaPrincipal_direccionguardada0,MemoriaPrincipal_dato0},
      {MemoriaPrincipal_direccion1,MemoriaPrincipal_estado1,MemoriaPrincipal_dueño1, MemoriaPrincipal_direccionguardada1,MemoriaPrincipal_dato1}, 
      {MemoriaPrincipal_direccion2,MemoriaPrincipal_estado2,MemoriaPrincipal_dueño2, MemoriaPrincipal_direccionguardada2,MemoriaPrincipal_dato2},
      {MemoriaPrincipal_direccion3,MemoriaPrincipal_estado3,MemoriaPrincipal_dueño3, MemoriaPrincipal_direccionguardada3,MemoriaPrincipal_dato3},
      {MemoriaPrincipal_direccion4,MemoriaPrincipal_estado4,MemoriaPrincipal_dueño4, MemoriaPrincipal_direccionguardada4,MemoriaPrincipal_dato4},
      {MemoriaPrincipal_direccion5,MemoriaPrincipal_estado5,MemoriaPrincipal_dueño5, MemoriaPrincipal_direccionguardada5,MemoriaPrincipal_dato5}, 
      {MemoriaPrincipal_direccion6,MemoriaPrincipal_estado6,MemoriaPrincipal_dueño6, MemoriaPrincipal_direccionguardada6,MemoriaPrincipal_dato6},
      {MemoriaPrincipal_direccion7,MemoriaPrincipal_estado7,MemoriaPrincipal_dueño7, MemoriaPrincipal_direccionguardada7,MemoriaPrincipal_dato7},
      {MemoriaPrincipal_direccion8,MemoriaPrincipal_estado8,MemoriaPrincipal_dueño8, MemoriaPrincipal_direccionguardada8,MemoriaPrincipal_dato8},
      {MemoriaPrincipal_direccion9,MemoriaPrincipal_estado9,MemoriaPrincipal_dueño9, MemoriaPrincipal_direccionguardada9,MemoriaPrincipal_dato9}, 
      {MemoriaPrincipal_direccion10,MemoriaPrincipal_estado10,MemoriaPrincipal_dueño10, MemoriaPrincipal_direccionguardada10,MemoriaPrincipal_dato10},
      {MemoriaPrincipal_direccion11,MemoriaPrincipal_estado11,MemoriaPrincipal_dueño11, MemoriaPrincipal_direccionguardada11,MemoriaPrincipal_dato11},
      {MemoriaPrincipal_direccion12,MemoriaPrincipal_estado12,MemoriaPrincipal_dueño12, MemoriaPrincipal_direccionguardada12,MemoriaPrincipal_dato12},
      {MemoriaPrincipal_direccion13,MemoriaPrincipal_estado13,MemoriaPrincipal_dueño13, MemoriaPrincipal_direccionguardada13,MemoriaPrincipal_dato13}, 
      {MemoriaPrincipal_direccion14,MemoriaPrincipal_estado14,MemoriaPrincipal_dueño14, MemoriaPrincipal_direccionguardada14,MemoriaPrincipal_dato14},
      {MemoriaPrincipal_direccion15,MemoriaPrincipal_estado15,MemoriaPrincipal_dueño15, MemoriaPrincipal_direccionguardada15,MemoriaPrincipal_dato15},

            
            
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
        public void setMemoriaPrincipal(int rowIndex, Placa placa) {
            table[rowIndex][0] = placa.memprincipal.Bloques_memoria.get(rowIndex).getDireccion();
            fireTableCellUpdated(rowIndex, 0);
        
            table[rowIndex][1] = placa.memprincipal.Bloques_memoria.get(rowIndex).getEstado();
            fireTableCellUpdated(rowIndex, 1);
            
             table[rowIndex][2] = placa.memprincipal.Bloques_memoria.get(rowIndex).getStringDueños();
            fireTableCellUpdated(rowIndex, 2);
            
            table[rowIndex][3] = placa.memprincipal.Bloques_memoria.get(rowIndex).getDireccionGuarda();
            fireTableCellUpdated(rowIndex, 3);
            
            table[rowIndex][4] = placa.memprincipal.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 4);
            
           
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


    
private JTable getMemoriaCacheL1_1_Procesador1() {
        MemoriaCacheL1_1_Procesador1Model = new MemoriaCacheL1_1_Procesador1Model();
        MemoriaCacheL1_1_Procesador1 = new JTable(MemoriaCacheL1_1_Procesador1Model);
        return MemoriaCacheL1_1_Procesador1;
    }

private JTable getMemoriaCacheL1_2_Procesador1() {
        MemoriaCacheL1_2_Procesador1Model = new MemoriaCacheL1_2_Procesador1Model();
        MemoriaCacheL1_2_Procesador1 = new JTable(MemoriaCacheL1_2_Procesador1Model);
        return MemoriaCacheL1_2_Procesador1;
    }

private JTable getMemoriaCacheL2_Procesador0() {
        MemoriaCacheL2_Procesador0Model = new MemoriaCacheL2_Procesador0Model();
        MemoriaCacheL2_Procesador0 = new JTable(MemoriaCacheL2_Procesador0Model);
        return MemoriaCacheL2_Procesador0;
    }

private JTable getMemoriaCacheL2_Procesador1() {
        MemoriaCacheL2_Procesador1Model = new MemoriaCacheL2_Procesador1Model();
        MemoriaCacheL2_Procesador1 = new JTable(MemoriaCacheL2_Procesador1Model);
        return MemoriaCacheL2_Procesador1;
    }

private JTable getMemoriaPrincipal() {
        MemoriaPrincipalModel = new MemoriaPrincipalModel();
        MemoriaPrincipal = new JTable(MemoriaPrincipalModel);
        return MemoriaPrincipal;
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
            
               for (int i = 0; i < serverGUI.MemoriaCacheL1_1_Procesador1Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL1_1_Procesador1Model.setMemoriaCacheL1_1_Procesador1(i,serverGUI.placa);
            }
            
            for (int i = 0; i < serverGUI.MemoriaCacheL1_2_Procesador1Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL1_2_Procesador1Model.setMemoriaCacheL1_2_Procesador1(i,serverGUI.placa);
            }
            
            for (int i = 0; i < serverGUI.MemoriaCacheL2_Procesador0Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL2_Procesador0Model.setMemoriaCacheL2_Procesador0(i,serverGUI.placa);
            }
            
             for (int i = 0; i < serverGUI.MemoriaCacheL2_Procesador1Model.getRowCount(); i++) {
                serverGUI.MemoriaCacheL2_Procesador1Model.setMemoriaCacheL2_Procesador1(i,serverGUI.placa);
            }
             
              for (int i = 0; i < serverGUI.MemoriaPrincipalModel.getRowCount(); i++) {
                serverGUI.MemoriaPrincipalModel.setMemoriaPrincipal(i,serverGUI.placa);
            }
        } );
        t.start();
    }


}
    

