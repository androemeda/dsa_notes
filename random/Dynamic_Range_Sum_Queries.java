import java.util.*;

class NumArray {

    int[] tree;
    int identity = 0; // Use Integer.MAX for the min range query identity
    int size;

    public NumArray(int[] nums) {
        this.size = nums.length;
        tree = new int[4 * size];
        Arrays.fill(tree, identity);
        buildTree(nums, 0, 0, size - 1);
    }

    // Build the segment tree
    public void buildTree(int[] nums, int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(nums, 2 * treeIndex + 1, left, mid);
        buildTree(nums, 2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = minQuery(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public void update(int index, int val) {
        updateHelper(0, 0, size - 1, index, val);
    }

    public void updateHelper(int treeIndex, int left, int right, int index, int value) {
        if (left == right) {
            tree[treeIndex] = value;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateHelper(2 * treeIndex + 1, left, mid, index, value);
        } else {
            updateHelper(2 * treeIndex + 2, mid + 1, right, index, value);
        }
        tree[treeIndex] = minQuery(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public int minRange(int left, int right) {
        return minRangeHelper(0, 0, size - 1, left, right);
    }

    public int minRangeHelper(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) return identity;
        if (queryLeft <= left && right <= queryRight) return tree[treeIndex];
        int mid = left + (right - left) / 2;
        return minQuery(minRangeHelper(2 * treeIndex + 1, left, mid, queryLeft, queryRight),
                        minRangeHelper(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight));
    }

    public int minQuery(int a, int b) {
        return a+b;
    }
}

public class Dynamic_Range_Sum_Queries {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() , q = sc.nextInt();

        int[] nums = new int[n+1];
        for(int i = 1; i <= n; i++){
            nums[i] = sc.nextInt();
        }

        int[][] queries = new int[q][3];
        for(int i = 0; i < q; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        NumArray obj = new NumArray(nums);  

        for(int i = 0; i < q; i++){
            if(queries[i][0] == 2) System.out.println(obj.minRange(queries[i][1], queries[i][2]));
            if(queries[i][0] == 1) obj.update(queries[i][1], queries[i][2]);
        }
    }
}