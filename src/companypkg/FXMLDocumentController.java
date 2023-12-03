/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author AR Smart
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button Overview;
    @FXML
    private Button Fillings;
    @FXML
    private Button Consult;
    @FXML
    private Button Compliance;
    @FXML
    private Button Application;
    @FXML
    private Button stockAnalysis;
    @FXML
    private Button Registration;
    @FXML
    private BorderPane companyBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OverviewOnClick(ActionEvent event) {
    }

    @FXML
    private void FillingsOnClick(ActionEvent event) {
    }

    @FXML
    private void ConsultOnClick(ActionEvent event) {
    }

    @FXML
    private void complianceOnClick(ActionEvent event) {
    }

    @FXML
    private void ApplicationOnClick(ActionEvent event) {
    }

    @FXML
    private void StockAnalysisOnClick(ActionEvent event) {
    }

    @FXML
    private void registrationOnClick(ActionEvent event) {
    }
    
}
