package medium;

/**
 *75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_75 {
    public void sortColors(int[] nums) {
        int start = -1 , end = nums.length, i ;
        while(start < nums.length - 1 && nums[++start] == 0);
        while(end > 0 && nums[--end] == 2);
        i = start ;
        while (i <= end && start < end){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                while(start < nums.length - 1 && nums[++start] == 0);
                i = start ;
            }else if(nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[end];
                nums[end] = tmp;
                while(end > 0 && nums[--end] == 2);
            }else {
                i++;
            }
        }

    }
}
