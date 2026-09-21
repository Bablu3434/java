import java.util.*;

public class fly {
    public static void main(String args[]) {

        int n = 5;

        // Upper Half
        for (int i = 1; i <= n; i++) {

            // 1st part stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces
            int spaces = 2 * (n - i);

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 2nd part stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower Half
        for (int i = n; i >= 1; i--) {

            // 1st part stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces
            int spaces = 2 * (n - i);

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 2nd part stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}