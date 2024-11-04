/*The MENU class contains the menu options for TRANSACTION CLASS AND TRANSFER */
import java.io.IOException;
import javax.swing.*;

public class Menu extends UserDetail{
    
    
    
    
    public void menu() throws IOException, InterruptedException {
        //set the text in an array
        String [] Options = {"Transaction",  "Account", "Exit"};
        /*Create a drop-down menu using JcomboBox 
         * Which allow the user to select a value for the operation to perform
        */
        JComboBox <String> com = new JComboBox<>(Options);
        // Using ConfirmDialog to confirm selection from JComboBox which is store as an Integer
        int choice = JOptionPane.showConfirmDialog(null, com,"SELECT AN OPTION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
        
        if(choice == JOptionPane.OK_OPTION){
            // The integer value of the choice is convert to string
            String select = (String) com.getSelectedItem();
            // Using try-Catch to catch any Error
            try{
            // Using switch-case to connect to methods of different class;
                switch (select) {
                    case "Transaction":
                        MenuT();
                        break;
                    
                    case "Account":
                    Account account = new Account();
                    account.readAccount();
                        break; 
                    case "Exit":
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Invalid Input");
                    break;
                }
                }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Invalid choice, Try again");
                menu();
                }
                
        }
        
    }
    public void MenuT() throws IOException, InterruptedException {
        Transaction tr = new Transaction();
        String [] Options = {"Withdrawal", "Deposit", "Transfer", "Return to Main Menu", "Exit"};
        /*Create a drop-down menu using JcomboBox 
         * Which allow the user to select a value for the operation to perform
        */
        JComboBox <String> com = new JComboBox<>(Options);
        int choice = JOptionPane.showConfirmDialog(null, com,"SELECT AN OPTION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(choice == JOptionPane.OK_OPTION){
            String select = (String) com.getSelectedItem();
            try {
            
                switch (select) {
                    case "Withdrawal":
                        tr.setWithdraw(0.00);
                        break;
                    case "Deposit":
                        tr.setDeposit(
                            
                        );
                        break;
                    case "Transfer": 
                    // POLYMORPHISMS
                    UserDetail transfer =new Transfer();
                    transfer.menuTransfer();
                        break;
                    case "Return to Main Menu":
                        menu();
                        break;
                    case "Exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("");
                        break;   
                }
            
            } catch (Exception e) {
                
                
            }
    
        }
        
}
public void menuTransfer() throws IOException, InterruptedException{

    
}
}