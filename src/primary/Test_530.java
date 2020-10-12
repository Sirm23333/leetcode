package primary;

import java.util.Stack;

/**
 *530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_530 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean visited = false;
        boolean inStack = false;
        TreeNode(int x) { val = x; }
    }
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root.inStack = true;
        int pre = 0;
        boolean flag = true; // 是否是中序遍历第一个数
        while(!stack.isEmpty()){
            TreeNode peek = stack.pop();
            if(peek.right != null && !peek.right.visited && !peek.right.inStack ){
                stack.push(peek.right);
                peek.right.inStack = true;
            }
            if(peek.left != null && !peek.left.visited && !peek.left.inStack){
                stack.push(peek);
                stack.push(peek.left);
                peek.left.inStack = true;
            }else {
                peek.visited = true;
                if(!flag){
                    min = Math.min(min,peek.val - pre);
                    pre = peek.val;
                }else {
                    pre = peek.val;
                    flag = false;
                }
            }
        }
        return min;
    }
}
