/*
 * Assignment 4
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.a4.s107502558;

import java.util.Scanner;

public class a4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int l = input.nextInt(); // input the row of arr
		int w = input.nextInt();// input the column of arr
		char[][] arr = new char[l][w]; //arr of map
		for(int i = 0; i < arr.length; i++) { 
            for(int j = 0; j < arr[i].length; j++) 
            	arr[i][j]=(char)input.next().charAt(0); //input the elements of map
            	
        }
		for(int i = 0; i < arr.length; i++) { 
            for(int j = 0; j < arr[0].length; j++) { 
            	int sum=0;// sum the mines in the map
            	if(arr[i][j]=='*') {// if the area have mine , print *
            		System.out.print("* ");
            		continue;
            	}
            	if(i-1>=0 && j-1>=0 ){// control the boundary of arr when check 
            		if (arr[i-1][j-1]=='*') {
            			sum++; //check there is a mine,so sum plus one
            		}
            	}
            	if(i-1>=0 && j>=0 ){// control the boundary of arr when check
            		if (arr[i-1][j]=='*') {
            			sum++;
            		}
            	}
            	if(i-1>=0 && j+1<=w-1 ){// control the boundary of arr when check
            		if (arr[i-1][j+1]=='*') {
            			sum++;
            		}
            	}
            	if(i>=0 && j-1>=0 ){// control the boundary of arr when check
            		if (arr[i][j-1]=='*') {
            			sum++;
            		}
            	}
            	if(i>=0 && j+1<=w-1 ){// control the boundary of arr when check
            		if (arr[i][j+1]=='*') {
            			sum++;
            		}
            	}
            	if(i+1<=l-1 && j-1>=0 ){// control the boundary of arr when check
            		if (arr[i+1][j-1]=='*') {
            			sum++;
            		}
            	}
            	if(i+1<=l-1 && j>=0 ){// control the boundary of arr when check
            		if (arr[i+1][j]=='*') {
            			sum++;
            		}
            	}
            	if(i+1<=l-1 && j+1<=w-1 ){// control the boundary of arr when check
            		if (arr[i+1][j+1]=='*') {
            			sum++;
            		}
            	}
            	if(sum!=0){ //if the surround area have mines ,print the number of mines 
            		System.out.print(sum+" ");
            	}else{//if the surround area have no mines ,print # 
            		System.out.print("# ");
            	}
            	
            }
            System.out.print("\n");
		}
	}

}

