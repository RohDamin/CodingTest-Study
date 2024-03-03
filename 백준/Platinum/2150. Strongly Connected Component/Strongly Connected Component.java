/*
# SCC(Strongly Connected Component)
- BFS 기반

1. 코사라주 알고리즘
- 정방향 그래프, 역방향 그래프, 스택 필요
- 정방향 그래프를 DFS를 수행하며 끝나는 순서대로 스택에 삽입(모든 정점에 대해 수행)
- 스택에서 pop하는 순서대로 역방향 DFS를 수행
- 한번 수행에 탐색되는 모든 정점을 같은 SCC로 묶어줌
- 스택이 빌 때까지 이 작업을 반복하면 SCC를 구할 수 있음
-> 2번의 DFS로 구현 -> 시간복잡도 O(V+E)

2. 타잔 알고리즘
- DFS를 수행할 때 생성되는 DFS 트리의 간선 정보를 이용하여 ALL DFS한 번으로 모든 SCC 구함
- ALL DFS를 돌리며 Spanning Tree를 만듦
- DFS 호출 순서에 따라 정점을 stack에 push
- 간선 분류를 통해 먼저 호출되는 정점이 더높은 위치를 가진다고 생각할 때,가장 높이 올라갈 수 있는 정점을 찾음
- 이 때 here->there가 교차간선이지만 아직 there가 SCC에 속하지 않는다면 discover[there] 또한 고려
- DFS가 끝나기전에 ret과 discover[here]가 같다면 stack에서 pop하면서 here가 나올 때까지 같은 SCC로 분류

출처: https://jason9319.tistory.com/98 [ACM-ICPC 상 탈 사람:티스토리]


-> 코사라주 알고리즘을 이용해 구현
 */
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> digraph; // 방향 그래프
    static ArrayList<ArrayList<Integer>> rdigraph; // 역방향 그래프
    static ArrayList<ArrayList<Integer>> result;
    static boolean[] visited;
    static Stack<Integer> stack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        digraph = new ArrayList<>();
        rdigraph = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            digraph.add(new ArrayList<>());
            rdigraph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            digraph.get(a).add(b);
            rdigraph.get(b).add(a);
        }

        stack = new Stack<>();
        visited = new boolean[V+1];

        for (int i = 1; i<=V; i++) {
            if (!visited[i]) dfs(i); 
        }

        Arrays.fill(visited, false); 

        int groupNum = 0;
        while(!stack.isEmpty()) {
            int start = stack.pop();
            if (visited[start]) continue;
            rdfs(start, groupNum);
            groupNum++;
        }

        // 출력
        System.out.println(groupNum);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<groupNum; i++) {
            Collections.sort(result.get(i));
            map.put(result.get(i).get(0), i);
        }
        map.keySet().forEach(key -> {
            int value = map.get(key);
            for (int now : result.get(value)) sb.append(now + " ");
            sb.append("-1\n");
        });

        System.out.print(sb);
        br.close();
    }

    static void dfs (int start) {
        visited[start] = true;
        for (int now : digraph.get(start)) {
            if (!visited[now]) {
                dfs(now);
            }
        }
        stack.push(start);
    }

    static void rdfs (int start, int groupNum) {
        visited[start] = true;
        result.get(groupNum).add(start);

        for (int now : rdigraph.get(start)) {
            if (!visited[now]) {
                rdfs(now, groupNum);
            }
        }
    }
}
