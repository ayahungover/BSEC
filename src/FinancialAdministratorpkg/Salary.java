
package FinancialAdministratorpkg;

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
import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;


public class Salary implements Serializable {
    private String month;
    private int employeeId;
    private double baseSalary;
    private double bonus;
    private double totalPay;

    public Salary(String month, int employeeId, double baseSalary, double bonus) {
        this.month = month;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.totalPay = baseSalary + bonus;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    
    public static void updateStockbrokerBalance(Stockbroker b, double dbl) throws IOException, ClassNotFoundException{
        
        double newBalance = b.getBalance() + (dbl);
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

    
}
