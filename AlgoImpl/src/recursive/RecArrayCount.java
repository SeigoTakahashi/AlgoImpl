package recursive;

public class RecArrayCount {

	static int recCount(int idx, int[] data) {
		if(idx == data.length-1) {
			return 1;
		}
		return 1 + recCount(idx+1, data);
	}

	public static void main(String[] args) {
		int[] data = {3,7,9,4,12,5,8};
		System.out.println("count: " + recCount(0,data));
	}
}
