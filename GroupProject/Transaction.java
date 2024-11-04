/*This Class contains the transaction process where Withdrawal, Deposit and Transfer methods are stored
 * We extends the user information from UserDetail
 */
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.time.*;
import java.time.format.*;


public class Transaction extends UserDetail{
    String Path = "UserSafe.txt";
    String Path2 = "Userhistory.txt";
    File file = new File(Path);
    File file1 = new File(Path2);
    private Double myWithdraw = 0.00;
    private Double myDeposit = 0.00;
    private long accNum;
    
    LocalDate date = LocalDate.now();
    LocalTime now = LocalTime.now();
    LocalTime times = now.withNano(0);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mm:ss:a");
    String time = times.format(format);
    
    Creation creation = new Creation();
    Prime main = new Prime();

    

    public Double setWithdraw(Double withdrawn) throws FileNotFoundException, IOException, InterruptedException{
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        withdrawn = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw"));
        accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
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
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your pin to confirm your transaction"));
                if(pin == Integer.parseInt(data[3]) ) {
                    Double five = Double.parseDouble(data[5]);
                    if(five > 0){
                        five -= withdrawn;
                        this.myWithdraw = withdrawn;
                        data[5] = Double.toString(five);
                        lines.set(i, String.join(",", data));
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                            for (String line : lines) {
                                bw.write(line);
                                bw.newLine();
                            }
                        } catch (IOException e) {
                            
                        }
                        creation.setTransactionId(0);
                        String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~DEBIT ALERT~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                            "The Sum of GHS"+myWithdraw +" is deducted to your Account\n"+
                            "\tName : "+data[0] + " "+ data[1]+
                            "\n\tACC NO: "+accNum +
                            "\n\tCurrent Balance:  GHS"+data[5]+
                            "\n\tTransaction ID: "+creation.getTransactionId()+ 
                            "\n\tDATE :" + date +
                            "\n\tTIME : "+time;
                            for (char w : word.toCharArray()){
                                System.out.print(w);
                                Thread.sleep(20);
                            }
                            PrintWriter hist = new PrintWriter(new FileWriter(file1, true));
                            hist.println(date + "," + time + ","+ accNum + "," + creation.getTransactionId() + ", Debit:"+ getWithdraw() );
                            hist.close();
                            int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                                if (confirm == JOptionPane.YES_OPTION){
                                    Login login = new Login();
                                    login.login();
                                }else {
                                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                                }
                        }else {
                            JOptionPane.showMessageDialog(null, "The balance in your account is 0");
                            int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                            if (confirm == JOptionPane.YES_OPTION){
                                Login login = new Login();
                                login.login();
                            }else {
                                JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                            }
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "This Pin doesn't exist");
                        Login login = new Login();
                        login.login();
                    }
                
            
        } else{
            int choice1 =JOptionPane.showConfirmDialog(null,"The account does not exist. \nWould you like to go back?\n Enter Yes to go back or No to exit.");
            if (choice1 == JOptionPane.YES_OPTION){
                Login login = new Login();
                login.login();
            }else if (choice1 == JOptionPane.NO_OPTION){
                Login login = new Login();
            login.login();
            }else{
            System.exit(0);
            }      
        }
        
    }

    reader.close();

        return myWithdraw;
    }
    public Double getWithdraw(){
        return myWithdraw;
    }



    //DEPOSIT

    
    public Double setDeposit() throws FileNotFoundException, IOException, InterruptedException{
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        Double deposit = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to deposit"));
        accNum = Long.parseLong(JOptionPane.showInputDialog("Enter your Account Number"));
        int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your pin to confirm your transaction"));
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
        
            if (pin == Integer.parseInt(data[3]) ) {
                
                
            
                    Double five = Double.parseDouble(data[5]);
                    five += deposit;
                    this.myDeposit = deposit;
                    data[5] = Double.toString(five);
                    lines.set(i, String.join(",", data));
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        for (String line : lines) {
                            bw.write(line);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                    
                    }


                        creation.setTransactionId(0);
                        String word = "\n\t\t~~~~~~~~~~~~~~~~~~~~~~CREDIT ALERT~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                        "The Sum of GHS"+myDeposit +" is added to your Account\n"+
                        "\tName : "+data[0] + " "+ data[1]+
                        "\n\tACC NO: "+accNum +
                        "\n\tCurrent Balance:  GHS"+data[5]+
                        "\n\tTransaction ID: "+creation.getTransactionId()+ 
                        "\n\tDATE :" + date +
                        "\n\tTIME : "+time;
                        for (char w : word.toCharArray()){
                            System.out.print(w);
                            Thread.sleep(20);
                        }

                    
                    PrintWriter hist = new PrintWriter(new FileWriter(file1, true));
                    hist.println(date + "," + time + ","+ accNum + "," + creation.getTransactionId() + ", CREDIT:"+ getDeposit() );
                    hist.close();
                    int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
                    
                
            }else {
                    JOptionPane.showMessageDialog(null, "This Pin doesn't exist");
            }
            
    }
        
    }
    
    reader.close();

        return myDeposit;
    }
    public double getDeposit(){
        return myDeposit;
    }
    
    
        
    
    public static void slowPrint(String slow, int stop){
        for (int i = 0; i < slow.length(); i++) {
            System.out.print(slow);
        }
    }
    

    

   
    
public void debitTransfer() throws IOException, InterruptedException{
   
   
}

    
}