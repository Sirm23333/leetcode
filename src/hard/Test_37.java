package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 37.解数独
 * dfs
 * (☆☆☆)
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_37 {

    public static int N = 9;
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[N][N]; // row[i][k]表示第i行有没有k
        boolean[][] col = new boolean[N][N]; // 表示第i列有没有k
        boolean[][] util = new boolean[N][N]; // 表示第i个九宫格有没有k
        List<Integer> rest = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    rest.add(i * N + j);
                    continue;
                }
                row[i][board[i][j]-'0'-1] = true;
                col[j][board[i][j]-'0'-1] = true;
                util[getUtilIndex(i,j)][board[i][j]-'0'-1] = true;
            }
        }
        if(rest.size() > 0){
            dfs(board,rest,0,row,col,util);
        }
    }
    public boolean dfs(char[][] board , List<Integer>rest , int restIdx  , boolean[][] row, boolean[][] col, boolean[][] util){

        if(restIdx >= rest.size())
            return true;
        int idx = rest.get(restIdx);
        for(int i = 1; i <= 9; i++){
            if(!row[idx/N][i-1] && !col[idx%N][i-1] && !util[getUtilIndex(idx/N,idx%N)][i-1]){
                board[idx / N][idx % N] = (char)(i + '0');
                row[idx / N][i-1] = true;
                col[idx % N][i-1] = true;
                util[getUtilIndex(idx/N,idx%N)][i-1] = true;
                if(dfs(board,rest,restIdx+1,row,col,util))
                    return true;
                board[idx / N][idx % N] = '.';
                row[idx / N][i-1] = false;
                col[idx % N][i-1] = false;
                util[getUtilIndex(idx/N,idx%N)][i-1] = false;
            }
        }
        return false;
    }

    public int getUtilIndex(int i, int j){
        return (i / 3) * 3 + (j / 3);
    }

}
