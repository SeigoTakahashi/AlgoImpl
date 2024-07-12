package rec_list;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecListTest extends RecList {

	/**
	 * 対象:addメソッド(引数1つ)
	 * ケースNo: 001
	 * 概要: 空の状態のリストの末尾にデータを1件追加する
	 */
	@Test
	public void testAdd01001() {
		RecList list = new RecList();
		boolean b = list.add(5);
		assertEquals(5, list.head.data);
		assertEquals(5, list.tail.data);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		assertEquals(1, list.head.data);
		assertEquals(9, list.tail.data);
		assertEquals(5, list.size);
		Node node = list.head;
		for(int d : array) {
			assertEquals(d, node.data);
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
		RecList list = new RecList();
		boolean b = list.add(0, 10);
		assertEquals(10, list.head.data);
		assertEquals(10, list.tail.data);
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
		RecList list = new RecList();
		boolean b = list.add(1, 10);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.add(0,100);
		assertEquals(100, list.head.data);
		assertEquals(9, list.tail.data);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.add(3,100);
		assertEquals(1, list.head.data);
		assertEquals(9, list.tail.data);
		assertEquals(6, list.size);
		assertTrue(b);
		int[] array1 = {1,3,5,100,7,9};
		Node node = list.head;
		for(int d : array1) {
			assertEquals(d, node.data);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.add(5,100);
		assertEquals(1, list.head.data);
		assertEquals(100, list.tail.data);
		assertEquals(6, list.size);
		assertTrue(b);
		int[] array1 = {1,3,5,7,9,100};
		Node node = list.head;
		for(int d : array1) {
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.add(6,100);
		assertEquals(1, list.head.data);
		assertEquals(9, list.tail.data);
		assertEquals(5, list.size);
		assertTrue(!b);
		Node node = list.head;
		for(int d : array) {
			assertEquals(d, node.data);
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
		RecList list = new RecList();
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.contains(11);
		assertTrue(!b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 003
	 * 概要: 空のリストでデータを検索する
	 */
	@Test
	public void testContains003() {
		RecList list = new RecList();
		boolean b = list.contains(10);
		assertTrue(!b);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 001
	 * 概要: 空のリストで存在しない値を取得する
	 */
	@Test
	public void testGet001() {
		RecList list = new RecList();
		int d = list.get(0);
		assertEquals(-1, d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 002
	 * 概要: 5件のデータが格納されたリストで
	 *       0番目の値を取得する
	 */
	@Test
	public void testGet002() {
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		int d = list.get(0);
		assertEquals(1, d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 003
	 * 概要: 5件のデータが格納されたリストで
	 *       2番目の値を取得する
	 */
	@Test
	public void testGet003() {
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		int d = list.get(2);
		assertEquals(5, d);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 004
	 * 概要: 5件のデータが格納されたリストで
	 *       4番目の値を取得する
	 */
	@Test
	public void testGet004() {
		RecList list = new RecList();
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		int d = list.get(5);
		assertEquals(-1, d);
	}

	/**
	 * 対象:isEmptyメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでisEmptyメソッドを実行する
	 */
	@Test
	public void testIsEmpty001() {
		RecList list = new RecList();
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
		RecList list = new RecList();
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
		RecList list = new RecList();
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
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
		RecList list = new RecList();
		int result = list.removeHead();
		assertEquals(-1, result);
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
		RecList list = new RecList();
		list.add(5);
		int result = list.removeHead();
		assertEquals(5, result);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node0 = list.getNode(0);
		Node node1 = list.getNode(1);
		Node node4 = list.getNode(4);

		int result = list.removeHead();
		assertEquals(1, result);
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
		RecList list = new RecList();
		int result = list.removeTail();
		assertEquals(-1, result);
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
		RecList list = new RecList();
		list.add(5);
		int result = list.removeTail();
		assertEquals(5, result);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node0 = list.getNode(0);
		Node node3 = list.getNode(3);

		int result = list.removeTail();
		assertEquals(9, result);
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
		RecList list = new RecList();
		int result = list.remove(0);
		assertEquals(-1, result);
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
		RecList list = new RecList();
		list.add(5);
		int result = list.remove(0);
		assertEquals(5, result);
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
		RecList list = new RecList();
		list.add(5);
		Node node0 = list.getNode(0);

		int result = list.remove(1);
		assertEquals(-1, result);
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
		RecList list = new RecList();
		list.add(5);
		Node node0 = list.getNode(0);

		int result = list.remove(-1);
		assertEquals(-1, result);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node node0 = list.getNode(0);
		Node node4 = list.getNode(4);

		int result = list.remove(-1);
		assertEquals(-1, result);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node node0 = list.getNode(0);
		Node node1 = list.getNode(1);
		Node node2 = list.getNode(2);
		Node node3 = list.getNode(3);
		Node node4 = list.getNode(4);

		int result = list.remove(0);
		assertEquals(1, result);
		assertEquals(4, list.size);
		assertEquals(node1, list.head);
		assertEquals(node4, list.tail);
		assertEquals(null, node0.next);
		Node[] arr = {node1,node2,node3,node4};
		int i=0;
		Node tar = list.head;
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node node0 = list.getNode(0);
		Node node1 = list.getNode(1);
		Node node2 = list.getNode(2);
		Node node3 = list.getNode(3);
		Node node4 = list.getNode(4);

		int result = list.remove(2);
		assertEquals(5, result);
		assertEquals(4, list.size);
		assertEquals(node0, list.head);
		assertEquals(node4, list.tail);
		assertEquals(null, node2.next);
		Node[] arr = {node0,node1,node3,node4};
		int i=0;
		Node tar = list.head;
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node node0 = list.getNode(0);
		Node node1 = list.getNode(1);
		Node node2 = list.getNode(2);
		Node node3 = list.getNode(3);
		Node node4 = list.getNode(4);

		int result = list.remove(4);
		assertEquals(9, result);
		assertEquals(4, list.size);
		assertEquals(node0, list.head);
		assertEquals(node3, list.tail);
		assertEquals(null, node3.next);
		Node[] arr = {node0,node1,node2,node3};
		int i=0;
		Node tar = list.head;
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}

		Node node0 = list.getNode(0);
		Node node4 = list.getNode(4);

		int result = list.remove(5);
		assertEquals(-1, result);
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
		RecList list = new RecList();
		Node node = list.getNode(0);
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
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node = list.getNode(0);
		assertTrue(node != null);
		assertEquals(list.head, node);
		assertEquals(1, node.data);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 003
	 * 概要: 5件のデータが格納されたリストで
	 *       2番目のデータを取得する
	 */
	@Test
	public void testGetNode003() {
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node = list.getNode(2);
		assertTrue(node != null);
		assertEquals(list.head.next.next, node);
		assertEquals(5, node.data);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 004
	 * 概要: 5件のデータが格納されたリストで
	 *       4番目のデータを取得する
	 */
	@Test
	public void testGetNode004() {
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node = list.getNode(4);
		assertTrue(node != null);
		assertEquals(list.tail, node);
		assertEquals(9, node.data);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 005
	 * 概要: 5件のデータが格納されたリストで
	 *       存在しない5番目のデータを取得する
	 */
	@Test
	public void testGetNode005() {
		RecList list = new RecList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		Node node = list.getNode(5);
		assertEquals(null, node);
	}
}
