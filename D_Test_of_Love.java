import java.util.Scanner;

public class D_Test_of_Love {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            String a = scanner.nextLine();
            scanner.nextLine();

            if (canCrossRiver(n, m, k, a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        // scanner.close();
    }
    
    public static boolean canCrossRiver(int n, int m, int k, String a) {
        
        int pos = -1;
        int swimmed = 0;

        while(pos < n){
            int nextPos = pos;
            for(int i=pos+m ; i>=pos+1 ; i--){
                if(a.charAt(i) == 'L'){
                    nextPos = i;
                    continue;
                }
            }

            if(k-swimmed == 0) return false;

            for(int i=pos+1 ; i<=pos+k-swimmed ; i++){
                if(a.charAt(i) == 'C') return false;
                if(a.charAt(i) == 'L'){
                    nextPos = i;
                    continue;
                }
                swimmed++;
            }
        }

        return true;
    }
}
