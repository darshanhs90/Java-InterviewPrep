package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return output;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		output.add(list);
		if (numRows == 1)
			return output;
		for (int i = 1; i < numRows; i++) {
			List<Integer> currList = output.get(output.size() - 1);
			List<Integer> newList = new ArrayList<Integer>();
			for (int j = 0; j < currList.size(); j++) {
				if (j == 0) {
					newList.add(currList.get(j));
				} else if (j - 1 >= 0) {
					newList.add(currList.get(j) + currList.get(j - 1));
				}
				if (j == currList.size() - 1)
					newList.add(currList.get(j));
			}
			output.add(newList);
		}
		return output;
	}
}
