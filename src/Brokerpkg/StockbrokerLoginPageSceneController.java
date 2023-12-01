/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Brokerpkg;

import investorpkg.Investor;
import investorpkg.InvestorHomePageSceneController;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;


public class StockbrokerLoginPageSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField passwordTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idTextField.getText());
        String password = passwordTextField.getText();
        if(!Account.checkStockbrokerAccountExistence(id)) {
            PopUp.Message("Account Doesn't Exist !");
            return;
        }
        if(!Account.stockbrokerIdPasswordMatch(id, password)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            PopUp.Message("Password didn't Match !");
            return;
        }
        Stockbroker b = Account.getStockbrokerInstance(id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Brokerpkg/BrokerHomePageScene.fxml"));
        Parent root = loader.load();
        BrokerHomePageSceneController ctrl = loader.getController();
        ctrl.data(b);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PlatformAdminstratorpkg/CreateNewStockbrokerAccountScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
