/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FinancialAdministratorpkg;

import Brokerpkg.Order;
import Brokerpkg.Stockbroker;
import PlatformAdminstratorpkg.PlatformAdminstrator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainpkg.Account;
import mainpkg.PopUp;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SalaryPaymentSceneController implements Initializable {

    @FXML
    private TextField baseSalaryTextField;
    @FXML
    private TextField bonusTextField;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private Label totalLabel;
    @FXML
    private TextField idTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }    

    @FXML
    private void calculateTotalSalaryButtonOnClick(ActionEvent event)throws IOException, ClassNotFoundException {
        double base = Double.parseDouble(baseSalaryTextField.getText());
        double bonus = Double.parseDouble(bonusTextField.getText());
        double total = base + bonus;
        totalLabel.setText(String.valueOf(total));
    }

    

    @FXML
    private void payEmployeeButtonOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        int id = Integer.parseInt(idTextField.getText());
        if (!Account.CheckStockbrokerAccountExistence(id)) {
            PopUp.Message("Employee Doesn't Exist !");
        }
        else {
            Stockbroker b;
            b = Account.getStockbrokerInstance(id);
            String month = monthComboBox.getValue();
            
            double baseSalary = Double.parseDouble(baseSalaryTextField.getText());
            double bonus = Double.parseDouble(bonusTextField.getText());
            double totalSalary = bonus+baseSalary;
            Salary s = new Salary(month, id, baseSalary, bonus);
            FinancialAdministrator.PaySalary(s);
            Salary.updateStockbrokerBalance(b, totalSalary);
            PopUp.Message("Salary has been paid !");
        }
    }
    
}


