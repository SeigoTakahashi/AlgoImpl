package recursive;

public class RecArraySum {

	static int recSum(int idx, int[] data) {
		if (idx == data.length) {
			return 0;
		}
		return data[idx] + recSum(idx + 1, data);
	}

	public static void main(String[] args) {
		int[] data = { 3, 7, 9, 4, 12, 5, 8 };
		System.out.println("sum: " + recSum(0, data));
	}
}
