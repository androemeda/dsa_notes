import java.util.*;

class Exponentiation{

    static int mod = 1000000007;

    public static long expo(long a, long b){
        if(b == 0){
            return 1l;
        }
        if(b == 1){ 
            return (a*1l)%mod;
        }
        if(b % 2 == 0){
            long ans = expo(a, b/2);
            return ((ans%mod) * (ans%mod))%mod;
        }
        else{
            long ans = expo(a, b/2);
            return (((ans%mod) * (ans%mod))%mod * (a%mod))%mod;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n > 0){

            int a = sc.nextInt();
            int b = sc.nextInt();

            long ans = expo(a*1l , b*1l);

            System.out.println(ans%mod);

            n--;
        }
    }
}

/* 
brute force - o(b)

taking half --> tc = o(logb)

 */