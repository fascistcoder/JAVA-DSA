package com.datastructures.Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/11/23
 */
public class ArrayProject {
	public static void main(String[] args) {
		System.out.print("How many days temperatures ? ");
		Scanner scanner = new Scanner(System.in);
		int noOfDays = scanner.nextInt();

		int[] arr = new int[noOfDays];
		int j = 1;

		for (int i = 0 ; i <arr.length ; i++){
			System.out.print("Day" + j + "'s high temp: ");
			arr[i] = scanner.nextInt();
			j++;
		}

		double average = calculateAverage(arr);
		System.out.println("Average = " + average);

		daysAboveAverage(average, arr);
	}

	public static double calculateAverage(int[] arr) {
		double sum = Arrays.stream(arr).sum();
		return sum / arr.length;
	}

	public static void daysAboveAverage(double avg, int[] arr){
		int count  = 0;
		for(int value : arr){
			if(value > avg){
				count++;
			}
		}
		System.out.println(count + " days above average");
	}
}
