import java.util.*;

public class Recursion3{
    static int stepCount = 0;

    //tower of hanoi. --> moves A disks at top from source to destination using the auxiliary. 
    public static void towerOfHanoi(int A , String source , String auxiliary , String destination ){
        if(A==0) {return;}
        //doubt.
        //stepCount = Math.pow(2 , A-1);
        //System.out.println(stepCount+". move from "+source+" to "+destination+".");
        //why cant we do like this? assuming our function correctly prints the step count.
        towerOfHanoi(A-1 , source , destination , auxiliary) ;
        stepCount++;
        System.out.println(stepCount+". move from "+source+" to "+destination+".") ;
        towerOfHanoi(A-1 , auxiliary , source , destination );
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of disks: ");
        int disks = sc.nextInt();
        System.out.println(); 
        towerOfHanoi(disks , "A" , "B" , "C") ;
    }
}