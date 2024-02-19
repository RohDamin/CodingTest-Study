/*
Divide and Conquer

재귀 호출과 같이 사용하면 좋음
분할 > 문제 해결 > 병합 과정을 거침
예) 병합 정렬(merge sort), 이분 탐색(binary search), 거듭제곱 연산(a^b)
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int minus = 0;
    public static int zero = 0;
    public static int plus = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int [n][n];

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == -1) {
                minus++;
            } else if (board[row][col] == 0){
                zero++;
            } else {
                plus++;
            }
            return;
        }

        int newSize = size/3; // 1/3 사이즈
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row, col+newSize+newSize, newSize);

        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
        partition(row+newSize, col+newSize+newSize, newSize);

        partition(row+newSize+newSize, col, newSize);
        partition(row+newSize+newSize, col+newSize, newSize);
        partition(row+newSize+newSize, col+newSize+newSize, newSize);
    }

    // 현재 파티션의 컬러가 모두 같은지 체크
    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; // 첫번째 원소 기준

        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if (board[i][j] != color) return false;
            }
        }
        return true;
    }
}