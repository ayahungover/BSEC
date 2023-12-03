
package FinancialAdministratorpkg;

import java.io.Serializable;


public class IncomeStatement implements Serializable{
    private String month;
    private double salaryAndWages;
    private double rentAndUtilities;
    private double expenses;
    private double revenue;
    private double cyberSecurity;
    private double softwareCost;
    private double netProfit;
    private double netLoss;

    public IncomeStatement(String month, double salaryAndWages, double rentAndUtilities, double expenses, double revenue, double contentAcquisition, double marketingCost, double netProfit, double netLoss) {
        this.month = month;
        this.salaryAndWages = salaryAndWages;
        this.rentAndUtilities = rentAndUtilities;
        this.expenses = expenses;
        this.revenue = revenue;
        this.cyberSecurity = cyberSecurity;
        this.softwareCost = softwareCost;
        this.netProfit = netProfit;
        this.netLoss = netLoss;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getSalaryAndWages() {
        return salaryAndWages;
    }

    public void setSalaryAndWages(double salaryAndWages) {
        this.salaryAndWages = salaryAndWages;
    }

    public double getRentAndUtilities() {
        return rentAndUtilities;
    }

    public void setRentAndUtilities(double rentAndUtilities) {
        this.rentAndUtilities = rentAndUtilities;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getCyberSecurity() {
        return cyberSecurity;
    }

    public void setCyberSecurity(double cyberSecurity) {
        this.cyberSecurity = cyberSecurity;
    }

    public double getSoftwareCost() {
        return softwareCost;
    }

    public void setSoftwareCost(double softwareCost) {
        this.softwareCost = softwareCost;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getNetLoss() {
        return netLoss;
    }

    public void setNetLoss(double netLoss) {
        this.netLoss = netLoss;
    }
    



    public static double calculateTotalExpenses(double salaryAndWages, double rentAndUtilities, double cyberSecurity, double softwareCost) {
    if (salaryAndWages < 0 || rentAndUtilities < 0 || cyberSecurity < 0 || softwareCost < 0) {
        throw new IllegalArgumentException("Input values must be non-negative");
    }
    return salaryAndWages + rentAndUtilities + cyberSecurity + softwareCost;
    }

    
    public static double calculateNetProfit(double revenue, double expenses) {
    if (revenue < 0 || expenses < 0) {
        throw new IllegalArgumentException("Input values must be non-negative");
    }
    
    double netProfit = 0;
    if (revenue > expenses) {
        netProfit = revenue - expenses;
    }
    return netProfit;
    }

    
    public static double calculateNetLoss(double revenue, double expenses) {
    if (revenue < 0 || expenses < 0) {
        throw new IllegalArgumentException("Input values must be non-negative");
    }

    double netLoss = 0;
    if (expenses > revenue) {
        netLoss = expenses - revenue;
    }
    return netLoss;
    }
    
}


    
    
   

    
    