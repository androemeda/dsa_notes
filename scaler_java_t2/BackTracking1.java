import java.util.*;

class BackTracking1{

    /**
     * Q.Give an array of positive numbers. you can pick any 2 numbers ,  add the the absolute difference to the array if not already present. determine the max size the array can acheive
     * 
     * whenever there is repeated - or / , think about gcd.
     * 
     * gcd(a,b,c) = gcd(gcd(a,b),c)
     * gcd(a,b) = gcd(b,a-b)
     * gcd(a,b,c) = gcd(gcd(b,a-b),c)
     * gcd(a,b,c) = gcd(a,b,c,|a-b|,|b-c|,|c-a|)
     * 
     * so , every number involved is a multiple of gcd
     */


    /**
     * Q. generate all N digit numbers using only {1 and 2}.
     * Ex: n=3 : 111,112,121,122,...222
     * produce them as list of digits like - <1,1,1>...
     */
    public static void generate(ArrayList<ArrayList<Integer>> ans , int n , ArrayList<Integer> list){

        if(list.size() == n){
            ans.add(new ArrayList(list));
            return;
        }

        list.add(1);
        generate(ans , n , list);
        list.remove(list.size()-1);
        list.add(2);
        generate(ans , n , list);
        list.remove(list.size()-1);
    }

    /**
     * Q.generate all sub-sequences of a given array.
     * 
     * done this question earlier using bit-manipulation. do using recursion now.
     * 
     * Ex : arr = [1,2,3] : ans = [],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
     * 
     * 2^n sub-sequences can be generated.
     * 
     * TC : n*(2^n) --> 2^n to create all sub-sequences and n to copy each list to a new list before appending to answer
     */


    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        generate(ans , 3 , list);

        System.out.println(ans);
    }
}

/**
 * bt vs greedy
 * bt - try every possibility
 * greedy - consider only maximum or minimum
 */

/**
 * TREE QUESTION SOLVED USING BACKTRACKING EARLIER (SOLVE AGAIN)
 * Q. find path having a specific sum.
 */