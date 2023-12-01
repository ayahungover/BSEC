/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import investorpkg.Investor;
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
public class InvestorListController implements Initializable {

    @FXML
    private TableView<Investor> tableView;
    @FXML
    private TableColumn<Investor, String> nameColumn;
    @FXML
    private TableColumn<Investor, Integer> idColumn;
    @FXML
    private TableColumn<Investor, String> contactColumn;
    @FXML
    private TableColumn<Investor, String> emailColumn;
    @FXML
    private TableColumn<Investor, LocalDate> joningDateColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("id"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("email"));
        joningDateColumn.setCellValueFactory(new PropertyValueFactory<Investor, LocalDate>("doj"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("contact"));
        
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

        
        tableView.setItems(investorList);       
        
        


    }    

    @FXML
    private void removeButtonONClick(ActionEvent event) {

    }
    
}
