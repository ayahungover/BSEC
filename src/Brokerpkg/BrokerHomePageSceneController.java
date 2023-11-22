
package Brokerpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class BrokerHomePageSceneController implements Initializable {

    @FXML
    private MenuItem listOfInvestors;
    @FXML
    private BorderPane BorderPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void listOfInvestorsMenuItemOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvestorListScene.fxml"));
        Parent root = loader.load();
        BorderPane.setCenter(root);
    }
    
}
