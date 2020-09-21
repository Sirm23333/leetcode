package primary;

import java.util.Stack;

/**
 *538. 把二叉搜索树转换为累加树
 *
 * (☆☆☆)
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_538 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean visited = false;
        TreeNode(int x) { val = x; }
    }
    public TreeNode convertBST2(TreeNode root) {
        if(root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int val = 0 ;
        while(!stack.isEmpty()){
            TreeNode peek = stack.peek();
            while(peek.right != null && !peek.right.visited){
                stack.push(peek.right);
                peek = stack.peek();
            }
            peek = stack.pop();
            peek.visited = true;
            peek.val += val;
            val = peek.val;
            if(peek.left != null)
                stack.push(peek.left);
        }
        return root;
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


}
