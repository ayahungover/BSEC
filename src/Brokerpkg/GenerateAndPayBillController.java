
package Brokerpkg;

import Stockpkg.Stock;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class GenerateAndPayBillController implements Initializable {
    
    private Stockbroker b;
    private Stock s;
    @FXML
    private TextArea billTextArea;
    private String bill = null; 
    
    public void data(Stockbroker b, Stock s){
        this.b = b;
        this.s = s;
        bill =
                "Stockbroker ID: " + b.getId() +
                "\nStockbroker Name: " + b.getName() +
                "\nStockbroker Address: " + b.getAddress() +
                "\nStockbroker Contact Number: " + b.getContact() +
                "\nStockbroker Email: " + b.getEmail() +
                "\nStock Code: " + s.getCode() +
                "\nStock Title: " + s.getTitle() + 
                "\nStock Old Price: " + s.getOldPrice() + " BDT" +
                "\nStock New Price: " + s.getNewPrice() + " BDT" +
                "\nStock Purchase Date:\t\t" + LocalDate.now();
    }

    public GenerateAndPayBillController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void downloadBillButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void payBillButtonOnClick(ActionEvent event) {
    }
    
}
