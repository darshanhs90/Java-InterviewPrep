package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return output;
		List<Integer> initList = new ArrayList<Integer>();
		initList.add(1);
		output.add(initList);
		for (int i = 1; i < numRows; i++) {
			initList = output.get(output.size() - 1);
			List<Integer> intermediateOutput = new ArrayList<Integer>();
			intermediateOutput.add(1);
			for (int j = 0; j < initList.size() - 1; j++) {
				intermediateOutput.add(initList.get(j) + initList.get(j + 1));
			}
			intermediateOutput.add(1);
			output.add(intermediateOutput);
		}
		return output;
	}
}
