public class Optimizations{

    /*
    you are given a string with lowercase english letters.calculate and return number of pairs (i,j) such that , 
    S.charAt(i)='a' and s.charAt(j)='g' and i<j. 
    ex: "a b c g a g" => 3 
    (0,3),(0,5),(4,5)
    */
   //unoptimized. O(n^2) . SC(1)
    public static int countAGPairs(String S){
        int count = 0;
        for(int i=0 ; i<S.length() ; i++){
            if(S.charAt(i)=='g'){
                for(int j=0 ; j<i ; j++){
                    if(S.charAt(j)=='a'){
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    //optimized. O(n) . SC(1)
    public static int countAGPairsOptimized(String S){
        int ans = 0;
        int gCount = 0; //instead of keeping a count of g's from back , we can also mantain count of a's from the start.
        for(int i=S.length()-1 ; i>=0 ; i--){
            if(S.charAt(i)=='a'){
                ans += gCount ;
            }
            if(S.charAt(i)=='g'){
                gCount++;
            }
        }
        return ans;
    }

    /* 
     given an integer array A containing N distinct integers , you have to find all the leaders in array A .
     (leader is greater than all the elements before it.) 
     ex: A[3,5,1,7,9,12,45,6,2] : ans=6
     */

    //unoptimized. O(n^2) . SC(1) .
    public static int countLeaders(int[] A){
        int ans = 1;
        boolean leader = true;
        for(int i =1 ; i<A.length ; i++){
            leader = true;
            for(int j = 0 ; j<i ; j++){
                if(A[i]<A[j]){
                    leader = false;
                    break;
                }
            }
            if(leader){
                ans++;
            }
        }
        return ans;
    }

    //optimized. O(n) . SC(1) .
    public static int countLeadersOptimized(int[] A){
        int ans = 0;
        int currentLeader = Integer.MIN_VALUE ;
        for(int i=0 ; i<A.length ; i++){
            if(A[i]>currentLeader){
                ans++;
                currentLeader = A[i];
            }
        }
        return ans;
    } 

    /* 
    Amazon , MicroSoft , Adobe
    a wire connects N light bulbs.
    each bulb has a switch associated with it, however due to faulty wiring , 
    a switch also changes the state of all the bulbs to the right of the current bulb. 
    1-->ON , 0-->OFF 
    return the count of times we press the switch to turn all bulbs on.
    ex: [1 0 1 0 1 1 1 0 0] ans: 5 
    */

    public static int switchCount(int[] A){
        int switchPressCount = 0;
        for(int i=0 ; i<A.length ; i++){
            if(switchPressCount%2==0){
                if(A[i]==0){
                    switchPressCount++; //switch is being presses even no of times so present state remains unchanged.
                }
            }else{
                if(A[i]==1){
                    switchPressCount++; //switch is being pressed odd no of times so present state will be altered.
                }
            }
        }
        return switchPressCount;
    }

    public static void main(String[] args){


        // System.out.println("unoptimized: "+countAGPairs("abcgag"));
        // System.out.println("optimized: "+countAGPairsOptimized("abcgag"));


        // int[] arr = {3,5,1,7,9,12,45,6,2} ;
        // System.out.println(countLeaders(arr));
        // System.out.println(countLeadersOptimized(arr));


        // int[] arr = {1,0,1,0,1,1,1,0,0};
        // System.out.println(switchCount(arr));

    }
}