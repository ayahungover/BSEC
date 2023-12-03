/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class ApplicationController implements Initializable {
    private ComboBox<String> Application;
    @FXML
    private RadioButton IssuerNo;
    @FXML
    private ToggleGroup IssuerComYes;
    @FXML
    private RadioButton IssuerYes;
    @FXML
    private ToggleGroup IssuerComNo;
    @FXML
    private Button Submit;
    @FXML
    private Label myLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Stock Trade","Other Corporate Action");
        Application.setItems(list);
    }    

    @FXML
    private void IssuerCom(ActionEvent event) {
    }

    @FXML
    private void SubmitOnClick(ActionEvent event) {
    }
    

public class Controller {

 @FXML
 private Label myLabel;
 @FXML
 private RadioButton IssuerYes, IssuerNo;
 
 public void IssuerCom(ActionEvent event) {
  
  if(IssuerYes.isSelected()) {
   myLabel.setText(IssuerYes.getText());
  }
  else if(IssuerNo.isSelected()) {
   myLabel.setText(IssuerNo.getText());
  }

 }
}
    
}
