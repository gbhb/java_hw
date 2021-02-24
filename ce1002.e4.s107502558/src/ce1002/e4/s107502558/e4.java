/*
 * Exercise 4
 * Course: ce1002
 * Name: �f�ɿ�
 * Student ID: 107502558
 */
package ce1002.e4.s107502558;

import java.util.Scanner;

public class e4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfPoints = input.nextInt();

		// Create an array to store points
		double[][] points = new double[numberOfPoints][2];
		String[] name = new String[numberOfPoints];
		for (int i = 0; i < points.length; i++) {
			name[i] = input.next();
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}

		// p1 and p2 are the indices in the points array
		int p1 = 0, p2 = 1; // Initial two points
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]); // Initialize
																										// shortestDistance

		// Compute distance for every two points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // Find distance

				if (shortestDistance > distance) {
					p1 = i; // Update p1
					p2 = j; // Update p2
					shortestDistance = distance; // Update shortestDistance
				}
			}
		}

		// Display result
		System.out.println("[" + name[p1] + ": " + points[p1][0] + ", " + points[p1][1] + "] [" + name[p2] + ": "
				+ points[p2][0] + ", " + points[p2][1] + "]");
		System.out.println("Distance: " + shortestDistance);
	}

	/** Compute the distance between two points (x1, y1) and (x2, y2) */
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}