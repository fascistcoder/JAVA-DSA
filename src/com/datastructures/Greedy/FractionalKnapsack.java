package com.datastructures.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/01/24
 */
public class FractionalKnapsack {
	public static void main(String[] args) {
		ArrayList<FractionalKnappSackItem> arrayList = new ArrayList<>();
		int[] value = { 100, 120, 60 };
		int[] weight = { 20, 30, 10 };
		int capacity = 50;

		for (int i = 0; i < value.length; i++) {
			arrayList.add(new FractionalKnappSackItem(i + 1, weight[i], value[i]));
		}

		new FractionalKnapsack().KnapSack(arrayList, capacity);
	}

	void KnapSack(ArrayList<FractionalKnappSackItem> itemArrays, int capacity) {
		Comparator<FractionalKnappSackItem> comparator = new Comparator<FractionalKnappSackItem>() {
			@Override public int compare(FractionalKnappSackItem o1, FractionalKnappSackItem o2) {
				if (o2.getRatio() > o1.getRatio()) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		itemArrays.sort(comparator);
		int usedCapacity = 0;
		double totalValue = 0;

		for (FractionalKnappSackItem item : itemArrays) {
			if (usedCapacity + item.getWeight() <= capacity) {
				usedCapacity += item.getWeight();
				System.out.println("Taken: " + item);
				totalValue += item.getValue();
			} else {
				int usedWeight = capacity - usedCapacity;
				double value = item.getRatio() * usedWeight;
				System.out.println("Taken: item index = " + item.getIndex() + ", obtained value = " + value + ", used weight = "
								   + usedWeight + ", ratio = " + item.getRatio());
				usedCapacity += usedWeight;
				totalValue += value;
			}
			if (usedCapacity == capacity) {
				break;
			}
		}
		System.out.println("Total value obtained: " + totalValue);

	}
}
