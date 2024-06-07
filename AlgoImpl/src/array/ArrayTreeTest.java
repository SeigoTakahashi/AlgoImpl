package array;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class ArrayTreeTest extends ArrayTree {

	/**
	 * 対象:addメソッド
	 * ケースNo: 001
	 * 概要: データを1件挿入する
	 */
	@Test
	void testAdd001() {
		ArrayTree tree = new ArrayTree();
		tree.add(5);
		assertEquals(5, tree.treeArray[0]);
		assertEquals(-1, tree.treeArray[1]);
		assertEquals(-1, tree.treeArray[2]);
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 002
	 * 概要: 5 → 10 の順にデータを挿入する
	 */
	@Test
	void testAdd002() {
		ArrayTree tree = new ArrayTree();
		tree.add(5);
		tree.add(10);
		assertEquals(5, tree.treeArray[0]);
        assertEquals(-1, tree.treeArray[1]);
        assertEquals(10, tree.treeArray[2]);
        assertEquals(-1, tree.treeArray[5]);
        assertEquals(-1, tree.treeArray[6]);
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 003
	 * 概要: 10 → 5 の順にデータを挿入する
	 */
	@Test
	void testAdd003() {
		ArrayTree tree = new ArrayTree();
		tree.add(10);
		tree.add(5);
		assertEquals(10, tree.treeArray[0]);
        assertEquals(5, tree.treeArray[1]);
        assertEquals(-1, tree.treeArray[2]);
        assertEquals(-1, tree.treeArray[3]);
        assertEquals(-1, tree.treeArray[4]);
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 004
	 * 概要: 5 → 10 → 3 → 4 → 1 → 8 → 12 → 9
	 *       の順にデータを挿入する
	 */
	@Test
	void testAdd004() {
		ArrayTree tree = new ArrayTree();
		int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

		assertEquals(5, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(10, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(4, tree.treeArray[4]);
        assertEquals(8, tree.treeArray[5]);
        assertEquals(12, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(9, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[13]);
        assertEquals(-1, tree.treeArray[14]);
        assertEquals(-1, tree.treeArray[25]);
        assertEquals(-1, tree.treeArray[26]);
	}

	/**
     * 対象:addメソッド
     * ケースNo: 005
     * 概要: 10件のデータを小さい順に挿入する
     */
    @Test
    void testAdd005() {
        int[] datas = {1,3,5,7,9,11,13,15,17,19};
        ArrayTree tree = new ArrayTree();
        for(int v : datas) {
            tree.add(v);
        }

        int i = 0;
        for(int v : datas) {
            assertEquals(v, tree.treeArray[i]);
            i = 2*i + 2;
        }
    }

    /**
     * 対象:addメソッド
     * ケースNo: 006
     * 概要: 11件のデータを小さい順に挿入する
     */
    @Test
    void testAdd006() {
        int[] datas = {1,3,5,7,9,11,13,15,17,19};
        ArrayTree tree = new ArrayTree();
        for(int v : datas) {
            tree.add(v);
        }

        int i = 0;
        for(int v : datas) {
            assertEquals(v, tree.treeArray[i]);
            i = 2*i + 2;
        }

        int ret = tree.add(21);
        assertEquals(-1, ret);
    }

    /**
     * 対象:addメソッド
     * ケースNo: 007
     * 概要: 10件のデータを大きい順に挿入する
     */
    @Test
    void testAdd007() {
        int[] datas = {9,8,7,6,5,4,3,2,1,0};
        ArrayTree tree = new ArrayTree();
        for(int v : datas) {
            tree.add(v);
        }

        int i = 0;
        for(int v : datas) {
            assertEquals(v, tree.treeArray[i]);
            i = 2*i + 1;
        }
    }

    /**
     * 対象:addメソッド
     * ケースNo: 008
     * 概要: 11件のデータを大きい順に挿入する
     */
    @Test
    void testAdd008() {
        int[] datas = {10,9,8,7,6,5,4,3,2,1};
        ArrayTree tree = new ArrayTree();
        for(int v : datas) {
            tree.add(v);
        }

        int i = 0;
        for(int v : datas) {
            assertEquals(v, tree.treeArray[i]);
            i = 2*i + 1;
        }

        int ret = tree.add(0);
        assertEquals(-1, ret);
    }


	/**
	 * 対象:containsメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでデータを探す
	 */
	@Test
	void testContains001() {
		ArrayTree tree = new ArrayTree();
		boolean b = tree.contains(5);
		assertTrue(!b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 002
	 * 概要: データ1件のツリーで存在するデータを探す
	 */
	@Test
	void testContains002() {
		ArrayTree tree = new ArrayTree();
		tree.add(5);
		boolean b = tree.contains(5);
		assertTrue(b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 003
	 * 概要: データ1件のツリーで存在しないデータを探す
	 */
	@Test
	void testContains003() {
		ArrayTree tree = new ArrayTree();
		tree.add(5);
		boolean b = tree.contains(10);
		assertTrue(!b);
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 004
	 * 概要: ツリーに存在するデータを探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testContains004() {
		ArrayTree tree = new ArrayTree();
		int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

		int[] datas = {5,3,1,4,10,8,9,12};
		for(int i=0; i<datas.length; i++) {
			boolean b = tree.contains(datas[i]);
			assertTrue(b);
		}
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 005
	 * 概要: ツリーに存在しないデータを探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testContains005() {
		ArrayTree tree = new ArrayTree();
		int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

		int[] datas = {-1,6,7,100,11};
		for(int i=0; i<datas.length; i++) {
			boolean b = tree.contains(datas[i]);
			assertTrue(!b);
		}
	}

	   /**
     * 対象:searchメソッド
     * ケースNo: 001
     * 概要: 空のツリーでデータを探す
     */
    @Test
    void testSearch001() {
        ArrayTree tree = new ArrayTree();
        int idx = tree.search(5);
        assertEquals(-1, idx);
    }

    /**
     * 対象:searchメソッド
     * ケースNo: 002
     * 概要: データ1件のツリーで存在するデータを探す
     */
    @Test
    void testSearch002() {
        ArrayTree tree = new ArrayTree();
        tree.add(5);
        int idx = tree.search(5);
        assertEquals(0, idx);
        assertEquals(5, tree.treeArray[idx]);
    }

    /**
     * 対象:searchメソッド
     * ケースNo: 003
     * 概要: データ1件のツリーで存在しないデータを探す
     */
    @Test
    void testSearch003() {
        ArrayTree tree = new ArrayTree();
        tree.add(5);
        int idx = tree.search(10);
        assertEquals(-1, idx);
    }

    /**
     * 対象:searchメソッド
     * ケースNo: 004
     * 概要: ツリーに存在するデータを探す
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testSearch004() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        int[] idxs = {0,2,1,4,3,5,6,12};
        for(int v : data) {
            tree.add(v);
        }

        for(int i=0; i<data.length; i++) {
            int idx = tree.search(data[i]);
            assertEquals(idxs[i], idx);
            assertEquals(data[i], tree.treeArray[idx]);
        }
    }

    /**
     * 対象:searchメソッド
     * ケースNo: 005
     * 概要: ツリーに存在しないデータを探す
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testSearch005() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        int[] datas = {-5,6,7,100,11};
        for(int i=0; i<datas.length; i++) {
            int idx = tree.search(datas[i]);
            assertEquals(-1, idx);
        }
    }

	/**
	 * 対象:maxメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでrootから最大値を探す
	 */
	@Test
	void testMax001() {
		ArrayTree tree = new ArrayTree();
		int result = tree.max(0);
		assertEquals(-1, result);
	}

	/**
	 * 対象:maxメソッド
	 * ケースNo: 002
	 * 概要: データが1件のツリーでrootから最大値を探す
	 */
	@Test
	void testMax002() {
		ArrayTree tree = new ArrayTree();
		tree.add(5);
		int result = tree.max(0);
		assertEquals(5, result);
		assertEquals(tree.treeArray[0], result);
	}

	/**
	 * 対象:maxメソッド
	 * ケースNo: 003
	 * 概要: ツリーに存在する各データを起点に最大値を探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testMax003() {
		ArrayTree tree = new ArrayTree();
		int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

		int[] nodes = {0,1,3,4,2,5,12,6};
		int[] ans = {12,4,1,4,12,9,9,12};
		for(int i=0; i<nodes.length; i++) {
			int result = tree.max(nodes[i]);
			assertEquals(ans[i], result);
		}
	}

	/**
     * 対象:maxメソッド
     * ケースNo: 004
     * 概要: ツリーに存在しないデータを起点に最大値を探す
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testMax004() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        int[] nodes = {7,8,36,200,51};
        for(int i=0; i<nodes.length; i++) {
            int result = tree.max(nodes[i]);
            assertEquals(-1, result);
        }
    }


	/**
	 * 対象:minメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでrootから最小値を探す
	 */
	@Test
	void testMin001() {
	    ArrayTree tree = new ArrayTree();
        int result = tree.min(0);
        assertEquals(-1, result);
	}

	/**
	 * 対象:minメソッド
	 * ケースNo: 002
	 * 概要: データが1件のツリーでrootから最小値を探す
	 */
	@Test
	void testMin002() {
	    ArrayTree tree = new ArrayTree();
        tree.add(5);
        int result = tree.max(0);
        assertEquals(5, result);
        assertEquals(tree.treeArray[0], result);
	}

	/**
	 * 対象:minメソッド
	 * ケースNo: 003
	 * 概要: ツリーに存在する各データを起点に最小値を探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testMin003() {

	    ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        int[] nodes = {0,1,3,4,2,5,12,6};
        int[] ans = {1,1,1,4,8,8,9,12};
        for(int i=0; i<nodes.length; i++) {
            int result = tree.min(nodes[i]);
            assertEquals(ans[i], result);
        }
	}

	/**
     * 対象:minメソッド
     * ケースNo: 004
     * 概要: ツリーに存在しないデータを起点に最大値を探す
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testMin004() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        int[] nodes = {7,8,36,200,51};
        for(int i=0; i<nodes.length; i++) {
            int result = tree.min(nodes[i]);
            assertEquals(-1, result);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 001
     * 概要: 空のツリーからデータを削除する
     */
    @Test
    void testRemove001() {
        ArrayTree tree = new ArrayTree();
        tree.remove(5);
        assertEquals(-1, tree.treeArray[0]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 002
     * 概要: データが1件のツリーから存在するデータを削除する
     */
    @Test
    void testRemove002() {
        ArrayTree tree = new ArrayTree();
        tree.add(5);
        tree.remove(5);
        assertEquals(-1, tree.treeArray[0]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 003
     * 概要: データが1件のツリーから存在しないデータを削除する
     */
    @Test
    void testRemove003() {
        ArrayTree tree = new ArrayTree();
        tree.add(5);
        tree.remove(10);
        assertEquals(5, tree.treeArray[0]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 004
     * 概要: ツリーに存在する葉を削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove004() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }
        tree.remove(4);

        assertEquals(5, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(10, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(-1, tree.treeArray[4]);
        assertEquals(8, tree.treeArray[5]);
        assertEquals(12, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(9, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[13]);
        assertEquals(-1, tree.treeArray[14]);
        assertEquals(-1, tree.treeArray[25]);
        assertEquals(-1, tree.treeArray[26]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 005
     * 概要: ツリーに存在する右側のみ枝があるデータを削除する
     *
     */
    @Test
    void testRemove005() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,15,3,4,1,8,19,12,10,14};
        for(int v : data) {
            tree.add(v);
        }

        tree.remove(8);

        assertEquals(5, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(15, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(4, tree.treeArray[4]);
        assertEquals(12, tree.treeArray[5]);
        assertEquals(19, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(10, tree.treeArray[11]);
        assertEquals(14, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[23]);
        assertEquals(-1, tree.treeArray[24]);
        assertEquals(-1, tree.treeArray[25]);
        assertEquals(-1, tree.treeArray[26]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 006
     * 概要: ツリーに存在する左側のみ枝があるデータを削除する
     */
    @Test
    void testRemove006() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,15,3,4,1,8,19,17,16,18};
        for(int v : data) {
            tree.add(v);
        }

        tree.remove(19);

        assertEquals(5, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(15, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(4, tree.treeArray[4]);
        assertEquals(8, tree.treeArray[5]);
        assertEquals(17, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(-1, tree.treeArray[12]);
        assertEquals(16, tree.treeArray[13]);
        assertEquals(18, tree.treeArray[14]);
        assertEquals(-1, tree.treeArray[27]);
        assertEquals(-1, tree.treeArray[28]);
        assertEquals(-1, tree.treeArray[29]);
        assertEquals(-1, tree.treeArray[30]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 007
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove007() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        tree.remove(5);

        assertEquals(8, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(10, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(4, tree.treeArray[4]);
        assertEquals(9, tree.treeArray[5]);
        assertEquals(12, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(-1, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[13]);
        assertEquals(-1, tree.treeArray[14]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 008
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove008() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        tree.remove(3);

        assertEquals(5, tree.treeArray[0]);
        assertEquals(4, tree.treeArray[1]);
        assertEquals(10, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(-1, tree.treeArray[4]);
        assertEquals(8, tree.treeArray[5]);
        assertEquals(12, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(9, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[13]);
        assertEquals(-1, tree.treeArray[14]);
        assertEquals(-1, tree.treeArray[25]);
        assertEquals(-1, tree.treeArray[26]);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 009
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove009() {
        ArrayTree tree = new ArrayTree();
        int[] data = {5,10,3,4,1,8,12,9};
        for(int v : data) {
            tree.add(v);
        }

        tree.remove(10);

        assertEquals(5, tree.treeArray[0]);
        assertEquals(3, tree.treeArray[1]);
        assertEquals(12, tree.treeArray[2]);
        assertEquals(1, tree.treeArray[3]);
        assertEquals(4, tree.treeArray[4]);
        assertEquals(8, tree.treeArray[5]);
        assertEquals(-1, tree.treeArray[6]);
        assertEquals(-1, tree.treeArray[7]);
        assertEquals(-1, tree.treeArray[8]);
        assertEquals(-1, tree.treeArray[9]);
        assertEquals(-1, tree.treeArray[10]);
        assertEquals(-1, tree.treeArray[11]);
        assertEquals(9, tree.treeArray[12]);
        assertEquals(-1, tree.treeArray[13]);
        assertEquals(-1, tree.treeArray[14]);
        assertEquals(-1, tree.treeArray[25]);
        assertEquals(-1, tree.treeArray[26]);
    }
}
