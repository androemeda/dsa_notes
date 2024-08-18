import java.util.*;

public class B_Right_Triangle{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int xa = sc.nextInt() , ya = sc.nextInt();
        int xb = sc.nextInt() , yb = sc.nextInt();
        int xc = sc.nextInt() , yc = sc.nextInt();

        int[] sides = new int[3];

        sides[0] = (xa - xb) * (xa - xb) + (ya - yb) * (ya - yb);
        sides[1] = (xb - xc) * (xb - xc) + (yb - yc) * (yb - yc);
        sides[2] = (xc - xa) * (xc - xa) + (yc - ya) * (yc - ya);

        Arrays.sort(sides);

        if(sides[0] + sides[1] == sides[2]){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}