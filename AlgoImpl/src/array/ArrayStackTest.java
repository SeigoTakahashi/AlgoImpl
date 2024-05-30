package array;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ArrayStackTest {
	/**
	 * 対象:pushメソッド
	 * ケースNo: 001
	 * 概要: 空の状態のスタックにデータを2件追加する
	 */
	@Test
	public void testPush001() {
		ArrayStack stack = new ArrayStack();
		int x = stack.push(5);
		int y = stack.push(6);
		assertEquals(5, x);
		assertEquals(6, y);
		assertEquals(5, stack.stackArray[0]);
		assertEquals(6, stack.stackArray[1]);
		assertEquals(2, stack.top);
	}

	/**
	 * 対象:pushメソッド
	 * ケースNo: 002
	 * 概要: 空の状態のスタックに上限までデータを追加する
	 */
	@Test
	public void testPush002() {
		ArrayStack stack = new ArrayStack();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayStack.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayStack.MAX_SIZE);
			array[i] = x;
			stack.push(x);
		}
		assertArrayEquals(array, stack.stackArray);
		assertEquals(array.length, stack.top);
	}

	/**
	 * 対象:pushメソッド
	 * ケースNo: 003
	 * 概要: 上限までデータが格納されたスタックに
	 *       さらにデータを1件追加する
	 */
	@Test
	public void testPush003() {
		ArrayStack stack = new ArrayStack();
		Random rand = new Random();
		rand.setSeed(5);
		int[] array = new int[ArrayStack.MAX_SIZE];
		for(int i=0; i<ArrayStack.MAX_SIZE; i++) {
			int x = rand.nextInt(ArrayStack.MAX_SIZE);
			array[i] = x;
			stack.push(x);
		}
		int y = stack.push(5);
		assertArrayEquals(array, stack.stackArray);
		assertEquals(ArrayStack.MAX_SIZE, stack.top);
		assertEquals(-1, y);
	}

	/**
	 * 対象:emptyメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでemptyメソッドを実行する
	 */
	@Test
	public void testEmpty001() {
		ArrayStack stack = new ArrayStack();
		assertEquals(true, stack.empty());
		assertEquals(0, stack.top);
	}

	/**
	 * 対象:emptyメソッド
	 * ケースNo: 002
	 * 概要: 上限の半分までデータが格納されたスタックで
	 *       emptyメソッドを実行する
	 */
	@Test
	public void testEmpty002() {
		ArrayStack stack = new ArrayStack();
		Random rand = new Random();
		for(int i=0; i<ArrayStack.MAX_SIZE/2; i++) {
			int x = rand.nextInt(ArrayStack.MAX_SIZE);
			stack.push(x);
		}
		assertEquals(false, stack.empty());
		assertTrue(stack.top > 0);
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでpopを実行する
	 */
	@Test
	public void testPop001() {
		ArrayStack stack = new ArrayStack();
		int x = stack.pop();
		assertEquals(-1, x);
		assertEquals(0, stack.top);
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 002
	 * 概要: データが2件追加されたスタックで
	 *       2回popを実行する
	 */
	@Test
	public void testPop002() {
		ArrayStack stack = new ArrayStack();
		stack.push(5);
		stack.push(6);

		int x = stack.pop();
		assertEquals(6, x);
		assertEquals(1, stack.top);
		assertEquals(false, stack.empty());

		int y = stack.pop();
		assertEquals(5, y);
		assertEquals(0, stack.top);
		assertEquals(true, stack.empty());
	}

	/**
	 * 対象:popメソッド
	 * ケースNo: 003
	 * 概要: データが2件追加されたスタックで
	 *       3回popを実行する
	 */
	@Test
	public void testPop003() {
		ArrayStack stack = new ArrayStack();
		stack.push(5);
		stack.push(6);

		int x = stack.pop();
		assertEquals(6, x);
		assertEquals(1, stack.top);
		assertEquals(false, stack.empty());

		int y = stack.pop();
		assertEquals(5, y);
		assertEquals(0, stack.top);
		assertEquals(true, stack.empty());

		int z = stack.pop();
		assertEquals(-1, z);
		assertEquals(0, stack.top);
		assertEquals(true, stack.empty());
	}

	/**
	 * 対象:peekメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでpeekを実行する
	 */
	@Test
	public void testPeek001() {
		ArrayStack stack = new ArrayStack();
		int x = stack.peek();
		assertEquals(-1, x);
		assertEquals(0, stack.top);
	}

	/**
	 * 対象:peekメソッド
	 * ケースNo: 002
	 * 概要: データが2件追加されたスタックで
	 *       2回peekを実行する
	 */
	@Test
	public void testPeek002() {
		ArrayStack stack = new ArrayStack();
		stack.push(5);
		stack.push(6);

		int x = stack.peek();
		assertEquals(6, x);
		assertEquals(2, stack.top);
		assertEquals(false, stack.empty());

		int y = stack.peek();
		assertEquals(6, y);
		assertEquals(2, stack.top);
		assertEquals(false, stack.empty());
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 001
	 * 概要: 空のスタックでsearchを実行する
	 */
	@Test
	public void testSearch001() {
		ArrayStack stack = new ArrayStack();
		int x = stack.search(10);
		assertEquals(-1, x);
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 002
	 * 概要: 上限までデータが格納されたスタックで
	 *       存在するデータをsearchで検索する
	 */
	@Test
	public void testSearch002() {
		ArrayStack stack = new ArrayStack();
		Random rand = new Random();
		rand.setSeed(7);
		int target = -1;
		int[] array = new int[ArrayStack.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayStack.MAX_SIZE);
			array[i] = x;
			stack.push(x);
			if(i == ArrayStack.MAX_SIZE / 2) {
				target = x;
			}
		}
		int x = stack.search(target);
		assertEquals(ArrayStack.MAX_SIZE / 2, x);
	}

	/**
	 * 対象:searchメソッド
	 * ケースNo: 003
	 * 概要: 上限までデータが格納されたスタックで
	 *       存在しないデータをsearchで検索する
	 */
	@Test
	public void testSearch003() {
		ArrayStack stack = new ArrayStack();
		Random rand = new Random();
		rand.setSeed(11);
		int[] array = new int[ArrayStack.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayStack.MAX_SIZE);
			array[i] = x;
			stack.push(x);
		}
		int x = stack.search(1001);
		assertEquals(-1, x);
	}
}
