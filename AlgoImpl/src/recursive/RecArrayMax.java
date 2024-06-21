package recursive;

public class RecArrayMax {
	static int recMax(int idx, int[] data) {
		if(idx == data.length - 1) {
			return data[idx];
		}
		return Math.max(data[idx], recMax(idx+1,data));
	}
	public static void main(String[] args) {
		int[] data = {3,7,9,4,12,5,8};
		System.out.println("max: " + recMax(0,data));
	}
}
