
package Brokerpkg;

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


public class BrokerHomePageSceneController implements Initializable {
    private Stockbroker b;

    
    public void data(Stockbroker b){
        this.b = b;
    }
    

    @FXML
    private MenuItem listOfInvestors;
    @FXML
    private BorderPane BorderPane;
    @FXML
    private MenuItem salaryAndBalanceMenuItem;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void listOfInvestorsMenuItemOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvestorListScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }

    @FXML
    private void salaryAndBalanceMenuItemOnClick(ActionEvent event) throws IOException {
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Brokerpkg/SalaryAndBalanceScene.fxml"));
            Parent root = loader.load();
            SalaryAndBalanceSceneController ctrl = loader.getController();
            if (b!=null){
                ctrl.data(this.b);
                BorderPane.setCenter(root);   
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
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
    private void buyStocksMenuItemOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyStockScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);   
        BuyStockSceneController ctrl = loader.getController();
        ctrl.data(b);
        BorderPane.setCenter(root);
        System.out.println(b.getBalance());
    }

    @FXML
    private void investorHistoryMenuItemOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvestorHistory.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }
    
}
