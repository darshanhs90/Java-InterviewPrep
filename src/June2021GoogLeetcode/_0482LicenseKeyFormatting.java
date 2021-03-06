package June2021GoogLeetcode;

public class _0482LicenseKeyFormatting {

	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c == '-')
				continue;
			else {
				sb.append(Character.toUpperCase(c));
				count++;
			}
			if (count == K) {
				sb.append("-");
				count = 0;
			}
		}
		sb = sb.reverse();
		if (sb.length() > 0 && sb.charAt(0) == '-')
			sb.deleteCharAt(0);

		return sb.toString();
	}
}
