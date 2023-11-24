
package employeepkg;

import java.io.Serializable;
import java.time.LocalDate;
import mainpkg.User;

/**
 *
 * @author User
 */
public class Employee extends User implements Serializable{
    private String designation;
    private double salary;
    public Employee(int id, String name, String address, String contact, String email, LocalDate dob, LocalDate doj, String password, String designation, double Salary) {
        super(id, name, address, contact, email, dob, doj, password);
        this.designation = designation;
        this.salary = salary;
        
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
