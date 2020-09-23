package hard;

import java.util.HashMap;
import java.util.Map;

/**
 *968. 监控二叉树
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class Test_968 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private Map<TreeNode,long[]> map = new HashMap<>();
    public int minCameraCover(TreeNode root) {
        dp(root);
        long[] ints = map.get(root);
        return (int) Math.min(ints[1],ints[2]);
    }
    public long[] dp(TreeNode root) {
        long[] arr = map.get(root);
        if(arr == null){
            arr = new long[]{-1,-1,-1};
            if(root == null){
                arr[0] = 0;
                arr[1] = Integer.MAX_VALUE;
                arr[2] = Integer.MAX_VALUE;
            }else {
                long[] left = dp(root.left);
                long[] right = dp(root.right);
                arr[0] = Math.min(left[0] + right[0] + 1 , left[1] + right[1]);
                arr[0] = Math.min(arr[0],left[1] + right[2]);
                arr[0] = Math.min(arr[0],left[2] + right[1]);
                arr[0] = Math.min(arr[0],left[2] + right[2]);
                arr[1] = 1 + left[0] + right[0];
                arr[2] = Math.min(Math.min(left[1] + right[1] , left[1] + right[2]) , left[2] + right[1]);
            }
            map.put(root,arr);
        }
        return arr;
    }




}
