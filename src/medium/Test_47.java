package medium;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 47.全排列 II
 * (☆☆)
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Test_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums,0,result );
        return result;
    }

    public void permuteUnique(int[] nums ,  int n , List<List<Integer>> result) {
        if(n >= nums.length - 1){
            List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(tmp);
            return ;
        }
        HashSet<Integer> have = new HashSet<>();
        for(int i = n; i < nums.length; i++){
            if(have.contains(nums[i])){
                continue;
            }
            have.add(nums[i]);
            {int tmp = nums[n];nums[n] = nums[i];nums[i] = tmp;}
            permuteUnique(nums,n+1,result);
            {int tmp = nums[n];nums[n] = nums[i];nums[i] = tmp;}
        }
    }

}
