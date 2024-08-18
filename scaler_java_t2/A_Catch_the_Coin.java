import java.util.*;
class A_Catch_The_Coin{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] nums = new int[n][2];
        for(int i=0 ; i<n ; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        for(int i=0 ; i<n ; i++){
            if(nums[i][1] >= -1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}