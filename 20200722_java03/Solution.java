package com.ssafy.hw.step03;

import java.util.Scanner;

public class Solution {
	static int Answer;
	static int N, S; // N: ȣ��ũ��, S: �ұ����̼�

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			int[][] map = new int[N][N];

			S = sc.nextInt();
			int[][] strider = new int[S][3];
			for (int k = 0; k < S; k++) {
				strider[k][0] = sc.nextInt();// ����ġ
				strider[k][1] = sc.nextInt();// ����ġ
				strider[k][2] = sc.nextInt();// ����(1:��,2:��)
			}

			Answer = 0;

			for (int k = 0; k < S; k++) {
				int pi = strider[k][0]; // ���� ��ġ i
				int pj = strider[k][1]; // ���� ��ġ j
				int dir = strider[k][2]; // ����

				map[pi][pj] = 1; // �� ���� ����

				if (dir == 1) { // up(y�న��)
					for (int y = 3; y >= 1; y--) {
						pi -= y;
						if (pi < 0) { // ���������� ������
							map[pi + y][pj] = 0; // �����ڸ� 0ó��
							break;
						} else { // ���� �����϶�
							map[pi][pj] = 1; // �����ڸ� 1ó��
							map[pi + y][pj] = 0; // �����ڸ� 0ó��
						}
					}
				} else if (dir == 2) { // down(y������)
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
				} else if (dir == 3) { // left(x�న��)
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
				} else { // (dir==4) right(x������)
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
					if (map[i][j] == 1)			// map�� ���� ��ü ī����
						Answer++;
					// System.out.print(map[i][j] + " "); // ����迭���Ȯ�ο�
				}
				// System.out.println();
			}
			System.out.println("#" + t + " " + Answer);
		}
		sc.close();
	}
}