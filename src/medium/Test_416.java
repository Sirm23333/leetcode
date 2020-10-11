package medium;

import java.util.Arrays;

/**
 *416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_416 {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2)
            return  false;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        if(nums[nums.length - 1] > target)
            return false;
        boolean[][] arr = new boolean[nums.length][target+1];
        arr[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++){
            arr[i][0] = true;
            for(int j = 1; j < target + 1; j++){
                if(nums[i] <= j)
                    arr[i][j] = arr[i - 1][j] || arr[i-1][j-nums[i]];
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }
        return arr[nums.length-1][target];
    }

}
