
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
    @FXML
    private Button rechargeButton;
    
    private double balance;
    @FXML
    private TextArea balanceTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("brokerSalary.bin");
        DataInputStream dis = null;
        
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(SalaryAndBalanceSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                dis = new DataInputStream(new FileInputStream("Investor.bin"));
                while (true){
                    balance = dis.readDouble();
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SalaryAndBalanceSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SalaryAndBalanceSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        balanceTextArea.setText(Double.toString(balance));
        
    }    

    @FXML
    private void rechargeButtonOnClick(ActionEvent event) {
        try {
            double addableBalance = Double.parseDouble(rechargeTextField.getText());
            balance += addableBalance;
            balanceTextArea.setText("Total balance: " + Double.toString(balance));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("brokerBalance.bin"));
            dos.writeDouble(balance);
        } catch (IOException ex) {
            Logger.getLogger(SalaryAndBalanceSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
