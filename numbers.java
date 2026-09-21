// public class numbers {
//     public static void main(String args[]){
//         int n = 5;  
//         for (int i = 1 ; i <= n ; i++){
//             for (int j = 1 ; j <= i ; j++){
//                 System.out.print(i + " ");
//             }
//             System.out.println();
//         }
//     }    
// }
// import java.util.*;
// public class numbers{
//     public static void main (String args[]){
        
//         for (int i = 1 ; i <= 4 ; i++){
//             for (int j = 1 ; j <= 5 ; j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }


// import java.util.*;
// public class numbers{
//     public static void main(String agrs[]){
//         int n = 5 ;
//         for (int i = 1 ; i <= n ; i++){
//             for (int j = 1 ;j<=n-i+1 ; j++) {
//                 System.out.print(j);
//             }
//             System.out.println();
//         }
//     }
// }


// public class numbers{
//     public static void main (String args[]){
//         int n = 5 ;
//         int number = 1;
//         for (int i = 1 ; i <= n ; i++){
//             for (int j =1 ; j<=i ; j++){
//                 System.out.print(number + " ");
//                 number ++ ;
//             }
//             System.out.println();
//         }
//     }
// }

public class numbers{
    public static void main (String args []){
        int n = 5 ;
        for (int i =1; i<=n ; i++){
            for (int j =1 ; j<= i ; j++){
            int  sum = i+j;
            if (sum % 2 == 0){
                 System.out.print("1");
            }
           
            else{
                System.out.println("0 ");


            }
            System.out.println();

        }
    }
}

}