// Greedy Algorithm
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int [k];
        s = br.readLine();
        st = new StringTokenizer(s, " ");

        // 입력값 k개를 배열 arr에 입력받는다
        for (int i = 0; i<k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[101]; // 콘센트가 사용 중인지 저장하는 배열
        int put = 0;
        int ans = 0;
        for (int i =0; i<k; i++) {
            int temp = arr[i];

            if (!use[temp]) { // 콘센트가 사용 중이 아닌 경우
                if (put < n) { // 콘센트를 꽃을 공간이 있는 경우 > 처음 n개는 모두 꽃을 수 있음
                    use[temp] = true;
                    put++;
                }
                else { // 콘센트를 꽃을 공간이 없는 경우
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = i; j<k; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용되는지 확인
                        if (use[arr[j]] && !arrayList.contains(arr[j])) { // 콘센트가 꽃혀 있고 && arrayList에 없는 경우
                            // 중복 제거하고 arrayList에 저장
                            arrayList.add(arr[j]); // arrayList에 추가
                        }
                    }

                    if (arrayList.size() != n) { // 나중에도 사용하는 콘센트가 구멍의 개수와 같지 않은 경우
                        for (int j = 0; j<use.length; j++) {
                            if (use[j] && !arrayList.contains(j)) { // 콘센트가 꽃혀 있고 && arrayList에 없는 경우
                                use[j] = false; // 해당 콘센트 제거
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrayList.get(arrayList.size() - 1);
                        use[remove] = false; // 가장 마지막에 사용될 콘센트 제거
                    }

                    use[temp] = true;
                    ans++;

                }
            }
        }

        System.out.print(ans);

        bw.flush();
        bw.close();
        br.close();
    }
}
