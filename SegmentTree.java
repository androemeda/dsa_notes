import java.util.*;

class SegmentTree {
    public int[] tree;
    public int identity;
    public int size; // size of the given array

    public int merge(int a, int b) {
        return Math.min(a, b);
    }

    public SegmentTree(int[] arr, int identity) {
        this.size = arr.length;
        this.identity = identity;
        tree = new int[4 * size];
        Arrays.fill(tree, identity);
        for(int i=0 ; i<size ; i++){
            update(i, arr[i]);
        }
    }

    // update array[index] = value
    public void update(int index, int value) {
        updateHelper(0, 0, size - 1, index, value);
    }

    private void updateHelper(int treeIndex, int leftBound, int rightBound, int index, int value) {
        if (leftBound == rightBound) {
            tree[treeIndex] = value;
            return;
        }

        int mid = (leftBound + rightBound) / 2;
        if (leftBound <= index && index <= mid) {
            updateHelper(2 * treeIndex + 1, leftBound, mid, index, value);
        } else {
            updateHelper(2 * treeIndex + 2, mid + 1, rightBound, index, value);
        }

        // leftChild: 2 * treeIndex + 1, leftBound, mid
        // rightChild: 2 * treeIndex + 2, mid + 1, rightBound
        tree[treeIndex] = merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public int query(int queryLeft, int queryRight) {
        return queryHelper(0, 0, size - 1, queryLeft, queryRight);
    }

    private int queryHelper(int treeIndex, int leftBound, int rightBound, int queryLeft, int queryRight) {
        // no overlap
        if (queryLeft > rightBound || queryRight < leftBound) {
            return identity;
        }
        // complete overlap
        if (queryLeft <= leftBound && rightBound <= queryRight) {
            return tree[treeIndex];
        }

        // partial overlap
        int mid = (leftBound + rightBound) / 2;
        return merge(queryHelper(2 * treeIndex + 1, leftBound, mid, queryLeft, queryRight),
                     queryHelper(2 * treeIndex + 2, mid + 1, rightBound, queryLeft, queryRight));
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};

        SegmentTree st = new SegmentTree(arr, Integer.MAX_VALUE);

        System.out.println(st.query(1, 4));
    }
}




















// class SegmentTree{

//     public class Node{
//         int data;
//         int start;
//         int end;
//         Node left;
//         Node right;
//         public Node(int start, int end){
//             // this.data = data;
//             this.start = start;
//             this.end = end;
//         }
//     }

//     Node root;

//     public SegmentTree(int[] arr){
//         root = constructTree(arr, 0Node, arr.length-1);
//     }

//     public Node constructTree(int[] arr, int start, int end){
//         if(start == end){
//             Node leafNode = new Node(start, end);
//             leafNode.data = arr[start];
//             return leafNode;
//         }

//         Node node = new Node(start, end);
//         int mid = (start + end) / 2;
//         node.left = constructTree(arr, start, mid);
//         node.right = constructTree(arr, mid+1, end);
//         node.data = node.left.data + node.right.data;
//         return node;
//     }

//     public int query(int start, int end){
//         return query(root, start, end);
//     }
    
//     public int query(Node node, int start, int end){
//         if(node.start >= start && node.end <= end){
//             return node.data;
//         }
//         else if(node.start > end || node.end < start){
//             return 0;
//         }
//         else{
//             return query(node.left, start, end) + query(node.right, start, end);
//         }
//     }

//     public void update(int index, int value){
//         update(root, index, value);
//     }

//     public void update(Node node, int index, int value){
//         if(node.start == node.end){
//             node.data = value;
//         }
//         else{
//             int mid = (node.start + node.end) / 2;
//             if(index <= mid){
//                 update(node.left, index, value);
//             }
//             else{
//                 update(node.right, index, value);
//             }
//             node.data = node.left.data + node.right.data;
//         }
//     }

//     public static void main(String[] args){
//         int[] arr = {3,8,6,7,-2,-8,4,9};

//         SegmentTree st = new SegmentTree(arr);

//         System.out.println(st.query(1, 4));
//     }
// }



/**
 * perform query on a range - ex : sum , min , max , avg , product of a range
 * get - o(logn)
 * update - o(logn)
 * segment tree is a binary tree which as interval info and operation info
 * segment tree is a full binary tree : leaf nodes = n , internal nodes = n-1 , total nodes = 2n-1
 * 
 * 
 * operation should be associative and commutative
 * 
 * sum --> 0
 * min --> Integer.MAX_VALUE
 * max --> Integer.MIN_VALUE
 * product --> 1
 * gcd --> 0
 * lcm --> 1
 * or operation --> 0
 * and operation --> 1
 * xor operation --> 0
 * 
 */