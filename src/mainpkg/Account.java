package mainpkg;

import investorpkg.Investor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public interface Account {

    public static int generateInvestorId() throws FileNotFoundException, IOException {
        int lowerBound = 1000000;
        int upperBound = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
            Investor i;
            ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
            while (true) {
                i = (Investor) ois.readObject();
                usedIds.add(i.getId());
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
        Random random = new Random();
        int id;
        do {
            id = lowerBound + random.nextInt(upperBound - lowerBound);
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;

    }
    
    public static boolean checkInvestorAccountExistence(int investorId) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Investor i;
             ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
             
            while(true){
                i = (Investor) ois.readObject();
                if(i.getId()== investorId) {
                    result = true;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return result;
    }
    
    public static boolean checkInvestorAccountExistence(String email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Investor i;
             ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
             
            while(true){
                i = (Investor) ois.readObject();
                if(i.getEmail().equals(email)) {
                    result = true;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return result;
    }
    

    public static boolean investorIdPasswordMatch(int investorId, String password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Investor i;
             ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
             
            while(true){
                i = (Investor) ois.readObject();
                if(i.getId() == investorId) {
                    if(i.getPassword().equals(password)) {
                        result = true;
                    }
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return result;
    }
    
    public static Investor getInvestorInstance(int investorId) {
        ObjectInputStream ois = null;
        Investor i1 = null;
        try {
             Investor i2;
             ois = new ObjectInputStream(new FileInputStream("Investor.bin"));
             
            while(true){
                i2 = (Investor) ois.readObject();
                if(i2.getId() == investorId) {
                    i1 = i2;
                }
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return i1;
    }

}
