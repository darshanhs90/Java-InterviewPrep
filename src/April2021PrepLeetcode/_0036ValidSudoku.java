package April2021PrepLeetcode;

import java.util.HashSet;

public class _0036ValidSudoku {

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][] { new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

		System.out.println(isValidSudoku(new char[][] { new char[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}

	public static boolean isValidSudoku(char[][] board) {
		HashSet[] rowArr = new HashSet[9];
		HashSet[] colArr = new HashSet[9];
		HashSet[] boxArr = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			rowArr[i] = new HashSet<Character>();
			colArr[i] = new HashSet<Character>();
			boxArr[i] = new HashSet<Character>();
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char c = board[i][j];
				if (c != '.') {
					int box = getBox(i, j);
					if (rowArr[i].contains(c) || colArr[j].contains(c) || boxArr[box].contains(c)) {
						return false;
					}
					rowArr[i].add(c);
					colArr[j].add(c);
					boxArr[box].add(c);
				}
			}
		}
		return true;
	}

	public static int getBox(int row, int col) {
		return (row / 3) * 3 + (col / 3);
	}

}
