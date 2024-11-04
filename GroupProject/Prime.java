import java.io.*;

import javax.swing.*;

public class Prime{
    public static void main(String[] args) throws IOException, InterruptedException {
        // message pop = new message();
        // pop.pop();

        
        try {
            // READS THE PYTHON SCRIPT FROM THE DIRECTORY
            ProcessBuilder Py = new ProcessBuilder("python", "C:/Users/user/GroupProject/Welcome.py");
        Py.directory(new File("C:/Users/user/GroupProject/"));
        // START TO READ
        Process pro = Py.start();
        InputStream In = pro.getInputStream();
        // USING BUFFERED READER 
        BufferedReader read = new BufferedReader(new InputStreamReader(In));
        String CountLine;
        while((CountLine = read.readLine()) != null){
            // PRINT OUT THE SCRIPT
            JOptionPane.showMessageDialog(null,CountLine);
        }
        } catch (Exception e) {
            
        }
    
            
        
        
                try {
                    do{
                        int k = JOptionPane.showConfirmDialog(null, "Welcome to Prime Bank. We're committed to providing you with the best banking experience possible.\nDo you already have an account with us? Please enter 'yes' or 'no' to create a new account.");
                    if (k == JOptionPane.NO_OPTION) {
                        // CREATES AN ACCOUNT FOR THE USER
                    Creation creation = new Creation();
                    creation.main();
            
                    } else if (k == JOptionPane.YES_OPTION){
                        // USER ENTER LOGIN DETAILS TO ACCESS THEIR DATA
                    Login log = new Login();
                    log.login();
                    }else if (k == JOptionPane.CANCEL_OPTION){
                        // EXIT THE SYSTEM
                        System.exit(0);
                    }
                    }while(true);
                } catch (Exception e) {
                    
                }
        
    }
}