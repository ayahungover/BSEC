
package companypkg;

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


public class CompanyLoginPageSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private Button loginButton;
    @FXML
    private TextField passwordTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idTextField.getText());
        String password = passwordTextField.getText();
        if(!Account.checkCompanyAccountExistence(id)) {
            PopUp.Message("Account Doesn't Exist !");
            return;
        }
        if(!Account.companyIdPasswordMatch(id, password)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            PopUp.Message("Password didn't Match !");
            return;
        }
        Company c = Account.getCompanyInstance(id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/companypkg/CompanyHomePageScene.fxml"));
        Parent root = loader.load();
        CompanyHomePageSceneController ctrl = loader.getController();
        ctrl.data(c);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PlatformAdminstratorpkg/CreateNewCompanyAccountScene.fxml"));
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
