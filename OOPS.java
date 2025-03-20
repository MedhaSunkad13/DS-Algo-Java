// import java.util.*;

// public class OOPS {

//     public static void main(String[] args) {
//         // Pen p1 = new Pen(); //Created a pen object called p1. (constructor)
        // p1.setColor("Blue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // p1.setColor("Pink");
        // System.out.println(p1.getColor());

        // Student s1 = new Student();
        // s1.name = "Medha";
        // s1.rollNo = 494;
        // s1.password = "abcdef";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;

        // Student s2 = new Student(s1); //copy
        // s1.marks[2] = 92;
        // s2.password = "xyz";

        // for(int i = 0; i < 3; i++) {
        //     System.out.println(s2.marks[i]);
        // }

        // Fish shark = new Fish();
        // shark.eat();

        //Dog duggu = new Dog();
        // duggu.legs = 4;
        // duggu.eat();
        // duggu.bark();
        // System.out.println(duggu.legs);

        //Peacock peaku = new Peacock();
        //peaku.breathe();
        //peaku.fly();

        // Calculator calc = new Calculator();
        // System.out.println(calc.add(2, 3));
        // System.out.println(calc.add(3, 9, 2));
        // System.out.println(calc.add(4.5, 2.4));

        // System.out.println(s1.name);
        // Student s2 = new Student(21);
        // System.out.println(s2.rollNo);
        // Student s3 = new Student();

        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // Hen hen = new Hen();
        // hen.eat();
        // hen.walk();
        // System.out.println(hen.color);

        // Queen q = new Queen();
        // q.moves();

        // Student s1 = new Student();
        // s1.schoolName = "PGHS";

        // Student s2 = new Student();
        // System.out.println(s2.schoolName);

//         Horse h = new Horse();
//         System.out.println( h.color );

//         // BankAccount myAcnt = new BankAccount();
//         // myAcnt.username = "Medhasunkad";
//         // myAcnt.setPassword("abcdefghijk");

//         //Scanner scn = new Scanner(System.in);
//     }
// }


// // class BankAccount {
// //    private String password;
// //    public String username;
// //    public void setPassword(String pswd) {
// //     password = pswd;
// //    }
// // }

// // class Pen {
//     private String color;
//     private int tip;

//     String getColor() {
//         return this.color;
//     }

//     int getTip() {
//         return this.tip;
//     }

//     void setColor(String newColor) {
//         this.color = newColor;
//     }

    // void setTip(int tip) {
    //     this.tip = tip;
//     }
// }

// class Student {
//     String name;
//     int rollNo;
//     String password;
//     int marks[];

//    //Shallow Copy Constructor
//     // Student(Student s1) {
//     //     marks = new int[3];
//     //     this.name = s1.name;
//     //     this.rollNo = s1.rollNo;
//     //     this.marks = s1.marks;
//     // }

//     //Deep Copy Constructor
//     Student(Student s1) {
//         marks = new int[3];
//         this.name = s1.name;
//         this.rollNo = s1.rollNo;
//         for(int i = 0; i < marks.length; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }

//     Student(String name) { //Parameterized
//         this.name = name;
//         marks = new int[3];
//     }

//     Student(int rollNo) {
//         this.rollNo = rollNo;
//         marks = new int[3];
//     }

//     Student() { //Non-Parameterized
//         System.out.println("Constructor is being called...");
//         marks = new int[3];
//     }
// }

//Base Class
// class Animal {
//     String color;

//     void eat() {
//         System.out.println("Eats");
//     }

//     void breathe() {
//         System.out.println("Breathes");
//     }
// }

//Derived Class
// class Fish extends Animal {
//     int fins;

//     void swim() {
//         System.out.println("Swims under water.");
//     }
// }

// class Mammal extends Animal {
//     int legs;

//     void walk() {
//         System.out.println("Walks..");
//     }
// }

// class Fish extends Animal {
//     void swim () {
//         System.out.println("Swims");
//     }
// }

// class Shark extends Fish{
//     void electroreception () {
//         System.out.println("Detection of electric fields");
//     }
// }

// class Bird extends Animal {
//     void fly() {
//         System.out.println("Flies");
//     }
// }

// class Peacock extends Bird {
    // void dance() {
    //     System.out.println("Dances");
    // }
// }

// class Dog extends Mammal {
//     String breed;
//     void bark() {
//         System.out.println("Bow Bow");
//     }
// }

//Method Overloading
// class Calculator {
    // public static int add(int a, int b) {
    //     return a + b;
    // }

    // public static int add(int a, int b, int c) {
    //     return a + b + c;
    // }

    // public static double add(double a, double b) {
    //     return a +  b;
    // }
// }

//Method Overriding 
// class Animal {
//     void eat() {
//         System.out.println("Eats anything");
//     }
// }

// class Dog {
//     void eat() {
//         System.out.println("Eats Bone");
//     }
// }

//Abstract classes
// abstract class Animal {
//     String color;

//     Animal() {
//         System.out.println("Animal constructor called..");
//         color = "Brown";
//     }
 
//     void eat() {
//         System.out.println("Animal eats");
//     }

//     abstract void walk();
// }

// class Horse extends Animal {
//     void changeColor() {
//         color = "Dark brown";
//     }

//     void walk() {
//         System.out.println("Walks on 4 legs");
//     }
// }

// class Hen extends Animal {
//      void changeColor() {
//         color = "Dark Red";
//     }

//     void walk() {
//         System.out.println("Walks on 2 legs");
//     }
// }

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("Up, down, left, right, diagonal -(in all 4 dirns)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("Up, down, left, right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("Up, down, left, right, diagonal -(by one step)");
    }
}

//Static keyword
class Student {
    String name;
    int rollNo;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

class Animal {
    String color;

    Animal() {
        System.out.println("Animal constructor is called.");
    }
}

class Horse extends Animal {
    Horse() {
        super.color = "White";
        System.out.println("Horse constructor is called.");
    }
}
