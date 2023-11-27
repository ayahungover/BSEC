
package Brokerpkg;

import employeepkg.Employee;
import java.time.LocalDate;



public class Stockbroker extends Employee {
    
    public Stockbroker(int id, String name, String address, String contact, String email, LocalDate dob, LocalDate doj, String password, String designation, double Salary) {
        super(id, name, address, contact, email, dob, doj, password, designation, Salary);
    }
    
}
