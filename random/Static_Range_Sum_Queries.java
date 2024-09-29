import java.util.*;
class Static_Range_Sum_Queries{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1 ; i<n ; i++){
            arr[i] += arr[i-1];
        }

        int[][] queries = new int[q][2];
        for(int i=0 ; i<q ; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();

            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 1){
                System.out.println(arr[right-1]);
            }else{
                System.out.println(arr[right-1] - arr[left-2]);
            }
        }

    }
}