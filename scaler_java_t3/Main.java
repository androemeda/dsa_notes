import java.util.*;

class Main{

    public static int subarraySumsII(int[] arr , int k){

        HashMap<Integer , Integer> map = new HashMap<>();

        int ans = 0;

        for(int i=1 ; i<arr.length ; i++){
            arr[i] += arr[i-1];
        }

        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == k){
                ans++;
            }
            if(map.containsKey(arr[i] - k)) ans += map.get(arr[i] - k);
            if(!map.containsKey(arr[i])) map.put(arr[i] , 0);
            map.put(arr[i] , map.get(arr[i])+1);
        }

        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() , k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(subarraySumsII(arr , k));
    }
}