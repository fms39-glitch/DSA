import java.util.*;
public class Selection{
    public static int[] selection(int[] a){
        for(int i = 0; i<a.length - 1;i++){
            int maxIndex = 0;
            for(int j = 1; j<a.length - i; j++){
                if(a[j]>a[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = a[maxIndex];
            a[maxIndex] = a[a.length - i -1];
            a[a.length - i -1] = temp;
        }
        return a;
    }


    public static void main(String[] args){
        int[] a = {1,2,0};
        System.out.println(Arrays.toString(selection(a)));
    }
}