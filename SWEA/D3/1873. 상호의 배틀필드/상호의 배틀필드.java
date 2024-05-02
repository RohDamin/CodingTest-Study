import java.util.*;
import java.io.*;

public class Solution {
	static int H, W;
	static char[][] map;
	static int y, x; // 전차 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스	
		for (int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 맵 높이
			W = Integer.parseInt(st.nextToken()); // 맵 너비
						
			// 맵 저장
			map = new char[H+1][W+1];
			for (int i=0; i<H; i++) {
				String s = br.readLine();
				for (int j=0; j<W; j++) {
					map[i][j] = s.charAt(j);
					
					// 전차 위치 저장
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						y = i;
						x = j;
					}
				}
			}
			
			// 입력 처리
			int N = Integer.parseInt(br.readLine()); // 입력 개수
			String opStr = br.readLine();
			for (int n=0; n<N; n++) {
				char op = opStr.charAt(n);
				if (op == 'S') shoot();
				else move(op);
			}
			
			// 출력 
			sb.append("#").append(t).append(" ");
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void shoot() {	
		int ny = y;
		int nx = x;
		
		if (map[y][x] == '^') { // 전차 방향이 위쪽인 경우
			ny--;
			
			while (true) {
				// 게임 맵 밖으로 포탄이 나가는 경우 -> 아무 일도 일어나지 않음
				if (!isRange(ny, nx)) return;
				
				// 만약 폭탄이 벽돌 벽과 부딪히는 경우 -> 평지가 됨
				if (map[ny][nx] == '*') {
					map[ny][nx] = '.';
					return;
				}
				
				// 만약 폭탄이 강철 벽과 부딪히는 경우 -> 아무 일도 일어나지 않음
				if (map[ny][nx] == '#') return;	
				
				// 평지 또는 물인 경우 -> 다음 칸 체크
				if (map[ny][nx] == '.' || map[ny][nx] == '-') ny--;
			}
		} else if (map[y][x] == 'v') { // 전차 방향이 아래쪽인 경우
			ny++;	
			while (true) {
				if (!isRange(ny, nx)) return;
				if (map[ny][nx] == '*') {
					map[ny][nx] = '.';
					return;
				}
				if (map[ny][nx] == '#') return;
				if (map[ny][nx] == '.' || map[ny][nx] == '-') ny++;
			}
			
		} else if (map[y][x] == '<') { // 전차 방향이 왼쪽인 경우
			nx--;	
			while (true) {
				if (!isRange(ny, nx)) return;
				if (map[ny][nx] == '*') {
					map[ny][nx] = '.';
					return;
				}
				if (map[ny][nx] == '#') return;
				if (map[ny][nx] == '.' || map[ny][nx] == '-') nx--;
			}
		} else if (map[y][x] == '>') { // 전차 방향이 오른쪽인 경우
			nx++;	
			while (true) {
				if (!isRange(ny, nx)) return;
				if (map[ny][nx] == '*') {
					map[ny][nx] = '.';
					return;
				}
				if (map[ny][nx] == '#') return;
				if (map[ny][nx] == '.' || map[ny][nx] == '-') nx++;
			}
		}
	}
	
	static void move(char op) {
		// 전차가 바라보는 방향을 op 방향으로 바꾸고, 
		// op 방향의 한 칸이 평지라면 위 그 칸으로 이동
		
		if (op == 'U') {
			int ny = y-1;
			int nx = x;
			
			// 다음 칸이 범위 안에 있고 && 다음 칸이 평지인 경우
			// 다음 칸으로 이동 가능
			if (isRange(ny, nx) && map[ny][nx] == '.') { 
				map[y][x] = '.'; // 원래 있었던 칸을 평지로 바꾸고
				map[ny][nx] = '^'; // 다음 칸으로 방향 옮긴 전차 이동
				
				y = ny; // 전차 위치 업데이트
				x = nx;	
			} else { // 다음 칸으로 이동할 수 없는 경우
				map[y][x] = '^'; // 전차 방향만 변경
			}
		} else if (op == 'D') {
			int ny = y+1;
			int nx = x;
			
			if (isRange(ny, nx) && map[ny][nx] == '.') { 
				map[y][x] = '.'; 
				map[ny][nx] = 'v';
				
				y = ny; 
				x = nx;	
			} else {
				map[y][x] = 'v'; 
			}
		} else if (op == 'L') {
			int ny = y;
			int nx = x-1;
			
			if (isRange(ny, nx) && map[ny][nx] == '.') { 
				map[y][x] = '.'; 
				map[ny][nx] = '<';
				
				y = ny; 
				x = nx;	
			} else {
				map[y][x] = '<'; 
			}
		} else if (op == 'R') {
			int ny = y;
			int nx = x+1;
			
			if (isRange(ny, nx) && map[ny][nx] == '.') { 
				map[y][x] = '.'; 
				map[ny][nx] = '>';
				
				y = ny; 
				x = nx;	
			} else {
				map[y][x] = '>'; 
			}
		}		
	}
	
	static boolean isRange(int py, int px) {
		return (py>=0 && px>=0 && py<H && px<W);
	}
}