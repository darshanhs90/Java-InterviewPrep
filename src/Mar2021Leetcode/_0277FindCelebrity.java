package Mar2021Leetcode;

public class _0277FindCelebrity {

	public static void main(String[] args) {
		System.out.println(findCelebrity(3));
	}

	static boolean knows(int a, int b) {
		return true;
	}

	public static int findCelebrity(int n) {
		for (int i = 0; i < n; i++) {
			if (isCelebrity(i, n)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isCelebrity(int currPerson, int n) {
		for (int i = 0; i < n; i++) {
			if (currPerson != i) {
				if (knows(currPerson, i))
					return false;
				if (!knows(i, currPerson))
					return false;
			}
		}
		return true;
	}

}
