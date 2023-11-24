
package FinancialAdministratorpkg;

import Brokerpkg.Broker;
import employeepkg.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SalaryAdjustmentController implements Initializable {

    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private TextField percentageIncrementTextField;
    @FXML
    private Button addNewSalaryButton;
    @FXML
    private Label currentSalaryLabel;
    @FXML
    private Label newSalaryLabel;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] designationList = {"Broker", "Financial Administrator", "SEC Administrator", "Market Analyst", "Investor Liaison", "Platform Adminstrator"};
        designationComboBox.getItems().addAll(designationList);
    }    

    @FXML
    private void addNewSalaryButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void designationComboboxOnClick(ActionEvent event) {
        String desig = designationComboBox.getValue();
        if (desig == "Broker"){
            String current = Double.toString(Broker)
            currentSalaryLabel.setText(Double.toString(Broker.));
        }
    }
    
}
