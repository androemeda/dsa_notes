import java.util.Arrays;
import java.util.Scanner;

//Q. do prime factorization of a given number and count them.
public class primeFactorisation{


    //product of all elements of array.
    static int prod(int[] arr){
        int product = 1;
        for(int i=0 ; i<arr.length ; i++){
            product  *= arr[i];
        }
        return product;
    }


    static int operation(int[] arr ,int p){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr[i+1]){
                index = i;
                break;
            }
        }
        int arri = arr[index];
        arr[index] = arr[index+1];
        int p1 = prod(arr);
        int ans1 = Math.abs(p-p1);

        arr[index] = arri;
        arr[index+1] = arri;
        int p2 = prod(arr);
        int ans2 = Math.abs(p-p2);

        if(ans1>=ans2){
            return p2;
        }else{
            return p1;
        }
    }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int[] arr = new int[100];

        for (int i = 2; i <=n ; i++){
            if(n%i==0){
                //System.out.println(i);
                n /= i;
                arr[count] = i;
                i=1;
                count++;
            }
        }
        System.out.println("number of prime factors are: "+count );
        int[] arr2 = new int[count] ;
        for (int i = 0; i < count; i++) {
            arr2[i] = arr[i];
        }
        System.out.println(Arrays.toString(arr2));
        int p = prod(arr2);
        System.out.println(operation(arr2 , p));
    }
}
/*
lowest ---> lowest+1
lowest+1 ---> lowest
*/