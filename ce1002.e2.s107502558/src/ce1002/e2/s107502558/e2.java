/*
 * Exercise 2
 * Course: ce1002
 * Name: �f�ɿ�
 * Student ID: 107502558
 */

package ce1002.e2.s107502558;

import java.util.*;

public class e2 {
	public static void printtower(String s, int n) {
		int x = 0;
		for (int i = 0; i < n; i++) { // �Ĥ@�h�j��t�d�L�_��(\n)
			for (int k = 0; k < n-i-1; k++) { // �ĤG�h�j��t�d�L�ť�( )
				System.out.print(" ");
			}
			for (int j = 0; j <= x*2 ; j++) { // �@���|��X��� �G���G

				if (j == 0) {// �e
					System.out.print(s.charAt(1));
				} else {
					System.out.print(s.charAt(2));
				
				}
				if (j == x * 2) { // ��
					System.out.print(s.charAt(1));
				}
			}
			System.out.print("\n");
			x += 1;
		}
		for (int a = 0; a < n * 2; a++) {
			System.out.print(s.charAt(1));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (;;) {
			int h = input.nextInt();
			if (h == -1) {
				break;
			}
			String s = input.nextLine();
			printtower(s, h);
			System.out.print("\n");
		}

	}

}
