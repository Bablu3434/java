import java.util.*;
public class pass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int button = sc.nextInt();

        if(button == 1 ){
            System.out.println("pass");
        }
        else if(button == 2){
            System.out.println("range");
        }
        else  if (button == 3){
            System.out.println("fail");
        }
        else if (button == 4 ){
            System.out.println("sorry your resut is invailed");
        }
        else{
            System.out.println("end this program ");
        }
        sc.close();


    }
}
