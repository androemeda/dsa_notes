import java.util.Arrays;
import java.util.Scanner;

public class B_K_th_one{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
 
        SegmentTree st = new SegmentTree(n,0);
        for (int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            st.update(i, x);
        }
 
        while (q-- > 0) {
            int t = sc.nextInt();
            if (t == 1) {
                int idx = sc.nextInt();
                st.update(idx,1 - st.query(idx,idx));
            } else {
                int k = sc.nextInt();
                ++k;
                int start = 0;
                int end = n - 1;
                int ans = -1;
                while(start <= end){
                    int mid = (start + end)/2;
                    if(st.query(0,mid) >= k){
                        ans = mid;
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
 
                System.out.println(ans);
            }
        }
 
        sc.close();
    }
}

class SegmentTree {
    int[] tree;
    int identity;
    int N; // size of the array
 
    int merge(int a, int b) {
        return a + b;
    }
 
    SegmentTree(int n, int identity) {
        this.N = n;
        this.identity = identity;
        this.tree = new int[4 * N];
        Arrays.fill(tree,identity);
    }
 
    public void update(int qIdx, int val) {
        update(0, 0, N - 1, qIdx, val);
    }
 
    private void update(int tIdx, int tL, int tR, int qIdx, int val) {
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
 
    public int query(int l, int r) {
        return query(0, 0, N - 1, l, r);
    }
 
    private int query(int tIdx, int tL, int tR, int l, int r) { //number of ones in the range left to right
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
}