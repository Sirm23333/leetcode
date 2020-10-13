package primary;

/**
 *剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_21 {
    public int[] exchange(int[] nums) {
        int fir = -1, sec;
        while (++fir < nums.length && nums[fir] % 2 == 1);
        sec = fir + 1;
        while(sec < nums.length){
            if(nums[sec] % 2 == 1){
                int tmp = nums[sec];
                nums[sec] = nums[fir];
                nums[fir] = tmp;
                fir++;
                sec++;
            }else {
                sec++;
            }
        }
        return nums;
    }
}
