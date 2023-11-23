/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package PlatformAdminstratorpkg;

import investorpkg.Investor;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CreateNewAccountSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button createAccountButton;
    @FXML
    private Button backButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contact = contactNumberTextField.getText();
        String email = emailTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        LocalDate doj = LocalDate.now();
        String password = passwordTextField.getText();
        int id = Account.generateInvestorId();
        double balance = 0;
        if (Account.checkInvestorAccountExistence(email)){
            PopUp.Message("Account Already Exists !");                
        }
        else{
            Investor i = new Investor(id, name, address, contact, email, dob, doj, password, balance);
            PlatformAdminstrator.createNewAccount(i);
            PopUp.Message("Account has been Succesfully Created\n"
                    + "Your Customer ID is: " + Integer.toString(id));            
            
        }
        
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/investorpkg/InvestorLoginPageScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
