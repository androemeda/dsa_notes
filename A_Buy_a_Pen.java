import java.util.*;

public class A_Buy_a_Pen{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt() , g = sc.nextInt() , b = sc.nextInt();
        String c = sc.next();
        int ans = Integer.MAX_VALUE;
        if(!c.equals("Red")) ans = Math.min(ans , r);
        if(!c.equals("Green")) ans = Math.min(ans , g);
        if(!c.equals("Blue")) ans = Math.min(ans , b);
        System.out.println(ans);

    }
}