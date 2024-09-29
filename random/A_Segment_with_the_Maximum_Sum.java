class Node {
    long max_sum;
    long total_sum;
    long max_pre;
    long max_suf;
    int startInterval;
    int endInterval;
    Node left;
    Node right;

    public Node(int startInterval, int endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }
}

class SegmentTree {
    Node root;
    
    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {
            node.max_sum = arr[start];
            node.total_sum = arr[start];
            node.max_pre = arr[start];
            node.max_suf = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        merge(node, node.left, node.right);
        return node;
    }

    private void merge(Node parent, Node left, Node right) {
        parent.total_sum = left.total_sum + right.total_sum;
        parent.max_pre = Math.max(left.max_pre, left.total_sum + right.max_pre);
        parent.max_suf = Math.max(right.max_suf, right.total_sum + left.max_suf);
        parent.max_sum = Math.max(Math.max(left.max_sum, right.max_sum), left.max_suf + right.max_pre);
    }

    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private void update(Node node, int index, int value) {
        if (node.startInterval == node.endInterval) {
            node.max_sum = value;
            node.total_sum = value;
            node.max_pre = value;
            node.max_suf = value;
            return;
        }

        int mid = node.startInterval + (node.endInterval - node.startInterval) / 2;
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }
        merge(node, node.left, node.right);
    }

    public long getMaxSum() {
        return root.max_sum;
    }
}

public class A_Segment_with_the_Maximum_Sum {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTree segmentTree = new SegmentTree(arr);
        long ans = segmentTree.getMaxSum();
        System.out.println((ans < 0) ? 0 : ans);

        for (int i = 0; i < m; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            segmentTree.update(index, value);
            ans = segmentTree.getMaxSum();
            System.out.println((ans < 0) ? 0 : ans);
        }
    }
}

/* 
import java.util.Arrays;
import java.util.Scanner;
 
public class SegmentTree {
    static class input{
        long mx_pre;
        long mx_suf;
        long mx_sub;
        long total_sum;
        public input(long x , long y , long z ,long a){
            this.mx_pre = x;
            this.mx_suf = y;
            this.mx_sub = z;
            this.total_sum = a;
        }
    }
    input[] tree;
    input identity;
    int N; // size of the array
 
    input merge(input left, input right) {
        input ans = new input(0,0,0,0);
        ans.total_sum = left.total_sum + right.total_sum;
        ans.mx_sub = Math.max(left.mx_sub , Math.max(right.mx_sub,left.mx_suf + right.mx_pre));
        ans.mx_pre = Math.max(left.mx_pre,left.total_sum + right.mx_pre);
        ans.mx_suf = Math.max(right.mx_suf , right.total_sum+left.mx_suf);
        return ans;
    }
 
    SegmentTree(int n, input identity) {
        this.N = n;
        this.identity = identity;
        this.tree = new input[4 * N];
        Arrays.fill(tree, identity);
    }
 
    public void update(int qIdx, input val) {
        update(0, 0, N - 1, qIdx, val);
    }
 
    private void update(int tIdx, int tL, int tR, int qIdx, input val) {
        if (tL == tR) {
            tree[tIdx] = val;
            return;
        }
 
        int tM = (tL + tR) / 2;
        if (qIdx <= tM) {
            update(2 * tIdx + 1, tL, tM, qIdx, val);
        } else {
            update(2 * tIdx + 2, tM + 1, tR, qIdx, val);
        }
        tree[tIdx] = merge(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
    }
 
    public input query(int l, int r) {
        return query(0, 0, N - 1, l, r);
    }
 
    private input query(int tIdx, int tL, int tR, int l, int r) {
        if (l > tR || r < tL) {
            return identity;
        }
        // complete overlap
        if (l <= tL && tR <= r) {
            return tree[tIdx];
        }
        // partial overlap
        int tM = (tL + tR) / 2;
        return merge(query(2 * tIdx + 1, tL, tM, l, r), query(2 * tIdx + 2, tM + 1, tR, l, r));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        SegmentTree st = new SegmentTree(n,new input(0,0,0,0));
        for (int i = 0; i < n; ++i) {
            Long x = sc.nextLong();
            st.update(i, new input(x,x,x,x));
        }
        System.out.println((st.query(0,n-1).mx_sub < 0) ? 0 : st.query(0,n-1).mx_sub);
        while (q-- > 0) {
            int idx = sc.nextInt();
            long val = sc.nextLong();
            st.update(idx, new input(val,val,val,val));
            System.out.println((st.query(0,n-1).mx_sub < 0) ? 0 : st.query(0,n-1).mx_sub);
        }
 
        sc.close();
    }
}
 */