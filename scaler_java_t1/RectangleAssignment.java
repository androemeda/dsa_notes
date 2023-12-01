class Rectangle3{

    int length;
    int breadth;

    public Rectangle3(int l , int b){
        this.length = l;
        this.breadth = b;
    }

    public int getArea(){
        return (this.length*this.breadth);
    }

    public boolean isSquare(){
        return (this.length==this.breadth);
    }

    public boolean isAreaGreaterThan(int k){
        return (this.getArea() > k) ;
    }
}



public class RectangleAssignment{

        static int[] solve(int[] A , int[] B){

            int[] ans = new int[A.length];

            for(int i=0 ; i<A.length ; i++){

                Rectangle3 rectI = new Rectangle3(A[i] , B[i]);

                int count = 0;

                for(int j=0 ; j<i ; j++){

                    Rectangle3 rectJ = new Rectangle3(A[j] , B[j]);

                    if(rectJ.isSquare() && rectJ.isAreaGreaterThan(rectI.getArea())){
                        count++;
                    }
                }

                ans[i] = count ;
            }
            return ans;
        }

        public static void main(String[] args){
           int[] A = {4,6,7};
           int[] B = {4,6,2};
           int[] C = solve(A , B);

           for(int i=0 ; i<C.length ; i++){
               System.out.print(C[i]+" ");
           }
           System.out.println();
        }
}

