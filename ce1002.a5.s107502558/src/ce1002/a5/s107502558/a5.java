/*
 * Assignment 5
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a5.s107502558;

import java.util.Scanner;

public class a5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new DaShu("000").getString());
		System.out.println(new DaShu("+000000000").getString());
		System.out.println(new DaShu("-000000000").getString());
		System.out.println(new DaShu("-000078763").getString());
		System.out.println(new DaShu("111111111111").plus(new DaShu("2222222222222")).getString());
		System.out.println(new DaShu("33333333333333").minus(new DaShu("444444444444444")).getString());
		String num1 = new String();
		String num2 = new String();
		String symbol = new String();
		for (;;) {
			// enter number1 symbol number2
			num1 = sc.next();
			if (num1.equals("exit")) {
				break;
			}
			symbol = sc.next();
			if (symbol.equals("exit")) {
				break;
			}
			num2 = sc.next();
			if (num2.equals("exit")) {
				break;
			}
			if (symbol.charAt(0) == '+') {
				if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
					System.out.println("-" + new DaShu(num2).plus(new DaShu(num1)).getString());
				} else if (num1.charAt(0) == '-') {
					System.out.println(new DaShu(num2).minus(new DaShu(num1)).getString());
				} else if (num2.charAt(0) == '-') {
					System.out.println(new DaShu(num1).minus(new DaShu(num2)).getString());
				} else {
					System.out.println(new DaShu(num1).plus(new DaShu(num2)).getString());
				}
			}
			if (symbol.charAt(0) == '-') {
				if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
					System.out.println(new DaShu(num2).minus(new DaShu(num1)).getString());
				} else if (num1.charAt(0) == '-') {
					System.out.println("-" + new DaShu(num1).plus(new DaShu(num2)).getString());
				} else if (num2.charAt(0) == '-') {
					System.out.println(new DaShu(num1).plus(new DaShu(num2)).getString());
				} else {
					System.out.println(new DaShu(num1).minus(new DaShu(num2)).getString());
				}
			}

		}

	}
}
