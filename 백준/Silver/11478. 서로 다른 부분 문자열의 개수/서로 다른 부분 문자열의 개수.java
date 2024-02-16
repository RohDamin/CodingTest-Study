import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        HashSet <String> set = new HashSet<String>();

        for(int i=0; i<str.length(); i++) {
            for (int j=i; j<str.length(); j++) {
                set.add(str.substring(i, j+1));
            }
        }

        System.out.println(set.size());

        bw.flush();
        bw.close();
        br.close();

    }
}

