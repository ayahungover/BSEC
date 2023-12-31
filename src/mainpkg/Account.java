package mainpkg;

import Brokerpkg.Stockbroker;
import SECAdministratorpkg.SECAdministrator;
import companypkg.Company;
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
    
    public static int GenerateStockbrokerID() {
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
            Stockbroker b;
            ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));
             
            while(true){
                b = (Stockbroker) ois.readObject();
                usedIds.add(b.getId());
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
    
    
    public static String GenerateStockbrokerPassword() {
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";

        String ALL_CHARACTERS = UPPER + LOWER ;
        int PASSWORD_LENGTH = 12;

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
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
    
    public static boolean CheckStockbrokerAccountExistence(int stockbrokerId) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Stockbroker b;
             ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));
             
            while(true){
                b = (Stockbroker) ois.readObject();
                if(b.getId()== stockbrokerId) {
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
    
    public static boolean CheckStockbrokerAccountExistence(String Email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            Stockbroker b;
            ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));
             
            while(true){
                b = (Stockbroker) ois.readObject();
                if(b.getEmail().equals(Email)) {
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
    
    
    public static boolean StockbrokerPasswordMatch(int EmployeeID, String Password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Stockbroker b;
             ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));
             
            while(true){
                b = (Stockbroker) ois.readObject();
                if(b.getId() == EmployeeID) {
                    if(b.getPassword().equals(Password)) {
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

    
    public static Stockbroker getStockbrokerInstance(int EmployeeID) {
        ObjectInputStream ois = null;
        Stockbroker ob = null;
        try {
             Stockbroker b;
             ois = new ObjectInputStream(new FileInputStream("Stockbroker.bin"));
             
            while(true){
                b = (Stockbroker) ois.readObject();
                if(b.getId() == EmployeeID) {
                    ob = b;
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
        return ob;
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
    
    public static int generateCompanyId() throws FileNotFoundException, IOException {
        int lowerBound = 1000000;
        int upperBound = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
            Company c;
            ois = new ObjectInputStream(new FileInputStream("Company.bin"));
            while (true) {
                c = (Company) ois.readObject();
                usedIds.add(c.getId());
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
    
    
    public static boolean checkCompanyAccountExistence(int companyId) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            Company c;
            ois = new ObjectInputStream(new FileInputStream("Company.bin"));
             
            while(true){
                c = (Company) ois.readObject();
                if(c.getId()== companyId) {
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
    
    public static boolean checkCompanyAccountExistence(String email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             Company c;
             ois = new ObjectInputStream(new FileInputStream("Company.bin"));
             
            while(true){
                c = (Company) ois.readObject();
                if(c.getEmail().equals(email)) {
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
    
    
    public static boolean companyIdPasswordMatch(int companyId, String password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            Company c;
            ois = new ObjectInputStream(new FileInputStream("Company.bin"));
             
            while(true){
                c = (Company) ois.readObject();
                if(c.getId() == companyId) {
                    if(c.getPassword().equals(password)) {
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

    
    public static Company getCompanyInstance(int companyId) {
        ObjectInputStream ois = null;
        Company c1 = null;
        try {
            Company c2;
            ois = new ObjectInputStream(new FileInputStream("Company.bin"));
             
            while(true){
                c2 = (Company) ois.readObject();
                if(c2.getId() == companyId) {
                    c1 = c2;
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
        return c1;
    }
    
    public static int GenerateSECAdministratorID(){
        int ID_LOWER_BOUND = 1000000;
        int ID_UPPER_BOUND = 9999999;
        Set<Integer> usedIds = new HashSet<>();
        ObjectInputStream ois = null;
        try {
            SECAdministrator s;
            ois = new ObjectInputStream(new FileInputStream("SECAdministrator.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                usedIds.add(s.getId());
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
    
    public static String GenerateSECAdministratorPassword() {
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWER = "abcdefghijklmnopqrstuvwxyz";

        String ALL_CHARACTERS = UPPER + LOWER ;
        int PASSWORD_LENGTH = 12;

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
        
        
    }
    
    
    public static boolean CheckSECAdministratorAccountExistence(int SECAdministratorId) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            SECAdministrator s;
            ois = new ObjectInputStream(new FileInputStream("SECAdministrator.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                if(s.getId()== SECAdministratorId) {
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
    
    public static boolean CheckSECAdministratorAccountExistence(String Email) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
            SECAdministrator s;
            ois = new ObjectInputStream(new FileInputStream("SECAdministrator.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                if(s.getEmail().equals(Email)) {
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
    
  
    
    public static boolean SECAdministratorIdPasswordMatch(int SECAdministratorId, String Password) {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             SECAdministrator s;
             ois = new ObjectInputStream(new FileInputStream("SECAdministratorId.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                if(s.getId() == SECAdministratorId) {
                    if(s.getPassword().equals(Password)) {
                        System.out.println(s.getPassword() + Password);
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
    
    public static SECAdministrator getSECAdministratorInstance(int SECAdministratorId) {
        ObjectInputStream ois = null;
        SECAdministrator ob = null;
        try {
             SECAdministrator s;
             ois = new ObjectInputStream(new FileInputStream("SECAdministrator.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                if(s.getId() == SECAdministratorId) {
                    ob = s;
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
        return ob;
    }
    
    public static boolean SECAdministratorAnyAccountExistance() {
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             SECAdministrator s;
             ois = new ObjectInputStream(new FileInputStream("SECAdministratorId.bin"));
             
            while(true){
                s = (SECAdministrator) ois.readObject();
                if(s == null) {   
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

    
    
}
