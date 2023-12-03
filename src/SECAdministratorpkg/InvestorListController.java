/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SECAdministratorpkg;

import investorpkg.Investor;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import mainpkg.AppendableObjectOutputStream;

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
    private void removeButtonONClick(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObservableList <Investor> investorList = FXCollections.observableArrayList();
        
        Investor s1 = tableView.getSelectionModel().getSelectedItem();
        File f = new File("Investor.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Investor temp = null;
        try {
            while(true){
                temp = (Investor) ois.readObject();
                if (temp.getId() != s1.getId()){
                investorList.add(temp);
                }
            }
        } catch (FileNotFoundException ex ) {ex.printStackTrace();}
        catch(EOFException e){}
        catch(IOException ex){ex.printStackTrace();}
               
        finally {
            try {
                ois.close();
            } catch (IOException ex) {}
        }
        
        
        f.delete();
        f = new File("Investor.bin");        
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            for(Investor e: investorList){
                oos.writeObject(e);
            }
            oos.close();
                
        } catch (IOException e) {}
        finally {
            try {
                fis.close();
            } catch (IOException ex) {}
        }
        tableView.setItems(investorList);
    

    }
    
}
