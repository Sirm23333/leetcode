package medium;

import java.util.HashMap;
import java.util.Map;

/**
 *106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private static Map<Integer,Integer> inMap = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public static TreeNode buildTree(int[] inorder, int inStart , int inEnd , int[] postorder , int postStart , int postEnd){
        if(inStart > inEnd || postStart > postEnd || inStart < 0 || postStart < 0 || inEnd > inorder.length - 1 || postEnd > postorder.length - 1)
            return null;
        if(inStart == inEnd && postStart == postEnd && inorder[inStart] == postorder[postStart]){
            TreeNode root = new TreeNode(inorder[inStart]);
            return root;
        }
        int nodeValue = postorder[postEnd];
        TreeNode root = new TreeNode(nodeValue);
        int idx = inMap.get(nodeValue);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder , postEnd - inEnd + idx , postEnd - 1);
        root.left = buildTree(inorder,inStart,idx - 1,postorder , postStart , postEnd - inEnd + idx - 1);
        return root;
    }
}
