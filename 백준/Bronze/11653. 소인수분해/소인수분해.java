import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int num = Integer.parseInt(br.readLine());
		
		int k = 2;
		while (num != 1) {
			if (num % k == 0) {
				sb.append(k).append("\n");
				num/=k;
			} else k++;
		}
		
		System.out.println(sb);
	}
}