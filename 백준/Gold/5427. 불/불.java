import java.io.*;
import java.util.*;
public class Main {
    static int w,h;
    static char[][] map;
    static Queue<int[]> person;
    static Queue<int[]> fire;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fire = new LinkedList<>();
            person = new LinkedList<>();

            for(int i=0; i<h; i++) {
                String line = br.readLine();
                for(int j=0; j<w; j++) {
                    char c = line.charAt(j);
                    if(c=='@') {
                        person.add(new int[] {j,i,0});
                    }else if(c=='*') {
                        fire.add(new int[] {j,i});
                    }
                    map[i][j] = c;
                }
            }
            int res= -1;
            out : while(true) {
                int fSize = fire.size();
                for(int i=0; i<fSize; i++) {
                    int[] pos = fire.poll();
                    int px = pos[0], py = pos[1];
                    fire(px, py);
                }

                int pSize = person.size();
                for(int i=0; i<pSize; i++) {
                    int[] pos = person.poll();
                    int px = pos[0], py = pos[1], time =pos[2];
                    res = escape(px, py, time);
                    if(res != -1) {
                        break out;
                    }
                }
                if(person.isEmpty()) break;
            }

            if(res !=-1) sb.append(res+"\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb.toString());

    }


    static int escape(int x, int y, int time) {
        for (int i = 0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextY > h-1 || nextX > w-1) { // 출구를 찾은 경우
                return time+1; // 최단시간 리턴
            }
            if (map[nextY][nextX] == '.') { // 통로인 경우
                map[nextY][nextX] = '@'; // 위치 변경
                person.add(new int[] {nextX, nextY, time+1}); // 큐에 방문한 노드를 삽입, 현재 최단시간+1
            }
        }
        return -1; // 루프가 모두 끝난 경우 -1 리턴 > 탈출이 불가한 경우
    }

    static void fire(int x, int y) {
        for (int i = 0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextY > h-1 || nextX > w-1) {
                continue;
            }

            if (map[nextY][nextX] == '.' || map[nextY][nextX] == '@') { // 인접 노드가 통로인 경우
                fire.add(new int[] {nextX, nextY}); // 큐에 방문한 노드 삽입
                map[nextY][nextX] = '*'; // 불로 변경
            }
        }
    }
}