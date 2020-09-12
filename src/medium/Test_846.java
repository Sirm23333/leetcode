package medium;

import java.util.Arrays;

/**
 * 846. 一手顺子
 *(☆☆☆)
 * 爱丽丝有一手（hand）由整数数组给定的牌。 
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *  
 *
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_846 {
    public static  boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0){
            return false;
        }
        Arrays.sort(hand);
        boolean[] visited = new boolean[hand.length];
        for(int i = 0; i < hand.length; i++){
            visited[i] = false;
        }
        int p = 0; // 指向第一个visited为false的位置，找到一组后再回到p位置开始找下一组
        int pre = hand[p] - 1;
        int cnt = 0; // 临时计数，表示连续出现数组的个数
        for(int i = 0; i < hand.length; ){
            if(visited[i]){
                if(p == i) p++;
                i++;
            }else if(pre == hand[i]){
                i++;
            }else if(hand[i] - pre == 1){
                pre = hand[i];
                visited[i] = true;
                cnt++;
                if(p == i) p++;
                i++;
                if(cnt == W){
                    cnt = 0;
                    i = p;
                    if(p < hand.length)
                        pre = hand[p] - 1;
                }
            }else {
                return false;
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int W = 3;
        System.out.println(isNStraightHand(hand,W));
    }
}
