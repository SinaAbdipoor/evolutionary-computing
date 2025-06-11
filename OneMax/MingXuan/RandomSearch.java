package MingXuan;

import java.util.ArrayList;

public class RandomSearch {
	public int iter;
	public int len;
	public int best = 0;

	public RandomSearch (int iter, int len) {
		this.iter = iter;
		this.len = len;
	}

	public int operate() {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			int num;
			num = (int)(Math.random() * 2);
			//list.add(num);
			if (num == 1) { sum++; }
		}

		return sum;
	}

	public void iteration() {
		//int best = 0;
		for (int i = 0; i < iter; i++) {
			int mid;
			mid = operate();
			if (mid > best) {
				best = mid;
			}
		}
		//return best;
	}

	@Override
	public String toString() {
		return "Array length: " + len + "\n" + "Iteration: " + iter + "\n" + "Result: " + best;
	}
}