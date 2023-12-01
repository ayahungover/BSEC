/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import static mainpkg.Account.SECAdministratorAnyAccountExistance;
import mainpkg.PopUp;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class SECAdministratorLogInPageController implements Initializable {

    @FXML
    private TextField SECIdTextField;
    @FXML
    private TextField SECPasswordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sECLoginButtonOnClick(ActionEvent event) throws IOException {
        int id = Integer.parseInt(SECIdTextField.getText());
        String password = SECPasswordTextField.getText();
        if(!Account.CheckSECAdministratorAccountExistence(id)) {
            PopUp.Message("Account Doesn't Exist !");
            return;
        }
        if(Account.SECAdministratorIdPasswordMatch(id, password)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            PopUp.Message("Password didn't Match !");
            return;
        }
        SECAdministrator s = Account.getSECAdministratorInstance(id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SECAdministratorpkg/SECAdministratorHomePage.fxml"));
        Parent root = loader.load();
        SECAdministratorHomePageController ctrl = loader.getController();
        ctrl.data(s);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sECBackButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/mainpkg/SelectUserScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sECSignUpButtonClick(ActionEvent event) throws IOException {
        if (!SECAdministratorAnyAccountExistance()){
            PopUp.Message("An account alreay Exist");
        }else{
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/PlatformAdminstratorpkg/CreateNewSECAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }
    
//    public static boolean SECAdministratorAnyAccountExistance() {
//        ObjectInputStream ois = null;
//        boolean result = false;
//        try {
//             SECAdministrator s;
//             ois = new ObjectInputStream(new FileInputStream("SECAdministratorId.bin"));
//             
//            while(true){
//                s = (SECAdministrator) ois.readObject();
//                if(s == null) {   
//                    result = true; 
//                }
//            }
//        }
//        catch(RuntimeException e){
//            e.printStackTrace();
//        }
//        catch (Exception ex) {
//            try {
//                if(ois!=null)
//                    ois.close();
//            } catch (IOException ex1) {  }           
//        }
//        return result;
//    }


}
