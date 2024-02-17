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
        int arr [] = new int [n];

        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (k>0) {
            for (int i = n-1; i>=0; i--){
                if (k>=arr[i]) { // k에서 뺄 수 있는 금액이라면
                    count += k/arr[i];
                    k -= (k/arr[i])*arr[i];
                }
            }
        }

        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }
}

