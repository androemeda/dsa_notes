import java.util.*;

class Stacks3{

    public static void print(int[] A){
        for(int i=0 ; i<A.length ; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
 
    /**
     * GOOGLE,AMAZON,APPLE,FACEBOOK
     * Q. NEAREST SMALLER ELEMENT
     *    given an array of +ve integers. for every index i find the nearest smaller element(distance-wise) on the left of i [from 0 to i-1]
     * 
     * A[j]<A[i] and j is largest number smaller than i.
     * 
     * Ex: 4,2,5,10,8,2 : ans = -1,-1,2,5,5,-1
     * 
     * TC:O(N) SC:O(N)
     * 
     */
    public static int[] prevSmaller(int[] A) {

        int[] ans = new int[A.length];

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0 ; i<A.length ; i++){

            if(st.isEmpty()){
                ans[i] = -1;
                st.push(A[i]);
            }

            else if(A[i]>st.peek()){
                ans[i] = st.peek();
                st.push(A[i]);
            }

            else if(A[i] <= st.peek()){
                while(!st.isEmpty() && st.peek()>=A[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = st.peek();
                }

                st.push(A[i]);
            }
        } 

        return ans;
    }

    /**
     * Q. given an array of +ve integers. for every index i find the index of the nearest smaller element(distance-wise) on the left of i [from 0 to i-1]
     * 
     * A[j]<A[i] and j is largest number smaller than i.
     * 
     * Ex: 4,5,2,1,10,18,3,2 : ans = -1,0,-1,-1,3,4,3,3
     * 
     * TC:O(N) SC:O(N)
     * 
     */
    public static int[] prevSmallerIndex(int[] A) {

        int[] ans = new int[A.length];

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0 ; i<A.length ; i++){

            if(st.isEmpty()){
                ans[i] = -1;
                st.push(i);
            }

            else if(A[i]>A[st.peek()]){
                ans[i] = st.peek();
                st.push(i);
            }

            else if(A[i] <= A[st.peek()]){
                while(!st.isEmpty() && A[st.peek()]>=A[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = st.peek();
                }

                st.push(i);
            }
        } 

        return ans;
    }

    /**
     * Q. given an array of +ve integers. for every index i find the nearest smaller element(distance-wise) on the right of i [from i+1 to n-1]
     * 
     * A[j]<A[i] and j is largest number smaller than i.
     * 
     * Ex: 4,5,2,1,10,18,3,2 : ans = 2,2,1,-1,3,3,2,-1
     *
     */

    /**
     * Q. find the index of nearest smaller on right side.
     */

    /**
     * Q. next greater on left side
     * Q. next greater on right side
     * Q. index of next greater on right side
     * Q. index of next greater on left side
     */

    /**
     * Q. Find the distance between ith element and the next greatest element.
     */

    /**
     * Q. LARGEST RECTANGLE AREA IN A HISTOGRAM.
     *    given an array where A[i] represents height of ith bar.
     *    width of each bar is 1 unit.
     *    return the area of largest rectangle which could be formed.
     * Ex: 4,3,4,6,2 : ans = 12
     * Ex: 2,1,5,6,2,3 : ans = 10
     */
    public static int areaInHistogram(int[] A){
        
    }

    public static void main(String[] args){
        
        int[] arr1 = {4,2,5,10,8,2};
        print(prevSmaller(arr1));

        int[] arr2 = {4,5,2,1,10,18,3,2};
        print(prevSmallerIndex(arr2));
    }
}