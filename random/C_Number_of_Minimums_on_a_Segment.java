import java.util.Scanner;

class Node {
    int min;
    int count; // count of minimums
    int startInterval;
    int endInterval;
    Node left;
    Node right;

    public Node(int min, int startInterval, int endInterval) {
        this.min = min;
        this.count = 1;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree {
    Node root;
    int identity = Integer.MAX_VALUE;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    public Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start], start, end);
        }
        int mid = start + (end - start) / 2;
        Node left = constructTree(arr, start, mid);
        Node right = constructTree(arr, mid + 1, end);
        Node node = new Node(Math.min(left.min, right.min), start, end);
        node.left = left;
        node.right = right;

        if (left.min < right.min) {
            node.min = left.min;
            node.count = left.count;
        } else if (left.min > right.min) {
            node.min = right.min;
            node.count = right.count;
        } else {
            node.min = left.min;
            node.count = left.count + right.count;
        }

        return node;
    }

    public int[] query(int qsi, int qei) {
        return query(this.root, qsi, qei);
    }

    public int[] query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return new int[] { node.min, node.count };
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return new int[] { identity, 0 };
        } else {
            int[] leftResult = query(node.left, qsi, qei);
            int[] rightResult = query(node.right, qsi, qei);
            if (leftResult[0] < rightResult[0]) {
                return leftResult;
            } else if (leftResult[0] > rightResult[0]) {
                return rightResult;
            } else {
                return new int[] { leftResult[0], leftResult[1] + rightResult[1] };
            }
        }
    }

    public void update(int index, int value) {
        update(this.root, index, value);
    }

    public void update(Node node, int index, int value) {
        if (node.startInterval == node.endInterval) {
            node.min = value;
            node.count = 1;
            return;
        }
        int mid = node.startInterval + (node.endInterval - node.startInterval) / 2;
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }

        if (node.left.min < node.right.min) {
            node.min = node.left.min;
            node.count = node.left.count;
        } else if (node.left.min > node.right.min) {
            node.min = node.right.min;
            node.count = node.right.count;
        } else {
            node.min = node.left.min;
            node.count = node.left.count + node.right.count;
        }
    }
}

public class C_Number_of_Minimums_on_a_Segment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SegmentTree segTree = new SegmentTree(nums);

        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int idx = sc.nextInt();
                int value = sc.nextInt();
                segTree.update(idx, value);
            } else if (type == 2) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int[] result = segTree.query(l, r - 1);
                System.out.println(result[0] + " " + result[1]);
            }
        }

        sc.close();
    }
}





























// class Node{
//     int data;
//     int count; // count of minimums
//     int startInterval;
//     int endInterval;
//     Node left;
//     Node right;
//     public Node(int data, int startInterval, int endInterval){
//         this.data = data;
//         this.count = 1;
//         this.startInterval = startInterval;
//         this.endInterval = endInterval;
//         this.left = null;
//         this.right = null;
//     }
// }

// class SegmentTree{
//     Node root;
//     int identity = Integer.MAX_VALUE;

//     public SegmentTree(int[] arr){
//         this.root = constructTree(arr, 0, arr.length-1);
//     }

//     public Node constructTree(int[] arr, int start, int end){
//         if(start == end){
//             return new Node(arr[start], start, end);
//         }
//         int mid = start + (end-start)/2;
//         Node left = constructTree(arr, start, mid);
//         Node right = constructTree(arr, mid+1, end);
//         Node node = new Node( merge(left.data , right.data) , start, end);
//         node.left = left;
//         node.right = right;
//         if(left.data < right.data){
//             node.count = left.count;
//         }else if(left.data > right.data){
//             node.count = right.count;
//         }else{
//             node.count = left.count + right.count;
//         }
//         return node;
//     }

//     public int query(int qsi , int qei){
//         return query(this.root, qsi, qei);
//     }

//     public int query(Node node, int qsi, int qei){
//         if(node.startInterval >= qsi && node.endInterval <= qei){
//             return node.data;
//         }else if(node.startInterval > qei || node.endInterval < qsi){
//             return identity;
//         }else{
//             return merge(query(node.left, qsi, qei), query(node.right, qsi, qei));
//         }
//     }

//     public int merge(int left, int right){
//         return Math.min(left, right);
//     }

//     public void update(int index, int value){
//         update(this.root, index, value);
//     }

//     public void update(Node node, int index, int value){
//         if(node.startInterval == node.endInterval){
//             node.data = value;
//             return;
//         }
//         int mid = node.startInterval + (node.endInterval - node.startInterval)/2;
//         if(index <= mid){
//             update(node.left, index, value);
//         }else{
//             update(node.right, index, value);
//         }
//         node.data = merge(node.left.data, node.right.data);
//     }

// }

// public class Main{
//     public static void main(String[] args){

//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt() , m = sc.nextInt();

//         int[] nums = new int[n];
//         for(int i = 0; i < n; i++){
//             nums[i] = sc.nextInt();
//         }

//         int[][] queries = new int[m][3];
//         for(int i = 0; i < m; i++){
//             queries[i][0] = sc.nextInt();
//             queries[i][1] = sc.nextInt();
//             queries[i][2] = sc.nextInt();
//         }


//     }
// }