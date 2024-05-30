package gen_list;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenListTest extends GenList {

	/**
	 * 対象:addメソッド(引数1つ)
	 * ケースNo: 001
	 * 概要: 空の状態のリストの末尾にデータを1件追加する
	 */
	@Test
	public void testAdd01001() {
		GenList<String> list = new GenList<String>();
		boolean b = list.add("5");
		assertEquals("5", list.head.data);
		assertEquals("5", list.tail.data);
		assertEquals(1, list.size);
		assertTrue(list.head == list.tail);
		assertTrue(b);
	}

	/**
	 * 対象:addメソッド(引数1つ)
	 * ケースNo: 002
	 * 概要: 空の状態のリストの末尾にデータを5件追加する
	 */
	@Test
	public void testAdd01002() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.0,3.0,5.0,7.0,9.0};
		for(double d : array) {
			list.add(d);
		}
		assertEquals(1.0, list.head.data, 0.01);
		assertEquals(9.0, list.tail.data, 0.01);
		assertEquals(5, list.size);
		Node<Double> node = list.head;
		for(Double d : array) {
			assertEquals(d, node.data, 0.01);
			node = node.next;
		}
	}

	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 001
	 * 概要: 空の状態の0番目にデータを追加する
	 */
	@Test
	public void testAdd02001() {
		GenList<Integer> list = new GenList<Integer>();
		boolean b = list.add(0, 10);
		assertEquals(10, (int)list.head.data);
		assertEquals(10, (int)list.tail.data);
		assertEquals(1, list.size);
		assertTrue(list.head == list.tail);
		assertTrue(b);
	}


	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 002
	 * 概要: 空の状態の1番目にデータを追加する
	 */
	@Test
	public void testAdd02002() {
		GenList<String> list = new GenList<String>();
		boolean b = list.add(1, "10");
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
		assertEquals(0, list.size);
		assertTrue(!b);
	}


	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 003
	 * 概要: 5件のデータが存在しているリストの0番目にデータを挿入する
	 */
	@Test
	public void testAdd02003() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.0,3.0,5.0,7.0,9.0};
		for(Double d : array) {
			list.add(d);
		}
		boolean b = list.add(0,100.0);
		assertEquals(100, list.head.data,0.01);
		assertEquals(9, list.tail.data,0.01);
		assertEquals(6, list.size);
		assertTrue(b);
	}

	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 004
	 * 概要: 5件のデータが存在しているリストの3番目にデータを挿入する
	 */
	@Test
	public void testAdd02004() {
		GenList<Integer> list = new GenList<Integer>();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.add(3,100);
		assertEquals(1, (int)list.head.data);
		assertEquals(9, (int)list.tail.data);
		assertEquals(6, list.size);
		assertTrue(b);
		int[] array1 = {1,3,5,100,7,9};
		Node<Integer> node = list.head;
		for(int d : array1) {
			assertEquals(d, (int)node.data);
			node = node.next;
		}
	}

	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 005
	 * 概要: 5件のデータが存在しているリストの5番目にデータを挿入する
	 */
	@Test
	public void testAdd02005() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		boolean b = list.add(5,"100");
		assertEquals("1", list.head.data);
		assertEquals("100", list.tail.data);
		assertEquals(6, list.size);
		assertTrue(b);
		String[] array1 = {"1","3","5","7","9","100"};
		Node<String> node = list.head;
		for(String d : array1) {
			assertEquals(d, node.data);
			node = node.next;
		}
	}

	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 006
	 * 概要: 5件のデータが存在しているリストの6番目にデータを挿入する
	 */
	@Test
	public void testAdd02006() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		boolean b = list.add(6,100.);
		assertEquals(1., list.head.data,0.01);
		assertEquals(9., list.tail.data,0.01);
		assertEquals(5, list.size);
		assertTrue(!b);
		Node<Double> node = list.head;
		for(Double d : array) {
			assertEquals(d, node.data, 0.01);
			node = node.next;
		}
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 001
	 * 概要: 5件のデータが格納されたリストで
	 *       存在するデータを検索する
	 */
	@Test
	public void testContains001() {
		GenList<Integer> list = new GenList<Integer>();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.contains(5);
		assertTrue(b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       存在しないデータを検索する
	 */
	@Test
	public void testContains002() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		boolean b = list.contains("11");
		assertTrue(!b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 003
	 * 概要: 空のリストでデータを検索する
	 */
	@Test
	public void testContains003() {
		GenList<Double> list = new GenList<Double>();
		boolean b = list.contains(10.);
		assertTrue(!b);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 001
	 * 概要: 空のリストで存在しない値を取得する
	 */
	@Test
	public void testGet001() {
		GenList<Integer> list = new GenList<Integer>();
		Integer d = list.get(0);
		assertEquals(null, d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       0番目の値を取得する
	 */
	@Test
	public void testGet002() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		String d = list.get(0);
		assertEquals("1", d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 003
	 * 概要: 5件のデータが格納されたリストで
	 *       2番目の値を取得する
	 */
	@Test
	public void testGet003() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		Double d = list.get(2);
		assertEquals(5., d, 0.01);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 004
	 * 概要: 5件のデータが格納されたリストで
	 *       4番目の値を取得する
	 */
	@Test
	public void testGet004() {
		GenList<Integer> list = new GenList<Integer>();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		int d = list.get(4);
		assertEquals(9, d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 005
	 * 概要: 5件のデータが格納されたリストで
	 *       存在しない5番目の値を取得する
	 */
	@Test
	public void testGet005() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		String d = list.get(5);
		assertEquals(null, d);
	}

	/**
	 * 対象:isEmptyメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでisEmptyメソッドを実行する
	 */
	@Test
	public void testIsEmpty001() {
		GenList<Double> list = new GenList<Double>();
		assertTrue(list.isEmpty());
	}

	/**
	 * 対象:isEmptyメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       isEmptyメソッドを実行する
	 */
	@Test
	public void testIsEmpty002() {
		GenList<Integer> list = new GenList<Integer>();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		assertTrue(!list.isEmpty());
	}

	/**
	 * 対象:sizeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでsizeメソッドを実行する
	 */
	@Test
	public void testSize001() {
		GenList<String> list = new GenList<String>();
		assertEquals(0, list.size());
		assertEquals(list.size, list.size());
	}

	/**
	 * 対象:sizeメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       sizeメソッドを実行する
	 */
	@Test
	public void testSize002() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		assertEquals(5, list.size());
		assertEquals(list.size, list.size());
	}

	/**
	 * 対象:removeHeadメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveHeadメソッドを実行する
	 */
	@Test
	public void testRemoveHead001() {
		GenList<Integer> list = new GenList<Integer>();
		Integer result = list.removeHead();
		assertEquals(null, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeHeadメソッド
	 * ケースNo: 002
	 * 概要: データが1件格納されたリストで
	 *       removeHeadメソッドを実行する
	 */
	@Test
	public void testRemoveHead002() {
		GenList<String> list = new GenList<String>();
		list.add("5");
		String result = list.removeHead();
		assertEquals("5", result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeHeadメソッド
	 * ケースNo: 003
	 * 概要: データが5件格納されたリストで
	 *       removeHeadメソッドを実行する
	 */
	@Test
	public void testRemoveHead003() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		Node<Double> node0 = list.getNode(0);
		Node<Double> node1 = list.getNode(1);
		Node<Double> node4 = list.getNode(4);

		Double result = list.removeHead();
		assertEquals(1., result,0.01);
		assertEquals(4, list.size);
		assertEquals(node1, list.head);
		assertEquals(node4, list.tail);
		assertEquals(null, node0.next);
	}

	/**
	 * 対象:removeTailメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveTailメソッドを実行する
	 */
	@Test
	public void testRemoveTail001() {
		GenList<Integer> list = new GenList<Integer>();
		Integer result = list.removeTail();
		assertEquals(null, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeTailメソッド
	 * ケースNo: 002
	 * 概要: データが1件格納されたリストで
	 *       removeTailメソッドを実行する
	 */
	@Test
	public void testRemoveTail002() {
		GenList<String> list = new GenList<String>();
		list.add("5");
		String result = list.removeTail();
		assertEquals("5", result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeTailメソッド
	 * ケースNo: 003
	 * 概要: データが5件格納されたリストで
	 *       removeTailメソッドを実行する
	 */
	@Test
	public void testRemoveTail003() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		Node<Double> node0 = list.getNode(0);
		Node<Double> node3 = list.getNode(3);

		Double result = list.removeTail();
		assertEquals(9., result,0.01);
		assertEquals(4, list.size);
		assertEquals(node0, list.head);
		assertEquals(node3, list.tail);
		assertEquals(null, node3.next);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveメソッドを実行する
	 */
	@Test
	public void testRemove001() {
		GenList<Integer> list = new GenList<Integer>();
		Integer result = list.remove(0);
		assertEquals(null, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 002
	 * 概要: データが1件格納されたリストで
	 *       0番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove002() {
		GenList<String> list = new GenList<String>();
		list.add("5");
		String result = list.remove(0);
		assertEquals("5", result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 003
	 * 概要: データが1件格納されたリストで
	 *       1番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove003() {
		GenList<Double> list = new GenList<Double>();
		list.add(5.);
		Node<Double> node0 = list.getNode(0);

		Double result = list.remove(1);
		assertEquals(null, result);
		assertEquals(1, list.size);
		assertEquals(node0, list.head);
		assertEquals(node0, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 004
	 * 概要: データが1件格納されたリストで
	 *       -1番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove004() {
		GenList<Integer> list = new GenList<Integer>();
		list.add(5);
		Node<Integer> node0 = list.getNode(0);

		Integer result = list.remove(-1);
		assertEquals(null, result);
		assertEquals(1, list.size);
		assertEquals(node0, list.head);
		assertEquals(node0, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 005
	 * 概要: データが5件格納されたリストで
	 *       -1番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove005() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}

		Node<String> node0 = list.getNode(0);
		Node<String> node4 = list.getNode(4);

		String result = list.remove(-1);
		assertEquals(null, result);
		assertEquals(5, list.size);
		assertEquals(node0, list.head);
		assertEquals(node4, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 006
	 * 概要: データが5件格納されたリストで
	 *       0番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove006() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}

		Node<Double> node0 = list.getNode(0);
		Node<Double> node1 = list.getNode(1);
		Node<Double> node2 = list.getNode(2);
		Node<Double> node3 = list.getNode(3);
		Node<Double> node4 = list.getNode(4);

		Double result = list.remove(0);
		assertEquals(1., result, 0.01);
		assertEquals(4, list.size);
		assertEquals(node1, list.head);
		assertEquals(node4, list.tail);
		assertEquals(null, node0.next);
		Node[] arr = {node1,node2,node3,node4};
		int i=0;
		Node<Double> tar = list.head;
		while(tar != null) {
			assertEquals(arr[i], tar);
			tar = tar.next;
			i++;
		}
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 007
	 * 概要: データが5件格納されたリストで
	 *       2番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove007() {
		GenList<Integer> list = new GenList<Integer>();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node<Integer> node0 = list.getNode(0);
		Node<Integer> node1 = list.getNode(1);
		Node<Integer> node2 = list.getNode(2);
		Node<Integer> node3 = list.getNode(3);
		Node<Integer> node4 = list.getNode(4);

		Integer result = list.remove(2);
		assertEquals(5, (int)result);
		assertEquals(4, list.size);
		assertEquals(node0, list.head);
		assertEquals(node4, list.tail);
		assertEquals(null, node2.next);
		Node[] arr = {node0,node1,node3,node4};
		int i=0;
		Node<Integer> tar = list.head;
		while(tar != null) {
			assertEquals(arr[i], tar);
			tar = tar.next;
			i++;
		}
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 008
	 * 概要: データが5件格納されたリストで
	 *       4番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove008() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}

		Node<String> node0 = list.getNode(0);
		Node<String> node1 = list.getNode(1);
		Node<String> node2 = list.getNode(2);
		Node<String> node3 = list.getNode(3);
		Node<String> node4 = list.getNode(4);

		String result = list.remove(4);
		assertEquals("9", result);
		assertEquals(4, list.size);
		assertEquals(node0, list.head);
		assertEquals(node3, list.tail);
		assertEquals(null, node3.next);
		Node[] arr = {node0,node1,node2,node3};
		int i=0;
		Node<String> tar = list.head;
		while(tar != null) {
			assertEquals(arr[i], tar);
			tar = tar.next;
			i++;
		}
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 009
	 * 概要: データが5件格納されたリストで
	 *       5番目のデータをremoveメソッドで削除する
	 */
	@Test
	public void testRemove009() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}

		Node<Double> node0 = list.getNode(0);
		Node<Double> node4 = list.getNode(4);

		Double result = list.remove(5);
		assertEquals(null, result);
		assertEquals(5, list.size);
		assertEquals(node0, list.head);
		assertEquals(node4, list.tail);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでデータを取得する
	 */
	@Test
	public void testGetNode001() {
		GenList<Integer> list = new GenList<Integer>();
		Node<Integer> node = list.getNode(0);
		assertEquals(null, node);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       0番目のデータを取得する
	 */
	@Test
	public void testGetNode002() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		Node<String> node = list.getNode(0);
		assertTrue(node != null);
		assertEquals(list.head, node);
		assertEquals("1", node.data);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 003
	 * 概要: 5件のデータが格納されたリストで
	 *       2番目のデータを取得する
	 */
	@Test
	public void testGetNode003() {
		GenList<Double> list = new GenList<Double>();
		Double[] array = {1.,3.,5.,7.,9.};
		for(Double d : array) {
			list.add(d);
		}
		Node<Double> node = list.getNode(2);
		assertTrue(node != null);
		assertEquals(list.head.next.next, node);
		assertEquals(5., node.data,0.01);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 004
	 * 概要: 5件のデータが格納されたリストで
	 *       4番目のデータを取得する
	 */
	@Test
	public void testGetNode004() {
		GenList<Integer> list = new GenList<Integer>();
		Integer[] array = {1,3,5,7,9};
		for(Integer d : array) {
			list.add(d);
		}
		Node<Integer> node = list.getNode(4);
		assertTrue(node != null);
		assertEquals(list.tail, node);
		assertEquals(9, (int)node.data);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 005
	 * 概要: 5件のデータが格納されたリストで
	 *       存在しない5番目のデータを取得する
	 */
	@Test
	public void testGetNode005() {
		GenList<String> list = new GenList<String>();
		String[] array = {"1","3","5","7","9"};
		for(String d : array) {
			list.add(d);
		}
		Node<String> node = list.getNode(5);
		assertEquals(null, node);
	}
}
