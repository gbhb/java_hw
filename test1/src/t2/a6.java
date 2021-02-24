package t2;

import java.util.Scanner;

public class a6 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (input.hasNext())
			System.out.println(parseMath("0 + " + input.nextLine()));

		input.close();
	}

	static String joinString(String[] str, int start, int end) {
		if (start >= str.length)
			return "";
		String builder = str[start];
		for (int i = start + 1; i < end && i < str.length; i++)
			builder += " " + str[i];

		return builder;
	}

	static double parseMath(String input) {
		String[] str = input.split(" ");
		if (str.length == 1 || str.length == 2)
			return Double.parseDouble(str[0]);
		if (str.length == 0)
			return 0d;

		System.out.println(String.join(" ", str));

		if (str[2].equals("(")) {
			int i, level;
			for (i = 3, level = 1; level != 0 && i < str.length; i++)
				if (str[i].equals("("))
					level++;
				else if (str[i].equals(")"))
					level--;

			return parseMath(String.format("%s %s %f %s", str[0], str[1], parseMath("0 + " + joinString(str, 3, i - 1)),
					joinString(str, i, str.length)));

		} else if (str[1].equals("*"))
			return parseMath(String.format("%f %s", Double.parseDouble(str[0]) * Double.parseDouble(str[2]),
					joinString(str, 3, str.length)));

		else if (str[1].equals("/"))
			if (Double.parseDouble(str[2]) == 0d)
				return Double.NaN;
			else
				return parseMath(String.format("%f %s", Double.parseDouble(str[0]) / Double.parseDouble(str[2]),
						joinString(str, 3, str.length)));

		else if (str[1].equals("+"))
			return Double.parseDouble(str[0]) + parseMath(joinString(str, 2, str.length));

		else if (str[1].equals("-"))
			return Double.parseDouble(str[0]) - parseMath(joinString(str, 2, str.length));

		return 0d;
	}

}
