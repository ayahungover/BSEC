/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Scarecrow
 */
public class ConsultController implements Initializable {

    
    @FXML
    private RadioButton PotentialInvestors;
    @FXML
    private ToggleGroup Shareholders;
    @FXML
    private RadioButton Shareholders;
    @FXML
    private ToggleGroup PotentialInvestors;
    @FXML
    private Button Show;
    @FXML
    private Label Consult;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
