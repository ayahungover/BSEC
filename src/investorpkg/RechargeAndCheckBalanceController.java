/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package investorpkg;

import Stockpkg.Stock;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainpkg.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author md.shahriarnur
 */
public class RechargeAndCheckBalanceController implements Initializable {

    @FXML
    private Label currentBalanceLabel;
    @FXML
    private TextField enterAmountTextArea;
//Double.parseDouble(enterAmountTextArea.getText())

    private Investor i;
    public void data(Investor i){
        this.i = i;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private void rechargeAccountButtonOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Double s = Double.parseDouble(enterAmountTextArea.getText());
        i.setBalance(i.getBalance()+s);
        Double newBalance = updateInvestorBalance(i);
        //Double newBalance = i.getBalance();
        currentBalanceLabel.setText("Your Current Balance is "+i.getBalance()+"TK");
    }

    @FXML
    private void checkBalanceButtonOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        double newSalary = 0;
        File f = new File("investor.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Investor temp = null;
        try {
            while(true){
                temp = (Investor) ois.readObject();
                if (temp.getId() == i.getId()){
                    newSalary = i.getBalance();
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
        currentBalanceLabel.setText("Your Current Balance is "+newSalary+"TK");
        
    }
    
    public double updateInvestorBalance(Investor i) throws IOException, ClassNotFoundException{
        
        double newBalance = i.getBalance();
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
