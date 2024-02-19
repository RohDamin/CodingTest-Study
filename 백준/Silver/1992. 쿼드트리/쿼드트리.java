/*
Divide and Conquer

재귀 호출과 같이 사용하면 좋음
분할 > 문제 해결 > 병합 과정을 거침
예) 병합 정렬(merge sort), 이분 탐색(binary search), 거듭제곱 연산(a^b)
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int [n][n];

        for (int i = 0; i<n; i++) {
            String s = br.readLine();
            for (int j = 0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        QuadTree(0, 0, n);
        System.out.println(sb);
    }

    public static void QuadTree(int x, int y, int size) {
        // 압축이 가능한 경우
        if (ispossble(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newsize = size/2;
        sb.append('(');
        QuadTree(x, y, newsize);
        QuadTree(x, y+newsize, newsize);
        QuadTree(x+newsize, y, newsize);
        QuadTree(x+newsize, y+newsize, newsize);
        sb.append(')');
    }

    // 압축이 가능한지 체크
    public static boolean ispossble(int x, int y, int size) {
        int color = arr[x][y]; // 첫번째 원소 기준

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
