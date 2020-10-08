package primary;

import java.util.ArrayList;
import java.util.List;

/**
 *剑指 Offer 57 - II. 和为s的连续正数序列
 *输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_57_II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> rsList = new ArrayList<>();
        int pre = 1, tail = 1, sum = 1;
        while(tail <= target / 2 + 1){
            if(sum < target){
                tail++;
                sum += tail;
            }else if(sum == target){
                int[] tmp = new int[tail - pre + 1];
                for(int i = pre; i <= tail; i++){
                    tmp[i-pre] = i;
                }
                rsList.add(tmp);
                tail++;
                sum += tail;
            }else {
                sum -= pre;
                pre++;
            }
        }
        int[][] rs = new int[rsList.size()][];
        for(int i = 0; i < rsList.size(); i++){
            rs[i] = rsList.get(i);
        }
        return rs;
    }
}
