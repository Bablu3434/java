import java.util.Scanner;

public class condotion {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age > 18){
            System.out.println("your are eligible for voting");
        } else {
            System.out.println("your are not eligible for voting");
        }
        sc.close();
    }
}
