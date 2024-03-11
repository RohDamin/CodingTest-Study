/*
 # 트리(Tree)

 * 트리는 다음과 같은 조건들을 충족한다.
 1) 연결 그래프이다.
 2) 방향을 무시하였을 때, 싸이클이 존재하지 않는다.
 3) 트리의 간선 개수는 반드시 트리의 정점 개수보다 1작다

 * 전위 순회, 중위 순회, 후위 순회, 레벨 순회가 존재한다.
 * 재귀적인 구조를 가지고 있다.

 */
import java.io.*;
import java.util.*;

public class Main {
    static class Island {
        char animal;
        long num;

        public Island(char animal, long num) {
            this.animal = animal;
            this.num = num;
        }
    }

    static Island[] islands;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        islands = new Island[N+1];
        tree = new ArrayList<>();
        for (int i = 0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        islands[1] = new Island( 'S', 0);
        for (int i = 2; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char t = st.nextToken().charAt(0);
            long a = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            islands[i] = new Island(t, a);
            tree.get(p).add(i);
        }
        System.out.println(dfs(1));
    }

    public static long dfs (int index) {
        long sum = 0;

        for (int next : tree.get(index)) {
            sum += dfs(next);
        }

        if (islands[index].animal == 'S') { // 양인 경우
            return sum + islands[index].num;
        } else { // 늑대인 경우
            return (sum - islands[index].num < 0) ? 0 : sum-islands[index].num;
        }
    }
}