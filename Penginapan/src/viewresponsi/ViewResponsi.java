/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viewresponsi;

import controller.LoginController;
import model.ModelMaul;

/**
 *
 * @author OWNER
 */
public class ViewResponsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        RenterDataView view = new RenterDataView();
new LoginController(new LoginPageView(), new ModelMaul());
    }
    
}
