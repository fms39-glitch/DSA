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
        else if(exponent == 1){
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



    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(Factorial(5));
        System.out.println(Fibonacci(4));
        System.out.println(power(5, 3));
        System.out.println(sumDigits(12345));

    }
}