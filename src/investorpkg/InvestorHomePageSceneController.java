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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.Account;


public class InvestorHomePageSceneController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    private Investor i;
    @FXML
    private Label nameTF;
    public void data(Investor i){
        this.i = i;
    }
    public void s(){
        System.out.println(i.getAddress());      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void personalInformationButtonOnClick(ActionEvent event) throws IOException {
//Problem
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountOverView.fxml"));
        Parent root = loader.load();
        AccountOverViewController ctrl = loader.getController();
        ctrl.data(i);
        BorderPane.setCenter(root);
        
        
        //nameTF.setText(i.getName());
//       Parent parent = FXMLLoader.load(getClass().getResource("AccountOverView.fxml"));
//       BorderPane.setCenter(parent);


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
    private void contactUsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AskQuestion.fxml"));
        BorderPane.setCenter(parent);
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
    private void stockListButtonOnClick(ActionEvent event) {
    }
    
    
}
