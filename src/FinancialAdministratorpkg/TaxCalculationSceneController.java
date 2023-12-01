/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FinancialAdministratorpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.PDFGenerator;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TaxCalculationSceneController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField incomeTextField;
    @FXML
    private TextField deductionsTextField;
    @FXML
    private TextField percentageOfTaxTextField;
    @FXML
    private Label taxableIncomeLabel;
    @FXML
    private Label totalTaxLabel;
    @FXML
    private TableView<TaxData> taxDataTableView;
    @FXML
    private TableColumn<TaxData, String> monthColumn;
    @FXML
    private TableColumn<TaxData, Double> incomeColumn;
    @FXML
    private TableColumn<TaxData, Double> deductionColumn;
    @FXML
    private TableColumn<TaxData, Double> taxPercentageColumn;
    @FXML
    private TableColumn<TaxData, Double> taxableIncomeColumn;
    @FXML
    private TableColumn<TaxData, Double> totalTaxColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");

        monthColumn.setCellValueFactory(new PropertyValueFactory<TaxData, String>("month"));
        incomeColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("income"));
        deductionColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("deduction"));
        taxPercentageColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("taxPercentage"));
        taxableIncomeColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("taxableIncome"));
        totalTaxColumn.setCellValueFactory(new PropertyValueFactory<TaxData, Double>("totalTax"));
    }    

    @FXML
    private void calculateTaxableIncomeButtonOnClick(ActionEvent event) {
        double income = Double.parseDouble(incomeTextField.getText());
        double deduction = Double.parseDouble(deductionsTextField.getText());
        double taxableIncome = TaxData.calculateTaxableIncome(income, deduction);

        taxableIncomeLabel.setText(Double.toString(taxableIncome));
    }

    @FXML
    private void calculateTotalTaxButtonOnClick(ActionEvent event) {
        double taxPercentage = Double.parseDouble(percentageOfTaxTextField.getText());
        double taxableIncome = Double.parseDouble(taxableIncomeLabel.getText());
        double totalTax = TaxData.calculateTax(taxableIncome, taxPercentage);

        totalTaxLabel.setText(String.valueOf(totalTax));
    }

    @FXML
    private void addDataButtonOnClick(ActionEvent event) {
        String month = monthComboBox.getValue();
        double income = Double.parseDouble(incomeTextField.getText());
        double deduction = Double.parseDouble(deductionsTextField.getText());
        double taxPercentage = Double.parseDouble(percentageOfTaxTextField.getText());
        double taxableIncome = TaxData.calculateTaxableIncome(income, deduction);
        double totalTax = TaxData.calculateTax(taxableIncome, taxPercentage);

        FinancialAdministrator.addTaxData(month, income, deduction, taxPercentage, taxableIncome, totalTax);
    }

    @FXML
    private void viewDataButtonOnClick(ActionEvent event) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("TaxData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            TaxData F;
            try{
                while(true){
                    F = (TaxData)ois.readObject();
                    taxDataTableView.getItems().add(F);
                }
            }
            catch(Exception e){
                
            }              
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
    }

    @FXML
    private void downloadTaxReportButtonOnClick(ActionEvent event) {
        TaxData b = taxDataTableView.getSelectionModel().getSelectedItem();
        PDFGenerator.generatePdf(b.toString());
    }
    
}
