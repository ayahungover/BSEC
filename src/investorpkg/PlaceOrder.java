/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investorpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;

/**
 *
 * @author md.shahriarnur
 */
public class PlaceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private int stockBrokerId;
    private int investorId;
    private String stockCode;
    private String stockTitle;
    private double price;
    private LocalDate dop = LocalDate.now();

    public PlaceOrder(int stockBrokerId, int investorId, String stockCode, String stockTitle, double price) {

        this.stockBrokerId = stockBrokerId;
        this.investorId = investorId;
        this.stockCode = stockCode;
        this.stockTitle = stockTitle;
        this.price = price;

    }

    public LocalDate getDop() {
        return dop;
    }

    public void setDop(LocalDate dop) {
        this.dop = dop;
    }

    public int getStockBrokerId() {
        return stockBrokerId;
    }

    public void setStockBrokerId(int stockBrokerId) {
        this.stockBrokerId = stockBrokerId;
    }

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\ninvestorId: " 
                + investorId + "\nstockCode: " 
                + stockCode + "\nstockTitle: " 
                + stockTitle + "\nprice: " 
                + price + "\nDate of Order: " + dop ;
    }

    public void placeOrder(PlaceOrder p) {
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File f = new File("PlaceOrder.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(p);

        } catch (IOException ex) {

            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
