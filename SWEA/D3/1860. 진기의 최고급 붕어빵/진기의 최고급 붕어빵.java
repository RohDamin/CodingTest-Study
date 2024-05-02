import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // N명의 사람이 방문
			int M = Integer.parseInt(st.nextToken()); // M초의 시간 동안
			int K = Integer.parseInt(st.nextToken()); // K개의 붕어빵을 만들 수 있음
			
			int[] guest = new int[11112];
			
			// 손님 도착 시간 배열에 저장
			st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				int time = Integer.parseInt(st.nextToken());
				guest[time]++; // 같은 시간에 여러 명의 손님이 올 수 있음. 몇명 방문하는지 자정
			}
			
			boolean isPossible = sale(N, M, K, guest);
			if (isPossible) sb.append("#").append(t).append(" ").append("Possible\n");
			else sb.append("#").append(t).append(" ").append("Impossible\n");
		}
		System.out.println(sb);
	}
	
	static boolean sale(int N, int M, int K, int[] guest) {
		int time = 0;
		int bread = 0;
		int guestCnt = 0;
		
		while (true) {
			// N명의 손님이 방문했으면 반복문 종료
			if (guestCnt>=N || time > 11111) return true;
						
			// M초 마다 K개씩 붕어빵 추가
			if (time != 0 && time % M == 0) {
				bread += K;
			}
			
			// 만약 현재 시간에 손님이 오는 경우
			if (guest[time] != 0) {
				if (bread-guest[time] >= 0) { // 현재 시간에 오는 손님보다 붕어빵의 개수가 더 많은 경우 판매 가능
					bread -= guest[time];
					guestCnt += guest[time];
				} else { // 붕어빵이 존재하지 않는다면
					return false;
				}
			}
			
			time++;
		}		
	}
}