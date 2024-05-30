package list;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class ListStackTest extends ListStack {

	/**
	 * 対象:pushメソッド
	 * ケースNo: 001
	 * 概要: 空の状態のスタックにデータを2件追加する
	 */
	@Test
	public void testPush001() {
		ListStack stack = new ListStack();
		int x = stack.push(5);
		int y = stack.push(6);
		assertEquals(5, x);
		assertEquals(6, y);
		assertEquals(5, stack.stackList.get(0));
		assertEquals(6, stack.stackList.get(1));
		assertEquals(5, stack.stackList.head.data);
		assertEquals(6, stack.stackList.tail.data);
		assertEquals(2, stack.stackList.size());
	}

	/**
	 * 対象:pushメソッド
	 * ケースNo: 002
	 * 概要: 空の状態のスタックに100件データを追加する
	 */
	@Test
	public void testPush002() {
		ListStack stack = new ListStack();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			stack.push(x);
		}
		Node node = stack.stackList.head;
		int i = 0;
		while(node != null) {
			assertEquals(array[i], node.data);
			node = node.next;
			i++;
		}
		assertEquals(100, stack.stackList.size);
		assertEquals(array[0], stack.stackList.head.data);
		assertEquals(array[99], stack.stackList.tail.data);
	}

	/**
	 * 対象:emptyメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでemptyメソッドを実行する
	 */
	@Test
	public void testEmpty001() {
		ListStack stack = new ListStack();
		assertEquals(true, stack.empty());
		assertEquals(0, stack.stackList.size);
	}

	/**
	 * 対象:emptyメソッド
	 * ケースNo: 002
	 * 概要: 100件分のデータが格納されたスタックで
	 *       emptyメソッドを実行する
	 */
	@Test
	public void testEmpty002() {
		ListStack stack = new ListStack();
		Random rand = new Random();
		for(int i=0; i<100; i++) {
			int x = rand.nextInt(100);
			stack.push(x);
		}
		assertEquals(false, stack.empty());
		assertTrue(stack.stackList.size > 0);
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでpopを実行する
	 */
	@Test
	public void testPop001() {
		ListStack stack = new ListStack();
		int x = stack.pop();
		assertEquals(-1, x);
		assertEquals(0, stack.stackList.size);
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 002
	 * 概要: データが2件追加されたスタックで
	 *       2回popを実行する
	 */
	@Test
	public void testPop002() {
		ListStack stack = new ListStack();
		stack.push(5);
		stack.push(6);

		int x = stack.pop();
		assertEquals(6, x);
		assertEquals(1, stack.stackList.size);
		assertEquals(false, stack.empty());

		int y = stack.pop();
		assertEquals(5, y);
		assertEquals(0, stack.stackList.size);
		assertEquals(true, stack.empty());
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 002
	 * 概要: データが2件追加されたスタックで
	 *       3回popを実行する
	 */
	@Test
	public void testPop003() {
		ListStack stack = new ListStack();
		stack.push(5);
		stack.push(6);

		int x = stack.pop();
		assertEquals(6, x);
		assertEquals(1, stack.stackList.size);
		assertEquals(false, stack.empty());

		int y = stack.pop();
		assertEquals(5, y);
		assertEquals(0, stack.stackList.size);
		assertEquals(true, stack.empty());

		int z = stack.pop();
		assertEquals(-1, z);
		assertEquals(0, stack.stackList.size);
		assertEquals(true, stack.empty());
	}

	/**
	 * 対象:peekメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでpeekを実行する
	 */
	@Test
	public void testPeek001() {
		ListStack stack = new ListStack();
		int x = stack.peek();
		assertEquals(-1, x);
		assertEquals(0, stack.stackList.size);
	}

	/**
	 * 対象:peekメソッド
	 * ケースNo: 002
	 * 概要: データが2件追加されたスタックで
	 *       2回peekを実行する
	 */
	@Test
	public void testPeek002() {
		ListStack stack = new ListStack();
		stack.push(5);
		stack.push(6);

		int x = stack.peek();
		assertEquals(6, x);
		assertEquals(2, stack.stackList.size);
		assertEquals(false, stack.empty());

		int y = stack.peek();
		assertEquals(6, y);
		assertEquals(2, stack.stackList.size);
		assertEquals(false, stack.empty());
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでsearchを実行する
	 */
	@Test
	public void testSearch001() {
		ListStack stack = new ListStack();
		int x = stack.search(10);
		assertEquals(-1, x);
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 002
	 * 概要: 100件のデータが格納されたスタックで
	 *       存在するデータをsearchで検索する
	 */
	@Test
	public void testSearch002() {
		ListStack stack = new ListStack();
		Random rand = new Random();
		rand.setSeed(7);
		int target = -1;
		int[] array = new int[100];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			stack.push(x);
			if(i == 50) {
				target = x;
			}
		}
		int x = stack.search(target);
		assertEquals(50, x);
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 003
	 * 概要: 100件のデータが格納されたスタックで
	 *       存在しないデータをsearchで検索する
	 */
	@Test
	public void testSearch003() {
		ListStack stack = new ListStack();
		Random rand = new Random();
		rand.setSeed(11);
		int[] array = new int[100];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			stack.push(x);
		}
		int x = stack.search(1001);
		assertEquals(-1, x);
	}
}
