package primary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_68_II {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 遍历树找出路径，遍历路径
    // O(N)+O(logN)->O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> paths = new ArrayList<>();
        dfs(root,p,q,new Stack<>(),paths);
        int minLength = Math.min(paths.get(0).size(),paths.get(1).size());
        for(int i = 0; i < minLength;i++){
            if(paths.get(0).get(i) != paths.get(1).get(i))
                return paths.get(0).get(i - 1);
        }
        return paths.get(0).get(minLength - 1);

    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> stack , List<List<TreeNode>> paths){
        stack.push(root);
        if(root == p || root == q){
            List<TreeNode> tmp = new ArrayList<>(stack);
            paths.add(tmp);
        }
        if(root.left != null)
            dfs(root.left,p,q,stack,paths);
        if(root.right != null)
            dfs(root.right,p,q,stack,paths);
        stack.pop();
    }


}
