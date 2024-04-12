import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들아있는 수의 개수
            String numbers = br.readLine(); // 배열에 들어있는 정수
            ArrayList<Integer> arr = makeArray(numbers, n); // numbers -> 리스트에 저장

            boolean isReverse = false; // R 함수가 실행된 경우 변경
            boolean error = false; // error가 발생한 경우 true

            for (int i = 0; i< p.length(); i++) {
                char op = p.charAt(i);
                if (op == 'R') { // 배열에 있는 수의 순서를 뒤집는 함수
                    isReverse = !isReverse;
                } else if (op == 'D'){ // 첫 번째 수를 버리는 함수
                    // 리스트가 비어 있는 경우
                    if (arr.isEmpty()) {
                        if (error) continue;
                        sb.append("error\n");
                        error = true;
                        continue;
                    }
                    // 리스트가 비어 있지 않은 경우
                    if (isReverse) arr.remove(arr.size()-1);
                    else arr.remove(0);
                }
            }
            if (error) continue;
            sb.append("[");

            if (isReverse) {
                for (int i = arr.size()-1; i>=0; i--) {
                    sb.append(arr.get(i)).append(",");
                }
            } else {
                for (int i = 0; i<arr.size(); i++) {
                    sb.append(arr.get(i)).append(",");
                }
            }
            if (sb.charAt(sb.length()-1) != '[') sb.deleteCharAt(sb.length()-1).append("]").append("\n");
            else sb.append("]").append("\n");
        }
        System.out.println(sb);
    }

    static ArrayList<Integer> makeArray(String s, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s.replace("[", "").
                replace("]", ""), ",");
        for (int i = 0; i<n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        return arr;
    }
}