/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

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
public class InvestorHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    private Investor i;
    public void data(Investor i){
        this.i = i;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void personalInformationButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void sellStocksButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void buyStocksButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void orderSummeryButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewMarketButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void bankButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void contactUsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) BorderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
    }
    
}
