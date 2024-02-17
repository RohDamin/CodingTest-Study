import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet <Integer> set = new HashSet<Integer>();

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        System.out.println(set.size());

        bw.flush();
        bw.close();
        br.close();

    }
}

