import java.io.*;
import java.util.*;
import javax.swing.*;

public class Fille {
    Login login = new Login();
    File file = new File("UserSafe.txt");
    public void file() throws IOException, InterruptedException {
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            long accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                    e.printStackTrace();
                }   
            for (int i = 0; i < lines.size(); i++) {
                String[] data = lines.get(i).split(",");
            if(accNum == Long.parseLong(data[4])) {
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your pin"));
                    if(pin == Integer.parseInt(data[3]) ) {
                        String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~ACCOUNT INFORMATION~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                    
                        "\tName : "+data[0] + " "+ data[1]+
                        "\n\tACC NO: "+data[4] +
                        "\n\tCurrent Balance:  GHS"+data[5]+
                        "\n\tContact: "+data[2];
                        
                        
                        for (char w : word.toCharArray()){
                            System.out.print(w);
                            Thread.sleep(20);
                        }
                        

                    }
                }
        
                }
                int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
            
        }

    
}