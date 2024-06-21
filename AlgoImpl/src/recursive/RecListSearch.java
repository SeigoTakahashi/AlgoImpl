package recursive;

public class RecListSearch {
	static boolean recSearch(int target, Node node) {
		if(node == null) {
			return false;
		}
		if(node.data == target) {
			return true;
		}
		return recSearch(target,node.next);
	}

	public static void main(String[] args) {
		Node n1 = new Node(5);

		Node n2 = new Node(9);
		n1.next = n2;

		Node n3 = new Node(7);
		n2.next = n3;

		Node n4 = new Node(12);
		n3.next = n4;

		Node n5 = new Node(3);
		n4.next = n5;

		System.out.println("search 7: " + recSearch(7, n1));
		System.out.println("search 10: " + recSearch(10, n1));
	}
}
