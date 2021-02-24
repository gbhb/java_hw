

import java.math.BigInteger;
import java.util.Scanner;

public class hw51 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			int c =scanner.nextInt();
			if(c==0) {return;}
			for(;c>0;c--) {
			
			int a= scanner.nextInt();
			int b= scanner.nextInt();
			BigInteger btwo = new BigInteger("2");  
			
			System.out.println(btwo.pow(a).add(btwo.pow(b)).toString());
			}
		}
		scanner.close();
	}
}


