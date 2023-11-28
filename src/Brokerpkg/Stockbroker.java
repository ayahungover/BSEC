
package Brokerpkg;

import employeepkg.Employee;
import java.time.LocalDate;
import mainpkg.User;



public class Stockbroker extends User {
    private double balance;
    public Stockbroker(int id, 
            String name, 
            String address, 
            String contact, 
            String email, 
            LocalDate dob, 
            LocalDate doj, 
            String password,
            double balance) {
        super(id, name, address, contact, email, dob, doj, password);
        this.balance = balance;
        
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
