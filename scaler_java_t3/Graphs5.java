import java.util.*;
class Graphs5{

    public static class DisjointSet{
        

        ArrayList<Integer> rank;
        ArrayList<Integer> size;
        ArrayList<Integer> parent;

        public DisjointSet(int n){
            this.rank = new ArrayList<>();
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();
            for(int i=0 ; i<=n ; i++){
                rank.add(0);
                size.add(1);
                parent.add(i);
            }
        }

        public int getUParent(int n){
            if(n == parent.get(n)) return n;
            int ans = getUParent(parent.get(n));
            parent.set(n , ans); //path compression.
            return ans;
        }

        public void unionByRank(int u , int v){
            int ulp_u = getUParent(u);
            int ulp_v = getUParent(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u , ulp_v);
            }
            else if(rank.get(ulp_v) < rank.get(ulp_u)){
                parent.set(ulp_v , ulp_u);
            }
            else{
                parent.set(ulp_v , ulp_u);
                int rank_ulp_u = rank.get(ulp_u);
                rank.set(ulp_u , rank_ulp_u+1);
            }
        }

        public void unionBySize(int u , int v){
            int ulp_u = getUParent(u);
            int ulp_v = getUParent(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u , ulp_v);
                size.set(ulp_v , size.get(ulp_u)+size.get(ulp_v));
            }
            else{
                parent.set(ulp_v , ulp_u);
                size.set(ulp_u , size.get(ulp_u)+size.get(ulp_v));
            }
        }

        public void isSameSet(int u , int v){
            if(getUParent(u) == getUParent(v)) System.out.println("same set");
            else System.out.println("different set");
        }
    }

    public static void main(String[] args){
        DisjointSet ds1 = new DisjointSet(7);
        ds1.unionBySize(1,2);
        ds1.unionBySize(2,3);
        ds1.unionBySize(4,5);
        ds1.unionBySize(6,7);
        ds1.unionBySize(5,6);
        ds1.isSameSet(3,7);
        ds1.unionBySize(3,7);
        ds1.isSameSet(3,7);
    }
}

/**
 * DISJOINT SET
 * disjoint set - 2 functions : tell parent : TC : O(4*alpha) ~= O(1)
 *                              union : rank , size : TC : O(4*alpha) ~= O(1)
 * used for dynamically changing graphs 
 */

/**
 * BI-PARTITE GRAPHS
 * a graph which can be colored with only 2 colors such that no 2 adjacent vertices have same color.
 * 
 * a graph without a cycle(linear graph) is always bipartite.
 * 
 * graph with a cycle of odd length can never be bi-partite
 * 
 * any graph without an odd length cycle is bi-partite
 */