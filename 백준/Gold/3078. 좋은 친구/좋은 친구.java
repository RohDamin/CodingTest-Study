import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer>[] q = new Queue[21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long sum = 0;

        for (int i = 0; i<21; i++) {
            q[i] = new LinkedList<>(); // 2~20 이름 길이의 큐 배열 만들기
        }

        for (int i = 0; i<N; i++) {
            int len = br.readLine().trim().length();

            if (q[len].isEmpty()) { // 만약 이름 길이의 큐 배열이 비어있는 경우
                q[len].offer(i); // 인덱스 삽입
            } else { // 이름 길이의 큐 배열이 비어있지 않은 경우
                while(i - q[len].peek() > K) { // 좋은 친구가 아닌 경우
                    q[len].poll(); // 비교한 값 삭제
                    if (q[len].isEmpty()) break; // 큐가 비면 중지
                } // 이제 큐에는 좋은 친구인 값들만 남아 있음
                sum += q[len].size(); // 결과값에 추가
                q[len].offer(i); // 지금 들어온 값 큐에 넣어줌

//                for (int j = 0; j<q[len].size(); j++) { // 메모리 초과 나오는 코드
//                    int next = q[len].poll(); // 배열의 top 값을 next에 저장
//                    if (i - next <= K) sum++; // 등수 차이가 K 이하인 경우 카운트 증가
//                    q[len].add(next); // 삭제한 값을 다시 넣어줌
//                }
            }
        }
        System.out.println(sum);
    }
}