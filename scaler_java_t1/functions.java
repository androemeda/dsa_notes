import java.lang.*;
import java.util.*;

public class Main {
    static int root(int n){
        int ans = 1;
        for (int i = 1; i <n ; i++) {
            if(i*i==n){
                ans = i;
            }
        }
        return ans;
    }
//    static int sum(int a , int b){
//        return (a+b);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        //Q. function to calculate sum.
//        int y= sc.nextInt();
//        int x= sc.nextInt();
//        int s = sum(x , y);
//        System.out.println(sum(x , y));


        //last in first out while evaluating functions inside functions.
        //function if not void , should ALWAYS return something.



        //Q. take a perfect square as input ans return its sq root.
        int n = sc.nextInt();
        System.out.println(root(n));
    }
}
