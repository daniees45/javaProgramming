import java.io.*;
import javax.swing.*;
import java.util.*;
public class DeleteFile extends Fille {
    Login login = new Login();
    public void DeleteAccount() throws IOException, InterruptedException {
        File file = new File("UserSafe.txt");

        Long accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
        int pass = Integer.parseInt( JOptionPane.showInputDialog("Enter your passWord"));
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(",");
            if (fields[3].equals(Integer.toString(pass)) && fields[4].equals(Long.toString(accNum))) {
                
                    int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to erase your information");
                    if (confirm == JOptionPane.YES_OPTION) {
                
                    
                    lines.set(i, String.join(",", "--,--,--,--,--,--"));
                    JOptionPane.showMessageDialog(null, "Your account has been deleted");
                    Creation creation = new Creation();
                    creation.main();
                    break;
                    }else if (confirm == JOptionPane.NO_OPTION){
                        login.login();
                    }
                }
            }
            
            
        
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
public void deleteHistory() throws IOException{
    File file = new File("Userhistory.txt");
    File file1 = new File("UserSafe.txt");
        Long accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
        int pass = Integer.parseInt( JOptionPane.showInputDialog("Enter your passWord"));
        List<String> lines = new ArrayList<>();
        List<String> lines1 = new ArrayList<>();
        // READ DATA FROM FILE
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // STORES THE DATA
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // READ DATA FROM FILE1
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line1;
            while ((line1 = br.readLine()) != null) {
                lines1.add(line1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ITERATE THROUGH THE DATA

        for (int i = 0; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(",");
            String[] fields1 = lines.get(i).split(",");
            //CHECK IF PIN AND ACCOUNT NUMBER ARE IN THE DATABASE
            if (fields1[3].equals(Integer.toString(pass)) && fields[2].equals(Long.toString(accNum))) {
                    // CONFIRM IF THE USER WANTS TO DELETE ACCOUNT
                    int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to erase your History");
                    if (confirm == JOptionPane.YES_OPTION) {
                
                    // DELETE THE ACCOUNT
                    lines.set(i, String.join(",", "--,--,--,--,--,--"));
                    JOptionPane.showMessageDialog(null, "Your account has been modified");
                    break;
                    }else if (confirm == JOptionPane.NO_OPTION){
                        login.login();
                    }
                }
            }
            
            
        
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

}
public void DeleteMenu() throws IOException, InterruptedException{
String [] Options = {"Erase History", "Erase Account", "Exit"};
        JComboBox <String> com = new JComboBox<>(Options);
        int choice = JOptionPane.showConfirmDialog(null, com,"SELECT AN OPTION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
        if(choice == JOptionPane.OK_OPTION){
            String select = (String) com.getSelectedItem();
            try{
            
                switch (select) {
                    case "Erase History":
                        deleteHistory();
                        break;
                    case "Erase Account":
                        DeleteAccount();
                        break;
                    case "Exit":
                    System.exit(0);
                    default:
                    System.out.println("Invalid Input");
                        break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Invalid choice, Try again");
                    
                }
        }
}
}

