//import java.util.*;

class Complex {

    int add(int a, int b) {
        return a + b;
    }

    int difference(int a, int b) {
        return a - b;
    }

    int product(int a, int b) {
        return a * b;
    }
}


class OOPPractice {

    public static void main(String[] args) {
        Complex operation = new Complex();
        System.out.println(operation.add(2, 3));
        System.out.println(operation.add(10, 4));
        System.out.println(operation.add(8, 2));
    }

}