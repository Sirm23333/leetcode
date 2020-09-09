package primary;

/**
 *给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_859 {

    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        // 考虑A和B相同的情况
        if(A.equals(B)){
            for(int i = 0; i < A.length(); i++){
                if(A.lastIndexOf(A.charAt(i)) != i)
                    return true;
            }
            return false;
        }
        // A和B不同的情况
        int hasUnSameIndexCnt = 0; // 标识已经查到同一位置有不同的字母
        char tempA = 0,tempB = 0; // 保存不同的两个字母
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                hasUnSameIndexCnt++;
                if(hasUnSameIndexCnt >= 3)
                    return false;
                else if(hasUnSameIndexCnt >= 2){
                    if(A.charAt(i) != tempB || B.charAt(i) != tempA)
                        return false;
                }else {
                    tempA = A.charAt(i);
                    tempB = B.charAt(i);
                }
            }
        }
        return hasUnSameIndexCnt == 2;
    }


}
