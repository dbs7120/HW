import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 맥주마시면서 걸어아기
public class 과제0924 {

	static int N; // 편의점 갯수
	static Point[] map;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine().trim());

			map = new Point[N + 2]; // 집 + 편의점 수 + 락페좌표수
			visited = new boolean[N + 2];
			flag = false;
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i] = new Point(x, y);
			}
			BFS();
			String result = flag ? "happy" : "sad";
			bw.write(result + "\n");

		}
		bw.flush();
		bw.close();
	}

	public static void BFS() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(map[0]);
		visited[0] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == map[N + 1].x && cur.y == map[N + 1].y) {
				flag = true;
				return;
			}
			for (int i = 1; i < N + 2; i++) { // 시작 제외
				if (visited[i])
					continue;
				if (Math.abs(cur.x - map[i].x) + Math.abs(cur.y - map[i].y) <= 50 * 20) { // 맥주거리내에있는지 검사: 50m * 20병
					q.offer(map[i]);
					visited[i] = true;
				}

			}
		}
	}

}
