import java.util.*;

public class even {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your number :");
        int num  = sc.nextInt ();
        if (num % 2 ==0){
        System.out.println("this number is even ");
        } 
        else{
        System.out.println("this number is odd");
        }
        sc.close();

    }
}
