import java.util.*;
class B_Angry_Monk{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t > 0){

            int n = sc.nextInt() , k = sc.nextInt();

            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int ans = 0;

            for(int i=arr.length-2 ; i>=0 ; i--){
                int cuts = arr[i]-1;
                int parts = cuts+1;
                ans += cuts+parts;
            }

            System.out.println(ans);

            t--;
        }
    }
}