//Summming up the numbers from 1 to n using recursion
public class Recursion{
    
    //1st summing numbers
    public static int sum(int a){
        if (a == 1){
            return 1;
        }
        else{
            return a + sum(a-1);
        }
    }

    //2nd factorial
    public static int Factorial(int a){
        if (a == 0){
            return 1;
        }
        else{
            return a * Factorial(a-1);
        }
    }

    //3rd Fibonacci Numbers
    public static int Fibonacci(int a){
        if (a == 0){
            return 0;
        }
        else if (a == 1){
            return 1;
        }
        else{
            return Fibonacci(a-1) + Fibonacci(a-2);
        }
    }

    //4th power
    public static int power(int base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        else{
            return base * power(base, exponent-1);
        }
    }

    //5th Sum Digits
    public static int sumDigits(int a){
        if(a == 0){
            return 0;
        }
        else{
            return a%10 + sumDigits(a/10);
        }
    }

    //6th reversing a String
    public static String revString(String a){
        if (a == null){
            return "Enter a valid string";
        }
        if (a.length() <= 1){
            return a;
        }
        else{
            return a.charAt(a.length() - 1) + revString(a.substring(0, a.length()-1));
        }
    }
    
    //7th Palindrome
    public static boolean isPalindrome(String a){
        if (a == null){
            return false;
        }

        a = a.toLowerCase();

        if (a.length() <= 1){
            return true;
        }
        if (a.charAt(0) != a.charAt(a.length() - 1)){
            return false;
        }
        else {
            return isPalindrome(a.substring(1, a.length() - 1));
        }
    }

    //8th Problem BinarytoDecimal
    //public static int binarytoDecimal(){

    //}



    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(Factorial(5));
        System.out.println(Fibonacci(4));
        System.out.println(power(5, 3));
        System.out.println(sumDigits(12345));
        System.out.println(revString("12345"));
        System.out.println(revString("Faizan"));
        System.out.println(isPalindrome("Racecar"));

    }
}