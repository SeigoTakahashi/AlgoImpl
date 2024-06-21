package recursive;

public class RecArrayProd {
	static int recProd(int idx, int[] data) {
		if (idx == data.length) {
			return 1;
		}
		return data[idx] * recProd(idx + 1, data);
	}
	public static void main(String[] args) {
		int[] data = {3,7,9,4,12,5,8};
		System.out.println("prod: " + recProd(0,data));
	}
}
