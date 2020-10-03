package medium;

/**
 *LCP 19. 秋叶收藏集
 *
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 * 通过次数7,860提交次数18,407
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UlBDOe
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP_19 {
    public static int minimumOperations(String leaves) {
        int[][] arr = new int[leaves.length()][3];
        arr[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        arr[0][1] = Integer.MAX_VALUE;
        arr[0][2] = Integer.MAX_VALUE;
        arr[1][0] = arr[0][0] + (leaves.charAt(1) == 'y' ? 1 : 0);
        arr[1][1] = arr[0][0] + (leaves.charAt(1) == 'r' ? 1 : 0);
        arr[1][2] = Integer.MAX_VALUE;
        for(int i = 2; i < leaves.length(); i++){
            arr[i][0] = arr[i - 1][0] + (leaves.charAt(i) == 'y' ? 1 : 0);
            arr[i][1] = Math.min(arr[i-1][0],arr[i-1][1]) + (leaves.charAt(i) == 'r' ? 1 : 0);
            arr[i][2] = Math.min(arr[i-1][1],arr[i-1][2]) + (leaves.charAt(i) == 'y' ? 1 : 0);
        }
        return arr[leaves.length()-1][2];
    }

    // 优化空间
    public static int minimumOperations3(String leaves) {
        int[]arr = new int[3];
        char[] chars = leaves.toCharArray();
        arr[0] = leaves.charAt(0) == 'y' ? 1 : 0;
        arr[1] = leaves.length() + 1; // 用长度加1即可代表为最大值，避免使用Integer.MAX_VALUE时，相加整形范围
        arr[2] = leaves.length() + 1;
        for(int i = 1; i < leaves.length(); i++){
            arr[2] = Math.min(arr[1],arr[2]) + (chars[i] == 'y' ? 1 : 0);
            arr[1] = Math.min(arr[0],arr[1]) + (chars[i] == 'r' ? 1 : 0);
            arr[0] = arr[0] + (chars[i] == 'y' ? 1 : 0);
        }
        return arr[2];
    }

    // 递归写法，超时
    public  int minimumOperations2(String leaves) {
        char[] chars = leaves.toCharArray();
        return getResult(chars,chars.length-1,2);

    }
    public int getResult(char[] leaves , int idx , int status){

        if(idx == 1){
            switch (status){
                case 0:
                    return (leaves[0] == 'y' ? 1 : 0) + (leaves[1] == 'y' ? 1 : 0);
                case 1:
                    return (leaves[0] == 'y' ? 1 : 0) + (leaves[1] == 'r' ? 1 : 0);
                case 2:
                    return Integer.MAX_VALUE;
                default:
                    return -1;
            }
        }
        switch (status){
            case 0:
                return (leaves[idx] == 'y' ? 1 : 0) + getResult(leaves,idx-1,0);
            case 1:
                return (leaves[idx] == 'r' ? 1 : 0) + Math.min(getResult(leaves,idx - 1, 0) , getResult(leaves , idx - 1, 1));
            case 2:
                return (leaves[idx] == 'y' ? 1 : 0) + Math.min(getResult(leaves,idx - 1, 1) , getResult(leaves , idx - 1, 2));
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        String lev = "yry";
        System.out.println(minimumOperations(lev));
    }
}
