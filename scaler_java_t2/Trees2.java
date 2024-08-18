class Trees2{

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x){
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Q. find height of a binary tree.
     * 
     * done using post-order traversal
     */
    public static int height(TreeNode root){
        return 0;
    }

    /**
     * Q. count number of nodes in a tree.
     * 
     * method 1 : traverse over all nodes , store them and return count . TC : SC : O(N) in all cases
     * 
     * method 2 : using only recursion . SC : O(logN) in best case
     * 
     * done on leetcode
     */

    /**
     * Q. given 2 trees , check wether they are mirror images of each other.
     * 
     * preOrder traversal
     * 
     * done on leetcode
     */

    /**
     * GOOGLE
     * Q. given a tree , convert it to its mirror image.
     * 
     * done on leetcode
     */

    /**
     * Q. search for a node in a tree.
     * 
     * preOrder traversal
     */

    /**
     * Q. given 2 arrays with preOrder and inOrder traversal of a binary tree (all values are distinct). construct the tree (return a TreeNode) .
     * 
     * preorder - root , preorder of left , preorder of right
     * inorder - inorder of left , root , inorder of right
     * 
     * passs indices in the function
     * 
     * preorder traversal
     */

    public static void main(String[] args){

    }
}

/**
 * preOrder traversal for fail-fast approach
 */