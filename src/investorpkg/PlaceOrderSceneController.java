/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import Brokerpkg.Stockbroker;
import Stockpkg.Stock;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.AppendableObjectOutputStream;
import mainpkg.PopUp;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class PlaceOrderSceneController implements Initializable {

    @FXML
    private TextArea oderDetailsTextArea;

    private Investor i;
    private Stock s;
    private String bill = null;
    @FXML
    private TableColumn<Stockbroker, Integer> idTableColumn;
    @FXML
    private TableColumn<Stockbroker, String> nameTableColumn;
    @FXML
    private TableColumn<Stockbroker, LocalDate> dojTableColumn;
    @FXML
    private TableColumn<Stockbroker, String> emailTableView;
    @FXML
    private TableColumn<Stockbroker, String> contactTableView;
    @FXML
    private TableView<Stockbroker> tableView;
    public void data(Investor i, Stock s){
            this.i = i;
            this.s = s;

            
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       nameTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("name"));
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, Integer>("id"));
        emailTableView.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("email"));
        dojTableColumn.setCellValueFactory(new PropertyValueFactory<Stockbroker, LocalDate>("doj"));
        contactTableView.setCellValueFactory(new PropertyValueFactory<Stockbroker, String>("contact"));
        
        
        
        ObjectInputStream ois = null;
        ObservableList <Stockbroker> stockbrokerList = FXCollections.observableArrayList();
        try {
             Stockbroker ss;
             ois = new ObjectInputStream(new FileInputStream("brokerSalary.bin"));
             
            while(true){
                ss = (Stockbroker) ois.readObject();
                stockbrokerList.add(ss);
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
    private void placeOrderButtonOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Stockbroker s1 = tableView.getSelectionModel().getSelectedItem();
        if (s1 == null){
            PopUp.Message("Select A Broker First");
        }
        else{
            PlaceOrder p = new PlaceOrder(s1.getId(),i.getId(),s.getCode(),s.getTitle(),s.getNewPrice());
            Double newBalance = updateInvestorBalance(i);
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("PlaceOrder.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(p);

            } catch (IOException ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        
        bill =
             "Investor ID: " + i.getId() +
             "\nInvestor Name: " + i.getName() +
             "\nInvestor Contact Number: " + i.getContact() +
             "\nInvestor Email: " + i.getEmail() +
             "\nStock Code: " + s.getCode() +
             "\nStock Title: " + s.getTitle() + 
             "\nStock Price: " + s.getNewPrice() + " BDT" +
             "\nStock Purchase Date:\t\t" + LocalDate.now()+
             "\n\nYour Current Balance is"+i.getBalance();
        PopUp.Message("Your order placed successfully");
        oderDetailsTextArea.setText(bill);
        }
        
        
    
    }
    
    
    
    
    
    public double updateInvestorBalance(Investor i) throws IOException, ClassNotFoundException{
        
        double newBalance = i.getBalance() - s.getNewPrice();
        ObservableList <Investor> investorList = FXCollections.observableArrayList();
        

        File f = new File("investor.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Investor temp = null;
        try {
            while(true){
                temp = (Investor) ois.readObject();
                investorList.add(temp);
            }
        } catch (FileNotFoundException ex ) {ex.printStackTrace();}
        catch(EOFException e){}
        catch(IOException ex){ex.printStackTrace();}
               
        finally {
            try {
                ois.close();
            } catch (IOException ex) {}
        }
        
        
        for(Investor e: investorList){
            if (e.getId() == i.getId()){
                e.setBalance(newBalance);
                break;
            }
        }
        
        
        f.delete();
        f = new File("investor.bin");        
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
        return newBalance;
             
    }   
}
