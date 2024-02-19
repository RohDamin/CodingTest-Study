/*
Divide and Conquer

재귀 호출과 같이 사용하면 좋음
분할 > 문제 해결 > 병합 과정을 거침
예) 병합 정렬(merge sort), 이분 탐색(binary search), 거듭제곱 연산(a^b)
*/

import java.io.*;
import java.util.*;

public class Main {
    public static char arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i<N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int x, int y, int size, boolean isBlank) {
        if (isBlank) { // 공백으로 채우기
            for (int i=x; i<x+size; i++) {
                for (int j=y; j<y+size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) { // 사이즈 1이면 더 나누지 않고 리턴
            arr[x][y] = '*';
            return;
        }

        int newSize = size/3; // 사이즈 1 이상이면 사이즈 재설정
        int count = 0;
        for (int i = x; i<x+size; i+=newSize) {
            for (int j = y; j<y+size; j+=newSize) {
                count++;
                if (count == 5) { // 만약 가운데 칸이라면
                    star(i, j, newSize, true); // 공백으로 저장
                } else { // 만약 가운데 칸이 아니라면
                    star(i, j, newSize, false); // 공백으로 저장 X
                }
            }
        }
    }
}