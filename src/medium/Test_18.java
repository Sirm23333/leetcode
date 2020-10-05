package medium;

import java.util.*;

/**
 *18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_18 {
    // 普通4重循环+去重，O(n^4)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int preA = 0,preB = 0,preC = 0,preD = 0;
        boolean flagA = false,flagB = false, flagC = false, flagD = false;
        List<List<Integer>> rs = new ArrayList<>();
        for(int a = 0; a < nums.length; a++){
            if(flagA && nums[a] == preA)
                continue;
            flagA = true;
            preA = nums[a];
            flagB = false;
            for(int b = a + 1; b < nums.length; b++){
                if(flagB && nums[b] == preB)
                    continue;
                flagB = true;
                preB = nums[b];
                flagC = false;
                for(int c = b + 1; c < nums.length; c++){
                    if(flagC && nums[c] == preC)
                        continue;
                    flagC = true;
                    preC = nums[c];
                    flagD = false;
                    for(int d = c + 1; d < nums.length; d++){
                        if(flagD && nums[d] == preD)
                            continue;
                        flagD = true;
                        preD = nums[d];
                        if(nums[a] + nums[b] + nums[c] + nums[d] == target){
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[a]);
                            tmp.add(nums[b]);
                            tmp.add(nums[c]);
                            tmp.add(nums[d]);
                            rs.add(tmp);
                        }
                    }
                }
            }
        }
        return rs;
    }

    // 双指针，可以降低到O(n^3)
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        for(int a = 0; a < nums.length; a++){
            if(a > 0 && nums[a] == nums[a - 1])
                continue;
            for(int b = a + 1; b < nums.length; b++){
                if(b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int ab = nums[a] + nums[b];
                int target2 = target - ab;
                int c = b + 1, d = nums.length - 1;
                while(c < d){
                    if(nums[c] + nums[d] == target2){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[a]);
                        tmp.add(nums[b]);
                        tmp.add(nums[c]);
                        tmp.add(nums[d]);
                        rs.add(tmp);
                        while(c < d && nums[++c] == nums[c-1]);
                        while(c < d && nums[--d] == nums[d+1]);
                    }else if(nums[c] + nums[d] > target2){
                        while(c < d && nums[--d] == nums[d+1]);
                    }else {
                        while(c < d && nums[++c] == nums[c-1]);
                    }
                }
            }
        }
        return rs;
    }
    // 加了一个哈希剪枝，快了一点，但复杂度还是O(n^3)
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        Arrays.sort(nums);
        Set<Integer> twoAdd = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                twoAdd.add(nums[i] + nums[j]);
            }
        }
        List<List<Integer>> rs = new ArrayList<>();
        for(int a = 0; a < nums.length; a++){
            if(a > 0 && nums[a] == nums[a - 1])
                continue;
            for(int b = a + 1; b < nums.length; b++){
                if(b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int ab = nums[a] + nums[b];
                int target2 = target - ab;
                if(!twoAdd.contains(target2))
                    continue;
                int c = b + 1, d = nums.length - 1;
                while(c < d){
                    if(nums[c] + nums[d] == target2){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[a]);
                        tmp.add(nums[b]);
                        tmp.add(nums[c]);
                        tmp.add(nums[d]);
                        rs.add(tmp);
                        while(c < d && nums[++c] == nums[c-1]);
                        while(c < d && nums[--d] == nums[d+1]);
                    }else if(nums[c] + nums[d] > target2){
                        while(c < d && nums[--d] == nums[d+1]);
                    }else {
                        while(c < d && nums[++c] == nums[c-1]);
                    }
                }
            }
        }
        return rs;
    }
    public List<List<Integer>> fourSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer,List<int[]>> addMap = new HashMap<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if(i < nums.length - 1 && nums[i] == nums[i + 1])
                continue;
            for(int j = i - 1; j  >= 0; j--){
                if(j < i - 1 && nums[j] == nums[j + 1])
                    continue;
                int add = nums[i] + nums[j];
                if(!addMap.containsKey(add))
                    addMap.put(add,new ArrayList<>());
                List<int[]> ints = addMap.get(add);
                ints.add(new int[]{j,i});
            }
        }
        List<List<Integer>> rs = new ArrayList<>();
        for(int a = 0; a < nums.length; a++){
            if(a > 0 && nums[a] == nums[a - 1])
                continue;
            for(int b = a + 1; b < nums.length; b++){
                if(b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int ab = nums[a] + nums[b];
                int target2 = target - ab;
                if(!addMap.containsKey(target2))
                    continue;
                List<int[]> ints = addMap.get(target2);
                for(int[] ints1 : ints){
                    if(ints1[0] > b){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[a]);
                        tmp.add(nums[b]);
                        tmp.add(nums[ints1[0]]);
                        tmp.add(nums[ints1[1]]);
                        rs.add(tmp);
                    }
                }
            }
        }
        return rs;
    }
}
