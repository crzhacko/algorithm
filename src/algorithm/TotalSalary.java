package algorithm;

public class TotalSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] relations = {
			"NNNNNN",
			"YNYNNY",
			"YNNNNY",
			"NNNNNN",
			"YNYNNN",
			"YNNYNN"
		};
		String[] relations2 = {
				"NYNNYN",
				"NNNNNN",
				"NNNNNN",
				"NNYNNN",
				"NNNNNN",
				"NNNYYN"
			};
		String[] relations3 = {
				"NNNN",
				"NNNN",
				"NNNN",
				"NNNN"
			};
		System.out.println(totalSalary(relations));
		System.out.println(totalSalary(relations2));
		System.out.println(totalSalary(relations3));
	}
	
	public static long totalSalary(String[] relations) {
		long[] dp = new long[relations.length];
		long total = 0;
		for (int i = 0; i < relations.length; i++) {
			if (dp[i] == 0) {
				dp[i] = getSalary(i, relations);
			}
			total += dp[i];
		}
		return total;
	}

	public static long getSalary(int i, String[] relations) {
		long salary = 0;
		for (int j = 0; j < relations[i].length(); j++) {
			if (relations[i].charAt(j) == 'Y') {
				salary += getSalary(j, relations);
			}
		}
		return salary == 0 ? 1 : salary;
	}
}
