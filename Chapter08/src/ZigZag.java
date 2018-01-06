public class ZigZag {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        printZigZag(matrix);

        int[][] matrix2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printZigZag(matrix2);

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        printZigZag(matrix3);
    }

    public static void printZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        boolean fromUp = false;

        while (tR <= rows) {
            printLine(matrix, tR, tC, dR, dC, fromUp);

            tR = (tC == cols ? tR + 1 : tR);
            tC = (tC == cols ? tC : tC + 1);

            dC = (dR == rows ? dC + 1 : dC);
            dR = (dR == rows ? dR : dR + 1);

            fromUp = !fromUp;
        }
        System.out.println(" ");
    }

    public static void printLine(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        //从上往下打印斜线上的元素
        if (fromUp) {
            while (tR <= dR) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        } else {
            while (dR >= tR) {
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
    }
}
