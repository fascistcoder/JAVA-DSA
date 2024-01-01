package com.datastructures.Greedy;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/12/23
 */
public class CoinChange {

	public static void main(String[] args) {
		new CoinChange().CoinChangeProblem(new int[]{1,2,5,10,20,50,10,1000}, 2035);
	}

	private void CoinChangeProblem(int[] coins, int totalAmount) {
		Arrays.sort(coins);
		for (int i = coins.length - 1; i >= 0; i--) {
			int coinValue = coins[i];
			int maxAmount = (totalAmount / coinValue) * coinValue;
			if (maxAmount > 0) {
				System.out.println("coin value " + coinValue + " taken count: " + totalAmount / coinValue);
				totalAmount = totalAmount - maxAmount;
			}
			if(totalAmount == 0){
				break;
			}
		}
	}
}
