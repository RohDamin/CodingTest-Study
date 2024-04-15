import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int card[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<m; i++){
            int k = Integer.parseInt(st.nextToken());
            sb.append(upperBound(card, k) - lowerBound(card, k)).append(' ');
        }

        System.out.println(sb);

        bw.flush();
        bw.close();
        br.close();

    }

    static int lowerBound (int arr[], int n) {

        int low= 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low+high)/2;

            if (n <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound (int arr[], int n) {

        int low= 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low+high)/2;

            if (n < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

