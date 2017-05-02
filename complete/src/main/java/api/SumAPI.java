package api;

import java.util.*;

public class SumAPI {
	// The list that will contain all values for sum.
	private List <Integer> list = new ArrayList<>();

	public void addValue(int value) {
		list.add(value);
	}

	// This will return the sum value.
	// If there is no value stored, 0 will be returned.
	public int getSum() {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}

		return sum;
	}

	// This will remove all integers in the list.
	// After this operation, the sum will be 0.
	public void removeAll() {
		list.clear();
	}
}
