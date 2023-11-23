package Brokerpkg;

import investorpkg.Investor;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

//    private ObservableList<Investor> investorList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Investor, Integer>("id"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("email"));
        dojColumn.setCellValueFactory(new PropertyValueFactory<Investor, LocalDate>("doj"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Investor, String>("contact"));

//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("Investor.bin");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(InvestorListSceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(fis);
//        } catch (IOException ex) {
//            Logger.getLogger(InvestorListSceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            Investor i;
//
//            while (true) {
//                try {
//                    i = (Investor) ois.readObject();
//                    investorList.add(i);
//                } catch (EOFException e) {
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }



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

        
        investorListTableView.setItems(investorList);

    }

}

