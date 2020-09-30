package medium;

/**
 *
 */
public class Test_701 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        if(root == null)
            return insert;
        TreeNode tmp = root;
        while(true){
            if(tmp.val > val){
                if(tmp.left != null){
                    tmp = tmp.left;
                }else {
                    tmp.left = insert;
                    break;
                }
            }else {
                if(tmp.right != null){
                    tmp = tmp.right;
                }else {
                    tmp.right = insert;
                    break;
                }
            }
        }
        return root;
    }
}
