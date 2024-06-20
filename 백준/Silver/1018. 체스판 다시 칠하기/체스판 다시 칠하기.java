import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int result = Integer.MAX_VALUE;

        char arr[][] = new char[N][M];

        for (int i = 0; i < N; i++) { // 배열에 저장
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int n = 0; n < N - 7; n++) {
            for (int m = 0; m < M - 7; m++) {

                for (int k = 0; k<2; k++) {
                    char start = k == 0 ? 'W' : 'B';

                    for (int i = n; i < n+8; i++) {
                        for (int j = m; j < m+8; j++) {

                            if (i%2 == j%2) { // 짝짝 홀홀 > start와 같아야 함
                                if (start != arr[i][j]) {
                                    count++;
                                }
                            } else { // 짝홀 홀짝 > start와 달라야 함
                                if (start == arr[i][j]) {
                                    count++;
                                }
                            }
                        }
                    }
                    result = Math.min(result, count);
                    count = 0;
                }
            }
        }
        System.out.print(result);
    }
}