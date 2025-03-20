//import java.util.*;

public class Patterns {
    public static void main(String[] args) {

        // for(int i=0; i<=4; i++) {
        //     for(int j=0; j<i; j++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        //Inversed Star Pattern
        // int n = 8;
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<(n-i); j++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        //Number Half Pyramid Pattern
        // int n = 4; 
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(j + " ");
        //     } 
        //     System.out.println();
        // }

        //Character Pattern
        // int n = 4;
        // char ch = 'A';
        //Outer Loop
        // for(int i = 1; i <= n; i++) {
        //     //Inner Loop
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(ch + " ");
        //         ++ch;
        //     }
        //     System.out.println();
        // }

        // Pyramid-like right-aligned star pattern

        // int n = 5;
        // for(int i = 1; i <= n; i++) {
        //     //Print Spaces
        //     for(int s = 1; s <= (n-i); s++) {
        //         System.out.print("  ");
        //     }
        //     //Print Stars
        //      for(int j = 1; j <= i; j++) {
        //             System.out.print("* ");
        //         }
        //         System.out.println();
        // }

        //INVERTED HALF-PYRAMID with Numbers pattern:

        // int n = 5;

        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= (n-i)+1; j++) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }

        //FLOYD'S Triangle pattern:

        // int n = 5;
        // int cnt = 1;

        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(cnt + " ");
        //         cnt--;
        //     }
        //     System.out.println();
        // }

          //Alternating 1-0 pattern
        // int n = 5;

        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         if (j % 2 != 0) { // Odd position
        //             System.out.print("1 ");
        //         } else { // Even position
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }    
    }
}

   