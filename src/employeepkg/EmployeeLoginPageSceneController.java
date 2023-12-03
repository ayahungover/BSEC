package employeepkg;

import SECAdministratorpkg.SECAdministrator;
import SECAdministratorpkg.SECAdministratorHomePageController;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.Account;
import static mainpkg.Account.SECAdministratorAnyAccountExistance;
import mainpkg.PopUp;

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
        String[] designationList = {"Financial Administrator", "SEC Adminstrator", "Market Analyst", "Investor Liaison", "Platform Adminstrator"};
        designationComboBox.getItems().addAll(designationList);
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = null;

        //int id = Integer.parseInt(employeeIdTextField.getText());
        //String password = employeePasswordTextField.getText();
        if (employeeIdTextField.getText().isEmpty()) {

            if (designationComboBox.getValue().equals("Financial Administrator")) {
                loader = new FXMLLoader(getClass().getResource("/FinancialAdministratorpkg/FinancialAdministratorHomePageScene.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (designationComboBox.getValue().equals("Platform Adminstrator")) {
                loader = new FXMLLoader(getClass().getResource("/Brokerpkg/BrokerHomePageScene.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            if (designationComboBox.getValue().equals("SEC Adminstrator")) {
                int id = Integer.parseInt(employeeIdTextField.getText());
                String password = employeePasswordTextField.getText();
                if (!Account.CheckSECAdministratorAccountExistence(id)) {
                    PopUp.Message("Account Doesn't Exist !");
                    return;
                }
                if (!Account.SECAdministratorIdPasswordMatch(id, password)) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    PopUp.Message("Password didn't Match !");
                    return;
                }
                SECAdministrator s = Account.getSECAdministratorInstance(id);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                loader = new FXMLLoader(getClass().getResource("/SECAdministratorpkg/SECAdministratorHomePage.fxml"));
                Parent root = loader.load();
                SECAdministratorHomePageController ctrl = loader.getController();
                ctrl.data(s);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

    }

    @FXML
    private void employeeSignUp(ActionEvent event) throws IOException {
        if (designationComboBox.getValue().equals("SEC Adminstrator")) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/PlatformAdminstratorpkg/CreateNewSECAccount.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            PopUp.Message("Select a designation 1st");
        }
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
