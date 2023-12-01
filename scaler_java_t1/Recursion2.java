public class Recursion2{

    //Q.write a function to print all elements of the array from index i to last.
    public static void printArray(int[] A , int i){
        if(i==A.length) {System.out.println() ; return;}
        System.out.print(A[i]+" ");
        printArray(A , i+1);
    }

    //Q.write a function to give summation of digits of a number.
    /**
     * define function --> return sum of digits of x
     */
    public static int sumOfDigits(int A){
        if(A==0) return 0; //or if(A<10) return A;
        return (A%10)+sumOfDigits(A/10);
    }

    //Q.given a string. check if it is palindrome or not.
    //SC : O(N) (space occupied is N/2)
    public static boolean isPalindrome(String s , int i){
        if(i==s.length()-1-i || i>s.length()-1-i) return true;
        if(s.charAt(i)==s.charAt(s.length()-1-i)) return isPalindrome(s , i+1);
        return false;
    }

    //Q.find nth fibonacci number.
    //TC: O(2^N) . recurson makes this code highly unoptimal.
    //SC: O(N)
    public static int fibonacciNum(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacciNum(n-1)+fibonacciNum(n-2);
    }

    public static void main(String[] args){
    
        // int[] arr = {1,2,3,4,5};
        // printArray(arr , 0);
    
        // System.out.println(sumOfDigits(123));

        // System.out.println(isPalindrome("abba" , 0));

        System.out.println(fibonacciNum(5));//0 1 1 2 3 5
    }
}

/**
 * read about fibbonacci series and golden ratio.
 * 
 * how to find runtime in java.
 * compare tc for iterative and recursive code.
 */