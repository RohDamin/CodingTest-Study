import java.io.*;
import java.util.*;

public class Main {
    static String correct = "123456780";
    static Map<String, Integer> map = new HashMap<>();

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        for (int i = 0; i<9; i++) {
            if (i%3 == 0) st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken());
        }
        String puzzle = sb.toString();
        map.put(puzzle, 0);
        System.out.println(bfs(puzzle));
    }

    public static int bfs(String puzzle) {
        Queue<String> q = new LinkedList<>();
        q.add(puzzle);

        while (!q.isEmpty()) {
            String pos = q.poll();
            int move = map.get(pos);
            int empty = pos.indexOf('0');
            int px = empty%3;
            int py = empty/3;

            if (pos.equals(correct)) return move;

            for (int i = 0; i<4; i++) {
                int nx = px+dx[i];
                int ny = py+dy[i];

                if (!isRange(nx, ny)) continue;

                int nPos = ny*3 + nx;
                char ch = pos.charAt(nPos);
                String next = pos.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, move+1);
                }
            }
        }
        return -1;
    }

    public static boolean isRange(int y, int x) {
        return x>=0 && y>=0 && x<3 && y<3;
    }
}