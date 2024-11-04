import java.io.IOException;

import javax.swing.*;
public class Account {
    EditFile edit = new EditFile();
    History history = new History();
    Fille file = new Fille();
    public void readAccount() throws IOException, InterruptedException{
        String [] Options = {"DashBoard", "Edit Account","History", "Erase DATA", "Exit"};
        JComboBox <String> com = new JComboBox<>(Options);
        int choice = JOptionPane.showConfirmDialog(null, com,"SELECT AN OPTION\t", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
       
        if(choice == JOptionPane.OK_OPTION){
            String select = (String) com.getSelectedItem();
            try{
            
                switch (select) {
                    case "DashBoard":
                    file.file();
                        break;
                    case "Edit Account":
                        edit.menu();
                        break;
                    case "Erase DATA":
                    DeleteFile del = new DeleteFile();
                    del.DeleteMenu();
                        break; 
                    case "History":
                        history.history();
                    case "Exit":
                    System.exit(0);
                    default:
                    System.out.println("Invalid Input");
                        break;
                }
                }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Invalid choice, Try again");
                    readAccount();
                }
        }
        
    }
    
}
