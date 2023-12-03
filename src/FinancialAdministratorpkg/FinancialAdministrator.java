package FinancialAdministratorpkg;

import Stockpkg.Stock;
import employeepkg.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;

public interface FinancialAdministrator {

    public static ObservableList<Stock> getStockList() {
        ObservableList<Stock> list = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            Stock s;
            ois = new ObjectInputStream(new FileInputStream("Stock.bin"));

            while (true) {
                s = (Stock) ois.readObject();
                list.add(s);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }
        return list;

    }

    public static void PaySalary(Salary c) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Salary.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addTaxData(String month, double income, double deductions, double taxableIncome, double taxPercentage, double totalTax) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("TaxData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            TaxData temp = new TaxData(month, income, deductions, taxableIncome, taxPercentage, totalTax);

            oos.writeObject(temp);

        } catch (IOException ex) {

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void CreateReport(String subject, String text) {

        File s = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            s = new File("Report.bin");
            if (s.exists()) {
                fos = new FileOutputStream(s, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);
            }
            Report newReport = new Report(subject, text);
            oos.writeObject(newReport);
        } catch (IOException ex) {
            Logger.getLogger(FinancialAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FinancialAdministrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String SearchReport(String subject) throws IOException {

        ObjectInputStream ois = null;

        try {
            Report r;
            ois = new ObjectInputStream(new FileInputStream("Report.bin"));

            while (true) {
                r = (Report) ois.readObject();
                if (r.subject.equals(subject)) {
                    return r.text;
                }

            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }
        return null;

    }

    public static boolean isAlpha(String s) {
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static void addIncomeData(String month, double salaryAndWages, double rentAndUtilities, double expenses, double revenue, double contentAcquisition, double marketingCost, double netProfit, double netLoss) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("IncomeData.bin"); // Adjust the file name as needed
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            IncomeStatement temp = new IncomeStatement(month, salaryAndWages, rentAndUtilities, expenses, revenue, contentAcquisition, marketingCost, netProfit, netLoss);

            oos.writeObject(temp);

        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                // Handle exceptions
            }
        }
    }

}
