/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import Brokerpkg.Stockbroker;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class BrokerListController implements Initializable {

    @FXML
    private TableView<Stockbroker> tableView;
    @FXML
    private TableColumn<Stockbroker, String> nameColumn;
    @FXML
    private TableColumn<Stockbroker, Integer> idColumn;
    @FXML
    private TableColumn<Stockbroker, String> contactColumn;
    @FXML
    private TableColumn<Stockbroker, String> emailColumn;
    @FXML
    private TableColumn<Stockbroker, LocalDate> joiningDateColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, Integer>("id"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("email"));
        joiningDateColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, LocalDate>("doj"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("contact"));
        
        
        
        ObjectInputStream ois = null;
        ObservableList <Stockbroker> stockbrokerList = FXCollections.observableArrayList();
        try {
             Stockbroker s;
             ois = new ObjectInputStream(new FileInputStream("brokerSalary.bin"));
             
            while(true){
                s = (Stockbroker) ois.readObject();
                stockbrokerList.add(s);
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

        
        tableView.setItems(stockbrokerList);
    }

    @FXML
    private void removeButtonOnClick(ActionEvent event) {
    }
    
}
