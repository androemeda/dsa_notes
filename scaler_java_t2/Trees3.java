class Trees3{

    /**
     * Q. given a binary tree , return the level order traversal.
     * 
     * return type is a 2D ArrayList
     * 
     * could be done using queue : TC:O(N) SC:O(N)(when tree is balanced - number of nodes in last level would be (n+1)/2) 
     * 
     * done on leetcode - 102
     */
    
    /**
     * AMAZON , MICROSOFT , ADOBE
     * 
     * Q.given a binary tree. return the left view of the tree. done in hw - https://www.scaler.com/academy/mentee-dashboard/class/148129/assignment/problems/4675/?navref=cl_pb_nv_tb
     *   
     *    first element of every level is the answer.
     * 
     * Q. return right view.
     *    last element of every level. leetcode - 199
     * 
     * Q. return vertical order traversal.
     * 
     * Q. top view.
     * 
     * Q. bottom view.
     * 
     * Q. boundry of the tree
     * 
     * Q. zig-zag traversal in level order. done on leetcode - 103
     */

    /**
     * TC OF SEARCHING IN A BINARY TREE
     */

    /**
     * Q. find an element in binary search tree
     * 
     * TC : O(logN)(avg) , in worst case(skewed tree) tc is O(N)
     * 
     * SC : O(N) in worst case(skewed tree)
     */

    /**
     * Q. given a BST , insert a value in it at appropriate position.
     */

    public static void main(String[] args){
    }
}

/**
 * inOrder traversal of a BST is always in sorted order.
 */



/*
TOP VIEW OF A BINARY TREE.
import java.util.*;


public class Solution {
    
    public class TreeData{
        TreeNode node;
        int dist;
        
        public TreeData(TreeNode node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    public ArrayList<Integer> verticalT(TreeNode A){
        
        if(A==null) return new ArrayList<Integer>();
        
        int minDist = 0 ;
        int maxDist = 0 ;
        
        Queue<TreeData> q = new LinkedList<>();
        
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        TreeData rootData = new TreeData(A , 0);
        
        q.add(rootData);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0 ; i<size ; i++){
                
                TreeData curr = q.remove();
                int dist = curr.dist;
                
                minDist = Math.min(minDist , dist);
                maxDist = Math.max(maxDist , dist);
            
                if(!map.containsKey(dist)){
                map.put(dist , new ArrayList<Integer>());
                }
            
                map.get(dist).add(curr.node.val);
                
                if(curr.node.left != null){
                    TreeData l = new TreeData(curr.node.left , dist-1);
                    q.add(l);
                }
                if(curr.node.right != null){
                    TreeData r = new TreeData(curr.node.right , dist+1);
                    q.add(r);
                }
            }
        }
        
        for(int i=minDist ; i<=maxDist ; i++){
            ans.add(map.get(i).get(0));
        }
        
        return ans;
    }
    
    public ArrayList<Integer> solve(TreeNode A) {
        
        return verticalT(A);
        
    }
}

*/
