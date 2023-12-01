
package employeepkg;

import Brokerpkg.BrokerHomePageSceneController;
import Brokerpkg.Stockbroker;
import com.sun.corba.se.pept.broker.Broker;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;


public class EmployeeLoginPageSceneController implements Initializable {

    @FXML
    private TextField employeeIdTextField;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField employeePasswordPasswordField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] designationList = {"Broker","Financial Administrator", "SEC Administrator", "Market Analyst", "Investor Liaison", "Platform Adminstrator"};
        designationComboBox.getItems().addAll(designationList);
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;
        if(employeeIdTextField.getText().isEmpty()){
            if(designationComboBox.getValue().equals("Broker")) {
                loader = new FXMLLoader(getClass().getResource("/Brokerpkg/BrokerHomePageScene.fxml"));
            }
            else if(designationComboBox.getValue().equals("Financial Administrator")) {
                loader = new FXMLLoader(getClass().getResource("/FinancialAdministratorpkg/FinancialAdministratorHomePageScene.fxml"));                   
            }
            else if(designationComboBox.getValue().equals("Platform Adminstrator")){
                loader = new FXMLLoader(getClass().getResource("/PlatformAdminstratorpkg/PlatformAdminstratorHomePageScene.fxml"));                               
            }
        }
        else{
            int id = Integer.parseInt(employeeIdTextField.getText());
            String password = employeePasswordPasswordField.getText();
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

            if (designationComboBox.getValue().equals("Broker")){
                loader = new FXMLLoader(getClass().getResource("/Brokerpkg/BrokerHomepageScene.fxml"));
                Parent root = loader.load();                
                BrokerHomePageSceneController ctrl = loader.getController();
                ctrl.data((Stockbroker) b);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }


        }
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
    
}
