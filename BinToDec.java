//import java.util.*;

public class BinToDec {  
    public static void binToDec(int binNum) {  //Method should be inside the class
        int myNum = binNum;
        int decNum = 0;
        int power = 0;

        while (binNum != 0) {
            int lastDig = binNum % 10;
            decNum = decNum + (lastDig * (int) Math.pow(2, power));

            power++;
            binNum /= 10;
        }
        System.out.println("Decimal number of " + myNum + " = " + decNum);
    }

    public static void decToBin(int n) {
        int orgNum = n;
        int power = 0;
        int binNum = 0;

        while(n > 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, power)); //Math.pow returns double value always.

            power++;
            n /= 2;
        }
        System.out.println("Binary form of " +orgNum+ " = " +binNum);
    }

    public static void main(String args[]) {
        //binToDec(1011);  //function can be called here
          decToBin(9);
    }
}
