/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import tec.cachesimulator.Clock;
import tec.cachesimulator.Placa;

@SuppressWarnings("serial")
public class Interfaz  extends JFrame {
     private JPanel serverPanel;
   


    private JTable connectedClientsList;
    private JScrollPane scrollPane;
    public String player1Connected = "";
    public String player2Connected = "";
    public String player3Connected = "";
    public String player4Connected = "";
    
    public Placa placa;
    public Clock clk;
    
     public Interfaz(Placa placa, Clock clk) {
          serverPanel = new JPanel();



        scrollPane = new JScrollPane(getTable());

        this.placa = placa;
        this.clk = clk;
        

        
       
        serverPanel.add(scrollPane);
        this.add(serverPanel);
        
    }

    private PlayerTableModel tableModel;

    public class PlayerTableModel extends AbstractTableModel {

        private String[] header = { "Players", "Connected To Server" };
        private String[][] table = { { "Player 1", player1Connected }, { "Player 2", player2Connected }};

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

        public void setPlayerConnected(int rowIndex, Placa placa) {
            table[rowIndex][1] = placa.chip0.cacheL1_1.Bloques_memoria.get(rowIndex).getDato();
            fireTableCellUpdated(rowIndex, 1);
        }

    }

private JTable getTable() {
        tableModel = new PlayerTableModel();
        connectedClientsList = new JTable(tableModel);
        return connectedClientsList;
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
                serverGUI.setTitle("Dark Project Server GUI");
                serverGUI.setSize(800, 600);
                serverGUI.setLocationRelativeTo(null);
                serverGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                serverGUI.setVisible(true);
                
            }
        });

        // Dummy thread that simulates user connecting and disconnecting randomly.
        Timer t = new Timer(1, (ActionEvent e) -> {
            for (int i = 0; i < serverGUI.tableModel.getRowCount(); i++) {
                serverGUI.tableModel.setPlayerConnected(i,serverGUI.placa);
            }
        } /* Random random = new Random();*/ );
        t.start();
    }


}
    

