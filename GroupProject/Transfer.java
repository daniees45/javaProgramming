/*The Transfer Class have methods that perform transaction between Bankify users and other banks
 * 
 */
import javax.swing.*;
import java.time.*;
import java.time.format.*;
import java.io.*;
import java.util.*;
// Extends data from UserDetail
public class Transfer extends UserDetail{
    //  time and data
    LocalDate date = LocalDate.now();
    LocalTime now = LocalTime.now();
    LocalTime times = now.withNano(0);
    // limits the time to hrs:mins:
    DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mm:ss:a");
    String time = times.format(format);
    String Path2 = "Userhistory.txt";
    File file1 = new File(Path2);
    
    
    private Double myTransfer = 0.00;
    private String OthernameAcc;
    private Long acct;
    private String Rbank;
    private Double Tmoney;
    private long  myacc1;
    Login login = new Login();
    Creation creation = new Creation();
    List<String> lines = new ArrayList<>();
    public double myBank() throws IOException, InterruptedException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Menu menu = new Menu();
        
        String nameAcc = JOptionPane.showInputDialog("Receipient Account Name");
        long myacc = Long.parseLong(JOptionPane.showInputDialog("Receipient Account number"));
        long myacc1 = Long.parseLong(JOptionPane.showInputDialog("Confirm Receipient Account number"));
        setTransfer(Tmoney);
        setOthername(nameAcc);
        setAmount(amount);
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
                e.printStackTrace();
            }        
                

        try {
            if (myacc1 == myacc && String.valueOf(myacc1).length() == 9){
                setOtheracct(myacc1);
                this.acct =myacc;
                    amount =Double.parseDouble(JOptionPane.showInputDialog("Amount to Transfer"));
                    int choice = JOptionPane.showConfirmDialog(null,"Are you Sure you want to transfer GHS"+amount+ " to "+getOthername()+"'s account?.\nClick OK to Continue or Cancel to abort");
                    if(choice == JOptionPane.OK_OPTION){
                        long myAccnum = Long.parseLong(JOptionPane.showInputDialog("  Enter your Account number"));
                        int pind = Integer.parseInt(JOptionPane.showInputDialog("Enter your Password"));
                        for (int i = 0; i < lines.size(); i++) {
                                String[] data = lines.get(i).split(",");
                            if ( myAccnum == Long.parseLong(data[4])){
                            
                        
                                if (pind == Integer.parseInt(data[3]) ) {
                                    Double amount1 = Double.parseDouble(data[5]);
                                    if(amount1 > 0){
                                        
                                        amount1 -= amount;

                                        data[5] = Double.toString(amount1);
                                        lines.set(i, String.join(",", data));  
                                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                                            for (String line : lines) {
                                            bw.write(line);
                                            bw.newLine();
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        creation.setTransactionId(0);
                                    
                                        setTransfer(amount);
                                        setAmount(amount1);
                                        
                                        creation.setTransactionId(0);
                                        debitTransfer();
                                        
                                        PrintWriter hist = new PrintWriter(new FileWriter(file1, true));
                                        hist.println(date + "," + time + ","+myAccnum+ "," + creation.getTransactionId() + ", DEBIT: A debit transaction of GHS"+ amount +" has been sent to " +nameAcc+ "'s account" +"{"+acct+"}");
                                        hist.close();
                                        // int end = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                                        // if(end == JOptionPane.YES_OPTION){
                                        //     login.login();
                                        // }else {
                                        //     JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                                        // }
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
                                }else{
                                    int choice1 =JOptionPane.showConfirmDialog(null,"The account does not exist. \nWould you like to go back?\n Enter Yes to go back or No to return to the main menu.");
                                    if (choice1 == JOptionPane.YES_OPTION){
                                    myBank();
                                    }else if (choice == JOptionPane.NO_OPTION){
                                    menu.menu();
                                    }else{
                                    System.exit(0);
                                    }    
                                }
                            }   
                        }
                    }else if (choice == JOptionPane.NO_OPTION){
                    
                    login.login();
                    }else{
                    JOptionPane.showMessageDialog(null, "Thank you for trusting us with your financial needs. Have a pleasant day!");
                    }

            }else{
                JOptionPane.showMessageDialog(null, "The account number must consist of exactly 9 digits. Please check and try again.");
                OtherBank();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thank you for trusting us with your financial needs. Have a pleasant day!");
                }   

            return amount;
        }
    public double OtherBank() throws IOException, InterruptedException{
        
    
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String bank = JOptionPane.showInputDialog("Receipient Bank Name");
        String nameAcc = JOptionPane.showInputDialog("Receipient Account Name");
        long myacc = Long.parseLong(JOptionPane.showInputDialog("Receipient Account number"));
        long myacc1 = Long.parseLong(JOptionPane.showInputDialog("Confirm Receipient Account number"));
        setOthername(nameAcc);
        setRbank(bank);
        setOtheracct(myacc);
        
        
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
                e.printStackTrace();
            }        
                

        try {
            if (myacc1 == myacc && String.valueOf(myacc1).length() == 9){
                setOtheracct(myacc1);
                this.acct =myacc;
                    amount =Double.parseDouble(JOptionPane.showInputDialog("Amount to Transfer"));
                    int choice = JOptionPane.showConfirmDialog(null,"Are you Sure you want to transfer GHS"+amount+ " to "+getOthername()+"'s account?.\nClick OK to Continue or Cancel to abort");
                    if(choice == JOptionPane.OK_OPTION){
                        long myAccnum = Long.parseLong(JOptionPane.showInputDialog("  Enter your Account number"));
                        
                        for (int i = 0; i < lines.size(); i++) {
                                String[] data = lines.get(i).split(",");
                            if ( data[4].equals(Long.toString(myAccnum))){
                                int pind = Integer.parseInt(JOptionPane.showInputDialog("Enter your Password"));
                                if (data[3].equals(Integer.toString(pind))) {
                                    
                                    Double amount1 = Double.parseDouble(data[5]);
                                    if(amount1 > 0){
                                        amount1 -= amount;
                                        
                                        data[5] = Double.toString(amount1);
                                        lines.set(i, String.join(",", data));  
                                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                                            for (String line : lines) {
                                            bw.write(line);
                                            bw.newLine();
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        creation.setTransactionId(0);
                                    
                                        setTransfer(amount);
                                        setAmount(amount1);
                                        
                                        creation.setTransactionId(0);
                                        debitOtherTransfer();
                                        
                                        PrintWriter hist = new PrintWriter(new FileWriter(file1, true));
                                        hist.println(date + "," + time + ","+myAccnum+ "," + creation.getTransactionId() + ", DEBIT: A debit transaction of GHS"+ amount +" has been sent to " +nameAcc+ "'s account" +"{"+acct+"}");
                                        hist.close();
                                        // int end = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                                        // if(end == JOptionPane.YES_OPTION){
                                        // login.login();
                                        // }else{
                                        //     JOptionPane.showMessageDialog(null, "Thank you for trusting us with your financial needs. Have a pleasant day!");
                                        // }
                                    }else {
                                            JOptionPane.showMessageDialog(null, "The balance in your account is 0");
                                            // int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                                            // if (confirm == JOptionPane.YES_OPTION){
                                            //     Login login = new Login();
                                            //     login.login();
                                            // }else {
                                            //     JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                                            // }
                                        }
                                }else{
                                    JOptionPane.showMessageDialog(null, "This Pin doesn't exist");
                                        login.login();
                                    
                                }
                            // } else{
                            //     int choice1 =JOptionPane.showConfirmDialog(null,"The account does not exist. \nWould you like to go back?\n Enter Yes to go back or No to exit.");
                            //     if (choice1 == JOptionPane.YES_OPTION){
                            //     myBank();
                            //     }else if (choice1 == JOptionPane.NO_OPTION){
                            //     login.login();
                            //     }else{
                            //     System.exit(0);
                            //     }      
                            }
                        }
                    }else if (choice == JOptionPane.NO_OPTION){
                    
                    login.login();
                }else{
                    JOptionPane.showMessageDialog(null, "Thank you for trusting us with your financial needs. Have a pleasant day!");
                }

        }else{
            JOptionPane.showMessageDialog(null, "The account number must consist of exactly 9 digits. Please check and try again.");
            OtherBank();
        }
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Thank you for trusting us with your financial needs. Have a pleasant day!");
            }   

            
            

        return amount;
    
    }
    // PRINT OUT THE DEBIT FROM OTHER BANK
    public void debitOtherTransfer() throws IOException, InterruptedException{
        Creation creation = new Creation();
        String word = ("\n\t\t~~~~~~~~~~~~~~~~~~~~~~DEBIT ALERT~~~~~~~~~~~~~~~~~~~~~~\n\n"+
        "\n\tYour account has been debited with GHS " + getTransfer() + ". Here are the transaction details:\n"+
        "\n\tName: " + getOthername() + 
        "\n\tAccount number: " + acct + 
        "\n\tBank: " + getRbank() + 
        "\n\tCurrent balance: GHS " + getAmount() + 
        "\n\tTransaction ID: " + creation.setTransactionId(0) + 
        "\n\tDate: " + date +
        "\n\tTime: " + time  );  
        for (char w : word.toCharArray()){
            System.out.print(w);
            Thread.sleep(20);
        }    
        int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
    }
    public void debitTransfer() throws IOException, InterruptedException{
        Creation creation = new Creation();
        String word = ("\n\t\t~~~~~~~~~~~~~~~~~~~~~~DEBIT ALERT~~~~~~~~~~~~~~~~~~~~~~\n\n"+
        "\n\tYour account has been debited with GHS" + getTransfer() + ". Here are the transaction details:\n"+
        "\n\tName: " + getOthername() + 
        "\n\tAccount number: " + acct + 
        "\n\tCurrent balance: GHS " + getAmount() + 
        "\n\tTransaction ID: " + creation.setTransactionId(0) + 
        "\n\tDate: " + date +
        "\n\tTime: " + time  );  
        for (char w : word.toCharArray()){
            System.out.print(w);
            Thread.sleep(20);
        }    
        int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
                if (confirm == JOptionPane.YES_OPTION){
                    Login login = new Login();
                    login.login();
                }else {
                    JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
                }
    }
// MUTATORS TO SET TRANSFER
    public Double setTransfer(Double transfer){
        this.myTransfer = transfer;
        return myTransfer;
        // MUTATORS TO GET TRANSFER
    }
    public Double getTransfer(){
        return myTransfer;
    }
    // MUTATORS TO SET AMOUNT
    public Double setAmount(Double amount){
        this.Tmoney = amount;
        return Tmoney;
    }
    // MUTATORS TO GET AMOUNT
    public Double getAmount(){
        return Tmoney;
    }
    // MUTATORS TO SET OTHERNAME
    public String setOthername(String name){
        this.OthernameAcc =name;
        return OthernameAcc;
    }
    // MUTATORS TO GET OTHERNAME
    public String getOthername(){
        return OthernameAcc;
    }
    // MUTATORS TO SET OTHER ACCT
    public Long setOtheracct(long myacct1){
        this.acct = myacc1;
        return acct;
    }
    public Long getOtheracct(){
        return acct;
    }
    // MUTATORS TO SET bank
    public String setRbank(String bank){
        this.Rbank = bank;
        return Rbank;
        
    }
    // MUTATORS TO GET BANK
    public String getRbank(){
        return Rbank;
    }
    public void menuTransfer() throws IOException, InterruptedException{
        

    String [] Options = {"My Bank", "Other Bank", "Exit"};
    JComboBox <String> com = new JComboBox<>(Options);
    int choice = JOptionPane.showConfirmDialog(null, com,"SELECT AN OPTION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if(choice == JOptionPane.OK_OPTION){
        String select = (String) com.getSelectedItem();
    try {
        switch (select) {
            case "My Bank":
                myBank();
                break;
            case "Other Bank":
                OtherBank();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
            JOptionPane.showMessageDialog(null, "Invalid Input");
                break;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error, Try again");
        menuTransfer();
    }
}
// if (choice == JOptionPane.NO_OPTION) {
//     // go back to the main menu
//     UserDetail menu = new Menu();
//     menu.menu();
// } else {
//     System.exit(0);
// }    }

}
}
