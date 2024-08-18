class Searching1{
    /**
     * Q. given a matrix whose rows and columns are sorted.
     *    given a target elements check wether it is present in the matrix.(in less than n^2)
     *    Ex: 5    10  12  15  20
     *        8    11  13  17  31
     *        10   12  14  22  38
     *        15   18  23  28  40    
     * TC: O(n+m).
     */
    public static boolean searchInSortedMatrix(int[][] A , int target){
        
        int row = 0;
        int col = A[0].length-1;

        while(row<=A.length-1 && col>=0){
            int check = A[row][col];
            if(check==target) return true;
            else if(check<target) row++;
            else col--;
        }
        return false;
    }

    /**
     * BINARY SEARCH ON A SORTED ARRAY
     * check wether the target is present or not in the array.
     * HW--> solve using recursion also(we dont use it because it will consume extra space)
     */
    public static boolean binarySearch(int[] A , int target){

        int s = 0;
        int e = A.length-1;

        while(s<=e){
            int mid = (s+e)/2;

            if(target==A[mid]) return true;
            if(target>A[e]) return false;
            if(target<A[s]) return false;

            if(target<A[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return false;
    }

    /**
     * Q. given a sorted array , find the floor of a given target.
     * floor--> largest element less than or equal to given number.
     * return -inf if not present.
     * Ex: -5 , 2 , 3 , 6 , 9 , 10 , 11 , 15 , 18 : target=4 : ans=3
     */
    public static int floor(int[] A , int target){

        int s = 0;
        int e = A.length-1;

        int ans = Integer.MIN_VALUE;

        while(s<=e){
            int mid = (s+e)/2;

            if(target==A[mid]) return A[mid];

            if(target<A[mid]){
                e = mid-1;
            }else{
                ans = A[mid];
                s = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {-5 , 2 , 3 , 6 , 9 , 10 , 11 , 15 , 18};

        int[][] matrix = {{5,10,12,15,20},{8,11,13,17,31},{10,12,14,22,38},{15,18,23,28,40}};
        System.out.println(searchInSortedMatrix(matrix , 10));

        System.out.println(floor(arr2 , 4));
    }
}