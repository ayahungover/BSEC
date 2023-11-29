
package Brokerpkg;

import Stockpkg.Stock;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;


public class Order implements Serializable {
    private int stockbrokerId;
    private String stockCode;
    private String stockTitle;
    private LocalDate purchaseDate;
    private double newPrice;
    private String bill;
    private int transactionId;

    public Order(Stockbroker b, Stock s, String Bill, int transactionId) {
        this.stockbrokerId = b.getId();
        this.stockCode = s.getCode();
        this.stockTitle = s.getTitle();
        this.purchaseDate = LocalDate.now();
        this.newPrice = s.getNewPrice();
        this.bill = bill;
        this.transactionId = transactionId;
    }

    public int getStockbrokerId() {
        return stockbrokerId;
    }

    public void setStockbrokerId(int stockbrokerId) {
        this.stockbrokerId = stockbrokerId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockTitle() {
        return stockTitle;
    }

    public void setStockTitle(String stockTitle) {
        this.stockTitle = stockTitle;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    
    public static void updateStockbrokerBalance(Stockbroker b, Stock s) throws IOException, ClassNotFoundException{
        
        double newBalance = b.getBalance() + (0.1 * s.getNewPrice());
        ObservableList <Stockbroker> stockbrokerList = FXCollections.observableArrayList();
        

        File f = new File("Stockbroker.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Stockbroker temp = null;
        try {
            while(true){
                temp = (Stockbroker) ois.readObject();
                stockbrokerList.add(temp);
            }
        } catch (FileNotFoundException ex ) {ex.printStackTrace();}
        catch(EOFException e){}
        catch(IOException ex){ex.printStackTrace();}
               
        finally {
            try {
                ois.close();
            } catch (IOException ex) {}
        }
        
        
        for(Stockbroker e: stockbrokerList){
            if (e.getId() == b.getId()){
                e.setBalance(newBalance);
                break;
            }
        }
        
        
        f.delete();
        f = new File("Stockbroker.bin");        
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
            for(Stockbroker e: stockbrokerList){
                oos.writeObject(e);
            }
            oos.close();
                
        } catch (IOException e) {}
        finally {
            try {
                fis.close();
            } catch (IOException ex) {}
        }
        
        
        
    }
    
    public static int GenerateTransactionId () {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> transactionIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
            Order o;
             ois = new ObjectInputStream(new FileInputStream("Order.bin"));
             
            while(true){
                o = (Order) ois.readObject();
                transactionIds.add(o.transactionId);
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
        Random random = new Random();
        int transactionId;
        do {
            transactionId = ID_LOWER_BOUND + random.nextInt(ID_UPPER_BOUND - ID_LOWER_BOUND);
        } while (transactionIds.contains(transactionId));
        return transactionId;
    }
    
    
    public static void insertBill(Order o) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Order.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(o);

        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

