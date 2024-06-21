package recursive;

public class RecListCountOdd {
	static int recCountOdd(Node node) {
		if(node == null) {
			return 0;
		}
		if(node.data % 2 == 1) {
			return 1 + recCountOdd(node.next);
		} else {
			return 0 + recCountOdd(node.next);
		}
		
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

		System.out.println("countOdd: " + recCountOdd(n1));
	}
}
