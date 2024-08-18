import java.util.*;
public class C_Make_Them_Narrow{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() , k = sc.nextInt();

        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;

        for(int i=0 ; i<=k ; i++){
            ans = Math.min(ans , nums[nums.length-1-(k-i)] - nums[i]);
        }
        
        if(k+1 == n) System.out.println(0);
        else System.out.println(ans);
    }
}