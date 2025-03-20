//import java.util.*;

public class javaBasics {

// public static int calculateProduct(int a, int b) {
//     return a * b;
// }

// public static int calculateFactorial(int n) {
//     int fact = 1;

//     for(int i = 1; i<=n; i+=1) {
//         fact *= i;
//     }
//     return fact;
// }

// public static int binCoeff(int n, int r) {
//     int fact_n = calculateFactorial(n);
//     int fact_r = calculateFactorial(r);
//     int fact_n_r = calculateFactorial(n-r);

//     int binomialCoeff = (fact_n)/(fact_n_r * fact_r);

//     return binomialCoeff;
// }

public static boolean isPrime(int n) {
    if (n <= 1)
     return false; // 0 and 1 are not prime
    if (n == 2) 
      return true;
    else{
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
              return false;
        }
    }
    return true;
}

public static void primesInRange(int n) {
    for(int i = 2; i <= n; i++) {
        if(isPrime(i)) { //if true
          System.out.print(i + " ");
       }
    }
    System.out.println();
}

public static void main(String args[]) {
    // Scanner sc = new Scanner(System.in);

    // System.out.print("Enter num1: ");
    // int num1 = sc.nextInt();

    // System.out.print("Enter num2: ");
    // int num2 = sc.nextInt();

    // int product = calculateProduct(4, 7);

    // System.out.println("Product is: " +product);

    //System.out.println("Factorial is: " + calculateFactorial(5));

    //System.out.println("Binomial Coefficient is: " +binCoeff(5, 2));

    //System.out.println(isPrime(10));

    primesInRange(20);

}

}

// public class javaBasics {
//     public static void main(String args[]) {
        // System.out.println("Hello Medha!"); //ln = newline

        // System.out.println("* * * *");
        // System.out.println("* * *");
        // System.out.println("* *");
        // System.out.println("*");
 
        //Sum calculation
        // int a = 10;
        // int b = 5;
        // System.out.println(a);
        // System.out.println(b);
        // int sum = a + b;
        // System.out.println("The sum is " +sum);

        //Input
        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);

        //Scanner sc = new Scanner(System.in);
        // int num1 = sc.nextInt();
        // int num2 = sc.nextInt();
        //int sum = num1 + num2;
        // int product = num1 * num2;
        // System.out.println("num1 = " +num1);
        // System.out.println("num2 = " +num2);
        // System.out.println("Product = " +product);

        //Area of Circle
        // float radius = sc.nextFloat();
        // float Area = 3.142f * radius * radius;
        // System.out.println("Area of a circle = " +Area);

        //Type Conversion
        // int a = 30;
        // long b = a;
        // System.out.println(b);

        // int A = 10;
        // int B = --A;
        // System.out.println(A);
        // System.out.println(B);

        // int A = 10;
        // int B = ++A;
        // System.out.println(A);
        // System.out.println(B);

        // System.out.println("Addition= " + (A+B));
        // System.out.println("Subtraction= " + (A-B));
        // System.out.println("Multiplication= " + (A*B));
        // System.out.println("Division= " + (A/B));
        // System.out.println("Modulus= " + (A%B));

        // int a = 15;
        // int b = 10;
        // System.out.println("Greater than: " + (a <= b));

        // int x = 2, y = 5;

        // int exp1 = (x * y / x);
        // int exp2 = (x * (y / x));

        // System.out.print(exp1 + ",");
        // System.out.print(exp2);

        // int x = 200, y = 50, z = 100;
        // if(x > y && y > z){
        //     System.out.println("Hello");
        //     }
        //     if(z > y && z < x)
        //     {
        //         System.out.println("Java");
        //     }
        //     if((y+200) < x && (y+150) < z){
        //         System.out.print("Hello Java \n");
        //     }

        // int x, y, z;
        // x = y = z = 2;
        // x += y;
        // y -= z;
        // z /= (x + y);
        // System.out.println(x + " " + y + " " + z);

        // System.out.print("Enter your age: ");
        // Scanner sc = new Scanner(System.in);

        // int age = sc.nextInt();

        // if(age >= 18) {
        //     System.out.println("Adult: You can vote/drive. ");
        // }

        // if(age >= 13 && age <= 19) {
        //     System.out.println("Teenager");
        // }

        // else {
        //     System.out.println("Not adult: You can't vote/drive. ");
        // }

        //int A = 2, B = 1, C = 5;

        // if(A >= B && A >= C) {
        //     System.out.println("A is largest");
        // }
        // else if(B >= C) {
        //     System.out.println("B is largest");
        // }
        // else {
        //     System.out.println("C is largest");
        // }

    // System.out.print("Enter any number: ");
    // Scanner sc = new Scanner(System.in);

    // int num = sc.nextInt();

    // if( num % 2 == 0 ){
    //     System.out.println("Even");
    // }else{
    //     System.out.println("Odd");
    // }

    // int age = 19;

    // if(age >= 18) {
    //     System.out.println("Adult");
    // }
    // else if(age >= 13 && age <= 19) {
    //     System.out.println("Teenager");
    // }
    // else {
    //     System.out.println("Child");
    // }

//     System.out.println("Enter your income: ");
//     Scanner sc = new Scanner(System.in);

//     int income = sc.nextInt();
//     int tax;

//     if(income < 500000) {
//         tax = 0;
//     }
//     else if(income >= 500000 && income < 1000000){
//        tax = (int)(income * 0.2);
//     }

//     else{
//         tax = (int)(income * 0.3);
//     }

//     System.out.println("Your tax is " + tax);

    // int marks = 74;

    // String result = ((marks >= 33) ? "PASS" : "FAIL");

    // System.out.println(result);

    // int number = 2;

    // switch(number)
    // {
    //     case 1: System.out.println("Samosa");
    //     break;

    //     case 2: System.out.println("Burger");
    //     break;

    //     case 3: System.out.println("Maggie");
    //     break;

    //     default: System.out.println("It was a dream");
    // }

    // Scanner sc = new Scanner(System.in);

    // System.out.print("Enter a: ");
    // int a = sc.nextInt();
    // System.out.print("Enter b: ");
    // int b = sc.nextInt();
    // System.out.print("Enter operator of your choice: ");
    // char operator = sc.next().charAt(0);

    // switch(operator) {
    //     case '+': System.out.println("a + b = " + a+b);
    //                 break;
    //     case '-': System.out.println("a - b = " + a-b);
    //                 break;
    //     case '*': System.out.println("a * b = " + a*b);
    //                 break;
    //     case '/': System.out.println("a / b = " + a/b);
    //                 break;
    //     case '%': System.out.println("a % b = " + a%b);
    //                 break;
    //     default: System.out.println("Wrong Operator");
                    
    // }

//     }
// }