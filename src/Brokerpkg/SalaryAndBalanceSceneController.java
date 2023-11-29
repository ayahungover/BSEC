
package Brokerpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SalaryAndBalanceSceneController implements Initializable {


    @FXML
    private TextField rechargeTextField;
    
    private double balance;

    private Stockbroker b;
    @FXML
    private TextArea balanceTextArea;
    
    
    public void data(Stockbroker b){
        this.b = b;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (b!=null){
            System.out.println("balance= "+b.getBalance());
            balanceTextArea.setText("Your current balance is: "+ b.getBalance());
        }
        else{
            System.out.println("b is null");
        }
   
    }    

    @FXML
    private void rechargeButtonOnClick(ActionEvent event) {
        double newBalance = Double.parseDouble(rechargeTextField.getText()) + b.getBalance();
        b.setBalance(newBalance);
        balanceTextArea.setText("your current balance is: "+ newBalance);
    }
    
}
