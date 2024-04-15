import java.io.*;
import java.util.*;

class Solution {
    static int swapNum;
    static int[] arr;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            swapNum = Integer.parseInt(st.nextToken());

            arr = new int[num.length()];
            for (int i=0; i<num.length(); i++) {
                arr[i] = num.charAt(i)-'0';
            }

            // 시간초과 최저화
            if (arr.length<swapNum) { // 자릿수만큼만 옮겨도 전부 옮길 수 있음
                swapNum = arr.length;;
            }

            DFS(0,0);

            sb.append("#").append(t+1).append(" ").append(max).append("\n");
            max = 0;
        }

        System.out.println(sb);
    }

    static void DFS(int start, int depth) {
        if (depth == swapNum) {
            int res = 0;
            for (int i=0; i<arr.length; i++) {
                res += (int) (Math.pow(10, i)*arr[arr.length-i-1]);
            }
            max = Math.max(max, res);
            return;
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                swap(i, j);
                DFS(i, depth+1);
                swap(j,i);
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}