import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// I/O
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 탑의 크기, 탑의 첨자 저장하는 정수형 배열(입력값, index) 스택
		Stack<int[]> top = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {

			int input = Integer.parseInt(stk.nextToken());

			while (!top.isEmpty()) {
				if (input < top.peek()[0]) { // 수신 가능한 탑이 있으면
					bw.write((top.peek()[1] + 1) + " "); // index값이 1부터이므로 +1
					break;	// 조건 만족시 바로 break로 반복문 탈출
				}
				top.pop();
			}

			if (top.isEmpty()) // 스택 다나올때까지 입력값보다 큰 값 찾지 못하면
				bw.write(0 + " "); // 0으로

			top.push(new int[] { input, i });	// 입력값, 입력인덱스 배열을 스택에 넣기
		}

		bw.flush();
		bw.close();

	}

}
