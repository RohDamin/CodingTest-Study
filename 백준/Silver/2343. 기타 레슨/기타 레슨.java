import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static long sum,cnt;
    static int[] arr;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long max = 0;
        long min = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
            if(min < arr[i]) min = arr[i];
        }

        while(min<=max){
            long mid = (min + max)/2;
            sum = 0;
            cnt = 0;

            for(int i=0;i<N;i++){
                if(sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) cnt++;

            if(cnt<=M) max = mid-1;
            else min = mid+1;
        }

        System.out.println(min);
    }
}