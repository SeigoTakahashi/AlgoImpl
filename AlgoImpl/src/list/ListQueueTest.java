package list;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class ListQueueTest extends ListQueue {
	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 001
	 * 概要: データを1件挿入する
	 */
	@Test
	public void testEnqueue001() {
		ListQueue queue = new ListQueue();
		boolean  b = queue.enqueue(5);
		assertTrue(b);
		assertEquals(1, queue.queueList.size);
		assertEquals(5, queue.queueList.get(0));
		assertEquals(5, queue.queueList.head.data);
		assertEquals(5, queue.queueList.tail.data);
	}

	/**
	 * 対象:enqueueメソッド
	 * ケースNo: 002
	 * 概要: データを100件挿入する
	 */
	@Test
	public void testEnqueue002() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			boolean b = queue.enqueue(x);
			assertTrue(b);
		}
		Node node = queue.queueList.head;
		int i = 0;
		while(node != null) {
			assertEquals(array[i], node.data);
			node = node.next;
			i++;
		}
		assertEquals(100, queue.queueList.size);
		assertEquals(array[0], queue.queueList.head.data);
		assertEquals(array[99], queue.queueList.tail.data);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 001
	 * 概要: データが空の状態から取り出す
	 */
	@Test
	public void testDequeue001() {
		ListQueue queue = new ListQueue();
		int d = queue.dequeue();
		assertEquals(-1, d);
		assertEquals(0, queue.queueList.size);
		assertEquals(null, queue.queueList.head);
		assertEquals(null, queue.queueList.tail);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 002
	 * 概要: 2件のデータが挿入されたキューから、
	 *       2件のデータを取り出す
	 */
	@Test
	public void testDequeue002() {
		ListQueue queue = new ListQueue();
		queue.enqueue(5);
		queue.enqueue(6);
		int d1 = queue.dequeue();
		assertEquals(5, d1);
		assertEquals(1, queue.queueList.size);
		assertEquals(6, queue.queueList.get(0));
		assertEquals(6, queue.queueList.head.data);
		assertEquals(6, queue.queueList.tail.data);
		int d2 = queue.dequeue();
		assertEquals(6, d2);
		assertEquals(0, queue.queueList.size);
		assertEquals(null, queue.queueList.head);
		assertEquals(null, queue.queueList.tail);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 003
	 * 概要: 100件enqueue、50件dequeueした状態から10件enqueueする
	 */
	@Test
	public void testDequeue003() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<array.length; i++) {
			int x = rand.nextInt(100);
			if(i >= 50)
				array[i-50] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<array.length/2; i++) {
			queue.dequeue();
		}
		for(int i=0; i<10; i++) {
			int x = rand.nextInt(100);
			array[i+50] = x;
			queue.enqueue(x);
		}
		Node node = queue.queueList.head;
		int i = 0;
		while(node != null) {
			assertEquals(array[i], node.data);
			node = node.next;
			i++;
		}
		assertEquals(60, queue.queueList.size);
		assertEquals(array[0], queue.queueList.head.data);
		assertEquals(array[59], queue.queueList.tail.data);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 004
	 * 概要: 100件enqueueした状態から100件dequeueする
	 */
	@Test
	public void testDequeue004() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<100; i++) {
			int x = rand.nextInt(100);
			queue.enqueue(x);
			array[i] = x;
		}
		for(int i=0; i<100; i++) {
			int d = queue.dequeue();
			assertEquals(array[i], d);
		}
		assertEquals(0, queue.queueList.size);
		assertEquals(null, queue.queueList.head);
		assertEquals(null, queue.queueList.tail);
	}

	/**
	 * 対象:dequeueメソッド
	 * ケースNo: 005
	 * 概要: 100件enqueueした状態から101件dequeueする
	 */
	@Test
	public void testDequeue005() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		for(int i=0; i<100; i++) {
			int x = rand.nextInt(100);
			queue.enqueue(x);
		}
		for(int i=0; i<100; i++) {
			queue.dequeue();
		}
		int d = queue.dequeue();
		assertEquals(-1, d);
		assertEquals(0, queue.queueList.size);
		assertEquals(null, queue.queueList.head);
		assertEquals(null, queue.queueList.tail);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 001
	 * 概要: データが空の状態でpeakを呼び出す
	 */
	@Test
	public void testPeak001() {
		ListQueue queue = new ListQueue();
		int d = queue.peak();
		assertEquals(-1, d);
		assertEquals(0, queue.queueList.size);
		assertEquals(null, queue.queueList.head);
		assertEquals(null, queue.queueList.tail);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 002
	 * 概要: 100件enqueueした状態のデータでpeakを呼び出す
	 */
	@Test
	public void testPeak002() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<100; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			queue.enqueue(x);
		}
		int d = queue.peak();
		assertEquals(queue.queueList.get(0), d);
		assertEquals(array[0], d);
		assertEquals(100, queue.queueList.size);
		assertEquals(array[0], queue.queueList.head.data);
		assertEquals(array[99], queue.queueList.tail.data);
	}

	/**
	 * 対象:peakメソッド
	 * ケースNo: 003
	 * 概要: 100件enqueue、50件dequeueした状態のデータでpeakを呼び出す
	 */
	@Test
	public void testPeak003() {
		ListQueue queue = new ListQueue();
		Random rand = new Random();
		rand.setSeed(7);
		int[] array = new int[100];
		for(int i=0; i<100; i++) {
			int x = rand.nextInt(100);
			array[i] = x;
			queue.enqueue(x);
		}
		for(int i=0; i<50; i++) {
			queue.dequeue();
		}
		int d = queue.peak();
		assertEquals(queue.queueList.get(0), d);
		assertEquals(array[50], d);
		assertEquals(50, queue.queueList.size);
		assertEquals(array[50], queue.queueList.head.data);
		assertEquals(array[99], queue.queueList.tail.data);
	}
}
