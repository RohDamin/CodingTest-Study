/*
Divide and Conquer

재귀 호출과 같이 사용하면 좋음
분할 > 문제 해결 > 병합 과정을 거침
예) 병합 정렬(merge sort), 이분 탐색(binary search), 거듭제곱 연산(a^b)
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static int N, c, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        search(0, 0, N);
    }

    public static void search(int x, int y, int size) {
        if ((r >= x) && (c >= y) && (r < x+size) && (c < y+size)) { // r,c가 범위내에 있는 경우
            search(x, y, size/2);
            search(x, y+size/2, size/2);
            search(x+size/2, y, size/2);
            search(x+size/2, y+size/2, size/2);
        } else {
            count += size*size;
        }
        if (x==r && y==c) {
            System.out.println(count);
            System.exit(0);
        }
    }
}