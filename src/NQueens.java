import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                board[j][i] = '.';
            }
        }
        backtrack( 0, board, ans);
        return ans;
    }

    private void backtrack( int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            ArrayList<String> ds = new ArrayList();
            for (char[] chars : board) {
                String r = new String(chars);
                ds.add(r);
            }
            ans.add(ds);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isPossiblePlace(board, row, col)) {
                board[row][col] = 'Q';
                backtrack( col+1, board, ans);
                board[row][col] = '.';
            }
        }

    }

    private boolean isPossiblePlace(char[][] board, int row, int col) {
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i < board.length && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        i = row;
        j = col;
        while (j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            j--;
        }
        return true;
    }
}
