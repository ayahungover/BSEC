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
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author AR Smart
 */
public class CompanyDashboardController implements Initializable {

    @FXML
    private BorderPane companyDashboardBorderPane;
    SceneSwitching newSceneOpener = new SceneSwitching();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void overviewButton(ActionEvent event) {
        companyDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("Overview.fxml"));
    }

    @FXML
    private void filingsButton(ActionEvent event) {
    }

    @FXML
    private void complianceButton(ActionEvent event) {
    }

    @FXML
    private void consultButton(ActionEvent event) {
    }

    @FXML
    private void applicationButton(ActionEvent event) {
    }

    @FXML
    private void analysisButton(ActionEvent event) {
    }

    @FXML
    private void registrationButton(ActionEvent event) {
    }
    
}
