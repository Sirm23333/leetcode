package medium;
import java.util.ArrayDeque;
import java.util.Queue;
/**
 *117. 填充每个节点的下一个右侧节点指针 II
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node pre,after;
        while(!queue.isEmpty()){
            int size = queue.size();
            after = queue.poll();
            if(after.left != null)
                queue.add(after.left);
            if(after.right != null)
                queue.add(after.right);
            for(int i = 0; i < size - 1; i++){
                pre = after;
                after = queue.poll();
                if(after.left != null)
                    queue.add(after.left);
                if(after.right != null)
                    queue.add(after.right);
                pre.next = after;
            }
            after.next = null;
        }
        return root;
    }
    // 不用队列，用两个辅助链表
    public Node connect2(Node root) {
        if(root == null)
            return root;
        Node curHead = root, curP = root; // 当前行的头节点和移动指针
        Node nextHead = null , nextP = null ; // 下一行的头结点和移动指针
        while(curHead != null){
            while(curP != null){
                if(curP.left != null){
                    if(nextHead == null){
                        nextHead = curP.left;
                        nextP = nextHead;
                    }else {
                        nextP.next = curP.left;
                        nextP = nextP.next;
                    }
                }
                if(curP.right != null){
                    if(nextHead == null){
                        nextHead = curP.right;
                        nextP = nextHead;
                    }else {
                        nextP.next = curP.right;
                        nextP = nextP.next;
                    }
                }
                curP = curP.next;
            }
            if (nextP != null)
                nextP.next = null;
            curHead = nextHead;
            curP = curHead;
            nextHead = null;
            nextP = null;
        }
        return root;
    }
}
