package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数组总和III
 * (☆☆)
 *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_216 {
    public void dfs(int cur, int k, int n , Stack<Integer> stack , List<List<Integer>> result){
        if(k == 1){
            if(cur == n){
                List<Integer> tmp = new ArrayList<>(stack);
                tmp.add(cur);
                result.add(tmp);
                return;
            }else {
                return;
            }
        }
        if(cur < n){
            stack.push(cur);
            for(int i = cur + 1; i < 10; i++){
                dfs(i , k - 1, n - cur , stack , result);
            }
            stack.pop();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(i,k,n,new Stack<>(),result);
        }
        return result;
    }
}
