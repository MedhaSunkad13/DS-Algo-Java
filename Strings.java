//import java.util.*;
import java.util.Arrays;

public class Strings {

    public static void printLetters(String str) {
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for(int i = 0; i < n/2; i++) {
            //Not a palindrome
            if(str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0, y = 0;

        for(int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

             //North   
            if(dir == 'N') {
                y++;
            }
            //South
            else if(dir == 'S') {
                y--;
            }
            else if(dir== 'W') {
                x--;
            }
            else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }

    public static String getSubString(String str, int si, int ei) {
        String subStr = " ";
        for(int i = si; i < ei; i++) {
            subStr += str.charAt(i);
        }
        return subStr;
    }

    public static String convertToUpperCase(String str) {
        StringBuilder sb = new StringBuilder(" ");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && i < str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString(); 
    }

    public static String compression(String str) {
        StringBuilder newStr = new StringBuilder(" ");

        for(int i = 0; i < str.length(); i++) {
            int cnt = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                cnt++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(cnt > 1) {
                newStr.append(cnt);
            }
        }
        return newStr.toString();
    }

    public static int countVowels(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i+=1) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean areAnagrams(String str1, String str2) {
        //Brute Force
        // for(int i = 0; i < str1.length(); i++) {
        //     for(int j = 0; j < str2.length(); j++) {
        //         if(str1.length() == str2.length() && str1.charAt(i) == str2.charAt(j)) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Optimized
         if (str1.length() != str2.length()) {
            return false;
        }

        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if(Arrays.equals(ch1, ch2)) {
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String args[]){

        //STRINGS are IMMUTABLE
        //Scanner sc = new Scanner(System.in);

        //String str = "HelloWorld";
        //Inbuilt string function
        //System.out.println(str.substring(0, 5));

        // String fruits[] = {"apple", "banana", "mango"};

        // String largest = fruits[0];
        // for(int i = 0; i < fruits.length; i++) {
        //     if(largest.compareTo(fruits[i]) < 0) {
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);

        //System.out.println(getSubString(str, 0, 5));

        //String name = sc.nextLine();
        //System.out.println("Your name is " +name+ " & Length = " +name.length());

        // String str = "MedhaDidi";
        // String str1 = "SigmaCourse";
        // String str2 = "MedhaDidi";
        // System.out.println(str.equals(str1) +" " +str.equals(str2));

        // String str3= "ApnaCollege".replace("l", " ");
        // System.out.println(str3);
        //System.out.println(fullName.charAt(3));
        //printLetters(fullName);

        // String str = "racecar";
        // System.out.println(isPalindrome(str));

        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // String s1 = "Tony";
        // String s2 = "Tony";
        // String s3 = new String("Tony");

        // if(s1 == s2) {
        //     System.out.println("Strings are equal");
        // }
        // else{
        //     System.out.println("Strings are not equal");
        // }

        // if(s1.equals(s3)) {
        //     System.out.println("Strings are equal");
        // }
        // else{
        //     System.out.println("Strings are not equal");
        // }

        // StringBuilder Sb = new StringBuilder(" ");
        // for(char ch = 'a'; ch <= 'z'; ch++) {
        //     Sb.append(ch);
        // }
        //abcdefghijklmnopqrstuvwxyz
        //System.out.println(Sb);

        //String str = "hi, i am medha";
        //System.out.print(convertToUpperCase(str));

        // String str = "aaabbcccdd";
        // System.out.println(compression(str));

        // String word = sc.nextLine();
        // System.out.print(countVowels(word));

        String str1 = "earth";
        String str2 = "heart";
        if(areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " +str2 + " are anagrams.");
        }
        else{
            System.out.println(str1 + " and " +str2 + "are not anagrams.");
        }
    }
}