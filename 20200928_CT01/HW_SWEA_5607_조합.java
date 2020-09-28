package d0928;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HW_SWEA_5607_조합 {

	static final int M = 1234567891;
	static int N;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			bw.append("#" + t + " " + nCr() + "\n");

		}
		bw.flush();
		bw.close();
	}

	// 페르마의 소정리 사용
	public static long nCr() {
		if (R == 0)
			return 1L;
		long[] fac = new long[N + 1];
		fac[0] = 1;
		for (int i = 1; i <= N; i++) {
			fac[i] = fac[i - 1] * i % M;

		}
		return (fac[N] * power(fac[R], M - 2) % M * power(fac[N - R], M - 2) % M) % M;
	}

	public static long power(long x, long y) {
		long res = 1L;
		x %= M;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % M;
			y = y >> 1;
			x = (x * x) % M;

		}
		return res;
	}

}
