
package FinancialAdministratorpkg;

import Stockpkg.Stock;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public interface FinancialAdministrator {
        public static ObservableList <Stock> getStockList() {
        ObservableList <Stock> list = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Stock s;
             ois = new ObjectInputStream(new FileInputStream("Stock.bin"));
             
            while(true){
                s = (Stock) ois.readObject();
                list.add(s);
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
        return list;
    }

}
