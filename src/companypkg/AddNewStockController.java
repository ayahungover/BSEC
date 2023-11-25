
package companypkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.PopUp;


public class AddNewStockController implements Initializable {

    @FXML
    private TextField codeTextField;
    @FXML
    private TextField companyNameTextField;
    @FXML
    private TextField oldPriceTextField;
    @FXML
    private TextField newPriceTextField;
    @FXML
    private TextField titleTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void addNewStockButtonOnClick(ActionEvent event) {
        
        String title = titleTextField.getText();
        double oldPrice = Double.parseDouble(oldPriceTextField.getText());
        double newPrice = Double.parseDouble(newPriceTextField.getText());
        String code = codeTextField.getText();
        String companyName = companyNameTextField.getText();
        Stock s = new Stock(code, title, companyName, oldPrice, newPrice);
        if(!Stock.checkStockExistence(s)){
            PlatformAdminstrator.AddNewStock(s);
            PopUp.Message("Stock Added Succesfully !");
        }
        else {
            PopUp.Message("Stock already exists !");
        }
    }        
    
    
}
