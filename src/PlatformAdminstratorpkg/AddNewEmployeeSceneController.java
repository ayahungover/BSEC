
package PlatformAdminstratorpkg;

import employeepkg.Employee;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mainpkg.Account;
import mainpkg.PopUp;


public class AddNewEmployeeSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private Button addNewEmployeeButton;
    @FXML
    private DatePicker dobDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] designationList = {"Broker", "Financial Administrator", "SEC Administrator", "Market Analyst", "Investor Liaison", "Platform Adminstrator"};
        designationComboBox.getItems().addAll(designationList);        
    }    

    @FXML
    private void addNewEmployeeButtonOnClick(ActionEvent event) {
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String contactNumber = contactNumberTextField.getText();
        String email = emailTextField.getText();
        LocalDate DOB = dobDatePicker.getValue();
        String designation = designationComboBox.getValue();
        if(Account.CheckEmployeeAccountExistence(email) == true) {
            PopUp.Message("Account Already Exists !");
            return;
        }
        int id = Account.GenerateEmployeeID();
        String password = Account.GenerateEmployeePassword();
        LocalDate DOJ = LocalDate.now();
        double salary = 0;
        Employee e = new Employee(id, name, address, contactNumber, email, DOB, DOJ, password, designation, salary);
        PlatformAdminstrator.EmployeeCreateNewAccount(e);
        
        PopUp.Message("Account has been Successfully Created\n"
                + "Employee ID: " + id +"\n"
                + "Employee Password: " + password);
    }
    
}
