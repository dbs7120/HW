package com.ssafy.hw.step03;

import java.util.Scanner;

public class Solution {
	static int Answer;
	static int N, S; // N: 호수크기, S: 소금쟁이수

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			int[][] map = new int[N][N];

			S = sc.nextInt();
			int[][] strider = new int[S][3];
			for (int k = 0; k < S; k++) {
				strider[k][0] = sc.nextInt();// 행위치
				strider[k][1] = sc.nextInt();// 열위치
				strider[k][2] = sc.nextInt();// 방향(1:하,2:우)
			}

			Answer = 0;

			for (int k = 0; k < S; k++) {
				int pi = strider[k][0]; // 시작 위치 i
				int pj = strider[k][1]; // 시작 위치 j
				int dir = strider[k][2]; // 방향

				map[pi][pj] = 1; // 뛴 흔적 저장

				if (dir == 1) { // up(y축감소)
					for (int y = 3; y >= 1; y--) {
						pi -= y;
						if (pi < 0) { // 영역밖으로 나갈시
							map[pi + y][pj] = 0; // 직전자리 0처리
							break;
						} else { // 정상 점프일때
							map[pi][pj] = 1; // 현재자리 1처리
							map[pi + y][pj] = 0; // 직전자리 0처리
						}
					}
				} else if (dir == 2) { // down(y축증가)
					for (int y = 3; y >= 1; y--) {
						pi += y;
						if (pi >= N) {
							map[pi - y][pj] = 0;
							break;
						} else {
							map[pi][pj] = 1;
							map[pi - y][pj] = 0;
						}
					}
				} else if (dir == 3) { // left(x축감소)
					for (int x = 3; x >= 1; x--) {
						pj -= x;
						if (pj < 0) {
							map[pi][pj + x] = 0;
							break;
						} else {
							map[pi][pj] = 1;
							map[pi][pj + x] = 0;
						}
					}
				} else { // (dir==4) right(x축증가)
					for (int x = 3; x >= 1; x--) {
						pj += x;
						if (pj >= N) {
							map[pi][pj - x] = 0;
							break;
						} else {
							map[pi][pj] = 1;
							map[pi][pj - x] = 0;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)			// map에 남은 개체 카운팅
						Answer++;
					// System.out.print(map[i][j] + " "); // 결과배열출력확인용
				}
				// System.out.println();
			}
			System.out.println("#" + t + " " + Answer);
		}
		sc.close();
	}
}