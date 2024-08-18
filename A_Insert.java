import java.util.*;

public class A_Insert{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() , k = sc.nextInt() , x = sc.nextInt() ;

        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }

        for(int i=0 ; i<n ; i++){
            System.out.print(nums[i]+" ");
            if(i+1 == k) System.out.print(x+" ");
        }
    }
}