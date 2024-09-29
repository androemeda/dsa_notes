import java.util.*;

class B_1_The_Strict_Teacher_Easy_Version{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while(tc-- > 0){

            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();

            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            int david = sc.nextInt();

            if(t1 == david || t2 == david) System.out.println(0);

            else if(t1 > david && t2 > david){
                int t = Math.min(t1 , t2);
                int ans = t-1;
                System.out.println(ans);
            }

            else if(t1 < david && t2 < david){
                int t = Math.max(t1 , t2);
                int ans = n-t;
                System.out.println(ans);
            }

            else{
                int mid = (t1+t2)/2;
                int ans = Math.min(Math.abs(t1-mid) , Math.abs(t2-mid));
                System.out.println(ans);
            }

        }
    }
}

/**
 * 
 * 
                int places = Math.abs(t2-t1-1);
                int ans = places/2;
                if(places%2 == 1) ans++;
                System.out.println(ans);

 */