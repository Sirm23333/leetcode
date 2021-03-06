package primary;

/**
 *剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_53_2 {

    public int missingNumber2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }

    // 二分
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return missingNumber(nums,0,n-1);
    }
    public int missingNumber(int[] nums , int start, int end) {
        if(start >= end){
            if(nums[start] != start)
                return start;
            else if(start == 0 && nums.length == 1)
                return start - 1;
            else
                return start + 1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == mid){
            return missingNumber(nums, mid , end);
        }else {
            return missingNumber(nums, start, mid );
        }
    }


}
