
package Brokerpkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


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
        GenerateAndPayBillController ctrl = loader.getController();
        ctrl.data(b, s);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
