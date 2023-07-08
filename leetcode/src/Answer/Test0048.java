package Answer;

import java.util.Scanner;

public class Test0048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入是几阶的矩阵:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("请输入图像的矩阵:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

    }
}

class Demo0048{
    public void rotate(int[][] matrix) {

    }
}
