/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelMaul;
import viewresponsi.AdminPageView;
import viewresponsi.LoginPageView;
import viewresponsi.RoomListView;

/**
 *
 * @author MSI Bravo
 */
public class LoginController {
    public LoginController(LoginPageView loginPage, ModelMaul model) {
        
        loginPage.blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.userCheck(loginPage.getUsername(), loginPage.getPassword()).equals("admin")){
                    AdminPageView admView = new AdminPageView();
                    AdminController admControl =new AdminController(admView,model);
                    loginPage.dispose();
                    System.out.println("p");
                }
                else if(model.userCheck(loginPage.getUsername(), loginPage.getPassword()).equals("renter")){
                    RoomListView roomView = new RoomListView();
                    RoomController roomControl = new RoomController(roomView,model);
                    loginPage.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username/password!");
                }
            }
        });
    }
}
