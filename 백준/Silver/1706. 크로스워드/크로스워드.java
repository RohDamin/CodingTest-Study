// 문자열
import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static int R, C;
	static ArrayList<String> wordList = new ArrayList<>();
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C]; 
		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		findWords();
		Collections.sort(wordList);
		System.out.println(wordList.get(0));
	}
	
	static void findWords() {
		
		// 가로 단어 저장
		for (int i=0; i<R; i++) {
			String rowStr = "";
			for (int j=0; j<C; j++) {
				rowStr += map[i][j];
			}
			String[] arr = rowStr.split("#");
			for (int s=0; s<arr.length; s++) {
				if (arr[s].length()>1) wordList.add(arr[s]);
			}
		}
				
		// 세로 단어 저장
		for (int j=0; j<C; j++) {
			String colStr = "";
			for (int i=0; i<R; i++) {
				colStr += map[i][j];
			}
			String[] arr = colStr.split("#");
			for (int s=0; s<arr.length; s++) {
				if (arr[s].length()>1) wordList.add(arr[s]);
			}
		}
	}
}