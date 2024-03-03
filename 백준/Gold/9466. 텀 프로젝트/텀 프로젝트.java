import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int cnt = 0;
    static int[] team;
    static boolean[] visited; // 정점 방문을 시작했는지 나타냄
    static boolean[] finished; // 정점의 방문을 완전히 끝냈는지 나타냄

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            team = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int n = 1; n<N+1; n++) {
                team[n] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i<N+1; i++) dfs(i);
            System.out.println(N - cnt); // 팀에 속하지 못한 학생들이므로 N-cnt
            cnt = 0; // cnt 초기화
        }
    }

    static void dfs(int now) {
        if (visited[now]) return; // 방문한 노드면 stop
        visited[now] = true; // 그렇지 않은 경우 true로 변경

        int next = team[now]; // 다음 값은 team[now]가 가리키는 값
        if (!visited[next]) dfs(next); // 다음 값을 방문한 적 없다면 dfs
        else { // 다음 값을 방문한 적 있다면
            if (!finished[next]) { // 정점 탐색을 끝냈는지 확인
                cnt++; // 현재 카운트 추가하고
                for (int i = next; i != now; i = team[i]) cnt++; // 사이클 돌면서 카운트 추가
            }
        }
        finished[now] = true; // 모든 탐색 끝나면 true로 변경
    }
}