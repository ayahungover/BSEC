
package Brokerpkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import investorpkg.Investor;
import investorpkg.PlaceOrder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.PopUp;


public class BuyStockSceneController implements Initializable {

    @FXML
    private TableColumn<Stock, String> codeColumn;
    @FXML
    private TableColumn<Stock, String> companyNameColumn;
    @FXML
    private TableColumn<Stock, String> titleColumn;
    @FXML
    private TableColumn<Stock, Double> oldPriceColumn;
    @FXML
    private TableColumn<Stock, Double> newPriceColumn;
    @FXML
    private TableView<Stock> tableView;
    
    
    private Stockbroker b;
    @FXML
    private TextArea placedOrdersTextArea;
    @FXML
    private TextField investorIdTextField;
    @FXML
    private TableColumn<Investor, String> investorName;
    @FXML
    private TableColumn<Investor, Integer> idCol;
    @FXML
    private TableColumn<Investor, String> contactCol;
    @FXML
    private TableView<Investor> investorTableView;

    public void data (Stockbroker b){
        this.b = b;
    }
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("code"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("companyName"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("title"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("newPrice"));
        ObservableList <Stock> stockList = PlatformAdminstrator.getStockList();
        tableView.getItems().addAll(stockList);    

    }    

    @FXML
    private void buyStockButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GenerateAndPayBill.fxml"));
        Parent root = loader.load();
        Stock s = tableView.getSelectionModel().getSelectedItem();
        if( s != null){
            GenerateAndPayBillController ctrl = loader.getController();
            ctrl.data(b, s);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
        }
        else{
            PopUp.Message("No stock is selected!");
        }
        
    }

    @FXML
    private void showPlacedOrdersButtonOnClick(ActionEvent event) {
        int investorId = Integer.parseInt(investorIdTextField.getText());
        int stockbrokerId = this.b.getId();
        placedOrdersTextArea.setText(Order.getInvestorOrders(investorId, stockbrokerId));
    }

    @FXML
    private void loadInvestorListButtonOnClick(ActionEvent event) {
        investorName.setCellValueFactory(new PropertyValueFactory<Investor, String>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("id"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Investor, String>("contact"));
        

        ObjectInputStream ois = null;
        ObservableList <Investor> investorList = FXCollections.observableArrayList();
        try {
             Investor i;
             ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
             
            while(true){
                i = (Investor) ois.readObject();
                investorList.add(i);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }

        
        investorTableView.setItems(investorList);
    }
    
}
