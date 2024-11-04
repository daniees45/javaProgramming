import java.io.*;

import java.util.*;
import javax.swing.*;

public class History  extends UserDetail{
    public  void history() throws FileNotFoundException, InterruptedException {
        String filename = "Userhistory.txt"; // name of the data file
        File file = new File("UserSafe.txt");
        List<String> lines = new ArrayList<>();
        //Read the file
        BufferedReader reader =new BufferedReader(new FileReader(filename));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        
            
                String line;
                Long data = Long.parseLong(JOptionPane.showInputDialog("Enter Account Number (or type 'exit' to quit): "));
                int pass = Integer.parseInt( JOptionPane.showInputDialog("Enter your passWord"));
                System.out.println("\n\tDATE        ||  TIME\t\t|| ACCOUNT\t\t||  TRANSACTION ID \t||  ACTION");
                while ((line = reader.readLine()) != null) {
                    String [] data1 = line.split(",");
            
                    //Check if the Account Number exist if not
                    for (int i = 0; i < lines.size(); i++) {
                        String[] fields = lines.get(i).split(",");
                        if ( fields[3].equals(Integer.toString(pass)) && data == Long.parseLong(data1[2])){
                            String word ="\n\t"+data1[0]+"  ||  "+data1[1]+" || "+data1[2]+"  \t||  "+data1[3]+"  \t\t||  "+data1[4];
                            for(char w : word.toCharArray()){
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
            reader.close();

        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
