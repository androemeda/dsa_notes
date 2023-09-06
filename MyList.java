    /*
    ---attributes: int[] arr , 
                   size(count of elements inserted inside array)

    ---functions: .size() ,
                **.add() (insert element at the end) ,  
                  .get(i) , 
                  .set(i , val) , 
                  .remove(i) , 
                  .remove() (remove from last index) ,
                  .isSorted() (tell if list is sorted or not) ,
                  .search(target) (returns true if target is present) ,
                  .getFreq(target) (returns frequency of target) ,
                  .sort() (sort the list)
    */

public class MyList{

    int[] arr;
    int size;

    public MyList(){
        arr = new int[4];
        size = 0;
    }

    public MyList(int elementCount){
        arr = new int[elementCount];
        size = 0;
    }

    public void add(int k){

        if(this.size==arr.length){
            int[] newArr = new int[2*arr.length];
            for(int i=0 ; i<arr.length ; i++){
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }

        arr[this.size] = k;
        this.size++;
    }

    public int size(){
        return this.size;
    }
    
    public int get(int i){
        if(i<size && i>=0){
            return this.arr[i];
        }else{
            System.out.println("ArrayIndexOutOfBounds.");
            return -1;
        }
    }

    public void set(int i , int value){
        if(i<size && i>=0){
            this.arr[i] = value;
        }else{
            System.out.println("ArrayIndexOutOfBounds.");
        }
    }

    public void remove(int i){

        if(i<size && i>=0){
            for(int j=i ; j<this.arr.length-1 ; j++){
                this.arr[j] = this.arr[j+1];
            }
            size--;

        }else{
            System.out.println("ArrayIndexOutOfBounds.");
        }
    }

    public boolean isSortedAsc(){
        for(int i=0 ; i<this.size()-1 ; i++){
            if(this.arr[i] > this.arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public void print(){
        for(int i=0 ; i<this.size() ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){

        MyList testArray = new MyList();

        testArray.print();
        testArray.add(1);
        testArray.add(4);
        testArray.print();
        testArray.add(9);
        testArray.add(11);
        testArray.print();
        System.out.println(testArray.isSortedAsc());
        testArray.add(2);
        testArray.print();
        System.out.println(testArray.isSortedAsc());
        System.out.println(testArray.size());
        System.out.println(testArray.get(2));
        testArray.remove(3);
        testArray.print();
        System.out.println(testArray.size());
        System.out.println(testArray.get(11));

    }
}