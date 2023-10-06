package dev.patika.plus.week2;

public class MatrixTransposeCalculator {
    public static void run() {
        int[][] matrixA, matrixT;

        matrixA = new int[][]{
                { 2, 3, 4,},
                { 5, 6, 4 },
        };
        matrixT = transposeMatrix2DInt(matrixA);

        System.out.println("Original matrix:");
        printMatrix2DInt(matrixA);
        System.out.println("Transposed matrix:");
        printMatrix2DInt(matrixT);
    }

    public static int[][] transposeMatrix2DInt(int[][] A) {
        int[][] matrixTransposed;
        int rowA, columnA;

        rowA = A.length;
        columnA = A[0].length;
        matrixTransposed = new int[columnA][rowA];

        for (int i = 0; i < columnA; i++) {
            for (int j = 0; j < rowA; j++) {
                matrixTransposed[i][j] = A[j][i];
            }
        }
        return matrixTransposed;
    }

    public static void printMatrix2DInt(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
