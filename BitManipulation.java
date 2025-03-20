//import java.util.*;

public class BitManipulation {

    public static void isEvenOrOdd(int n) {
        int bitMask = 1;
        //Even
        if((n & bitMask) == 0) {
            System.out.println(n +" is even");
        }
        else{
            System.out.println(n + " is odd");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;

        if((n & bitMask) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = ((~0) << i);
        return n & bitMask;
    }

    public static int clearIBitsInRange(int n, int i, int j) {
        int a = ((~0) << (j+1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOf2(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n) {
        int cnt = 0;
        while(n > 0) {
            if((n & 1) != 0) { //checked LSB
                cnt++;
            }
            n = n>>1;
        }
        return cnt;
    }

    public static int fastExponent(int a, int n) {
        int ans = 1;

        while(n > 0) {
            if((n & 1) != 0) { //Check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

   public static void swapWithoutTemp(int a, int b) {
    System.out.println("Before swap: a = " + a + ", b = " + b);
    
    a = a + b;
    b = a - b;
    a = a - b;
    
    System.out.println("After swap: a = " + a + ", b = " + b);
   }

   public static int addOne(int x) {
        return -~x;
    }

    public static void main(String args[]) {
       //System.out.println((6>>1));
       //isEvenOrOdd(7);
       //System.out.println(getIthBit(10, 3));
       //System.out.println(setIthBit(10, 2));
       //System.out.println(clearIthBit(10, 2));
       //System.out.println(updateIthBit(10, 2, 3));
       //System.out.println(clearIBits(15, 2));
       //System.out.println(clearIBitsInRange(10, 2, 4));
       //System.out.println(isPowerOf2(15));
       //System.out.println(countSetBits(15));
       //System.out.println(fastExponent(3, 5));
       //int a = 5, b = 10;
       //swapWithoutTemp(a, b);
        int x = 5;
        System.out.println("Original number: " + x);
        System.out.println("After adding 1: " + addOne(x));
   }
}