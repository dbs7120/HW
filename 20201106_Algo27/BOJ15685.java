import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {

	static int N, map[][];
	static int cnt = 0;

	static int[] dy = { 0, -1, 0, 1 }; // 우 상 좌 하
	static int[] dx = { 1, 0, -1, 0 };

	static List<Integer> dragon;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[101][101];
		int x, y, d, g;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			dragon = new LinkedList<Integer>();

			map[y][x] = 1;

			int ny = y + dy[d];
			int nx = x + dx[d];
			map[ny][nx] = 1;

			dragon.add(d);

//			int len = (int) Math.pow(2, g);
//			for (int l = 0; l < len; l++) {
//				int dir = (dragon.get(l) + 1) % 4;
//				ny += dy[dir];
//				nx += dx[dir];
//				map[ny][nx] = 1;
//				dragon.add(dir);
//			}

			for (int gen = 0; gen < g; gen++) {
				int size = dragon.size();
				System.out.println(size);

				for (int s = size - 1; s >= 0; s--) {
					int dir = (dragon.get(s) + 1) % 4;

					ny += dy[dir];
					nx += dx[dir];
					map[ny][nx] = 1;
					dragon.add(dir);
				}
			}

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1 && map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}
}
