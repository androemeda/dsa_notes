import java.util.*;
public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while(t > 0){

            int n = sc.nextInt();

            int[] movie1 = new int[n];
            for(int i=0 ; i<n ; i++){
                movie1[i] = sc.nextInt();
            }

            int[] movie2 = new int[n];
            for(int i=0 ; i<n ; i++){
                movie2[i] = sc.nextInt();
            }

            t--;
        }
    }
}