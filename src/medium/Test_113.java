package medium;
import java.util.LinkedList;
import java.util.List;

/**
 *113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_113 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new LinkedList<>();
        }
        if(root.val == sum && root.left == null && root.right == null){
            List<List<Integer>> rs = new LinkedList<>();
            List<Integer> tmp = new LinkedList<>();
            tmp.add(root.val);
            rs.add(tmp);
            return rs;
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        List<List<Integer>> rs = new LinkedList<>();
        rs.addAll(left);
        rs.addAll(right);
        for(List<Integer> tmp : rs){
            tmp.add(0,root.val);
        }
        return rs;
    }


}
