package medium;

import java.util.Stack;

/**
 *面试题 04.05.合法二叉搜索树
 * (☆☆)
 *实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case_0405 {
    public class TreeNode {
        int val;
        boolean visited = false;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        long pre = Long.MIN_VALUE;
        while(!stack.isEmpty()){
            TreeNode peek = stack.peek();
            while(peek.left != null && !peek.visited){
                stack.push(peek.left);
                peek = peek.left;
            }
            stack.pop();
            peek.visited = true;
            if(pre < peek.val){
                pre = peek.val;
            }else {
                return false;
            }
            if(peek.right != null){
                stack.push(peek.right);
            }
        }
        return true;
    }

    // 方法二
    public boolean isValidBST2(TreeNode root) {
        // root是二叉搜索树条件是root左子树所有节点的值都小于root，右子树所有节点的值都大于root
        return isValidBST(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValidBST(TreeNode root, long max, long min){
        // root.val需要满足在(min,max)
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.right, max , root.val) && isValidBST(root.left,  root.val, min);
    }

}
