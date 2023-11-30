
package Brokerpkg;

import Stockpkg.Stock;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import mainpkg.PDFGenerator;
import mainpkg.PopUp;


public class GenerateAndPayBillController implements Initializable {
    
    
    @FXML
    private TextArea billTextArea;
    private String bill = null; 
    private Stockbroker b;
    private Stock s;
    

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
        billTextArea.setText(bill);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void downloadBillButtonOnClick(ActionEvent event) {
        PDFGenerator.generatePdf(bill);
        PopUp.Message("Bill Has been dowloaded\n");
    }

    @FXML
    private void payBillButtonOnClick(ActionEvent event) {
        int transactionId = Order.GenerateTransactionId();
        Order o = new Order(b, s, bill, transactionId);
        Order.insertBill(o);
        b.setBalance(b.getBalance() + (s.getNewPrice() * 0.1));
        PopUp.Message("Transaction has been Completed !\n"
                + "Transaction ID: " + Integer.toString(transactionId) +
                "\nyour current balance: " + b.getBalance() +"BDT");
    }
    
}
