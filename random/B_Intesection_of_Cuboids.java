import java.util.Scanner;

class B_Intersection_of_Cuboids {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();
        int g = sc.nextInt(), h = sc.nextInt(), i = sc.nextInt();
        int j = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt();

        boolean x = (a >= g && a <= j) || (d >= g && d <= j);
        boolean y = (b >= h && b <= k) || (e >= h && e <= k);
        boolean z = (c >= i && c <= l) || (f >= i && f <= l);

        if(x && y && z) System.out.println("Yes");
        else System.out.println("No");
    }
}
