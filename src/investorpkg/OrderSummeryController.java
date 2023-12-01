/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import Brokerpkg.Stockbroker;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class OrderSummeryController implements Initializable {

    @FXML
    private TableView<PlaceOrder> tableView;
    @FXML
    private TableColumn<PlaceOrder, String> stockCodeColumn;
    @FXML
    private TableColumn<PlaceOrder, String> stockTitleColumn;
    @FXML
    private TableColumn<PlaceOrder, Integer> brokerIdColumn;
    @FXML
    private TableColumn<PlaceOrder, String> priceColumn;
    @FXML
    private TableColumn<PlaceOrder, LocalDate> purcheseDateColumn;

    
    private Investor i;
    public void data(Investor i){
        this.i = i;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stockCodeColumn.setCellValueFactory(new PropertyValueFactory<PlaceOrder, String>("stockCode"));
        stockTitleColumn.setCellValueFactory(new PropertyValueFactory<PlaceOrder, String>("stockTitle"));
        brokerIdColumn.setCellValueFactory(new PropertyValueFactory<PlaceOrder, Integer>("stockBrokerId"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PlaceOrder, String>("stockCode"));
        purcheseDateColumn.setCellValueFactory(new PropertyValueFactory<PlaceOrder, LocalDate>("dop"));
        
        ObjectInputStream ois = null;
        ObservableList <PlaceOrder> placeOrderList = FXCollections.observableArrayList();
        try {
             PlaceOrder p;
             ois = new ObjectInputStream(new FileInputStream("PlaceOrder.bin"));
             
            while(true){
                p = (PlaceOrder) ois.readObject();
                if (i.getId() == p.getInvestorId()){
                    placeOrderList.add(p);
                }
        
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

        
        tableView.setItems(placeOrderList);
    }
        

    
}
