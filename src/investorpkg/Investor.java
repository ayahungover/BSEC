
package investorpkg;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;
import mainpkg.User;


public class Investor extends User implements Serializable {
    private double balance = 0.0;
    
    public Investor(int id,
            String name,
            String address,
            String contact,
            String email,
            LocalDate dob,
            LocalDate doj,
            String password,
            double balance){
        super(id, name, address, contact, email, dob, LocalDate.now(), password);
        this.balance = balance;                
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    public double updateInvestorBalance(Investor i, double amount) throws IOException, ClassNotFoundException{
        
        double newBalance = i.getBalance()+amount;
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
