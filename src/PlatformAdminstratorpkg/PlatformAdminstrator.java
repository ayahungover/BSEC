
package PlatformAdminstratorpkg;

import investorpkg.Investor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;


public interface PlatformAdminstrator {
    public static void createNewAccount(Investor i) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("Investor.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(i);

        } catch (IOException ex) {
            Logger.getLogger(Investor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Investor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
