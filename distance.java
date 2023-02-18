import java.util.*;
public class distance {
    public static void main(String[] args) {
        float speed;
        float distance = 0;
        int time;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the time(hours):");
        time = sc.nextInt();
        System.out.println("Enter the speed (mph):");
        speed = sc.nextFloat();
        System.out.println("Hours\t\tDistance\n"+
                "----------------------------");
        for(int i = 1; i <=time; i++) {
                distance = speed * i;
            
            
            System.out.println(i+ "\t\t "+  distance);
        }
       

    }
}
