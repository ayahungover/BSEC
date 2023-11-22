
package Brokerpkg;

import investorpkg.Investor;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class InvestorListSceneController implements Initializable {
    @FXML
    private TableView<Investor> investorListTableView;
    @FXML
    private TableColumn<Investor, String> nameColumn;
    @FXML
    private TableColumn<Investor, Integer> idColumn;
    @FXML
    private TableColumn<Investor, String> emailColumn;
    @FXML
    private TableColumn<Investor, LocalDate> dojColumn;
    @FXML
    private TableColumn<Investor, String> contactColumn;

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("id"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("email"));   
        dojColumn.setCellValueFactory(new PropertyValueFactory<Investor, LocalDate>("doj"));        
        contactColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("contact"));
      
    }    
    
}
