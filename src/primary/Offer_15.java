package primary;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 *请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_15 {
    private static int tmp_0 = 0x55555555; // 0101,0101,0101,0101,0101,0101,0101,0101
    private static int tmp_1 = 0xaaaaaaaa; // 1010,1010,1010,1010,1010,1010,1010,1010
    private static int tmp_2 = 0x33333333; // 0011,0011,0011,0011,0011,0011,0011,0011
    private static int tmp_4 = 0xcccccccc; // 1100,1100,1100,1100,1100,1100,1100,1100
    private static int tmp_8 = 0x0f0f0f0f; // 0000,1111,0000,1111,0000,1111,0000,1111
    private static int tmp_16 = 0xf0f0f0f0; // 1111,0000,1111,0000,1111,0000,1111,0000
    private static int tmp_32 = 0x00ff00ff; // 0000,0000,1111,1111,0000,0000,1111,1111

    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0){
            if((n & 1) == 1){
                cnt++;
            }
            n = n >>> 1;
        }
        return cnt;
    }

    public int hammingWeight2(int n) {
        int x = n;
        x = x & 0x55555555 + (x & 0xaaaaaaaa >>> 1);
        x = x & 0x33333333 + (x & 0xcccccccc >>> 2);
        x = x & 0x0f0f0f0f + (x & 0xf0f0f0f0 >>> 4);
        x = x & 0x00ff00ff + (x & 0xff00ff00 >>> 8);
        x = x & 0x0000ffff + (x & 0xffff0000 >>> 16);
        return x;
    }
}
