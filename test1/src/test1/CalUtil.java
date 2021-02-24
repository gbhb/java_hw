package test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CalUtil {
	static final String symbol = "+-*/()"; // �B���
	static final String[] priority = { "+-", "*/", "()" }; // �B����u����

	/**
	 * �B��Ť����
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
	 * ��J�r�Ŧꤽ���A��^���G
	 * 
	 * @param exp
	 * @return
	 * @throws Exception
	 */
	public static String getResultByStrCal(String exp) throws Exception {
		List<String> list = analyze(exp); // ��������
		double result = cacl(list); // �p�⵲�G
		return String.format("%.2f", result);// %.2f\n�����G%f �X�X�B�I�� .2 �X�X���p���I \n �X�X����
	}

	/**
	 * ���R�⦡
	 * 
	 * @param exp
	 * @return
	 * @throws Exception
	 */
	public static List<String> analyze(String exp) throws Exception {
		if (exp == null) {
			throw new Exception("illegal parameter.");
		}
		exp = exp.replaceAll("\\s*", ""); // �h���Ҧ����Ů�]���F��K�����s�b�Ů��X�k�^

		List<String> list = new ArrayList<String>();
		Stack<String> sym = new Stack<String>();
		
		StringBuilder buf = new StringBuilder();
		for (char c : exp.toCharArray()) {
			if (symbol.indexOf(c) >= 0) { // �p�G�O�B���
				if (buf.length() > 0) { // �p�G���ާ@��
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
			} else { // ���O�B��ūh��@�ާ@�ơ]�]���w�g�h���Ҧ��Ů�A�o�ؤ��A�ݭn�P�_�Ů�^
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
	 * �p��
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
