/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SECAdministratorpkg;

import employeepkg.Employee;
import java.time.LocalDate;

/**
 *
 * @author md.shahriarnur
 */
public class SECAdministrator extends Employee {
    
    public SECAdministrator(int id, String name, String address, String contact, String email, LocalDate dob, LocalDate doj, String password, String designation, double Salary) {
        super(id, name, address, contact, email, dob, doj, password, designation, Salary);
    }
    
}
