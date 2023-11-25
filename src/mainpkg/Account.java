package mainpkg;

import employeepkg.Employee;
import investorpkg.Investor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public interface Account {
    
    public static int GenerateEmployeeID() {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
             Employee e;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                e = (Employee) ois.readObject();
                usedIds.add(e.getId());
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
        Random random = new Random();
        int id;
        do {
            id = ID_LOWER_BOUND + random.nextInt(ID_UPPER_BOUND - ID_LOWER_BOUND);
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
    
    
    public static String GenerateEmployeePassword() {
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";
        String SPECIAL = "!@#$%^&*()_-+=<>?";

        String ALL_CHARACTERS = UPPER + LOWER + DIGITS + SPECIAL;
        int PASSWORD_LENGTH = 12;

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
    }
    
    
    public static boolean CheckEmployeeAccountExistence(int EmployeeId) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getId()== EmployeeId) {
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
    
    
    public static boolean CheckEmployeeAccountExistence(String Email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getEmail().equals(Email)) {
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
    
    
    public static boolean EmployeepasswordMatch(int EmployeeID, String Password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getId() == EmployeeID) {
                    if(c.getPassword().equals(Password)) {
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
    
    public static Employee getEmployeeInstance(int EmployeeID) {
        ObjectInputStream ois = null;
        Employee oc = null;
        try {
             Employee c;
             ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
             
            while(true){
                c = (Employee) ois.readObject();
                if(c.getId() == EmployeeID) {
                    oc = c;
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
        return oc;
    }

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
