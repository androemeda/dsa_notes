class DynamicProgramming3{

    /**
     * Q.WILD-CARD MATCHING
     * given 2 strings:
     * s1 --> word {a-z}
     * s2 --> wild card {a-z , ? , *}
     * ? --> matches with any one character
     * * --> matches with a sequence of character (could also be empty string)
     * Ex: s1 = abxclm
     *     s2 = a*lm
     *     ans: true
     * Ex: s1 = abxclm
     *     s2 = a*
     *     ans: true
     * Ex: s1 = abc
     *     s2 = a?
     *     ans: false
     * Ex: s1 = abcdef
     *     s2 = *?
     *     ans: true
     * Ex: s1 = ""
     *     s2 = *****
     *     ans: true
     * Ex: s1 = abc
     *     s2 = a*d
     *     ans: false
     */

    /**
     * Q. given 2 strings A and B, count the number of unique ways in which we can get string B as a sub-seq of string A.
     * Ex: A : rabybxbit
     *     B : rabbit
     *     ans : 3
     * 
     * generate all sub-sequences of A and compare with B --> TC : O((2^N)*M) (backtracking solution)
     */

    /**
     * Q. LPS (LONGEST PALINDROMIC SUB-SEQUENCE)
     *    return length of largest palindromic sub-sequence.
     * Ex: agbdba : 5 (abdba)
     * Ex: acbacb : 3 (aba , bcb ,...)
     * 
     * approach 1 : find LCS in between s and reverse of s.
     * approach 2 : 2 pointer and dp
     * approach 3 (iterative) : start filling matrix from base-case
     *                          base case would be diagonal elements with value 1.
     *                          for all cases below diagonal , value is 0.
     *                          now we need to move diagonally in the upper triangle.
     */
    
    public static void main(String[] args){

    }
}