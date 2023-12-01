import java.util.* ;
public class day2{
    public static void main(String args[]){
        // long longVar = Long.MAX_VALUE;
        // System.out.println(longVar);
        // System.out.println(longVar);
        // double doubleVar = (double)longVar;
        // //to store numbers larger than long , we could use double.
        
        
        
        
        
        // //hw--> learn how double and long store value.(49:00)





        // int x=10 , y=100;
        // System.out.println(x=y);
        // System.out.println(x==y);
        // "=" is assignment operator , "==" is for comparison.
        //"a==b"--> if a is equal to b. 

        // boolean f = 0; //int cant be converted to boolean. incompatible type. explicit typecasting is also not possible.
        // boolean f = "false"; //same as above. even overflow cannot happen.
        // System.out.println(f);





        //"==" "<" ">" "=<" ">=" "!="
        //System.out.println(10>8);
        // System.out.println(10>=8 + 2<7);//presidence not known so use brackets.
        // System.out.println((10>=8) + (2<7));//cannot concatanate 2 booleans using +.
        //System.out.println((10>=8) +" "+ (2<7));//strings can concatenate anything!



        //logical operators.  
        // &&-->and 
        // ||-->or
        
        //Q.write an function which gives true only when both inputs are false. f , f, f, t(f,f)
        //ANS.   !(a||b)
        
        
        
        //hw---->build it using and operator.



        //check if a is the largest number or not. 
        //int a=10 , b=3, c=8 , d=12; 
        // System.out.println((a>b) && (a>c) && (a>d));//always move from left to right.
        // System.out.println((a>b) || (a>c) && (a>d));//t || t ||f--> t || f -->f
        //System.out.println((a>b) || ((a=b)==3) );
        //precedence of && and || is same , hence operation happens from left to right.
        





        //  taking inputs.
         Scanner sc = new Scanner(System.in);
        // int input = sc.nextInt() ;
        // System.out.println(input);




        //Q. input 2 no.s and print true if a>b , else false
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println(a>b);



        //  if-else
        // if(boolean condtion){

        // }
        // else if(boolean condition){

        // }
        // else{

        // }
        
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // if(a>b){
        //     System.out.println("a is greater than b");
        // }else{
        //     System.out.println("a is less than or equal to b");
        // }
        


        // System.out.print("enter age:"); 
        // int age = sc.nextInt();
        // if(age>=18){
        //     System.out.println("eligible to vote");
        // }else{
        //     System.out.println("not eligible to vote");
        // }


        // System.out.print("enter an integer number:");
        // int num = sc.nextInt();
        // if(num%2 == 0){
        //     System.out.print("even");
        // }
        // else{
        //     System.out.println("odd");
        // }



        //System.out.print(-31%5);//"-1" is the wrong answer . remainder has to be +ve. since qd<D always and r=D-qd. to solve the issue , add divisor to final answer if remainder is negetive.
        


        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        if(num1>=num2 && num1>=num3){
            System.out.println("num1 is largest.");
        }else if(num2>=num3){
            System.out.println("num2 is largest");
        }else{
            System.out.println("num3 is largest");
        }

    }
}