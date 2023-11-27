/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class StockListController implements Initializable {

    @FXML
    private TableView<Stock> stockTableView;
    @FXML
    private TableColumn<Stock, String> codeColumn;
    @FXML
    private TableColumn<Stock, String> companyNameColumn;
    @FXML
    private TableColumn<Stock, Double> oldPriceColumn;
    @FXML
    private TableColumn<Stock, Double> newPriceColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("code"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("companyName"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("newPrice"));
        ObservableList <Stock> stockList = PlatformAdminstrator.getStockList();
        stockTableView.getItems().addAll(stockList);
    }    
}
