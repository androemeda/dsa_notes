//  --HW--  for finding root n, reduce number of iterations from root n to log(n).



//Q. write a function that takes 10 numbers and return average.
// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
//     static double avg(double n1 ,double n2 , double n3, double n4 , double n5 , double n6, double n7, double n8, double n9 , double n10 ){
//         double average=0;
//         average = (n1+n2+n3+n4+n5+n6+n7+n8+n9+n10)/10;
//         return average;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n1 = sc.nextInt();
//         int n2 = sc.nextInt();
//         int n3 = sc.nextInt();
//         int n4 = sc.nextInt();
//         int n5 = sc.nextInt();
//         int n6 = sc.nextInt();
//         int n7 = sc.nextInt();
//         int n8 = sc.nextInt();
//         int n9 = sc.nextInt();
//         int n10 = sc.nextInt();
//         System.out.println(avg(n1 , n2 , n3 , n4 , n5 , n6 , n7 , n8 , n9, n10));

//     }
// }






/*--ARRAYS--
datatype[] arrayName = new datatype[size];
or
datatype arrayName[] = new datatype[size];
*/







//Q. solve above question using arrays.
// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
//     static int sum(int[] arr){
//         int sum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             sum += arr[i];
//         }
//         return sum;
//     }
//     static double avg(int[] marks){
//         int sum = sum(marks);
//         return (sum/10.0);
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] marks = new int[10];
//         for (int i = 0; i < 10; i++) {
//             marks[i] = sc.nextInt();
//         }
//         System.out.println(avg(marks));
//     }
// }






//Q. implement a function that takes an integer array and a target value and returns true if target is present in array and false if not.
// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
//     static boolean search(int[] arr ,int target){
//         for(int i=0 ; i< arr.length; i++){
//             if(arr[i]==target){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("size of array: ");
//         int size = sc.nextInt();
//         System.out.println("enter elements:");
//         int[] arr = new int[size];
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = sc.nextInt();
//         }
//         System.out.print("target: ");
//         int target = sc.nextInt();
//         System.out.println(search(arr , target));
//     }
// }









//Q. implement a function to return frequency of target in an array.
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int search(int[] arr ,int target){
        int count = 0;
        for(int i=0 ; i< arr.length; i++){
            if(arr[i]==target){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size of array: ");
        int size = sc.nextInt();
        System.out.println("enter elements:");
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("target: ");
        int target = sc.nextInt();
        System.out.println(search(arr , target));
    }
}