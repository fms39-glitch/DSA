import java.util.*;
public class Bubble {
    public static int[] bubble(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {

                if (a[j-1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a; // Fixed: Added the missing return statement
    }

    public static void main(String args[]){
        int[] a = {3,2,1};
        System.out.println(Arrays.toString(bubble(a)));
    }
}