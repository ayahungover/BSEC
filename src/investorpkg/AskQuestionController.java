/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class AskQuestionController implements Initializable {

    @FXML
    private TextArea askQuestionOrReportTextArea;
    @FXML
    private ComboBox<String> askToComboBox;
    @FXML
    private TextArea viewAnswerTextArea;
    @FXML
    private ComboBox<Integer> selectQuestionComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String[] internalUser = {"Strock Broker" , "Platform Administrator" , "SEC Administrator" , "Financial Auditor"};
       askToComboBox.getItems().addAll(internalUser);
    }    

    @FXML
    private void submitQuestionButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadAnswerButtonOnClick(ActionEvent event) {
    }
    
}
