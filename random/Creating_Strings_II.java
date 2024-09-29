class Creating_String_II{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();

        int[] factorials = new int[n+1];
        for(int i=0 ; i<=n ; i++){
            if(i==0){
                factorials[i] = 1;
            }else{
                factorials[i] = factorials[i-1]*i;
            }
        }

        int ans = factorials[n];

        
    }
}