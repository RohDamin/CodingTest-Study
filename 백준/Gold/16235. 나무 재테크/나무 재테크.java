import java.io.*;
import java.util.*;
class Tree implements Comparable<Tree> {
    int x, y, age;
    public Tree(int x, int y, int age) {
        super();
        this.x = x;
        this.y = y;
        this.age = age;
    }
    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}

public class Main {
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int[][] A;
    static int[][] map;
    static Deque<Tree> tree;
    static Queue<Tree> deadTree;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        tree = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, age));
        }

        while (K > 0) {
            deadTree = new LinkedList<>();
            Spring();
            Summer();
            Autumn();
            Winter();
            K--;
        }

        bw.write(tree.size() + "\n");
        bw.flush();
        bw.close();
    }

    static void Spring() {
        for (int i = 0; i < tree.size();) {
            Tree cur = tree.poll();
            if (map[cur.x][cur.y] >= cur.age) {
                map[cur.x][cur.y] -= cur.age;
                cur.age++;
                i++;
                tree.add(cur);
            } else {
                deadTree.add(cur);
            }
        }
    }

    static void Summer() {
        for (Tree t : deadTree) {
            map[t.x][t.y] += t.age / 2;
        }
    }

    static void Autumn() {
        Queue<Tree> temp_list = new LinkedList<>();
        for (Tree t : tree) {
            if (t.age % 5 == 0) {
                temp_list.add(t);
            }
        }
        while (!temp_list.isEmpty()) {
            Tree t = temp_list.poll();

            for (int i = 0; i < 8; i++) {
                int next_x = t.x + dx[i];
                int next_y = t.y + dy[i];
                if (next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N) {
                    tree.addFirst(new Tree(next_x, next_y, 1));
                }
            }
        }
    }

    static void Winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }
}
