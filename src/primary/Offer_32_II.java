package primary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_32_II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque();
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null)
            return rs;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode tmpNode = q.peek();
                tmp.add(tmpNode.val);
                if(tmpNode.left != null)
                    q.add(tmpNode.left);
                if(tmpNode.right != null)
                    q.add(tmpNode.right);
                q.poll();
            }
            rs.add(tmp);
        }
        return rs;
    }
}
