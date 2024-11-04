import java.util.*;
import java.io.*;
import javax.swing.*;
public class EditFile extends UserDetail{

    File file = new File("UserSafe.txt");
    public void editData() throws IOException, InterruptedException{
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
                String name = JOptionPane.showInputDialog("Enter your first name");
                String last_name = JOptionPane.showInputDialog("Enter your last name");
                long contact = Long.parseLong(JOptionPane.showInputDialog("Enter your new 10-digits Phone number"));
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter new 4-digits pin"));
                if(String.valueOf(contact).length() == 10 && String.valueOf(pin).length() == 4){
                    int confirm = JOptionPane.showConfirmDialog(null,"Please Confirm the changes");
                    if (confirm == JOptionPane.OK_OPTION) {
                    fields[0] = name;
                    fields[1] = last_name;
                    fields[2] = Long.toString(contact);
                    fields[3] = Integer.toString(pin);
                    lines.set(i, String.join(",", fields));
                    JOptionPane.showMessageDialog(null, "Your account has been modified");
                    String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~ACCOUNT INFORMATION~~~~~~~~~~~~~~~~~~~~~~\n\n"+
            
                "\tName : "+fields[0] + " "+ fields[1]+
                "\n\tACC NO: "+fields[4] +
                "\n\tCurrent Balance:  GHS"+fields[5]+
                "\n\tContact: "+fields[2];
                
                
                for (char w : word.toCharArray()){
                    System.out.print(w);
                    Thread.sleep(20);
                }
                int confirm1 = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm1 == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
                    break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Phone digit must be 10 and Pin has to be 4 digit.Try again");
                    editData();
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
    public void editName() throws IOException, InterruptedException{
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
                
                String name = JOptionPane.showInputDialog("Enter your first name");
                String last_name = JOptionPane.showInputDialog("Enter your last name");
                int confirm = JOptionPane.showConfirmDialog(null,"Confirm changes");
                if (confirm == JOptionPane.OK_OPTION) {
                fields[0] = name;
                fields[1] = last_name;
                lines.set(i, String.join(",", fields));
                JOptionPane.showMessageDialog(null, "Your account has been modified");
                String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~ACCOUNT INFORMATION~~~~~~~~~~~~~~~~~~~~~~\n\n"+
            
                "\tName : "+fields[0] + " "+ fields[1]+
                "\n\tACC NO: "+fields[4] +
                "\n\tCurrent Balance:  GHS"+fields[5]+
                "\n\tContact: "+fields[2];
                
                
                for (char w : word.toCharArray()){
                    System.out.print(w);
                    Thread.sleep(20);
                }
                int confirm1 = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm1 == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
                break;
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
        
    
    public void editContact() throws IOException, InterruptedException{
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
                
                long contact = Long.parseLong(JOptionPane.showInputDialog("Enter your new 10-digits Phone number"));
                if(String.valueOf(contact).length() == 10){
                int confirm = JOptionPane.showConfirmDialog(null," Confirm  changes");
                if (confirm == JOptionPane.OK_OPTION) {
                fields[2] = Long.toString(contact);
                lines.set(i, String.join(",", fields));
                JOptionPane.showMessageDialog(null, "Your account has been modified");
                String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~ACCOUNT INFORMATION~~~~~~~~~~~~~~~~~~~~~~\n\n"+
            
                "\tName : "+fields[0] + " "+ fields[1]+
                "\n\tACC NO: "+fields[4] +
                "\n\tCurrent Balance:  GHS"+fields[5]+
                "\n\tContact: "+fields[2];
                
                
                for (char w : word.toCharArray()){
                    System.out.print(w);
                    Thread.sleep(20);
                }
                int confirm1 = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm1 == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
                break;
                
                }
            }else{
                JOptionPane.showMessageDialog(null, "Phone digit must be 10, Try again");
                editContact();
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

    public void editPassword() throws IOException, InterruptedException{
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
                
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter new 4-digits pin"));
                if (String.valueOf(pin).length() == 4){
                int confirm = JOptionPane.showConfirmDialog(null," Confirm changes");
                if (confirm == JOptionPane.OK_OPTION) {
                    
                fields[3] =Integer.toString(pin);
                lines.set(i, String.join(",", fields));
                JOptionPane.showMessageDialog(null, "Your account has been modified");
                String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~ACCOUNT INFORMATION~~~~~~~~~~~~~~~~~~~~~~\n\n"+
            
                "\tName : "+fields[0] + " "+ fields[1]+
                "\n\tACC NO: "+fields[4] +
                "\n\tCurrent Balance:  GHS"+fields[5]+
                "\n\tContact: "+fields[2];
                
                
                for (char w : word.toCharArray()){
                    System.out.print(w);
                    Thread.sleep(20);
                }
                int confirm1 = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm1 == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
                break;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Pin must be four digit.Try again");
                editPassword();
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
    public void menu() throws IOException, InterruptedException {
        
        String [] Options = {"Update all Account information", "Update Name", "Update Pin", "Exit"};
        JComboBox <String> com = new JComboBox<>(Options);
        int choice = JOptionPane.showConfirmDialog(null, com,"UPDATE ACCOUNT INFORMATION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
        //Safe s = new Safe();
        if(choice == JOptionPane.OK_OPTION){
            String select = (String) com.getSelectedItem();
            try{
            
                switch (select) {
                    case "Update all Account information":
                        editData();
                        break;
                    case "Update Name":
                        editName();
                        break;
                    case "Update Pin":
                        editPassword();
                        break;
                
                    case "Update Contact":
                        editContact();
                        break;

                    case "Exit":
                    System.exit(0);
                    default:
                    System.out.println("Invalid Input");
                        break;
                }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Invalid choice, Try again");
                    UserDetail menu = new Menu();
                    menu.menu();
                }
        }
        
    }
   
}

