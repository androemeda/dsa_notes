import java.util.ArrayList;
import java.util.Scanner;

//given an arraylist and a number k , return the count of pairs such that A[i]+A[j]=k(i!=j)
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("number of elements: ");
        int n = sc.nextInt();
        System.out.println("elements: ");
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            arr.add(input);
        }
        System.out.print("target: ");
        int target = sc.nextInt();
//        int count =0;
//        for (int i = 0; i < arr.size(); i++) {         //n*(n-1)/2 iterations ~ n^2
//            for (int j = i+1; j < arr.size(); j++) {
//                if(arr.get(i)+arr.get(j)==target){
//                    count++;
//                }
//            }
//        }

        
    }
}
