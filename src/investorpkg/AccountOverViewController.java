/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainpkg.Account;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class AccountOverViewController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label contactNoLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label DOBLabel; 
    @FXML
    private Label idLabel;
    
    private Investor i;
    public void data(Investor i){
        this.i = i;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
// Problem
//        if (nameLabel == null){
//            System.out.println("Null");
//        }
//        else{
//            nameLabel.setText(i.getName());
//        }
        
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        idLabel.setText(Integer.toString(i.getId()));
        nameLabel.setText(i.getName());
        contactNoLabel.setText(i.getContact());
        addressLabel.setText(i.getAddress());
        emailLabel.setText(i.getEmail());
        DOBLabel.setText(i.getDob().format(DateTimeFormatter.ISO_DATE));
        
    }
    
}
