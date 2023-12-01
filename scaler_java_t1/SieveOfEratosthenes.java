import java.util.*;

public class SieveOfEratosthenes{

    public static int arrayListProduct(ArrayList<Integer> arr){
        int product = 1;
        for(int i=0 ; i<arr.size() ; i++){
            product *= arr.get(i);
        }
        return product;
    }

    public static ArrayList<Integer> primeFactorsOfN(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2 ; i<=n ; i++){
            if(n%i==0){
                list.add(i);
                n /= i;
                i=1;
            }
        }
        return list;
    }

    public static int primeBefore(int n){
        if(n==2) return 4;        //return 4 , because i had to return any number greater than next prime of 2 , i.e. , 3. if not done so , the function will return wrong answer for even numbers.
        for(int i=n-1 ; i>=2 ; i--){
            if(primeFactorsOfN(i).size()==1){
                return i;
            }
        }
        return -1;
    }

    public static int primeAfter(int n){
        for(int i=n+1 ; i<Integer.MAX_VALUE ; i++){
            if(primeFactorsOfN(i).size()==1){
                return i;
            }
        }
        return -1;
    }

    public static int solve(int A) {
        int ans = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        ArrayList<Integer> primesFactors = primeFactorsOfN(A);
        System.out.println("factors: "+primesFactors+"\n");

        for(int i=0 ; i<primesFactors.size() ; i++){
            int temp = primesFactors.get(i);
            System.out.println("focus on: "+temp);

            int primeBefore = primeBefore(primesFactors.get(i));
            int primeAfter = primeAfter(primesFactors.get(i));
            System.out.println("prime before: "+primeBefore+"  prime after: "+primeAfter);

            primesFactors.set(i , primeBefore);
            int p1 = arrayListProduct(primesFactors);
            System.out.println("p1: "+p1);

            primesFactors.set(i , primeAfter);
            int p2 = arrayListProduct(primesFactors);
            System.out.println("p2: "+p2);

            primesFactors.set(i , temp);
            int p = arrayListProduct(primesFactors);

            if(Math.abs(p-p1)<minDiff){
                minDiff = Math.abs(p-p1);
                ans = p1;
            }
            if(Math.abs(p-p2)<=minDiff){
                minDiff = Math.abs(p-p2);
                ans = p2;
            }
            System.out.println("min diff: "+minDiff);
            System.out.println("current ans: "+ans);
            System.out.println("\n\n-------------------------------------------------");
        }
        System.out.println("final ans: "+ans);
        return ans;
    }

    public static void main(String[] args){
        System.out.println(solve(36));//12 36 8 24
    }

}


































































































// import java.util.*;

// class SieveOfEratosthenes{

//     public static ArrayList<Integer> primeFactorsOfN(int n){
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         for(int i=2 ; i<=n ; i++){
//             if(n%i==0){
//                 list.add(i);
//                 n /= i;
//                 i=1;
//             }
//         }
//         return list;
//     }

//     public static HashMap<Integer , Integer> primeFactorsTillN(int n){
//         HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
//         boolean[] arr = new boolean[n+1];

//         for(int i=0 ; i<=n ; i++){
//             arr[i]=true;
//         }

//         for(int i=2 ; i*i<=n ; i++){
//             if(arr[i]==true){
//                 for(int j=i*i ; j<=n ; j+=i){
//                     arr[j]=false;
//                 }
//             }
//         }

//         int count = 1;
//         for(int i=2 ; i<=n ; i++){
//             if(arr[i]==true){
//                 map.put(i , count);
//                 count++;
//             }
//         }

//         // printing key-value pairs from hash-map
//         for (Integer myKey: map.keySet()) {
//         String key = myKey.toString();
//         String value = map.get(myKey).toString();
//         System.out.println(key + " : " + value);
//         }

//         return map;
//     }

//     public static ArrayList<Float> primeBeforeAndAfter(int n){
//         ArrayList<Float> list = new ArrayList<Float>();
//         float nextPrime;
//         float previousPrime;

//         if(n==2){
//             list.add(2f);
//             list.add(3f);
//             return list;
//         }

//         for(float i=n-1 ; i>1 ; i--){
//             if(primeFactorsOfN((int)i).size()==1){
//                 previousPrime = i;
//                 list.add(previousPrime);
//                 break;
//             }
//         }

//         for(float i=n+1 ; ; i++){
//             if(primeFactorsOfN((int)i).size()==1){
//                 nextPrime = i;
//                 list.add(nextPrime);
//                 break;
//             }
//         }
//         return list;
//     }

//     public static int nearestSimilarNumber(int n){
//         float factor = 1; // next/previous prime factor divided by prime factor of that number.
//         float minFactor = 1;
//         ArrayList<Integer> primeFactors = primeFactorsOfN(n);
//         for(int i=0 ; i<primeFactors.size() ; i++){

//             float previousPrime = primeBeforeAndAfter(primeFactors.get(i)).get(0);
//             System.out.println("previous prime: "+previousPrime);

//             float nextPrime = primeBeforeAndAfter(primeFactors.get(i)).get(1);
//             System.out.println("next prime: "+nextPrime);

//             if(previousPrime==primeFactors.get(i)){
//                 factor = nextPrime/primeFactors.get(i);
//             }
//             else if(1-previousPrime/primeFactors.get(i) > nextPrime/primeFactors.get(i)-1 ){
//                 factor = nextPrime/primeFactors.get(i);
//             }else{
//                 factor = previousPrime/primeFactors.get(i);
//             }
//             System.out.println("factor: "+factor);

//             minFactor = Math.min(factor , minFactor);
//             System.out.println("minimum factor: "+minFactor);

//             System.out.println("\n\n--------------------------------------------");

//         }
//         int ans = (int)(Math.round(n*minFactor));
//         return ans;
//     }

//     public static void main(String[] args){
//         // primeFactorsTillN(100) ;
//         System.out.println("prime factors of 35: "+primeFactorsOfN(100)+"\n\n");
//         // System.out.println(primeBeforeAndAfter(5));
//         System.out.println(nearestSimilarNumber(100));
//     }
// }