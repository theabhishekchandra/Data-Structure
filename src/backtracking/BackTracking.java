package backtracking;

import java.util.Arrays;
import java.util.Random;

public class BackTracking {
    /** TYPE OF BACKTRACKING <p>
     *  Decision
     *  Optimization
     *  Enumeration -> list of possible solutions.*/
    public static void main(String[] args) {
        /*int[] baseArray = new int[5];
        changeArray(baseArray,0,1);
        System.out.println("Array: " + Arrays.toString(baseArray));*/
        String string = "abc";
//        printPermutation(string,"",0);

        /*// Chess Problem
        char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
        nQueen(board,0);*/
       /* char[][] sudokuBoard = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        /// Sudoku Problem
        sudoku(sudokuBoard,0,0);*/


    }

    static void changeArray(int[] arr, int i, int val){
        if (i == arr.length) {
            System.out.println("Array: " + Arrays.toString(arr));
            return;
        }
        arr[i] = val;
        changeArray(arr, i+1, val+1);  // recursion
        arr[i] = arr[i] - 2; // Backtrack
    }

    static void findSubset(String str, String ans, int i){
        // Base Case
        if (i == str.length()){
            System.out.println(ans);
            return;
        }
        // yes
        findSubset(str, ans + str.charAt(i), i+1);

        // No
        findSubset(str,ans,i+1);

    }

    static void permutations(String str, String ans){
        // Base str = "abc"
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i);
            permutations(newStr, ans + curr);
        }
    }

    static void printPermutation(String str, String ans, int idx){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            String NewStr = str.substring(0,i) + str.substring(i + 1);
            printPermutation(NewStr,ans + curChar ,idx +1);
        }

    }

    static void nQueen(char[][] board, int row){
//        System.out.println(Arrays.deepToString(board));
        // Base
        if (row == board.length){
            System.out.println("__________");
            printBoard(board);
            return;
        }
        for (int j = 0 ; j < board.length;j++){
            if (isSafePlaceForQueen(board,row,j)) {
                board[row][j] = 'Q'; // Set Queen.
                nQueen(board,row +1); // Recursion function.
                board[row][j] = '.'; // Backtracking -> clear after backtracking.
            }
        }
    }
    static Boolean isSafePlaceForQueen(char[][] board, int row, int column){
        // i = row and j = column
        // For Upper Right Diagonal. i++, j--.
        for (int i = row -1 ,j = column + 1; i >= 0 && j < board.length; i-- , j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // For Upper Left Diagonal. i--, j--.

        for (int i = row -1 ,j = column -1; i >= 0 && j >= 0; i-- , j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        // For Lower Right Diagonal i++, j++.

        // For Lower Left Diagonal i--, j--.

        /*// For Bottom j, i++.
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 'Q'){
                return false;
            }
        }*/
        // For Top j, i--.
        for (int i = board.length -1 ; i >= 0 ; i--) {
            if (board[i][column] == 'Q'){
                return false;
            }
        }

        /*// For Right i, j++.
        for (int j = 0 ; j < board.length; j++){
            if (board[row][j] == 'Q'){
                return false;
            }
        }
        // For Left i, j--.
        for (int j = board.length - 1; j >= 0; j--){
            if (board[row][j] == 'Q'){
                return false;
            }
        }*/

        return true;
    }
    static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void sudoku(char[][] board, int row, int col) {
        // Base case: If the row exceeds the board, the puzzle is solved
        if (row == 9) {
            printBoard(board);
            return;
        }

        // Move to the next column; if at last column, move to the next row
        int nRow = row, nCol = col + 1;
        if (nCol == 9) {
            nRow++;
            nCol = 0;
        }

        // If the cell is already filled, move to next
        if (board[row][col] != '.') {
            sudoku(board, nRow, nCol);
            return;
        }

        // Try digits 1-9
        for (int digit = 1; digit <= 9; digit++) {
            if (isCorrectDigit(board, row, col, digit)) {
                board[row][col] = (char) ('0' + digit);
                sudoku(board, nRow, nCol);
                board[row][col] = '.';  // Backtrack
            }
        }
    }

    static Boolean isCorrectDigit(char[][] board, int row, int col, int digit) {
        char digitChar = (char) ('0' + digit);

        // Horizontally
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digitChar) {
                return false;
            }
        }

        // Vertically
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digitChar) {
                return false;
            }
        }

        // 3x3 Grid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == digitChar) {
                    return false;
                }
            }
        }
        return true;
    }

}
