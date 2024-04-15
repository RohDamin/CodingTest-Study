// 좌표 압축, 정렬
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] origin, sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        origin = new int[N];
        sorted = new int[N];
        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            // 중복 제거
            // hashMap에 v가 없을 때에만 배열에 값 넣기
            if(!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++;
            }
        }

        for (int key : origin) {
            // 중복이 제거된 랭킹 값을 출력하면 됨
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}