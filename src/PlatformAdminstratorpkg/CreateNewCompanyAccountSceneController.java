
package PlatformAdminstratorpkg;

import companypkg.Company;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;


public class CreateNewCompanyAccountSceneController implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contact = contactTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        int id = Account.generateInvestorId();
        double balance = 0;
        if (Account.checkCompanyAccountExistence(email)){
            PopUp.Message("Account Already Exists !");                
        }
        else{
            Company c = new Company(id, name, address, contact, email, password, balance);
            PlatformAdminstrator.createNewCompanyAccount(c);
            PopUp.Message("Account has been Succesfully Created\n"
                    + "Your Company ID is: " + Integer.toString(id));            
            
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/companypkg/CompanyLoginPageScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
