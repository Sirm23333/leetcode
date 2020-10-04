package medium;

/**
 *2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Tmp = l1, l2Tmp = l2,rs = new ListNode(),rsTmp = rs;
        int carry = 0,l1Val = 0,l2Val = 0, add = 0;
        while(l1Tmp != null || l2Tmp != null){
            if(l1Tmp == null)
                l1Val = 0;
            else {
                l1Val = l1Tmp.val;
                l1Tmp = l1Tmp.next;
            }
            if(l2Tmp == null)
                l2Val = 0;
            else {
                l2Val = l2Tmp.val;
                l2Tmp = l2Tmp.next;
            }
            add = l1Val + l2Val + carry;
            if(add > 9){
                carry = 1;
                add %= 10;
            }else {
                carry = 0;
            }
            rsTmp.next = new ListNode(add);
            rsTmp = rsTmp.next;
        }
        if(carry > 0){
            rsTmp.next = new ListNode(carry);
        }
        return rs.next;
    }
}
