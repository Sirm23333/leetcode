package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * (☆☆)
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Test_94 {
    class TreeNode {
        int val;
        boolean visited = false;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return new ArrayList<>();
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            while(peek.left != null && !peek.left.visited){
                stack.push(peek.left);
                peek = stack.peek();
            }
            result.add(peek.val);
            peek.visited = true;
            stack.pop();
            if(peek.right != null){
                stack.push(peek.right);
            }
        }
        return result;
    }
}
