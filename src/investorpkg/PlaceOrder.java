/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investorpkg;

import java.time.LocalDate;

/**
 *
 * @author md.shahriarnur
 */
public class PlaceOrder {
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
    
    
    
    
}
