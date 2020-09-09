package primary;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_475 {

    // 求所有房子中，每一个房子离最近一个供暖器的距离的最大值

    // O(nm)复杂度
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        for(int house : houses){
            int min = Integer.MAX_VALUE;
            for(int heater : heaters){
                min = Math.min(min,Math.abs(house - heater));
            }
            result = Math.max(result,min);
        }
        return result;
    }
    // O(nlogn + mlogm + m + n)复杂度
    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        int min;
        for(int i = 0,j = 0; i < houses.length && j < heaters.length;){
            if(houses[i] > heaters[j] && j < heaters.length - 1)
                j++;
            else {
                min = Math.min(j > 0 ? Math.abs(houses[i]-heaters[j-1]) : Integer.MAX_VALUE,Math.abs(houses[i]-heaters[j]));
                result = Math.max(result,min);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] houses = {1,5};
        int[] heaters = {2};
        System.out.println(findRadius2(houses,heaters));
    }
}
