
package investorpkg;
import java.io.Serializable;
import java.time.LocalDate;
import mainpkg.User;


public class Investor extends User implements Serializable {
    private double balance = 0.0;
    
    public Investor(int id,
            String name,
            String address,
            String contact,
            String email,
            LocalDate dob,
            LocalDate doj,
            String password,
            double balance){
        super(id, name, address, contact, email, dob, LocalDate.now(), password);
        this.balance = balance;                
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
