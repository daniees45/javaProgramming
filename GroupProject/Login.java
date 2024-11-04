import java.io.*;
import javax.swing.*;
import java.util.*;
public class Login extends UserDetail{
    File file = new File("UserSafe.txt");
    Creation creation = new Creation();
    Menu me = new Menu();
    
    public void login() throws IOException {
        
            
        List<String> lines = new ArrayList<>();
        // READS FILES
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // STORES FILE
                lines.add(line);   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    
        // USERS ENTER DETAILS
        Long accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
        int pass = Integer.parseInt( JOptionPane.showInputDialog("Enter your passWord"));

                try {                 
                    
                    for (int i = 0; i < lines.size(); i++) {
                        String[] fields = lines.get(i).split(",");
                        // CHECK FOR USER DETAILS
                        if (accNum == Long.parseLong(fields[4])){
                            if (pass == Integer.parseInt(fields[3]) ) {
                                me.menu();
                                
                            
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid Credentials, Try again");
                                login();
                            }
                    }    
                }
                            
                    
                    } catch (Exception e) {
                    
                    
                }
            }    
            
    
    

public void another() throws IOException, InterruptedException{
    int exit = JOptionPane.showConfirmDialog(null,"Do you want to perform another Transaction");
        if ( exit == JOptionPane.OK_OPTION) {
            Login log = new Login();
            log.login();
        } else if(exit == JOptionPane.NO_OPTION){
            System.exit(0);
        }else if(exit == JOptionPane.CANCEL_OPTION){
            System.exit(0);
        }
}
}