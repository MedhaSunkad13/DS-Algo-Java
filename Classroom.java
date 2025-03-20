//import java.util.*;

public class Classroom {

    public static void printArr(int []arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void changeArr(int arr[], int val, int i) {
        //Base Case:
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        //Recursion
        arr[i] = val;
        changeArr(arr, val+1, i+1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubSets(String str, String ans, int i) {
    // Base Case
    if (i == str.length()) {
        if (ans.length() == 0) {
            System.out.println("null");  
        } else {
            System.out.println(ans);
        }
        return;
    }

    // Yes Choice
    findSubSets(str, ans + str.charAt(i), i + 1);

    // No Choice 
    findSubSets(str, ans, i + 1);   
   }

    //String builder
    // public static void findSubSets(String str, StringBuilder ans, int i) {
    // // Base Case
    //     if (i == str.length()) {
    //         if (ans.length() == 0) {
    //             System.out.println("null");
    //         } else {
    //             System.out.println(ans);
    //         }
    //         return;
    //     }
        
    //     // Yes Choice
    //     ans.append(str.charAt(i));
    //     findSubSets(str, ans, i + 1);
        
    //     // Backtrack
    //     ans.deleteCharAt(ans.length() - 1); 
        
    //     // No Choice
    //     findSubSets(str, ans, i + 1);
    // }

    public static void findPermutations(String str, String ans) {
        //Base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //Recursion: T.C = O(n * n!)
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            //"abcde" => "ab" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutations(newStr, ans+curr);
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        //vertical up
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //Diagonal left up
        for(int i = row-1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //vertical right up
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
             if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    // public static void nQueens(char board[][], int row) {
    //     if(row == board.length) {
    //         printBoard(board);
    //         count++;
    //         return;
    //     }

    //     //Column loop
    //     for(int j = 0; j < board.length; j++) {
    //        if(isSafe(board, row, j)) {
    //          board[row][j] = 'Q';
    //         //System.out.println("Row: " + row + " Col: " + j);
    //         nQueens(board, row + 1); //function call
    //         board[row][j] = 'x'; //backtracking
    //        }
    //     }
    // }

    public static boolean nQueens(char board[][], int row) {
        if(row == board.length) {
            //printBoard(board);
            count++;
            return true;
        }

        //Column loop
        for(int j = 0; j < board.length; j++) {
           if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                //System.out.println("Row: " + row + " Col: " + j);
                if(nQueens(board, row + 1)) { //function call
                    return true;
                }
                    board[row][j] = 'x'; //backtracking
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("-------Chess-Board-------");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int countGridWays(int i, int j, int n, int m) {
        //Base Case:
        if(i == n - 1 && j == m - 1) { //Condn for last cell
            return 1;
        }
        else if(i == n || j == m) { //boundary condition 
            return 0;
        }

        int w1 = countGridWays(i+1, j, n, m); //Move down
        int w2 = countGridWays(i, j+1, n, m); //Move right
        return w1 + w2;
    }

    //Sudoku Solver
    public static boolean isSafe(int sudoku[][], int row, int col, int dig) {
        //Column
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == dig) {
                return false;
            }
        }

        //Row
        for(int j = 0; j < 9; j++) {
            if(sudoku[row][j] == dig) {
                return false;
            }
        }

        //Grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        
        //3x3 Grid
        for(int i = sr; i < sr+3; i++) {
            for(int j = sc; j < sc+3; j++) {
                if(sudoku[i][j] == dig) {
                    return false;
                }
            }
        }
        return true;
    }

   public static boolean sudokuSolver(int sudoku[][], int row, int col) {
    //Base Case
    if(row == 9) { 
        return true;
    }

    //Recursion-Work
    int nextRow = row, nextCol = col + 1;
    if(nextCol == 9) {
        nextRow = row + 1;
        nextCol = 0;
    }

    if(sudoku[row][col] != 0) {
        return sudokuSolver(sudoku, nextRow, nextCol);
    }

    for(int dig = 1; dig <= 9; dig++) {
        if(isSafe(sudoku, row, col, dig)) {
            sudoku[row][col] = dig;
            if(sudokuSolver(sudoku, nextRow, nextCol)) { //Soln Exists
                return true;
            }
            sudoku[row][col] = 0; //Backtracking
        }
    }
    return false;
   }

    public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ratInAMaze(int maze[], int x, int y) {
        //Base Case:

        //Recursion
       
    }

    static int count = 0;

    public static void main(String args[]) {
            // int arr[] = new int[5];
            // changeArr(arr, 1, 0);
            // printArr(arr);
            // String str = "abc";
            // findSubSets(str, new StringBuilder(), 0);
            // findSubSets(str, "", 0);
            // findPermutations(str, " ");
            //  int n = 3;
            //  char board[][] = new char[n][n];
            //Initialize
            //  for(int i = 0; i < n; i++) {
            //     for(int j = 0; j < n; j++) {
            //         board[i][j] = 'x';
            //     }
            // }
            //nQueens(board, 0);
            // if(nQueens(board, 0)) {
            //     System.out.println("Solution is possible.");
            //     printBoard(board);
            // }
            // else {
            //     System.out.println("Solution is not possibe.");
            // }
            //System.out.println("Total possible ways to solve N-queens = " +count);
            // int n = 4, m = 4;
            // System.out.println(countGridWays(0, 0, n, m));

                int sudoku[][] = {
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
            if(sudokuSolver(sudoku, 0, 0)) {
                System.out.println("Solution exists for the sudoku");
                printSudoku(sudoku);
            }
            else {
                System.out.println("Solution doesn't exists for the sudoku.");
            }

            // int maze[][] = { { 1, 0, 0, 0 },
            //                  { 1, 1, 0, 1 },
            //                  { 0, 1, 0, 0 },
            //                  { 1, 1, 1, 1 } };
            //     System.out.println(ratInAMaze(maze, 0, 0));
    }
} 