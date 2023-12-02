/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import PlatformAdminstratorpkg.PlatformAdminstrator;
import Stockpkg.Stock;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.PopUp;

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
    
    
    private Investor i;
    public void data(Investor i){
        this.i = i;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("code"));
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<Stock,String>("companyName"));
        oldPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("oldPrice"));
        newPriceColumn.setCellValueFactory(new PropertyValueFactory<Stock,Double>("newPrice"));
        //ObservableList <Stock> stockList = PlatformAdminstrator.getStockList();
        
        ObjectInputStream ois = null;
        ObservableList <Stock> stockList = FXCollections.observableArrayList();
        try {
             Stock i;
             ois = new ObjectInputStream(new FileInputStream("Stock.bin"));
             
            while(true){
                i = (Stock) ois.readObject();
                stockList.add(i);
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

        
        stockTableView.setItems(stockList);

    }
//        stockTableView.getItems().addAll(stockList);
//    }    

    @FXML
    private void placeStockButtonOnClick(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlaceOrderScene.fxml"));
        Parent root = loader.load();
        Stock s = stockTableView.getSelectionModel().getSelectedItem();
        if( s != null){
            PlaceOrderSceneController ctrl = loader.getController();
            ctrl.data(i,s);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
        }
        else{
            PopUp.Message("No stock is selected!");
        }
    }
}
