package recursive;

public class RecBinarySearch {
	static int recSearch(int target, int[] data, int left, int right) {
		if (right < left) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (data[mid] == target) {
			return mid;
		}
		if (data[mid] > target) {
			return recSearch(target, data, left, mid - 1);
		}

		return recSearch(target, data, mid + 1, right);

	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 14, 15, 16, 18, 19, 20 };
		System.out.println("search 5: " + recSearch(5, data, 0, data.length - 1));
		System.out.println("search 9: " + recSearch(9, data, 0, data.length - 1));
		System.out.println("search 10: " + recSearch(10, data, 0, data.length - 1));
		System.out.println("search 20: " + recSearch(20, data, 0, data.length - 1));
	}
}
