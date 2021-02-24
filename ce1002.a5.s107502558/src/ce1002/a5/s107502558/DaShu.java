package ce1002.a5.s107502558;

import java.util.*;

public class DaShu {
	public String v = "";
	public int tmp = 0; // to store "-"

	public DaShu() {
	}

	public DaShu(String val) {

		if (val.charAt(0) == '-' || val.charAt(0) == '+') { // exclude the symbol
			this.v = val.substring(1);
		} else {
			this.v = val;
		}
		if (val.charAt(0) == '-') {
			tmp = tmp + 1;
		}
		String stv = ""; // store result
		int co = 0;// to avoid like 000000
		for (int i = 0; i <= this.v.length() - 1; i++) {// from head check
			if (co == 0 && this.v.charAt(i) == '0') {
				continue;
			}
			stv = stv + this.v.charAt(i); // store the number in stv by char
			co++; // when there is a number not be 0 ,stop skip 0
		}
		this.v = stv;
		if (this.v.equals("")) {// when val is all 0
			this.v = "0";
		}
	}

	public String getString() {
		String stv = ""; // store result
		int co = 0;// to avoid like 000000
		if (tmp == 1) {
			tmp = 0;
			return '-' + v;
		} else {
			for (int i = 0; i <= this.v.length() - 1; i++) {// from head check
				if (co == 0 && this.v.charAt(i) == '0') {
					continue;
				}
				stv = stv + this.v.charAt(i); // store the number in stv by char
				co++; // when there is a number not be 0 ,stop skip 0
			}
			this.v = stv;
			if (this.v.equals("")) {// when val is all 0
				return "0";
			}
			return stv;
		}
	}

	public DaShu plus(DaShu dashu) {
		String s1 = this.v; // number be plused
		String s2 = dashu.v;// plus number
		DaShu temp = new DaShu();// make a new DaShu type object to store the result
		if (s1.length() > s2.length()) {// Ensure that s1 is less than or equal to the length of s2
			String t = s1;
			s1 = s2;
			s2 = t;
		}

		int cha = s2.length() - s1.length();
		for (int i = 0; i < cha; i++) {
			s1 = '0' + s1; // Fill the vacancy in front of s1 with 0
		}

		int w = 0;// next position need to add 1
		for (int i = s2.length() - 1; i >= 0; i--) {
			int a = Integer.valueOf(s1.charAt(i) - 48);// change the string to int
			int b = Integer.valueOf(s2.charAt(i) - 48);

			int t = 0;// Temp a number
			if (w == 1) {
				t++;
				w = 0;
			}
			if (t + a + b > 9) {
				t = t + a + b - 10;
				temp.v = t + "" + temp.v;// note: int+"" can be string
				w++;
			} else {
				t = t + a + b;
				temp.v = t + "" + temp.v;
			}
		}
		if (w == 1) {
			temp.v = "1" + temp.v;// the final position if it needs to add 1
		}
		return temp;
	}

	public DaShu minus(DaShu dashu) {
		String s1 = this.v;
		String s2 = dashu.v;
		DaShu temp = new DaShu();
		String fuhao = "";// to store "-"
		int l1 = s1.length();
		int l2 = s2.length();
		// Judge, if s1 is less than s2 then the symbol is - then, s1 and s2 exchange
		// position, to ensure that s1 is large
		if ((l1 == l2 && s1.compareTo(s2) < 0) || l1 < l2) {
			fuhao = "-";
			String t = s1;
			s1 = s2;
			s2 = t;
		}
		for (int i = 0; i < Math.abs(l1 - l2); i++) {
			s2 = '0' + s2; // Fill the vacancy in front of s2 with 0
		}
		
		int w = 0;// the next position if need to minus 1
		// Calculate the difference between each position
		for (int i = s1.length() - 1; i >= 0; i--) {
			int a = Integer.valueOf(s1.charAt(i) - 48);
			int b = Integer.valueOf(s2.charAt(i) - 48);
			int t = 0;// Temp
			if (w == 1) {
				t = t - 1 + a - b;
			} else {
				t = t + a - b;
			}
			
			if (t < 0) {
				t += 10;
				temp.v = t + "" + temp.v;

				w = 1;
			} else {
				temp.v = t + "" + temp.v;
				w = 0;
			}
		}
		temp.v = fuhao + temp.v;// symbol+result
		return temp;
	}

}
