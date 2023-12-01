
package Brokerpkg;

import employeepkg.Employee;
import investorpkg.Investor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;
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

    
    public static String AddInvestorHistory(int id, String name, LocalDate lastInteraction, String interaction) throws ClassNotFoundException{
        
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

     
        try {
            
            s = new File("InvestorHistory.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            InvestorHistory i = new InvestorHistory(id, name, lastInteraction, interaction);    
//            listOfReport.add(newReport);
            oos.writeObject(i);
            
//           oos.close();
           
            

        } catch (IOException ex) {
            Logger.getLogger(Stockbroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Stockbroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    
        return null;
        
   }
    
    
    
    
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public static String LookupInvestorHistory(int id){
       
        ObjectInputStream ois = null;
        String data = "";
        try{
            InvestorHistory i;
            ois = new ObjectInputStream(new FileInputStream("InvestorHistory.bin"));
            
            while(true){
                i = (InvestorHistory) ois.readObject();
                if(i.getId()==(id)){
                    data = data + i.name + "\n" + i.lastInteraction + "\n" + i.getInteraction() + "\n \n";
                }
                
            }
            
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        return data;
        
        
       
   }
    
    
    
    
    
}
