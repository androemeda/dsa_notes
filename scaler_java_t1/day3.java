import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        //FIZZ-BUZZ QUESTION.

        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        if(n%3==0 && n%15 !=0){
//            System.out.println("Fizz");
//        }else if(n%5==0 && n%15 !=0){
//            System.out.println("Buzz");
//        }else if(n%3==0 && n%5==0){
//            System.out.println("Fizz-Buzz");
//        }

//        System.out.println("do you want to adopt a dog?(yes/no)");
//        String q1 = sc.next();

//        //next() takes word until space is printed. nextLine() takes entire line as input.

//        if(q1.equals("yes")){
//            System.out.println("what kind of dog do you want?(pet/wild)");
//            String q2 = sc.next();
//            if(q2.equals("pet")){
//                System.out.println("what breed do you want?(original/cross)");
//                String q3 = sc.next();
//                if(q3.equals("original")){
//                    System.out.println("thanks . we recommend u dodA");
//                }else{
//                    System.out.println("thanks . we recommend dogB");
//                }
//            }else{
//                System.out.println("what breed do you want?(original/cross)");
//                String q3 = sc.next();
//                if(q3.equals("original")){
//                    System.out.println("thanks . we recommend u dodC");
//                }else{
//                    System.out.println("thanks . we recommend dogD");
//                }
//            }
//        }else{
//            System.out.println("ok thank you. contact us whenever you want to.");
//        }








        //WHIILE LOOP.


        //Q.print values from 1 to 10.
//        int a = 1;
//        while(a<=10){
//            //if condition inside is always true , it will keep printing numbers till largest possible value of integer. after that it will overflow(become -ve largest) then keep incrementing and again become zero and keep running in this loop.
//            System.out.println(a);
//            a+=1;
//        }


//        try doing while(false)
//            while(a>10). a=11
//            if(false)
//            if(a>10) . a=11
//            while/if(-empty-).


//        int key = sc.nextInt();
//        int x = 0;
//        while(x != key){
//            x += 1;
//        }
//        System.out.println("key number is "+x);

        //Q.print all even numbers from 1 to 100.
//        int a = 2;
//        while(a<=100){
//            System.out.println(a);
//            a +=2;
//        }

        // Q.print all numbers betweeen 2 integers a and b.
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        if(a%2==0){
//            while(a<=b){
//                System.out.println(a);
//                a+=2;
//            }
//        }else{
//            while(a<=b){
//                System.out.println(a+1);
//                a+=2;
//            }
//        }

        //optimal code is the one which goes through lesser loops

        //Q. sum of all odd numbers between two given numbers a and b.
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int sum = 0;
//        if (a % 2 == 0) {
//            a+=1;
//        }
//        while(a<=b){
//            sum += a;
//            a +=2 ;
//        }
//        System.out.println(sum);




        //Q.print all digits of a given number in new line.
//        int n = sc.nextInt();
//        while(n>0){
//            System.out.println(n%10);
//            n=n/10;
//        }






        //FOR LOOP.


        //Q.print from 1 to 100.
//        for(int i =1; i<=100; i++){
//            System.out.println(i);
//        }


        //Q. find all factors of a given nnumber.
        // int n = sc.nextInt();
        // int a=0;
        // for(int i=1 ; i<=n/2; i++){
        //     if(n%i==0){
        //         System.out.println(i);
        //         a+=1;
        //     }
        // }
        // System.out.println(n);
        // System.out.println("number of factors are "+(a+1));
    }
}