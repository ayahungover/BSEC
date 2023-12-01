/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class SECAdministratorHomePageController implements Initializable {

    
    @FXML
    private BorderPane BorderPane;
    
    private SECAdministrator s;
    public void data(SECAdministrator s){
        this.s = s;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void personalInformationbuttonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SECAdministratorPersonalInformation.fxml"));
        Parent root = loader.load();
        SECAdministratorPersonalInformationController ctrl = loader.getController();
        ctrl.data(s);
        BorderPane.setCenter(root);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("SECAdministratorPersonalInformation.fxml"));
//        Parent root = loader.load();
//        BorderPane.setCenter(root);
    }


    @FXML
    private void investorListbuttonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvestorList.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void brokerListbuttonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BrokerList.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void getReportbuttonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutbuttonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) BorderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void rulesAndTipsbuttonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RulesAndTips.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }
    
}
