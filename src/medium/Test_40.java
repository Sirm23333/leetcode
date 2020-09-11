package medium;

import javax.xml.validation.SchemaFactory;
import java.util.*;

/**
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_40 {


    public void dfs(int[] candidates, int target, int idx , int sum , Stack<Integer> stack , List<List<Integer>> result){
        HashSet<Integer> visited = new HashSet<>(); // 记录这一层已经选择过的数
        for(int i = idx + 1; i < candidates.length; i++){
            if(visited.contains(candidates[i]))
                continue;
            if(candidates[i] + sum == target){
                visited.add(candidates[i]);
                List<Integer> tmp = new ArrayList<>(stack);
                tmp.add(candidates[i]);
                result.add(tmp);
            }else if(candidates[i] + sum < target){
                visited.add(candidates[i]);
                stack.push(candidates[i]);
                sum += candidates[i];
                dfs(candidates,target,i,sum,stack,result);
                sum -= candidates[i];
                stack.pop();
            }else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates,target,0,0,new Stack<>(),result);
        return result;
    }

}