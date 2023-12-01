
package Brokerpkg;

import investorpkg.Investor;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mainpkg.Account;


public class InvestorHistoryController implements Initializable {

    @FXML
    private TextField investorIdTextField;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> interactionComboBox;
    @FXML
    private TextArea addedTextArea;
    @FXML
    private TextArea viewTextArea;
    @FXML
    private TextField searchIdTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        interactionComboBox.getItems().addAll("Stocks Bought", "Stocks Sold");
        
    }    

    @FXML
    private void addClientHistoryButtonOnClick(ActionEvent event) throws ClassNotFoundException {
        int id = Integer.parseInt(investorIdTextField.getText());
        LocalDate lastInteraction = dateDatePicker.getValue();
        String interaction = interactionComboBox.getValue();
        
        if(Account.CheckInvestorAccountExistence(id)){
            Investor i = Account.getInvestorInstance(id);
            Stockbroker.AddInvestorHistory(id, i.getName(),lastInteraction, interaction);
            
        addedTextArea.setText("Investor History \n");
        addedTextArea.appendText("Investor ID: "+ id +"\n");
        addedTextArea.appendText("Investor Name: "+ i.getName() +"\n");
        addedTextArea.appendText("Investor Address: "+ i.getAddress() +"\n"+"\n");
        
        addedTextArea.appendText("Last Interaction Date: "+ lastInteraction.toString() +"\n");
        addedTextArea.appendText("Type of Interaction : "+ interaction +"\n");

            
        }
        else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Account Doesn't Exists !");
            a.showAndWait();
        }
    }

    @FXML
    private void viewHistoryButtonOnClick(ActionEvent event) {
        viewTextArea.clear();
        int id = Integer.parseInt(searchIdTextField.getText());
        if(Account.CheckInvestorAccountExistence(id)){
            String data = Stockbroker.LookupInvestorHistory(id);
            viewTextArea.appendText(data);
        }
    }
    
}
