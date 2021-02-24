/*
 * Exercise 3
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.e3.s107502558;

import java.util.Scanner;

public class e3 {
	static void bubbleSort(int[] arr,String[] name) {  
	        int n = arr.length;  
	        int temp = 0;
	        String stemp;
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 //swap elements  
	                                 temp = arr[j-1];  
	                                 stemp = name[j-1];
	                                 arr[j-1] = arr[j];
	                                 name[j-1] = name[j];
	                                 arr[j] = temp;
	                                 name[j] = stemp;
	                         }  
	                          
	                 }  
	         }
	}
	static void imbubbleSort(int[] arr,String[] name) {  
        int n = arr.length;  
        int temp = 0;
        String stemp;
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] < arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 stemp = name[j-1];
                                 arr[j-1] = arr[j];
                                 name[j-1] = name[j];
                                 arr[j] = temp;
                                 name[j] = stemp;
                         }  
                          
                 }  
         }
} 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a1=0;
		a1 = input.nextInt();
		int a2 = input.nextInt();
		
		int[][] score = {{12, 81, 77, 100, 70,65,69,43,67},{34,70,66,92,72,65,28,62,87},{56,92,55,58,80,65,77,85,63}};
		String[] name = {"Wang Da Ming","Zhou Zhu Jiao","Li Xiao Hua","Ma Xian Sheng","Xue Ce Sheng","Hui Kao Sheng","Da Xue Sheng","Xin Xian Ren","Tong Gu He Ren"};
		if(a2==2) {
		bubbleSort(score[a1-1],name);
		}else {
			imbubbleSort(score[a1-1],name);
		}
		if(a1==1)
		System.out.println("Student name	MathScore");
		if(a1==2)
		System.out.println("Student name	ChineseScore");
		if(a1==3)
		System.out.println("Student name	ComputerScore");
		for(int i=0; i < 9; i++){  
			 System.out.print(name[i]); 
			 System.out.println("\t"+score[a1-1][i]);
			 
		 }  

	}

}
