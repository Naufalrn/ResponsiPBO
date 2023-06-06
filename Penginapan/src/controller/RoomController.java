/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelMaul;
import viewresponsi.LoginPageView;
import viewresponsi.RenterDataView;
import viewresponsi.RoomListView;

/**
 *
 * @author MSI Bravo
 */
public class RoomController {
    RoomListView roomView;
    ModelMaul model;
    String[][] data;
    int row;
    public RoomController(RoomListView roomListView,ModelMaul modelMaul){
        this.roomView = roomListView;
        this.model = modelMaul;
        showData();
        
        roomView.tabel.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
              row = roomView.tabel.getSelectedRow();
              if(data[row][3].equals("empty")){
                  RenterDataView rentView = new RenterDataView();
                  RenterController rentControl = new RenterController(rentView, model, data[row][0]);
                  roomView.window.dispose();
              }
              else{
                  JOptionPane.showMessageDialog(null, "Room is already occupied!");
              }
            }  
        });
        
        roomView.bcancel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0){
               LoginPageView loginView = new LoginPageView();
               LoginController logControl = new LoginController(loginView, model);
               roomView.window.dispose();
           }
           
        });
    }
    void showData(){
        data = model.readRoom();
        String[] columnName = {"Name", "Size", "Price", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnName){
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };
        roomView.tabel.setModel(tableModel);
    }
   }

