package recursive;

public class RecArrayPow {
	static int recPow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		return a * recPow(a,b-1);
	}
	public static void main(String[] args) {
		System.out.println("pow: " + recPow(2,10));
	}
}
