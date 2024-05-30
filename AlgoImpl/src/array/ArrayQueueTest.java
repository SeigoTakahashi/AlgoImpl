package array;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class ArrayQueueTest extends ArrayQueue {
	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 001
	 * 概要: データを1件挿入する
	 */
	@Test
	public void testEnqueue001() {
		ArrayQueue queue = new ArrayQueue();
		boolean  b = queue.enqueue(5);
		assertTrue(b);
		assertEquals(1, queue.size);
		assertEquals(0, queue.front);
		assertEquals(1, queue.rear);
		assertEquals(5, queue.queueArray[0]);
	}

	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 002
	 * 概要: データをデータサイズ上限の半分まで挿入する
	 */
	@Test
	public void testEnqueue002() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.size);
		assertEquals(0, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}

	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 003
	 * 概要: データをデータサイズ上限まで挿入する
	 */
	@Test
	public void testEnqueue003() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE, queue.size);
		assertEquals(0, queue.front);
		assertEquals(0, queue.rear);
	}

	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 004
	 * 概要: データをデータサイズ上限まで挿入済みのキューに
	 *       追加でデータを1件挿入する
	 */
	@Test
	public void testEnqueue004() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		boolean b = queue.enqueue(5);
		assertTrue(!b);
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE, queue.size);
		assertEquals(0, queue.front);
		assertEquals(0, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 001
	 * 概要: データが空の状態から取り出す
	 */
	@Test
	public void testDequeue001() {
		ArrayQueue queue = new ArrayQueue();
		int d = queue.dequeue();
		assertEquals(-1, d);
		assertEquals(0, queue.size);
		assertEquals(0, queue.front);
		assertEquals(0, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 002
	 * 概要: 2件のデータが挿入されたキューから、
	 *       2件のデータを取り出す
	 */
	@Test
	public void testDequeue002() {
		ArrayQueue queue = new ArrayQueue();
		queue.enqueue(5);
		queue.enqueue(6);
		int d1 = queue.dequeue();
		assertEquals(5, d1);
		assertEquals(1, queue.size);
		assertEquals(1, queue.front);
		assertEquals(2, queue.rear);
		int d2 = queue.dequeue();
		assertEquals(6, d2);
		assertEquals(0, queue.size);
		assertEquals(2, queue.front);
		assertEquals(2, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 003
	 * 概要: 配列の真ん中から後ろ半分にデータが詰まった状態のキューに対し、
	 *       データを10件挿入する
	 */
	@Test
	public void testDequeue003() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<10; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE/2 + 10, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(10, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 004
	 * 概要: 配列の真ん中から後ろ半分にデータが詰まった状態のキューに対し、
	 *       空いた隙間の分だけデータを挿入する
	 */
	@Test
	public void testDequeue004() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 005
	 * 概要: 配列のちょうど真ん中からキューが始まり、
	 *       すべての要素が埋まっている状態のキューに対して、
	 *       データを1件挿入する
	 */
	@Test
	public void testDequeue005() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		boolean b = queue.enqueue(5);
		assertTrue(!b);
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 006
	 * 概要: 配列のちょうど真ん中からキューが始まり、
	 *       すべての要素が埋まっている状態のキューから、
	 *       データを全件取り出す
	 */
	@Test
	public void testDequeue006() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length; i++) {
			queue.dequeue();
		}
		assertArrayEquals(array, queue.queueArray);
		assertEquals(0, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}


	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 007
	 * 概要: 配列のちょうど真ん中からキューが始まり、
	 *       中身が空のキューからデータを1件取り出す
	 */
	@Test
	public void testDequeue007() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length; i++) {
			queue.dequeue();
		}
		int d = queue.dequeue();
		assertEquals(-1, d);
		assertArrayEquals(array, queue.queueArray);
		assertEquals(0, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 001
	 * 概要: データが空の状態でpeakを呼び出す
	 */
	@Test
	public void testPeak001() {
		ArrayQueue queue = new ArrayQueue();
		int d = queue.peak();
		assertEquals(-1, d);
		assertEquals(0, queue.size);
		assertEquals(0, queue.front);
		assertEquals(0, queue.rear);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 002
	 * 概要: 配列の前半分が埋まった状態のキューに対して、
	 *       peakを呼び出す
	 */
	@Test
	public void testPeak002() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length/2; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		int d = queue.peak();
		assertEquals(queue.queueArray[0], d);
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.size);
		assertEquals(0, queue.front);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.rear);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 003
	 * 概要: 配列の後ろ半分が埋まった状態のキューに対して、
	 *       peakメソッドを呼び出す
	 */
	@Test
	public void testPeak003() {
		ArrayQueue queue = new ArrayQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[ArrayQueue.MAX_SIZE];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(ArrayQueue.MAX_SIZE);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		int d = queue.peak();
		assertEquals(queue.queueArray[ArrayQueue.MAX_SIZE/2], d);
		assertArrayEquals(array, queue.queueArray);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.size);
		assertEquals(ArrayQueue.MAX_SIZE/2, queue.front);
		assertEquals(0, queue.rear);
	}
}
