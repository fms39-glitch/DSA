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
    public static int binarytoDecimal(String a){
        if (a.length() == 0){
            return 0;
        }

        else{
            int dig = a.charAt(0) - '0';
            return dig * (int)Math.pow(2, a.length() -1) + binarytoDecimal(a.substring(1));
        }

    }

    //9th 8.3.2 Largext num in an Array the index is defaulted to the numbers.length - 1
    public static int largest(int[] numbers, int index) {
		if (index == 0) {
			return numbers[0];
		}
		return Math.max(numbers[index], largest(numbers, index-1));
	}

//eg. {1,2,3}; index = 1
    //10th Problem Summing the array
    public static int sumArray(int[] array, int index){
        if(index == array.length){
            return 0;
        }
        else{
            return array[index] + sumArray(array, index+1);
        }
    }

    // 11th 8.3.3 Multiply
    public static int multiply(int x, int y) {
		if (x == 0) {
			return 0;
		}
		else {
			return multiply(x-1, y) + y;
		}
	}

    //12th 8.3.4 GCD 
    public static int GCD(int x, int y) {
		if(y == 0) {
			return x;
		}
		
		else {
			return GCD(y, x%y);
		}
	}

    //13th 8.3.5 Log problem
    public static int log(int base, int num) {
		if(num <= 1) {
			return 0;
		}
		return 1+log(base,num/base);
	}

    //14th 8.3.6 Sum to K problem
    public static int sumtok(int k) {
		if(k <= 0) {
			return 0;
		}
		else {
			return k+sumtok(k-1);
		}
	}

    //15th 8.5.1 minimum element in an Array.
	public static int recursiveMin(int[] numbers, int startIndex) {
		if (startIndex == numbers.length - 1) {
			return numbers[startIndex];
		}
		return Math.min(numbers[startIndex], recursiveMin(numbers, startIndex + 1));
	}

    //16th 8.5.3 decimal to binary
	
	public static String decToBinary(int num) {
		
		if (num < 2) {
			return Integer.toString(num);
		}
		return decToBinary(num/2) + num%2;
	}




    // --- Solved 6 leet code problems ---
        // 509. Fibonnacci (easy recursive)
        // 231. Power of Two (easy recursive)
        // 326. Power of Three (easy recursive)
        // 342. power of Four (easy  recursive)
        //  50. Pow(x, n) (medium)
        //2094. Finding 3-Digit Even Numbers (Easy) (non recursively)



    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(Factorial(5));
        System.out.println(Fibonacci(4));
        System.out.println(power(5, 3));
        System.out.println(sumDigits(12345));
        System.out.println(revString("12345"));
        System.out.println(revString("Faizan"));
        System.out.println(isPalindrome("Racecar"));
        System.out.println(binarytoDecimal("1000"));
        System.out.println(sumArray(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(largest(new int[] {8,2,2}, 2));
		System.out.println(largest(new int[] {8,2,9}, 2));
        System.out.println(multiply(6, 6));
		System.out.println(multiply(2, 6));
        System.out.println(GCD(9, 81));
		System.out.println(GCD(36, 6));
        System.out.println(log(10,100));
		System.out.println(log(2,4));
        System.out.println(sumtok(5));
		System.out.println(sumtok(10));
        System.out.println(recursiveMin(new int[] {2, 4, 8}, 0));
		System.out.println(recursiveMin(new int[] {233,201,110}, 0));
        System.out.println(decToBinary(13));
		System.out.println(decToBinary(63));

    }
}