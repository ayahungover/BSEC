
package PlatformAdminstratorpkg;

import Brokerpkg.Stockbroker;
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


public class CreateNewStockbrokerAccountSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField passwordTextField;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) throws IOException {
        int id = Account.generateInvestorId();
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contact = contactTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        LocalDate doj = LocalDate.now();
        
        double balance = 0;
        if (Account.checkCompanyAccountExistence(email)){
            PopUp.Message("Account Already Exists !");                
        }
        else{
            Stockbroker b = new Stockbroker(id, name, address, contact, email, dob, doj,  password, balance);
            PlatformAdminstrator.createNewStockbrokerAccount(b);
            PopUp.Message("Account has been Succesfully Created\n"
                    + "Your Stockbroker ID is: " + Integer.toString(id));
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Brokerpkg/StockbrokerLoginPageScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
    
