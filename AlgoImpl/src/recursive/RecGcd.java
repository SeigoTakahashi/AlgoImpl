package recursive;

public class RecGcd {
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println("gcd: " + gcd(1920, 1080));
	}
}
