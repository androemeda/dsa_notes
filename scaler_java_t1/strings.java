public class strings{

    //Q.given a string , toggle the case of all characters and return.
    static String toggleCase(String s){

        String ans = "";

        for(int i=0 ; i<s.length() ; i++){

            if(s.charAt(i)>='a' && s.charAt(i)<='z'){

                ans += (char)((int)(s.charAt(i)-97) + (int)('A'));

            }
            
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){

                ans += (char)((int)s.charAt(i)-(int)('A')+ (int)('a'));

            }
        }

        return ans;
    }





    //Q. conditions for password:(lowercase,uppercase,number,special character, length>=8(compulsory)).
    // 4/4-->strong , 3/4-->moderate , 2/4-->weak , 1/4-->poor . if length<8--> not accepted 
    static void passwordStrength(String s){
        if(s.length()<8){
            System.out.println("very short. please try again.");
        }else{
            int count=0;

            for(int i=0 ; i<s.length() ; i++){
                if(s.charAt(i)>='a'  &&  s.charAt(i)<='z' ){
                    count++;
                    break;
                }
            }
            for(int i=0 ; i<s.length() ; i++){//no need for special char condition seperately.
                if(s.charAt(i)=='!'||s.charAt(i)=='@'||s.charAt(i)=='#'||s.charAt(i)=='$'||s.charAt(i)=='%'||s.charAt(i)=='^'||s.charAt(i)=='&'||s.charAt(i)=='*'||s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='`'||s.charAt(i)=='~'||s.charAt(i)=='?'||s.charAt(i)=='/'||s.charAt(i)=='|'||s.charAt(i)=='_'||s.charAt(i)=='-'||s.charAt(i)=='.'||s.charAt(i)=='<'||s.charAt(i)=='>'||s.charAt(i)=='+'||s.charAt(i)=='='){
                    count++;
                    break;
                }
            }
            for(int i=0 ; i<s.length() ; i++){
                if(s.charAt(i)>='A'  &&  s.charAt(i)<='Z' ){
                    count++;
                    break;
                }
            }
            for(int i=0 ; i<s.length() ; i++){
                if(s.charAt(i)>='0' &&  s.charAt(i)<='9' ){
                    count++;
                    break;
                }
            }

            if(count==1){
                System.out.println("poor");
            }else if(count==2){
                System.out.println("weak");
            }else if(count==3){
                System.out.println("moderate");
            }else if(count==4){
                System.out.println("strong");
            }
        }
    }

    //Q.print all characters of a string.
    static void printAllCharacters(String s){
        for(int i=0 ; i<s.length() ; i++){
            System.out.print(s.charAt(i)+" ");
        }
    }

    //Q.count number of vowels in a given string.
    static int vowelCount(String s){
        int count = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='a' ||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
                count++;
            }
        }
        return count;
    }

    //Q.count number of vowels in a string of only lower case english letters.(length-vowels)

    //Q. given a string , return true if palindrome , else false.
    static boolean isPalindrome(String s){


        // for(int i=0 ; i<s.length()/2 ; i++){
        //     if(s.charAt(i) != s.charAt(s.length()-1-i)){
        //         return false;
        //     }
        // }
        // return true;

        int start=0;
        int end=s.length()-1;

        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Q.return the reverse of the given string.
    static String reverse(String s){
        String reverse = "";
        for(int i=s.length()-1 ; i>=0 ; i--){
            reverse += s.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args){
        String s = "hjfb\\\t\\nljfnfk";
        String str = "abc";
        //System.out.println(s);
        //printAllCharacters("hwefbwie wkjeb");
        //System.out.println(vowelCount("kjsdbwihfAKBDH"));
        //System.out.println(isPalindrome("*$01n10$*"));
        //System.out.println(reverse("abcde"));
        //passwordStrength("abcd@ef1gAh__ij");
        System.out.println(toggleCase("jahdgKAHDhsdb"));
    }
}

//to compare 2 strings , use .equals().
//to compare 2 characters , directly use == .
//to print \n , write \\n.