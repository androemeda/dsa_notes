//count number of factors.
//do base change function.
//find remainder.
//hcf
//lcm

import java.lang.*;
import java.util.*;

public class calculator {

    static float sum(float x ,float y) {
        return x + y;
    }
    static float sub(float x , float y){
        return (x-y);
    }

    static float pow(float x , float y){
        for (int i = 1; i <y; i++) {
            x*=x;
        }
        return x;
    }

    static float div(float x , float y){
        return (x/y);
    }

    static float prod(float x , float y){
        return (x*y);
    }

    public static void main(String[] args) {
        int choice =0;
        float ans=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first number:");
        float num1 = sc.nextFloat();

        while(choice==0){
            System.out.print("enter operator(=,-,/,*,^,q):");
            char op = sc.next().charAt(0);
            if(op ==  'q'){
                break;
            }
            System.out.print("enter second number:");
            float num2 = sc.nextFloat();

            switch (op){
                case '+':
                    ans = sum(num1 , num2);
                    break;
                case '-':
                    ans = sub(num1 , num2);
                    break;
                case '/':
                    ans = div(num1 , num2);
                    break;
                case '*':
                    ans = prod(num1 , num2);
                    break;
                case '^':
                    ans = pow(num1 , num2);
                    break;
            }
            System.out.println("answer is:"+ans);
            num1 = ans;
        }
    }
}
