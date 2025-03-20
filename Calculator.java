import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter operator of your choice: ");
        char operator = sc.next().charAt(0);

        switch(operator) {
            case '+': System.out.println("a + b = " + (a + b)); 
                        break;
            case '-': System.out.println("a - b = " + (a - b)); 
                        break;
            case '*': System.out.println("a * b = " + (a * b)); 
                        break;
            case '/': 
                if (b != 0) {
                    System.out.println("a / b = " + (a / b));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            case '%': System.out.println("a % b = " + (a % b)); 
                        break;
            default: System.out.println("Wrong Operator");
        }

        sc.close(); // Close the scanner
    }
}
