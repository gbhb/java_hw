/*
 * Assignment 3
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a3.s107502558;

import java.util.Scanner;

public class a3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int l = input.nextInt(); // l is the length of the set
		
		int[] x = new int[l]; //the elements in set
		for(int i=0;i<x.length;i++){
		      x[i]=input.nextInt(); // input the elements to set
		}
		String t;
		
		for(int i=0;i<Math.pow(2, l);i++){
			t=Integer.toBinaryString(i); // use binary to control the element to print out
			for(int ii=0;ii<l;ii++){
				if(t.length()<l) { //supply 0 to make t conform length
					t="0"+t; 
				}
			}
			String xx= ""; //store the element to print finally 
			System.out.print("[");
			int c=0; //c decided which x[c] to show
			for(int a=l;a>0;a--) {
				if(t.charAt(a-1)=='1') { //when 0 do not show and 1 show out the list 
					xx=xx+String.valueOf(x[c])+", "; 
				}
				c++;
			}
			if(!xx.equals("")) //avoid none set
			System.out.print(xx.subSequence(0, xx.length()-2)); //delete the unnecessary comma
		    System.out.print("]\n");
		}

	}

}


