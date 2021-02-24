package test1;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine() ;
        try {
            String result = CalUtil.getResultByStrCal(exp);
            System.out.printf(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("請輸入正確計算公式");
        }
	
	}	
}