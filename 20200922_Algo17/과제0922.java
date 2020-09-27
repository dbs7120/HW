import java.util.Scanner;

// 대규의 팬덤활동
//	• 비트마스킹
//		n & 1 <=> n%2==0 (짝수 판단)
//		S & ( 1 << i ): Check (S에 i가 있는지 판단)
//		S = S | ( 1 << i ) : Add  (S에 i 넣기)
//		S = S & ~(1 << i) : Remove (S에 i 제거)
//		S = S ^ ( 1 << i ) : Toggle (S에 i가 있으면 제거 없으면 추가)
//		S = ( 1 << N ) -1 : All (S에 N만큼 1로 가득 채우기)
//		S = 0 : Empty

// 1023: 1111111111
// 점화식 : DP[N][X][상태비트 OR 2 ^ X] = DP[N - 1][X - 1][상태비트] + DP[N - 1][X + 1][상태비트]

public class 과제0922 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int mod = 1000000000;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][][] dp = new int[101][10][1 << 10];

			for (int i = 1; i <= 9; i++) // 0을 제외한 1~9까지를 1로 초기화함 (0은 시작 숫자가 될 수없음)
				dp[1][i][1 << i] = 1;

			for (int i = 2; i <= N; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 1023; k++) {
						if (j == 0)
							dp[i][0][k | (1 << 0)] = (dp[i][0][k | (1 << 0)] + dp[i - 1][1][k]) % mod;
						else if (j == 9)
							dp[i][9][k | (1 << 9)] = (dp[i][9][k | (1 << 9)] + dp[i - 1][8][k]) % mod;
						else { // 0 과 9가 아니라면 하나씨그 현재자릿수 +1, -1을 한 이전 높이의 두개 수행
							dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k]) % mod;
							dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j + 1][k]) % mod;
						}
					}
				}
			}
			int ans = 0;
			for (int i = 0; i <= 9; i++)
				ans = (ans + dp[N][i][1023]) % mod;
			System.out.println("#" + t + " " + ans);

		}
		sc.close();
	}

}
