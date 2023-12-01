// public class AddBinStr {
//     public String addBinary(String A, String B) {
//         while (A.length() > B.length()) {
//             B = "0" + B;
//         }
        
//         while (A.length() < B.length()) {
//             A = "0" + A;
//         }
        
//         String sum = "";
//         char carry = '0';
        
//         for (int i = A.length() - 1; i >= 0; i--) {
//             char digitA = A.charAt(i);
//             char digitB = B.charAt(i);
            
//             if (digitA == '0' && digitB == '0' && carry == '0') {
//                 sum = '0' + sum;
//                 carry = '0';
//             } else if (digitA == '0' && digitB == '1' && carry == '0') {
//                 sum = '1' + sum;
//                 carry = '0';
//             } else if (digitA == '1' && digitB == '0' && carry == '0') {
//                 sum = '1' + sum;
//                 carry = '0';
//             } else if (digitA == '1' && digitB == '1' && carry == '0') {
//                 sum = '0' + sum;
//                 carry = '1';
//             } else if (digitA == '0' && digitB == '0' && carry == '1') {
//                 sum = '1' + sum;
//                 carry = '0';
//             } else if (digitA == '0' && digitB == '1' && carry == '1') {
//                 sum = '0' + sum;
//                 carry = '1';
//             } else if (digitA == '1' && digitB == '0' && carry == '1') {
//                 sum = '0' + sum;
//                 carry = '1';
//             } else {
//                 sum = '1' + sum;
//                 carry = '1';
//             }
//         }
        
//         if (carry == '1') {
//             sum = '1' + sum;
//         }
        
//         return sum;
//     }
// }


// public class Solution {
//     public String addBinary(String A, String B) {
//         while (A.length() > B.length()) {
//             B = "0" + B;
//         }
        
//         while (A.length() < B.length()) {
//             A = "0" + A;
//         }
        
//         String sum = "";
//         int carry = 0;
        
//         for (int i = A.length() - 1; i >= 0; i--) {
//             int digitA = A.charAt(i) - '0';
//             int digitB = B.charAt(i) - '0';
            
//             int digitSum = digitA + digitB + carry;
            
//             sum = (digitSum % 2) + sum;
//             carry = digitSum / 2;
//         }
        
//         if (carry > 0) {
//             sum = '1' + sum;
//         }
        
//         return sum;
//     }
// }
