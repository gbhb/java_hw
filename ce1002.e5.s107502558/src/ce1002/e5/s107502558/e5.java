/*
 * Exercise 5
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.e5.s107502558;

import java.util.Scanner;

public class e5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("1. Add Income Transaction Record\n2. Add Pay Transaction Record\n3. Show Total\n4. Exit");
			int i = sc.nextInt();//choose what to do
			if (i == 4) {
				break;
			}
			if (i == 1) {
				System.out.print("Transaction Name: ");
				String name =sc.next();
				Transaction t = new Transaction(name);
				System.out.print("Transaction Income: ");
				int m =sc.nextInt();
				t.plusmoney(m);
				
			}
			if (i == 2) {
				System.out.print("Transaction Name: ");
				String name =sc.next();
				Transaction t = new Transaction(name);
				System.out.print("Transaction Pay: ");
				int m =sc.nextInt();
				t.minusmoney(m);
			}
			if (i == 3) {
				Transaction t = new Transaction();
				System.out.println("name	income	pay");
				for(int a=1;a<=t.i;a++) {
					System.out.println(t.name[a]+'\t'+t.in[a]+'\t'+t.pay[a]);
					
				}
				System.out.println("Total: "+t.total);
			}
		}
	}

}

class Transaction {
	
	public static int i = 0; //numbers of case
	public static  String[] name = new String[32767];
	public static  int[] in = new int[32767]; //in is income
	public static  int[] pay = new int[32767];
	public int total=0;
	
	public Transaction() {
	}
	public Transaction(String n) {
		i++;
		name[i] = n;//from 1 start
	}
	public void plusmoney(int m) {
		in[i]=m;
		pay[i]=0;
		total = total+m;
	}
	public void minusmoney(int m) {
		in[i]=0;
		pay[i]=m;
		total = total-m;
	}
	
	
	
	
}