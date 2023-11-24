package Brokerpkg;

import employeepkg.Employee;
import java.io.Serializable;
import java.time.LocalDate;
import mainpkg.Account;


public class Broker extends Employee implements Account,Serializable{
    private double salary;
    
    public Broker(int id, String name, String address, String contact, String email, LocalDate dob, LocalDate doj, String password) {
        super(id, name, address, contact, email, dob, doj, password);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    
}
