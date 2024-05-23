import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        long S = Long.parseLong(br.readLine());
        
        long n = 0;
        long i = 1;
        while (true) {
        	n = i*(i+1)/2;
        	if (n > S) break;
        	i++;
        }

        System.out.println(i-1);
    }
}
