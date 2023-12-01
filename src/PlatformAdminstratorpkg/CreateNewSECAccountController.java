/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package PlatformAdminstratorpkg;

import SECAdministratorpkg.SECAdministrator;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class CreateNewSECAccountController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private DatePicker dobDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createNewAccountButtonOnClick(ActionEvent event) throws IOException {
        int id = Account.generateInvestorId();
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contact = contactTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        LocalDate doj = LocalDate.now();
        Double Salary = 0.0;
        String designation = "SEC Administrator";
        
        double balance = 0;
        if (Account.CheckSECAdministratorAccountExistence(email)){
            PopUp.Message("Account Already Exists !");                
        }
        else{
            SECAdministrator s = new SECAdministrator(id, name, address, contact, email, dob, doj, password, designation, Salary);
            PlatformAdminstrator.createNewSECAccount(s);
            PopUp.Message("Account has been Succesfully Created\n"
                    + "Your SEC Administrator ID is: " + Integer.toString(id)
                    +"Your Password is "+ password);
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/SECAdministratorpkg/SECAdministratorLogInPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
