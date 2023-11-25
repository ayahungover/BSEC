
package Brokerpkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


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
    private Button buyStockButtonOnClick;
    @FXML
    private TableView<Stock> tableView;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("code"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("companyName"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("title"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("oldPriceColumn"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("newPriceColumn"));
        ObservableList <Stock> list = PlatformAdminstrator.getStockList();
        tableView.getItems().addAll(list);        
        
    }    
    
}
