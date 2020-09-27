import java.util.Scanner;

// 파이프 옮기기
public class 과제0923 {
	static int N;
	static int[][] map;
	static long answer;
	static long[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dp = new long[N][N][3]; // 3차원값: 가로(0)/세로(1)/대각선(2)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 시작위치에서 가로로 오는 경우만 1로 초기화
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (j + 1 < N && map[i][j + 1] == 0) { // 도착지 형태가 가로인 경우, 해당위치에 파이프 검사
					dp[i][j + 1][0] += dp[i][j][0] + dp[i][j][2];
				}

				if (i + 1 < N && map[i + 1][j] == 0) { // 도착지 형태가 세로인 경우, 해당위치에 파이프 검사
					dp[i + 1][j][1] += dp[i][j][1] + dp[i][j][2];
				}

				// 도착지 형태가 대각인 경우, 해당위치에 파이프 검사
				if (i + 1 < N && j + 1 < N && map[i + 1][j + 1] == 0 && map[i][j + 1] == 0 && map[i + 1][j] == 0) {
					dp[i + 1][j + 1][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			answer += dp[N - 1][N - 1][i];
		}
		System.out.println(answer);
		sc.close();
	}

}