/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelMaul;
import viewresponsi.LoginPageView;
import viewresponsi.RenterDataView;

/**
 *
 * @author MSI Bravo
 */
public class RenterController {
     RenterDataView rentView ;
    ModelMaul model ;
    String room;
    
    public RenterController(RenterDataView rentView, ModelMaul model, String room){
        this.rentView = rentView;
        this.model = model;
        this.room = room;
        
        rentView.btnAddPanel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0){
                model.insertRent(rentView.getName(), rentView.getID(), rentView.getContact(), rentView.getRentTime(), room);
            } 
        });
        rentView.btnLogout.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0){
                LoginPageView logView = new LoginPageView();
                LoginController logControl = new LoginController (logView, model);
                rentView.window.dispose();
            } 
        });
    }
}
