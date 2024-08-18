class Trees1{

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

    public static void preOrder(TreeNode root){

        if(root == null) return;

        System.out.print(root.val+" ");

        preOrder(root.left);

        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){

        if(root == null) return;

        inOrder(root.left);

        System.out.print(root.val+" ");

        inOrder(root.right);
    }

    public static void postOrder(TreeNode root){

        if(root == null) return;

        postOrder(root.left);

        postOrder(root.right);

        System.out.print(root.val+" ");
    }

    /**
     * Q. given 2 BTs . return true if the trees are identical.
     * 
     * where ever we need fail fast approach we will use preOrder.
     * 
     * TC : O(N)
     * SC : O(N) (worst case : when the tree is skewed) . (O(logN) if tree is balance - best case)
     */
    public static boolean isIdentical(TreeNode root){
        return true;
    }

    /**
     * Q. given 2 BTs return true if they are mirror images of each other.
     */

    public static void main(String[] args){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.right = new TreeNode(10);
        root.left.right = new TreeNode(11);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }
}

/**
 * anything which can be done using recursion could be done using iterations also. most of the times we use stacks for it.
 */