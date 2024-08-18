import java.util.Stack;

class Stacks2{

    /**
     * GOOGLE
     * Q. design a stack with operations on the middle element.
     *    it should have getMid() and removeMid() operations apart from all the normal push(),pop(),size() operations.
     * Ex: push(1),push(2),pop(),getMid()[returns 1],push(3),push(4),getMid()[returns 3],push(7),getMid()[returns 3],removeMid(),getMid()[returns 4]
     * 
     * time complexities of all operations should be O(1).
     * 
     *                 getMid() removeMid()
     * array/list      O(1)     O(N)
     * LinkedList      O(1)     O(N)(will work in O(1) on for first time, will take O(N) after that) 
     * DLL             O(1)     O(1)
     */

    /**
     * Q. Given a collection stack . design a new stack which also supports getMin() feature. 
     *    cant use any other data structure apart from the collections stack.
     * Ex: push(7),get(min)[returns 7],push(8),getMin()[returns 7],push(4),getMin()[returns 4],pop(),getMin()[returns 7]
     */
    
    /**
     * DOUBLE CHARACTER TROUBLE
     * Q. given a string , remove all consecutive duplicates recursively.
     * TC : O(N)
     * SC : O(N)
     */

    /**
     * Q. build a calculator. given a string , calculate the result.
     * 
     * infix : a+b --> postfix : ab+
     * Exs: 3 * 4 --> 3 4 *
     *      4 + 8 * 7 --> 4 + 8 7 * --> 4 8 7 * +
     *      10 + 3 * 4 - 7 --> 10 3 4 * + 7 -
     *      10 / (4-2) * 6 + 9 --> 10 4 2 - / 6 * 9 +
     *      (10+3) * 2 - (7-6) * (4+8) --> 10 3 + 2 * 7 6 - 4 8 + * -
     * 
     * constraints for creating infix to postfix : do in TC:O(N) where N os length of the string.
     */
    
    public static void main(String[] args){

    }
}

/**
 * 
 * collections stack
 * 
 * Stack<Data_Type> st = new Stack<Data_Type>();
 * 
 * st.push(x) 
 * st.pop() --> remvoves and returns
 * st.peek() --> returns
 * st.size()
 * st.isEmpty() --> true if empty
 */