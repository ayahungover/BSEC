/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FinancialAdministratorpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinancialAdministratorHomePageSceneController implements Initializable {

    @FXML
    private MenuItem seeEmployeeSalaryMenuItem;
    @FXML
    private BorderPane BorderPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void seeEmployeeSalaryMenuItemOnClick(ActionEvent event) {

    }

    @FXML
    private void logoutMenuItemOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) BorderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void salaryPaymentButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("SalaryPaymentScene.fxml"));
       Parent root = loader.load();
       BorderPane.setCenter(root);

    }
    
}
