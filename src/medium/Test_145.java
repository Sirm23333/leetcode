package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_145 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean flag = false; // 第几次访问
        boolean visited = false;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        postorderTraversal(root,order);
        return order;
    }
    public void postorderTraversal(TreeNode root , List<Integer> order) {
        if(root == null)
            return ;
        postorderTraversal(root.left,order);
        postorderTraversal(root.right,order);
        order.add(root.val);
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        if(root == null)
            return order;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if(peek.right != null && !peek.right.visited)
                stack.push(peek.right);
            if(peek.left != null && !peek.left.visited)
                stack.push(peek.left);
            if((peek.right == null || peek.right.visited) && (peek.left == null || peek.left.visited)){
                order.add(peek.val);
                peek.visited = true;
                stack.pop();
            }
        }
        return order;
    }
}
