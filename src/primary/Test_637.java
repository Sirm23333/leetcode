package primary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 637. 二叉树的层平均值
 * (☆☆)
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class NodeItem{
        TreeNode treeNode;
        int depth;
        NodeItem(TreeNode treeNode , int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<long[]> levelInfo = new ArrayList<>(); // 每一个层的节点数与和
        Queue<NodeItem> queue = new ArrayDeque<>();
        queue.add(new NodeItem(root,0));
        while(!queue.isEmpty()){
            NodeItem head = queue.poll();
            if(head.depth + 1 > levelInfo.size()){
                long[] tmp = {0,0};
                levelInfo.add(tmp);
            }
            long[] ints = levelInfo.get(head.depth);
            ints[0] += head.treeNode.val;
            ints[1]++;
            if(head.treeNode.left != null){
                queue.add(new NodeItem(head.treeNode.left,head.depth+1));
            }
            if(head.treeNode.right != null){
                queue.add(new NodeItem(head.treeNode.right,head.depth+1));
            }
        }

        for(long[] tmp : levelInfo){
            result.add((double)tmp[0] / tmp[1]);
        }
        return result;
    }

    // 更快的写法
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                sum += head.val;
                if(head.left != null){
                    queue.add(head.left);
                }
                if(head.right != null){
                    queue.add(head.right);
                }
            }
            result.add((double)sum / size);
        }
        return result;
    }

}
