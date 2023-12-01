/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class SECAdministratorPersonalInformationController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label dateOfJoiningLabel;
    @FXML
    private Label idLabel;

    private SECAdministrator s;
    public void data(SECAdministrator s){
        this.s = s;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        idLabel.setText(Integer.toString(s.getId()));
        nameLabel.setText(s.getName());
        contactLabel.setText(s.getContact());
        addressLabel.setText(s.getAddress());
        emailLabel.setText(s.getEmail());
        dateOfBirthLabel.setText(s.getDob().format(DateTimeFormatter.ISO_DATE));
        dateOfJoiningLabel.setText(s.getDoj().format(DateTimeFormatter.ISO_DATE));
        
    }
    
}
