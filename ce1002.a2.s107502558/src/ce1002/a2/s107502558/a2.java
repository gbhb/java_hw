package ce1002.a2.s107502558;


import java.util.Scanner;
public class a2{

	public static void main(String[] args) {
		System.out.println((new And(new Lit(true), new Lit(false))).eval()); 
		System.out.println((new And(new Lit(true), new Lit(true))).eval()); 
		System.out.println((new Or(new Lit(true), new Lit(false))).eval()); 
		System.out.println((new Or(new Lit(false), new Lit(false))).eval()); 
		
	}

}
