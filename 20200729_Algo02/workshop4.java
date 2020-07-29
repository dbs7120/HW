import java.util.Scanner;

public class workshop4 {	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			int result = -1, temp = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					temp = 0;
					for (int y = i; y < i + M; y++) {
						for (int x = j; x < j + M; x++) {
							temp += map[y][x];
						}
					}
					if (result < temp)
						result = temp;

				}
			}
			System.out.println("#" + t + " " + result);
		}
		sc.close();

	}

}
