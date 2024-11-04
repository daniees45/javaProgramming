import java.io.*; 
public class UserDetail {  
public double amount; 
private String myLast_name; 
private String myName; 
private long myContact; 
private int mYpIn; 
private long mYaccnum; 
private Double mYMoney; 
public String PATH = "UserSafe.txt";  
 
File file = new File(PATH); 
 
public String getName() throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 
     
     
    String countLine; 
    while((countLine = writer.readLine()) != null) { 
        String [] words = countLine.split(","); 
             
        String name = words[0]; 
        this.myName = name; 
    } 
    writer.close(); 
    return myName ; 
} 
public String getLastName()throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 

    String countLine; 
    while((countLine = writer.readLine()) != null) { 
        String [] words = countLine.split(","); 
    
 
    String last_name= words[1]; 
 
        this.myLast_name = last_name; 
    } 
    writer.close(); 
    return myLast_name ; 
} 
public long getContact()throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 
     
     
    String countLine; 
    while((countLine = writer.readLine()) != null) { 
        String [] words = countLine.split(","); 
             
         
        String contact1 = words[2]; 
        long contact = Integer.parseInt(contact1); 
        this.myContact = contact; 
    } 
    writer.close(); 
    return myContact ; 
} 
 
 
public double getMoney()throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 
     
     
    String countLine; 
    while((countLine = writer.readLine()) != null) { 
        String [] words = countLine.split(","); 
             
        String amount1 = words[5]; 
        amount = Double.parseDouble(amount1); 
        this.mYMoney = amount; 
    } 
    writer.close(); 
    return mYMoney ; 
} 
public long getAccnum(long accnum)throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 
     
     
    String countLine; 
    while((countLine = writer.readLine()) != null)  
    { 
        String [] words = countLine.split(","); 
             
        String pin1 = words[4]; 
        accnum = Long.parseLong(pin1); 
        this.mYaccnum = accnum; 
    } 
    writer.close(); 
    return mYaccnum ; 
} 
public int getPin(int pin) throws IOException{ 
    BufferedReader writer = new BufferedReader(new FileReader(file)); 
     
     
    String countLine; 
    while((countLine = writer.readLine()) != null)  
    { 
        String [] words = countLine.split(","); 
             
        String pin1 = words[3]; 
        pin = Integer.parseInt(pin1); 
        this.mYpIn = pin; 
    } 
    writer.close(); 
    return mYpIn ; 
} 
 
 



public void menuTransfer() throws IOException, InterruptedException{

}
public void debitTransfer() throws IOException, InterruptedException{

}
public void menu() throws IOException, InterruptedException{

}


}
