
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
        codeColumn.setCellValueFactory(new PropertyValueFactory<Stock, String>("codeColumn"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Stock, String>("companyColumn"));
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
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        f = new File("Stock.bin");
        if (f.exists()){
            try {
                fos = new FileOutputStream(f,true);
                oos = new ObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddNewStockController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddNewStockController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddNewStockController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddNewStockController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        oos.writeObject(s);
        
        if(!Stock.checkStockExistence(s)){
            PlatformAdminstrator.AddNewStock(s);
            PopUp.Message("Stock Added Succesfully !");
        }
        else {
            PopUp.Message("Stock already exists !");
        }
        
        f = new File("Stock.bin");
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        ObservableList <Stock> stockList = FXCollections.observableArrayList();
        
        Stock s2;
        try {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                while(true){
                    s2 = (Stock) ois.readObject();
                    if (s2.getCompanyName()==companyName){
                        stockList.add(s2);
                        System.out.println();
                    }
                }
            } 
        catch(Exception e){
            e.printStackTrace();
        }
        stockTableView.setItems(stockList);
        
        
    }        
    
    
}
