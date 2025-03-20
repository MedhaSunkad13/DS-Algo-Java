// import java.util.*;

// public class Matrices {

//     public static void minMax(int matrix[][]) {
//         int largest = Integer.MIN_VALUE;
//         int smallest = Integer.MAX_VALUE;

//         for(int i = 0; i < matrix.length; i++) {
//             for(int j = 0; j < matrix[0].length; j++) {
//                 if(largest < matrix[i][j]) {
//                     largest = matrix[i][j];
//                 }

//                  if(smallest > matrix[i][j]) {
//                     smallest = matrix[i][j];
//                 }
//             }
//         }
//         System.out.println("Largest element: " + largest);
//         System.out.println("Smallest element: " + smallest);
//     } 

//     public static boolean searchKey(int matrix[][], int target) {
//         for(int i = 0; i < matrix.length; i++) {
//             for(int j = 0; j < matrix[0].length; j++) {
//                 if(matrix[i][j] == target) {
//                     System.out.println("Target found at index " + "(" +i+ "," +j+ ")");
//                     return true;
//                 }
//             }
//         }
//         System.out.println("Target NOT found");
//         return false;
//     }

//     // public static void main(String args[]) {
//     //     Scanner sc = new Scanner(System.in);

//     //     int matrix[][] = new int[3][3];

//     //     int n = 3, m = 3;

//     //     for(int i = 0; i < n; i++) {
//     //         for(int j = 0; j < m; j++) {
//     //             matrix[i][j] = sc.nextInt();
//     //         }
//     //     }
//     //     //Output
//     //      for(int i = 0; i < n; i++) {
//     //         for(int j = 0; j < m; j++) {
//     //             System.out.print(matrix[i][j] +" ");
//     //         }
//     //         System.out.println();
//     //      }
//     //      //searchKey(matrix, 7);
//     //      minMax(matrix);
//     // }

//     // public static void printSpiral(int matrix[][]) {
//         // int startRow = 0;
//         // int startCol = 0;
//         // int endRow = matrix.length-1;
//         // int endCol = matrix[0].length-1;

//         // while(startRow <= endRow && startCol <= endCol) {
//         //     //top
//         //     for(int j = startCol; j <= endCol; j++) {
//         //         System.out.print(matrix[startRow][j]+" ");
//         //     }

//             //right
//             for(int i = startRow+1; i <= endRow; i++) {
//                 System.out.print(matrix[i][endCol]+" ");
//             }

//             //bottom
//             for(int j = endCol-1; j >= startCol; j--) {
//                  if(startRow == endRow) {
//                     break;
//                 }
//                 System.out.print(matrix[endRow][j]+" ");
//             }

//             //Left
//             for(int i = endRow-1; i >= startRow+1; i--) {
//                 if(startCol == endCol) {
//                     break;
//                 }
//                 System.out.print(matrix[i][startCol] +" ");
//             }

//             startRow++;
//             startCol++;
//             endRow--;
//             endCol--;
//         }
//     }

//     // public static int diagonalSum(int matrix[][]) { //T.C = O(n^2)
//     //     int sum = 0;
//     //     //Loops
//     //     // for(int i = 0; i < matrix.length; i++) {
//     //     //     for(int j = 0; j < matrix[0].length; j++) {
//     //     //         //Primary Diagonal
//     //     //         if(i == j) {
//     //     //             sum = sum + matrix[i][j];
//     //     //         }
//     //     //         else if(i + j == matrix.length-1) {
//     //     //             sum = sum + matrix[i][j];
//     //     //         }
//     //     //     }
//     //     // }

//     //     //Optimized Code
//     //     for(int i = 0; i < matrix.length; i++) { //linear T.C = O(n)
//     //         //PD
//     //         sum += matrix[i][i];

//     //         //SD
//     //         if(i != matrix.length-1-i)
//     //         sum += matrix[i][matrix.length-1-i];
//     //     }
//     //     return sum;
//     // }

//     // public static boolean staircaseSearch(int matrix[][], int target) {
//         //int row = 0, col = matrix[0].length-1;
//         // int col = 0, row = matrix.length-1;

//         //   while (col >= 0 && row <= matrix.length-1) { 
//             if (matrix[row][col] == target) {
//             System.out.println("Found at index (" + row + "," + col + ")");
//             return true;
//         }
//             else if(target > matrix[row][col]) {
//                 col++;
//             }
//             else{
//                 row--;
//             }
//         }

//         // while(row <= matrix.length && col >= 0) {
//         //     if(matrix[row][col] == target) {
//         //         System.out.println("Found key at index " +"(" +row+ "," +col+ ")");
//         //         return true;
//         //     }
//         //     else if(target < matrix[row][col]) {
//         //         col--;
//         //     }
//         //     else {
//         //         row++;
//         //     }
//         // }
//     //     System.out.print("Target not found");
//     //     return false;
//     // }
    
//     // public static int countOccurrences(int matrix[][], int key) {
//     //     int cnt = 0;
//     //     for(int i = 0; i < matrix.length; i++) {
//     //         for(int j = 0; j < matrix[0].length; j++) {
//     //             if(matrix[i][j] == key) {
//     //                 cnt += 1;
//     //             }
//     //         }
//     //     }
//     //     return cnt;
//     // }

//     // public static int calculateSum(int matrix[][]) {
//         int sum = 0;
//         int row = 1;
//         for(int col = 0; col < matrix[0].length; col++) {
//             sum += matrix[row][col];
//         }
//         return sum;
//     }

//     // public static int[][] findTranspose(int matrix[][]) {
//     //     int newMatrix[][] = new int[matrix[0].length][matrix.length];
//     //     for(int i = 0; i < matrix.length; i++) {
//     //         for(int j = 0; j < matrix[0].length; j++) {
//                 //swap
//                 // int temp = i;
//                 // i = j;
//                 // j = temp;
//                 //int newMatrix[j][i] = matrix[i][j];
//         //     }
//         // }
//         //return newMatrix[][];
//     //}

//     // public static void printMatrix(int matrix[][]) {
//         for(int i = 0; i < newMatrix.length; i++) {
//             for(int j = 0; j < newMatrix[0].length; j++) {
//                 System.out.print(newMatrix[i][j] +" ");
//             }
//         }
//         System.out.println();
//     }

//     // public static void main(String args[]) {
//         //int matrix[][] = {{1, 2, 3, 4,},
//                         //   {5, 6, 7, 8},
//                         //   {9, 10, 11, 12},
//                         //   {13, 14, 15, 16}};

//         //printSpiral(matrix);
//         //System.out.println("Diagonal Sum = " +diagonalSum(matrix));

//         // int matrix[][] = {
//         //                    {10, 20, 30, 40},
//         //                    {15, 25, 35, 45},
//         //                    {27, 29, 37, 48},
//         //                    {32, 33, 39, 50},
//         //                   };
//         // staircaseSearch(matrix, 10);
//         // int matrix[][] = {
//         //                     {2, 6, 4},        
//         //                     {1, 5, 9},
//         //                     {11, 4, 3},
//         //                     {2, 1, 3},
//         //                  };

//         //System.out.println("Sum of 2nd row = " +calculateSum(matrix));
//         //System.out.println("Count = " +countOccurrences(matrix, 7));
//         // System.out.println("Original Matrix:");
//         // printMatrix(matrix);
//         // System.out.println("Transpose of a matrix: "+findTranspose(matrix));
//         // printMatrix(newMatrix);
// //     }
// // }