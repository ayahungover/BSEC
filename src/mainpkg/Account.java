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
            while (true){
                i = (Investor) ois.readObject();
                usedIds.add(i.getId());
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
            id = lowerBound + random.nextInt(upperBound - lowerBound);
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;

    }
}
