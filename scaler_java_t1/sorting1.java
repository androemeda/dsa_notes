public class sorting1{

    public static void printArray(int[] arr){
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * ---BUBBLE SORT---
     * always swapping 2 consecutive elements.
     * if distance between elements adds up to cost , bubble sort becomes most optimal.
     * best case - O(n) - when array is already sorted.
     * worst case - O(n^2) - when array is sorted in descending oredr.
     * with each iteration , the largest element comes at the end.
     */
    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        ans = arr.clone(); //if u simply do ans=arr , the actual value of arr will also change , hence , clone it.
        for(int j=0 ; j<n-1 ; j++){ //run the loop n-1 times
        boolean swapped = false;
            for(int i=0 ; i<n-1-j; i++){
                if(ans[i]>ans[i+1]){     //putting an '>=' makes it non-stable , keeping it '>' makes it stable.
                    int temp = ans[i];
                    ans[i] = ans[i+1];
                    ans[i+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        
        int[] arr = {1,3,7,5,2,8};
        printArray(arr);
        printArray(bubbleSort(arr));
        printArray(arr);
    }
}