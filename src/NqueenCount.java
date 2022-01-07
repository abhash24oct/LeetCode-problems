public class NqueenCount {


    public int totalNQueens(int n) {
        int count = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] colArray = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        findCount(0, colArray, upperDiagonal, lowerDiagonal, board, count);
        return count;
    }

    void findCount(int col, int[] colArray, int[] upperDiagonal, int[] lowerDiagonal, char[][] board, int count) {
        int n = board.length;
        if (col == n) {

            count = count + 1;
            System.out.println(count);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (colArray[row] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[n - 1 + col - row] == 0) {
                colArray[row] = 1;
                upperDiagonal[row + col] = 1;
                lowerDiagonal[n - 1 + col - row] = 1;
                board[row][col] = 'Q';
                findCount(col + 1, colArray, upperDiagonal, lowerDiagonal, board, count);
                colArray[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n - 1 + col - row] = 0;
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        NqueenCount nqueenCount = new NqueenCount();
        System.out.println(nqueenCount.totalNQueens(4));
    }
}
