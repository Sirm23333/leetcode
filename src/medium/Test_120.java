package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_120 {

    // 递归+记忆化
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle,0,0,new HashMap<>());
    }

    public int minimumTotal(List<List<Integer>> triangle , int row , int idx , Map<Integer,Integer> step){
        if(step.containsKey(triangle.size() * row + idx)){
            return step.get(triangle.size() * row + idx);
        }
        if(row == triangle.size() - 1){
            step.put(triangle.size() * row + idx , triangle.get(row).get(idx));
            return triangle.get(row).get(idx);
        }
        int min = triangle.get(row).get(idx) + Math.min(minimumTotal(triangle,row+1,idx,step),minimumTotal(triangle,row+1,idx+1,step));
        step.put(triangle.size() * row + idx , min);
        return min;
    }

    // 递推
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size() > 1){
            for(int i = triangle.size() - 2; i >= 0; i--){
                List<Integer> nextLine = triangle.get(i + 1);
                List<Integer> tmp = triangle.get(i);
                for(int j = 0; j < tmp.size(); j++){
                    tmp.set(j,tmp.get(j) + Math.min(nextLine.get(j),nextLine.get(j+1)));
                }
            }
        }
        return triangle.get(0).get(0);
    }


}
