package primary;

import java.util.Arrays;
import java.util.Scanner;

/**
 *给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_665 {

    public static boolean checkPossibility(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums,0,newNums,1,nums.length);
        newNums[0] = Integer.MIN_VALUE;
        newNums[nums.length+1] = Integer.MAX_VALUE;
        // 返回true的条件
        // 1.无折点
        // 2.无普通折点，且有且只有一个Z型折点，且两个点中至少有一个右点大于等于左点
        boolean hasZPoint = false; // 记录是否找到了一个满足条件的Z折点
        for(int i = 1; i < newNums.length - 1; i++){
            if(newNums[i] > newNums[i + 1]){ // 出现折点，有向下的趋势
                if(newNums[i + 1] <= newNums[i + 2]){// 是一个Z型折点
                    if(hasZPoint){
                        return false;
                    }
                    // 这里i+2不会越界，因为数组最后是一个最大值，newNums[len-2]<newNums[len-1]，所以i肯定小于len-2
                    if(newNums[i+1] >= newNums[i-1] || newNums[i+2] >= newNums[i]){
                        hasZPoint = true;
                    }else {
                        return false;
                    }
                }else { // 是一个普通折点
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for(int i = 0; i < 5; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(checkPossibility(nums));
    }

}
