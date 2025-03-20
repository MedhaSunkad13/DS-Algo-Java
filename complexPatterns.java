//import java.util.*;

public class complexPatterns {

public static void hollow_rectangle(int totRows, int totCols) {
    //Outer loop
    for(int i=1; i<=totRows; i++) {
        //Inner Loop
        for(int j=1; j<=totCols; j++) {
            //cell (i,j)
            if(i == 1 || i == totRows || j == 1 || j == totCols) {
                //Boundary Condition
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

public static void rotatedHalfPyramid(int n) {
    //Outer loop - Lines
    for(int i = 1; i <= n; i++) {
        //Spaces
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j <= i; j++) {
            System.out.print("*");
        }
         System.out.println();
    }
}

public static void halfPyramidNumbers(int n) {
    //Outer Loop
    for(int i = 1; i <= n; i++) {
        //numbers
        for(int j = 1; j <= (n-i) + 1; j++) {
            System.out.print(j+ " ");
        }
        System.out.println();
    }
}

public static void floydsTriangle(int n) {
    int cnt = 1;
    //Outer
    for(int i = 1; i <= n; i++) {
        //Inner
        for(int j = 1; j <= i; j++) {
            System.out.print(cnt + " ");
            cnt++;
        }
        System.out.println();
    }
}

public static void zero_OneTriangle(int n) {
    //Outer loop
    for(int i = 1; i <= n; i++) {
        //Inner loop
        for(int j = 1; j <= i; j++) {
            if((i + j) % 2 != 0) {
                System.out.print(" 0 ");
            }
            else{
                System.out.print(" 1 ");
            }
        }
        System.out.println();
    }
}

public static void butterflyPattern(int n){
    //Outer Loop
    //make i<n to make a pattern has a pointed edge(refer-Simply coding)
    for(int i = 1; i <= n; i++) {
        //Inner Loop //stars
        for(int j = 1; j <= i; j++) {
            System.out.print(" *");
        }
        //Space
        for(int j = 1; j <= 2*(n-i); j++) {
            System.out.print("  ");
        }
        //Stars
         for(int j = 1; j <= i; j++) {
            System.out.print(" *");
        }
        System.out.println();
    }
    //Mirror-image(Inverted)
    for(int i = 1; i <= n; i++) {
        //Inner Loop //stars
        for(int j = 1; j <= (n-i)+1; j++) {
            System.out.print(" *");
        }
        //Space
        for(int j = 1; j <= 2*(i-1); j++) {
            System.out.print("  ");
        }
        //Stars
         for(int j = 1; j <= (n-i)+1; j++) {
            System.out.print(" *");
        }
        System.out.println();
    }
}

public static void solidRhombus(int n) {
    //outer loop
    for(int i = 1; i <= n; i++) {
        //inner loop(space)
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j <= n; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

public static void hollow_rhombus(int n) {
     //outer loop
    for(int i = 1; i <= n; i++) {
        //inner loop(space)
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        //Hollow-rectangle
        for(int j = 1; j <= n; j++) {
            if(i==1 || i==n || j==1 || j==n) {
            System.out.print("*");
        }
        else{
            System.out.print(" ");
        }
    }
        System.out.println();
    }
}

public static void diamond(int n) {
    //Outer loop
    //make i<n to make a pattern has a pointed edge(refer-Simply coding)
    for(int i = 1; i <= n; i++) { 
        //Inner loop -> Space
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j <= (2*i)-1; j++){
            System.out.print("*");
        }
        //Space
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
          System.out.println();
    }
        for(int i = n; i >= 1; i--) {
        //Inner loop -> Space
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j <= (2*i)-1; j++){
            System.out.print("*");
        }
        //Space
        for(int j = 1; j <= (n-i); j++) {
            System.out.print(" ");
        }
        System.out.println();
    }
}

public static void hillPattern(int n) {
    //outer loop
    for(int i = 1; i <= n; i++) {
        //Inner loop -> Space
        for(int j = i; j <= n; j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j < i; j++) {
            System.out.print("*");
        }
        for(int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

public static void invertedHillPattern(int n) {
    //outer loop
    for(int i = n; i >= 1; i-=1) {
        //Inner loop -> Space
        for(int j = i; j <= n; j++) {
            System.out.print(" ");
        }
        //Stars
        for(int j = 1; j < i; j++) {
            System.out.print("*");
        }
        for(int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}


public static void main(String args[]) {
    //hollow_rectangle(8, 4);
    //rotatedHalfPyramid(6);
    //halfPyramidNumbers(8);
    //floydsTriangle(9);
    //zero_OneTriangle(5);
    //butterflyPattern(5);
    //solidRhombus(5);
    //hollow_rhombus(7);
    //diamond(5);
    //hillPattern(5);
    //invertedHillPattern(5);
   }
}