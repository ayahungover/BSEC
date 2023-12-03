/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Scarecrow
 */
public class FillingsController implements Initializable {

    @FXML
    private ComboBox<String> filingsCombo;
    @FXML
    private TextArea filingsDocument;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        filingsCombo.getItems().addAll("Annual Reports","Quarterly Reports","Current Reports","Proxy Statements", "registration statements", "insider transactions","foreign filings");
    }    
    
}
