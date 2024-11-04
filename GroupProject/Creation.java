/*This class Creation receieve data from the user, set the data to a variable and get the data */
import java.util.*;
import javax.swing.*;

import java.io.*;

public class Creation {
    private String myName;
    private String lastName;
    private Long myNum = (long)0000000;
    private long myAcct;
    private Double myAmount = 0.00;
    
    private int myPin;
    private int myTransactionId;
    public Double amount = 0.00;
    public final String filename = "UserSafe.txt"; 
    Random rand = new Random();
    
    File file = new File(filename);

    public long setAccNum(long accNum) throws FileNotFoundException{
        // Scanner scan = new Scanner(file);
        
        
        // GENERATE A RANDOM ACCOUNT NUMBER
        accNum = rand.nextLong(999999999) + 222;
        // String [] data = line.split(",");
        // CHECKS IF THE ACCOUNT NUMBER DOES NOT EXIST
        
            /*  ASSIGN THE NEW ACCOUNT NUMBER
            */
                this.myAcct = accNum;
    
        
        return myAcct;
    }

    public long getAccnum(){   
        return myAcct;
    }
    public Double setAmount(Double amount){
        this.myAmount = amount;
        return myAmount;
    }
    public Double getAmount(){
        return myAmount;
    }
    //SET USER NAME 
    public String setName(String name){
        // USER INPUT
        name = JOptionPane.showInputDialog("Enter your First name");
        this.myName = name;
        return myName;
    }
    public String getName(){
        //GET THE USER NAME
        return myName;
    }
    public String setLastName(String last_Name){
        // SET USER LAST NAME
        last_Name = JOptionPane.showInputDialog("Enter your last name");
        this.lastName = last_Name;
        return lastName;
    }
    public String getLastName(){
        // GET 
        return lastName;
    }
    public long setPhoneNum(long contact){
        JOptionPane.showMessageDialog(null, "The phone number msut be 9 digit excluding the first zero");
        contact = Long.parseLong(JOptionPane.showInputDialog("Enter your Phone number"));
        try {
            if(String.valueOf(contact).length() == 9){
                this.myNum = contact;
            }else{
                JOptionPane.showMessageDialog(null, "Error, Number is not 9 digits, Try again");
                setPhoneNum(0);
            }
        } catch (Exception e) {
            
        }
        

        return myNum;
    }
    public long getPhoneNum(){
        return myNum;
    }

    public int setPin(int pin){
        JOptionPane.showMessageDialog(null, "The pin must be four-digits");
        pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your four digit pin "));
        try {
            if (String.valueOf(pin).length() == 4){
                this.myPin = pin;
            }else{
                JOptionPane.showMessageDialog(null, "Error,The Pin is not four-digits, Try again");
                setPin(pin);
            }
        } catch (Exception e) {
            
        }
        
    
    return myPin;
    }
    public int getPin(){
        return myPin;
    }
    public void StoreData()throws IOException{
        
        
    PrintWriter write = new PrintWriter(new FileWriter("UserSafe.txt", true));
        write.println(getName() + ","+ getLastName() + ","+getPhoneNum() + ","+ getPin() + ","+ getAccnum()+","+getAmount() );
        write.close();

        
    }
    public int setTransactionId(int transactionID){
        transactionID = rand.nextInt(999999999) + 111;
        this.myTransactionId = transactionID;
        return myTransactionId;
    }
    public int getTransactionId(){
        return myTransactionId;
    }
    public void printData() throws InterruptedException{
        String detail = "\n\n\t~~~~~~~~~~~~~~~~~~~~DATA CREATED SUCCESSFULLY~~~~~~~~~~~~~~~~~~~~\n"+
            "\n\tNAME: "+getLastName() +" "+getName() +
            "\n\tCONTACT :"+getPhoneNum() + 
            "\n\tACCOUNT NUMBER : "+getAccnum() +
            "\n\tNOTE IT IS VERY IMPORTANT TO KNOW YOUR ACOUNT NUMBER AND PIN, IT WILL BE USED TO ACCESS YOUR INFORMATION";
            for (char w : detail.toCharArray()){
                System.out.print(w);
                Thread.sleep(20);
            }
    }
    public void main() throws IOException, InterruptedException{
        Login login = new Login();
    setName(getLastName());
    setLastName(getLastName());
    setPhoneNum(getPhoneNum());
    setPin(getPin());
    setAccNum(0);

    
    // setAccNum(0);
    
    // Confirmation from the User
    int k = JOptionPane.showConfirmDialog(null, "IS YOUR DETAILS CORRECT? IF ENTER YES TO CONTINUE, NO TO CREATE ACCOUNT");
    if (k == JOptionPane.YES_OPTION) {
        // Store Data
        StoreData();

        // Sort the data
        DataSort();
        // Print Data
        printData();
    // Go to Login Class Directly
    int confirm = JOptionPane.showConfirmDialog(null,"Would you like to proceed with your banking or exit our system?");
    if (confirm == JOptionPane.YES_OPTION){
        
        login.login();
    }else {
        JOptionPane.showMessageDialog(null,"Your satisfaction is our priority. Thank you for banking with us. Goodbye!");
    }
    
    } else if (k == JOptionPane.NO_OPTION){
        // if no, Enter information
        main();
    }else if (k == JOptionPane.CANCEL_OPTION){
        // exit
        System.exit(0);
    }
    }
    // This sort the data 
    public void DataSort(){
        List<String> lines = new ArrayList<>();
        //Read the file

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(lines);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String Sort : lines) {
                bw.write(Sort);
                bw.newLine();
            }
        } catch (IOException e) {
        
        }
    }
    


    

}
