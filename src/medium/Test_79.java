package medium;

/**
 *79. 单词搜索
 * (☆☆) 简单dfs
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(dfs(board , i, j, word, 0 , visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board , int i, int j, String word , int idx , boolean visited[][]){
        if(idx >= word.length() - 1)
            return true;
        visited[i][j] = true;
        // 上
        if(i > 0 && !visited[i - 1][j] && board[i-1][j] == word.charAt(idx+1)){
            if(dfs(board,i-1,j,word,idx+1,visited))
                return true;
        }
        // 下
        if(i < board.length - 1 && !visited[i + 1][j] && board[i+1][j] == word.charAt(idx+1)){
            if(dfs(board,i+1,j,word,idx+1,visited))
                return true;
        }
        // 左
        if(j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(idx+1)){
            if(dfs(board,i,j-1,word,idx+1,visited))
                return true;
        }
        // 右
        if(j < board[0].length - 1 && !visited[i][j+1] && board[i][j+1] == word.charAt(idx+1)){
            if(dfs(board,i,j+1,word,idx+1,visited))
                return true;
        }
        visited[i][j] = false;
        return false;
    }

}
