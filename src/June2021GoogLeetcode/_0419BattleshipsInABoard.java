package June2021GoogLeetcode;

public class _0419BattleshipsInABoard {

	public static void main(String[] args) {
		System.out.println(countBattleships(new char[][] { new char[] { 'X', '.', '.', 'X' },
				new char[] { '.', '.', '.', 'X' }, new char[] { '.', '.', '.', 'X' } }));
	}

	public static int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					if (i != 0 && board[i - 1][j] == 'X')
						continue;
					if (j != 0 && board[i][j - 1] == 'X')
						continue;
					count++;
				}
			}
		}
		return count;
	}

}
