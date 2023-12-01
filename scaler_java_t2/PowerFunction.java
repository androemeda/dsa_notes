class PowerFunction{

    //return (A^B)%M
    public static int powerFunction(int A , int B , int M){
        long ans = 1;
        for(int i=0 ; i<B ; i++){
            ans = ((ans%M)*(A%M))%M ;
        }
        return (int)(ans);
    }
    public static void main(String[] args){
        System.out.println(powerFunction(Integer.MAX_VALUE , Integer.MAX_VALUE , Integer.MAX_VALUE));
    }
}