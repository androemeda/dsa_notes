import java.util.*;
class A_Only_Pluses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int maxProduct = 0;
            
            for (int i = 0; i <= 5; i++) {
                for (int j = 0; j <= 5 - i; j++) {
                    int k = 5 - i - j;
                    int newA = a + i;
                    int newB = b + j;
                    int newC = c + k;
                    int product = newA * newB * newC;
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
            System.out.println(maxProduct);
            t--;
        }
    }
}