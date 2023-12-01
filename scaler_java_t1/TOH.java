import java.util.*;

public class TOH {

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    static int count = 0;

    public static void toh(int A , int s , int a , int d){
        if(A==0) return;
        toh(A-1 , 1 , 3 , 2);
        //move Ath from 1 to 3 manually.
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(A);
        list.add(s);
        list.add(d);
        ans.add(list);
        count++;
        toh(A-1 , 2 , 1 , 3);
    }

    public static void main(String[] args) {
        int A=3;
        toh(A , 1 , 2 , 3) ;
        System.out.println(ans);
    }
}