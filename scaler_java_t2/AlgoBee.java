import java.util.*;
import java.io.*;
 
public class AlgoBee{

    static int power(int A, 
                       int B, int C) 
{ 
         
    // Base cases 
    if (A == 0) 
        return 0; 
    if (B == 0) 
        return 1; 
     
    // If B is even 
    long y; 
    if (B % 2 == 0)
    { 
        y = power(A, B / 2, C); 
        y = (y * y) % C; 
    } 
     
    // If B is odd 
    else
    { 
        y = A % C; 
        y = (y * power(A, B - 1, 
                             C) % C) % C; 
    } 
     
    return (int)((y + C) % C); 
} 

    static Long ans = 0l;
     
	public static void printDivisors(int n){ 
		for(int i=1;i<=n;i++){
			if(n%i==0){
				// System.out.print(i+" ");
                ans = (ans%1000000007 + power(i , 69 , 1000000007 ))%1000000007;
            }
        }
	} 

	public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        Long num = 1l;

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
            num *= arr[i];
        }

        System.out.println(num);

	} 
} 
