
package FinancialAdministratorpkg;

import employeepkg.Employee;
import java.time.LocalDate;
import mainpkg.User;


public class FinancialAdministrator extends Employee{
    
    public FinancialAdministrator(int id, String name, String address, String contact, String email, LocalDate dob, LocalDate doj, String password) {
        super(id, name, address, contact, email, dob, doj, password);
    }
    
    public void adjustEmployeeSalary(Employee e, double newSalary){
        e.setSalary(newSalary);
    }
    
}
