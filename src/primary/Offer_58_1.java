package primary;

import java.util.Stack;

/**
 *剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_58_1 {
    // 7ms
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] s1 = s.split(" +");
        for(int i = s1.length - 1; i >= 0; i--){
            sb.append(s1[i].trim() + " ");
        }
        return sb.toString().trim();
    }
    // 2ms
    public String reverseWords4(String s) {
        StringBuffer sb = new StringBuffer();
        String[] s1 = s.split(" ");
        for(int i = s1.length - 1; i >= 0; i--){
            if(!"".equals(s1[i].trim()))
                sb.append(s1[i].trim() + " ");
        }
        return sb.toString().trim();
    }
    // 3ms
    public String reverseWords2(String s) {
        int start = s.length() - 1, end = start;
        StringBuffer sb = new StringBuffer();
        while(start >= 0){
            while(start >= 0 && s.charAt(start) == ' ')
                start--;
            if(start < 0)
                break;
            end = start;
            while(start >= 0 && s.charAt(start) != ' ')
                start--;
            sb.append(s,start+1,end+1);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    // 5ms
    public String reverseWords3(String s) {
        int start = 0,end=0;
        StringBuffer sb = new StringBuffer();
        Stack<String> stack = new Stack<>();
        while(end < s.length()){
            while(end < s.length() && s.charAt(end) == ' ')
                end++;
            if(end >= s.length())
                break;
            start = end;
            while(end < s.length() && s.charAt(end) != ' ')
                end++;
            stack.push(s.substring(start,end));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
