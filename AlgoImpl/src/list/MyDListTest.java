package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyDListTest extends MyList {

	/**
	 * 対象:addメソッド(引数1つ)
	 * ケースNo: 001
	 * 概要: 空の状態のリストの末尾にデータを1件追加する
	 */
	@Test
	public void testAdd01001() {
		MyDList list = new MyDList();
		boolean b = list.add(5);
		assertEquals(5, list.head.data);
		assertEquals(5, list.tail.data);
		assertEquals(1, list.size);
		assertEquals(null, list.head.next);
		assertEquals(null, list.head.prev);
		assertTrue(list.head == list.tail);
		assertTrue(b);
	}


	/**
	 * 対象:addメソッド(引数2つ)
	 * ケースNo: 001
	 * 概要: 空の状態の0番目にデータを追加する
	 */
	@Test
	public void testAdd02001() {
		MyDList list = new MyDList();
		boolean b = list.add(0, 5);
		assertEquals(5, list.head.data);
		assertEquals(5, list.tail.data);
		assertEquals(1, list.size);
		assertEquals(null, list.head.next);
		assertEquals(null, list.head.prev);
		assertTrue(list.head == list.tail);
		assertTrue(b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 001
	 * 概要: 5件のデータが格納されたリストで
	 *       存在するデータを検索する
	 */
	@Test
	public void testContains001() {
		MyDList list = new MyDList();
		int[] array = {1,3,5,7,9};
		for(int d : array) {
			list.add(d);
		}
		boolean b = list.contains(5);
		assertTrue(b);
	}

	/**
	 * 対象:getメソッド
	 * ケースNo: 001
	 * 概要: 空のリストで存在しない値を取得する
	 */
	@Test
	public void testGet001() {
		MyDList list = new MyDList();
		int d = list.get(0);
		assertEquals(-1, d);
	}

	/**
	 * 対象:isEmptyメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでisEmptyメソッドを実行する
	 */
	@Test
	public void testIsEmpty001() {
		MyDList list = new MyDList();
		assertTrue(list.isEmpty());
	}

	/**
	 * 対象:sizeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでsizeメソッドを実行する
	 */
	@Test
	public void testSize001() {
		MyDList list = new MyDList();
		assertEquals(0, list.size());
		assertEquals(list.size, list.size());
	}

	/**
	 * 対象:removeHeadメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveHeadメソッドを実行する
	 */
	@Test
	public void testRemoveHead001() {
		MyDList list = new MyDList();
		int result = list.removeHead();
		assertEquals(-1, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeTailメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveTailメソッドを実行する
	 */
	@Test
	public void testRemoveTail001() {
		MyDList list = new MyDList();
		int result = list.removeTail();
		assertEquals(-1, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:removeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでremoveメソッドを実行する
	 */
	@Test
	public void testRemove001() {
		MyDList list = new MyDList();
		int result = list.remove(0);
		assertEquals(-1, result);
		assertEquals(0, list.size);
		assertEquals(null, list.head);
		assertEquals(null, list.tail);
	}

	/**
	 * 対象:getNodeメソッド
	 * ケースNo: 001
	 * 概要: 空のリストでデータを取得する
	 */
	@Test
	public void testGetNode001() {
		MyDList list = new MyDList();
		DNode node = list.getNode(0);
		assertEquals(null, node);
	}
}
