import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        String vowels = "aeiou"; 
        
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt(); 
            
            int min = n / 5; 
            int extra = n % 5;

            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            StringBuilder s3 = new StringBuilder();
            StringBuilder s4 = new StringBuilder();
            StringBuilder s5 = new StringBuilder();

            StringBuilder[] arr = {s1, s2, s3, s4, s5};

            for (int i = 0; i < min; i++) {
                s1.append("a");
                s2.append("e");
                s3.append("i");
                s4.append("o");
                s5.append("u");
            }

            for (int i = 0; i < extra; i++) {
                arr[i].append(vowels.charAt(i));
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder sb : arr) {
                result.append(sb);
            }

            System.out.println(result.toString());
        }
    }
}
