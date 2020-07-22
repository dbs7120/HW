package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input, temp;
		int[] count = new int[10];

		while (true) {
			input = sc.nextInt();
			if (input == 0)
				break;
			temp = input / 10;
			switch (temp) {
			case 0:
				count[0]++;
				break;
			case 1:
				count[1]++;
				break;
			case 2:
				count[2]++;
				break;
			case 3:
				count[3]++;
				break;
			case 4:
				count[4]++;
				break;
			case 5:
				count[5]++;
				break;
			case 6:
				count[6]++;
				break;
			case 7:
				count[7]++;
				break;
			case 8:
				count[8]++;
				break;
			case 9:
				count[9]++;
				break;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (count[i] != 0) {
				System.out.println(i + ": " + count[i] + "개");
			}
		}

		sc.close();
	}

}
