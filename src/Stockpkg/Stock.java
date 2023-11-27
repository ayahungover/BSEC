
package Stockpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Stock implements Serializable {
    public final String code;
    public String title;
    public String companyName;
    public double oldPrice;
    public double newPrice;

    public Stock(String code, String title, String companyName, double oldPrice, double newPrice) {
        this.code = code;
        this.companyName = companyName;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    public static boolean checkStockExistence(Stock x) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            Stock s;
            ois = new ObjectInputStream(new FileInputStream("Stock.bin"));
             
            while(true){
                s = (Stock) ois.readObject();
                if(s.getCode().equals(x.getCode()) || s.getTitle().equals(x.getTitle())) {
                    result = true;
                }
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
        return result;
    }

    
}
