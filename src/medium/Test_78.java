package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 通过次数142,426提交次数181,382
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_78 {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0);
    }
    // nums[start~len-1]的所有子集
    public static List<List<Integer>> subsets(int[] nums , int start){
        List<List<Integer>> rs = new ArrayList<>();
        if(start == nums.length){
            rs.add(new ArrayList<>());
            return rs;
        }
        List<List<Integer>> subsets = subsets(nums, start+1);
        for(List<Integer> subset : subsets){
            // 选start
            rs.add(subset);
            // 不选start
            List<Integer> tmp = new ArrayList<>(subset);
            tmp.add(nums[start]);
            rs.add(tmp);
        }
        return rs;
    }
}
