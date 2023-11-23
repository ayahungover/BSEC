
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import mainpkg.PopUp;


public class InvestorLoginPageSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button backButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idTextField.getText());
        String password = passwordTextField.getText();
        if(!Account.checkInvestorAccountExistence(id)) {
            PopUp.Message("Account Doesn't Exist !");
            return;
        }
        if(!Account.investorIdPasswordMatch(id, password)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            PopUp.Message("Password didn't Match !");
            return;
        }
        Investor i = Account.getInvestorInstance(id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/investorpkg/InvestorHomePageScene.fxml"));
        Parent root = loader.load();
        InvestorHomePageSceneController ctrl = loader.getController();
        ctrl.data(i);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PlatformAdminstratorpkg/CreateNewAccountScene.fxml"));
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
