
package companypkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mainpkg.AppendableObjectOutputStream;
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
    @FXML
    private TableView<Stock> stockTableView;
    @FXML
    private TableColumn<Stock, String> titleColumn;
    @FXML
    private TableColumn<Stock, String> codeColumn;
    @FXML
    private TableColumn<Stock, String> companyColumn;
    @FXML
    private TableColumn<Stock, Double> oldPriceColumn;
    @FXML
    private TableColumn<Stock, Double> newPriceColumn;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<Stock, String>("title"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock, String>("code"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Stock, String>("companyName"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock, Double>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock, Double>("newPrice"));

    }    

    @FXML
    private void addNewStockButtonOnClick(ActionEvent event) throws IOException {
        
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

    @FXML
    private void loadListButtonOnClick(ActionEvent event) {
        ObservableList <Stock> stockList = PlatformAdminstrator.getStockList();
        stockTableView.getItems().addAll(stockList);
    }
    
    
    
    
}
