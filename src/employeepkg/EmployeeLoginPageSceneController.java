
package employeepkg;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EmployeeLoginPageSceneController implements Initializable {

    @FXML
    private TextField employeeIdTextField;
    @FXML
    private TextField employeePasswordTextField;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private Button loginButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] designationList = {"Broker", "Financial Auditor", "SEC Adminstrator", "Market Analyst", "Investor Liaison", "Platform Adminstrator"};
        designationComboBox.getItems().addAll(designationList);
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        if(designationComboBox.getValue().equals("Broker")) {
            loader = new FXMLLoader(getClass().getResource("/Brokerpkg/BrokerHomePageScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                    
            
        }
    }
    
}
