class Node{
    int data;
    int startInterval;
    int endInterval;
    Node left;
    Node right;
    public Node(int data, int startInterval, int endInterval){
        this.data = data;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree{
    Node root;
    int identity = 0;

    public SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    public Node constructTree(int[] arr, int start, int end){
        if(start == end){
            return new Node(arr[start], start, end);
        }
        int mid = start + (end-start)/2;
        Node left = constructTree(arr, start, mid);
        Node right = constructTree(arr, mid+1, end);
        Node node = new Node(left.data + right.data, start, end);
        node.left = left;
        node.right = right;
        return node;
    }

    public int query(int qsi , int qei){
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }else if(node.startInterval > qei || node.endInterval < qsi){
            return identity;
        }else{
            return merge(query(node.left, qsi, qei), query(node.right, qsi, qei));
        }
    }

    private int merge(int left, int right){
        return left + right;
    }

    public void update(int index, int value){
        update(this.root, index, value);
    }

    private void update(Node node, int index, int value){
        if(node.startInterval == node.endInterval){
            node.data = value;
            return;
        }
        int mid = node.startInterval + (node.endInterval - node.startInterval)/2;
        if(index <= mid){
            update(node.left, index, value);
        }else{
            update(node.right, index, value);
        }
        node.data = merge(node.left.data, node.right.data);
    }

}

public class Main{
    public static void main(String[] args){

        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(1, 3));
    }
}