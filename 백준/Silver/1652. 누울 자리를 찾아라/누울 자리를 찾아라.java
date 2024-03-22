import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int horiz = 0; // 가로 자리 개수
        int verti = 0; // 세로 자리 개수
        for (int i = 0; i<N; i++) {
            int horizCnt = 0;
            int vertiCnt = 0;
            for (int j = 0; j<N; j++) {
                // 가로
                if (map[i][j] == '.') horizCnt++;
                else if (map[i][j] == 'X') {
                    if (horizCnt>=2) horiz++;
                    horizCnt = 0;
                }

                // 세로
                if (map[j][i] == '.') vertiCnt++;
                else if (map[j][i] == 'X') {
                    if (vertiCnt>=2) verti++;
                    vertiCnt = 0;
                }
            }
            // for 문 끝났는데 cnt가 2보다 같거나 크면 자리개수++
            if (horizCnt>=2) horiz++;
            if (vertiCnt>=2) verti++;
        }
        System.out.print(horiz + " " + verti);
    }
}