package list;

public class Sample01 {
	public static void main(String[] args) {
		Node n1 = new Node(1);

		Node n2 = new Node(2);
		n1.next = n2;

		Node n3 = new Node(3);
		n2.next = n3;

		Node n4 = new Node(4);
		n3.next = n4;

		Node n5 = new Node(5);
		n4.next = n5;

		Node target = n1;
		while(target != null) {
			System.out.println(target.data);
			target = target.next;
		}
	}
}
