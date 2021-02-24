/*
 * Assignment 6
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a6.s107502558;

import java.util.ArrayList;
import java.util.Scanner;

public class a6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String temp = sc.nextLine();
			if (temp.isEmpty()) {
				break;
			}
			System.out.println(parse("0 + " + temp));
		}
	}

	static String instr(String[] str, int first, int last) {
		if (first >= str.length)
			return "";
		String bulider = str[first];
		for (int i = first + 1; i < last && i < str.length; i++) {
			bulider += " " + str[i];
		}
		return bulider;
	}

	static double parse(String in) {
		String[] str = in.split(" ");
		if (str.length == 1 || str.length == 2)
			return Double.parseDouble(str[0]);
		if (str.length == 0)
			return 0d;

		//System.out.println(String.join(" ", str)); //to check the sequence
		// once choose two words in str to do and return the rest
		if (str[2].equals("(")) { //when detect "(" i use to traverse to find "(" and ")" floor is use to know how floor () and we need the outest floor
			int i, floor;
			for (i = 3, floor = 1; floor != 0 && i < str.length; i++) {
				if (str[i].equals("("))
					floor++;
				else if (str[i].equals(")"))
					floor--;
			}// we parse inside the () part to priorly deal and reparse the rest part after rebuilding it
			return parse(String.format("%s %s %f %s", str[0], str[1], parse("0 + " + instr(str, 3, i - 1)),instr(str, i, str.length)));//add "0 + " is to conform str[2].equals("(")

		} else if (str[1].equals("*"))//when detect "*" deal with the first and third char and rebulid the rest part and take into parse
			return parse(String.format("%f %s", Double.parseDouble(str[0]) * Double.parseDouble(str[2]),instr(str, 3, str.length)));

		else if (str[1].equals("/")) 
			if (Double.parseDouble(str[2]) == 0d) //if the third number is 0 return NaN
				return Double.NaN;
			else //when detect "/" deal with the first and third char and rebulid the rest part and take into parse
				return parse(String.format("%f %s", Double.parseDouble(str[0]) / Double.parseDouble(str[2]),instr(str, 3, str.length)));

		else if (str[1].equals("+"))//when detect "+" deal with the first number and continue the rest part in the function after rebuliding for rest part
			return Double.parseDouble(str[0]) + parse(instr(str, 2, str.length));

		else if (str[1].equals("-"))//when detect "-" deal with the first number and continue the rest part in the function like recursive
			return Double.parseDouble(str[0]) - parse(instr(str, 2, str.length));

		return 0d;
	}

}