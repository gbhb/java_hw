package test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CalUtil {
	static final String symbol = "+-*/()"; // 運算符
	static final String[] priority = { "+-", "*/", "()" }; // 運算符優先級

	/**
	 * 運算符比較器
	 */
	static Comparator<String> comp = new Comparator<String>() {
		public int compare(String s1, String s2) {
			int n1 = 0, n2 = 0;
			for (int i = 0; i < priority.length; i++) {
				if (priority[i].indexOf(s1) >= 0) {
					n1 = i;
				}
				if (priority[i].indexOf(s2) >= 0) {
					n2 = i;
				}
			}
			return (n1 - n2);
		}
	};

	/**
	 * 輸入字符串公式，返回結果
	 * 
	 * @param exp
	 * @return
	 * @throws Exception
	 */
	public static String getResultByStrCal(String exp) throws Exception {
		List<String> list = analyze(exp); // 中綴轉後綴
		double result = cacl(list); // 計算結果
		return String.format("%.2f", result);// %.2f\n解釋：%f ——浮點型 .2 ——兩位小數點 \n ——換行
	}

	/**
	 * 分析算式
	 * 
	 * @param exp
	 * @return
	 * @throws Exception
	 */
	public static List<String> analyze(String exp) throws Exception {
		if (exp == null) {
			throw new Exception("illegal parameter.");
		}
		exp = exp.replaceAll("\\s*", ""); // 去掉所有的空格（為了方便中間存在空格算合法）

		List<String> list = new ArrayList<String>();
		Stack<String> sym = new Stack<String>();
		
		StringBuilder buf = new StringBuilder();
		for (char c : exp.toCharArray()) {
			if (symbol.indexOf(c) >= 0) { // 如果是運算符
				if (buf.length() > 0) { // 如果有操作數
					String v = buf.toString();
					if (!v.matches("\\d+([.]\\d+)?")) {
						throw new Exception("illegal varaible(" + v + ").");
					}
					list.add(v);
					buf.delete(0, buf.length());
				}

				if (c == '(') {
					sym.push(String.valueOf(c));
				} else if (c == ')') {
					String last = "";
					while (sym.size() > 0) {
						last = sym.pop();
						if (last.equals("(")) {
							break;
						} else {
							list.add(last);
						}
					}
					if (!"(".equals(last)) {
						throw new Exception("illigal express.");
					}
				} else if (sym.size() > 0) {
					String s = String.valueOf(c);
					String last = sym.peek();
					if (last.equals("(") || comp.compare(s, last) > 0) {
						sym.push(s);
					} else {
						last = sym.pop();
						list.add(last);
						sym.push(s);
					}
				} else {
					sym.push(String.valueOf(c));
				}
			} else { // 不是運算符則當作操作數（因為已經去除所有空格，這裏不再需要判斷空格）
				buf.append(c);
			}
		}

		if (buf.length() > 0) {
			list.add(buf.toString());
		}

		while (sym.size() > 0) {
			String last = sym.pop();
			if ("()".indexOf(last) >= 0) {
				throw new Exception("illigal express.");
			}
			list.add(last);
		}

		return list;
	}

	/**
	 * 計算
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static double cacl(List<String> list) throws Exception {
		Stack<Double> val = new Stack<Double>();
		double result = 0;
		while (list.size() > 0) {
			String s = list.remove(0);
			if (symbol.indexOf(s) >= 0) {
				double d1 = val.pop();
				double d2 = val.pop();
				if ("+".equals(s)) {
					result = d2 + d1;
				} else if ("-".equals(s)) {
					result = d2 - d1;
				} else if ("*".equals(s)) {
					result = d2 * d1;
				} else if ("/".equals(s)) {
					result = d2 / d1;
				} else {
					throw new Exception("illigal symbol(" + s + ").");
				}
				val.push(result);
			} else {
				if (!s.matches("\\d+([.]\\d+)?")) {
					throw new Exception("illigal variable(" + s + ").");
				}
				val.push(Double.valueOf(s));
			}
		}

		return result;
	}

}
