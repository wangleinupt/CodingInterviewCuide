public class SpiralPrint {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        spiralOrderPrint(matrix);

        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        spiralOrderPrint(matrix1);
    }

    public static void spiralOrderPrint(int[][] matrix){
        int tR = 0;
        int tC = 0;

        int dR = matrix.length-1;
        int dC = matrix[0].length-1;

        while (tR <= dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }

        System.out.println(" ");
    }


    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            //最后一圈是一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if (tC == dC) {
            //最后一圈是一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC]);
            }
        } else {
            int nowR = tR;
            int nowC = tC;

            //打印上面一行
            while (nowC < dC){
                System.out.print(matrix[nowR][nowC++] + " ");
            }
            //打印右边一列
            while (nowR < dR){
                System.out.print(matrix[nowR++][nowC] + " ");
            }
            //打印下边一行
            while (nowC > tC){
                System.out.print(matrix[nowR][nowC--] + " ");
            }
            //打印左边一列
            while (nowR > tR){
                System.out.print(matrix[nowR--][nowC] + " ");
            }
        }
    }
}
