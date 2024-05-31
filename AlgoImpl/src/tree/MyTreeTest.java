package tree;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class MyTreeTest extends MyTree {

	/**
	 * 対象:addメソッド
	 * ケースNo: 001
	 * 概要: データを1件挿入する
	 */
	@Test
	void testAdd001() {
		MyTree tree = new MyTree();
		tree.add(5);
		assertEquals(5, tree.root.data);
		assertTrue(tree.root.isLeaf());
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 002
	 * 概要: 5 → 10 の順にデータを挿入する
	 */
	@Test
	void testAdd002() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		assertEquals(5, tree.root.data);
		assertTrue(!tree.root.isLeaf());
		assertEquals(10, tree.root.right.data);
		assertTrue(tree.root.right.isLeaf());
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 003
	 * 概要: 10 → 5 の順にデータを挿入する
	 */
	@Test
	void testAdd003() {
		MyTree tree = new MyTree();
		tree.add(10);
		tree.add(5);
		assertEquals(10, tree.root.data);
		assertTrue(!tree.root.isLeaf());
		assertEquals(5, tree.root.left.data);
		assertTrue(tree.root.left.isLeaf());
	}

	/**
	 * 対象:addメソッド
	 * ケースNo: 004
	 * 概要: 5 → 10 → 3 → 4 → 1 → 8 → 12 → 9
	 *       の順にデータを挿入する
	 */
	@Test
	void testAdd004() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		TreeNode n5 = tree.root;
		TreeNode n3 = tree.root.left;
		TreeNode n1 = tree.root.left.left;
		TreeNode n4 = tree.root.left.right;
		TreeNode n10 = tree.root.right;
		TreeNode n8 = tree.root.right.left;
		TreeNode n9 = tree.root.right.left.right;
		TreeNode n12 = tree.root.right.right;

		assertEquals(5, n5.data);
		assertTrue(!n5.isLeaf());
		assertEquals(3, n3.data);
		assertTrue(!n3.isLeaf());
		assertEquals(1, n1.data);
		assertTrue(n1.isLeaf());
		assertEquals(4, n4.data);
		assertTrue(n4.isLeaf());
		assertEquals(10, n10.data);
		assertTrue(!n10.isLeaf());
		assertEquals(8, n8.data);
		assertTrue(!n8.isLeaf());
		assertEquals(9, n9.data);
		assertTrue(n9.isLeaf());
		assertEquals(12, n12.data);
		assertTrue(n12.isLeaf());
	}

	/**
	 * 対象:searchNodeメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでデータを探す
	 */
	@Test
	void testSearchNode001() {
		MyTree tree = new MyTree();
		TreeNode node = tree.searchNode(5);
		assertEquals(null, node);
	}

	/**
	 * 対象:searchNodeメソッド
	 * ケースNo: 002
	 * 概要: データ1件のツリーで存在するデータを探す
	 */
	@Test
	void testSearchNode002() {
		MyTree tree = new MyTree();
		tree.add(5);
		TreeNode node = tree.searchNode(5);
		assertEquals(5, node.data);
		assertEquals(tree.root, node);
	}

	/**
	 * 対象:searchNodeメソッド
	 * ケースNo: 003
	 * 概要: データ1件のツリーで存在しないデータを探す
	 */
	@Test
	void testSearchNode003() {
		MyTree tree = new MyTree();
		tree.add(5);
		TreeNode node = tree.searchNode(10);
		assertEquals(null, node);
	}

	/**
	 * 対象:searchNodeメソッド
	 * ケースNo: 004
	 * 概要: ツリーに存在するデータを探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testSearchNode004() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		TreeNode n5 = tree.root;
		TreeNode n3 = tree.root.left;
		TreeNode n1 = tree.root.left.left;
		TreeNode n4 = tree.root.left.right;
		TreeNode n10 = tree.root.right;
		TreeNode n8 = tree.root.right.left;
		TreeNode n9 = tree.root.right.left.right;
		TreeNode n12 = tree.root.right.right;

		int[] datas = {5,3,1,4,10,8,9,12};
		TreeNode[] nodes = {n5,n3,n1,n4,n10,n8,n9,n12};
		for(int i=0; i<datas.length; i++) {
			TreeNode node = tree.searchNode(datas[i]);
			assertEquals(datas[i], node.data);
			assertEquals(nodes[i], node);
		}
	}

	/**
	 * 対象:searchNodeメソッド
	 * ケースNo: 005
	 * 概要: ツリーに存在しないデータを探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testSearchNode005() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		int[] datas = {-1,6,7,100,11};
		for(int i=0; i<datas.length; i++) {
			TreeNode node = tree.searchNode(datas[i]);
			assertEquals(null, node);
		}
	}

	/**
	 * 対象:containsメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでデータを探す
	 */
	@Test
	void testContains001() {
		MyTree tree = new MyTree();
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
		MyTree tree = new MyTree();
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
		MyTree tree = new MyTree();
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
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

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
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		int[] datas = {-1,6,7,100,11};
		for(int i=0; i<datas.length; i++) {
			boolean b = tree.contains(datas[i]);
			assertTrue(!b);
		}
	}

	/**
	 * 対象:maxNodeメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでrootから最大値を探す
	 */
	@Test
	void testMaxNode001() {
		MyTree tree = new MyTree();
		TreeNode node = tree.maxNode(tree.root);
		assertEquals(null, node);
	}

	/**
	 * 対象:maxNodeメソッド
	 * ケースNo: 002
	 * 概要: データが1件のツリーでrootから最大値を探す
	 */
	@Test
	void testMaxNode002() {
		MyTree tree = new MyTree();
		tree.add(5);
		TreeNode node = tree.maxNode(tree.root);
		assertEquals(5, node.data);
		assertEquals(tree.root, node);
	}

	/**
	 * 対象:maxNodeメソッド
	 * ケースNo: 004
	 * 概要: ツリーに存在する各データを起点に最大値を探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testMaxNode003() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		TreeNode n5 = tree.root;
		TreeNode n3 = tree.root.left;
		TreeNode n1 = tree.root.left.left;
		TreeNode n4 = tree.root.left.right;
		TreeNode n10 = tree.root.right;
		TreeNode n8 = tree.root.right.left;
		TreeNode n9 = tree.root.right.left.right;
		TreeNode n12 = tree.root.right.right;

		TreeNode[] nodes = {n5,n3,n1,n4,n10,n8,n9,n12};
		TreeNode[] ansNode = {n12,n4,n1,n4,n12,n9,n9,n12};
		int[] ans = {12,4,1,4,12,9,9,12};
		for(int i=0; i<nodes.length; i++) {
			TreeNode node = tree.maxNode(nodes[i]);
			assertEquals(ans[i], node.data);
			assertEquals(ansNode[i], node);
		}
	}

	/**
	 * 対象:minNodeメソッド
	 * ケースNo: 001
	 * 概要: 空のツリーでrootから最小値を探す
	 */
	@Test
	void testMinNode001() {
		MyTree tree = new MyTree();
		TreeNode node = tree.minNode(tree.root);
		assertEquals(null, node);
	}

	/**
	 * 対象:minNodeメソッド
	 * ケースNo: 002
	 * 概要: データが1件のツリーでrootから最小値を探す
	 */
	@Test
	void testMinNode002() {
		MyTree tree = new MyTree();
		tree.add(5);
		TreeNode node = tree.minNode(tree.root);
		assertEquals(5, node.data);
		assertEquals(tree.root, node);
	}

	/**
	 * 対象:minNodeメソッド
	 * ケースNo: 004
	 * 概要: ツリーに存在する各データを起点に最小値を探す
	 *       ツリーの中身はtestAdd004と同じ
	 */
	@Test
	void testMinNode003() {
		MyTree tree = new MyTree();
		tree.add(5);
		tree.add(10);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(12);
		tree.add(9);

		TreeNode n5 = tree.root;
		TreeNode n3 = tree.root.left;
		TreeNode n1 = tree.root.left.left;
		TreeNode n4 = tree.root.left.right;
		TreeNode n10 = tree.root.right;
		TreeNode n8 = tree.root.right.left;
		TreeNode n9 = tree.root.right.left.right;
		TreeNode n12 = tree.root.right.right;

		TreeNode[] nodes = {n5,n3,n1,n4,n10,n8,n9,n12};
		TreeNode[] ansNode = {n1,n1,n1,n4,n8,n8,n9,n12};
		int[] ans = {1,1,1,4,8,8,9,12};
		for(int i=0; i<nodes.length; i++) {
			TreeNode node = tree.minNode(nodes[i]);
			assertEquals(ans[i], node.data);
			assertEquals(ansNode[i], node);
		}
	}

	/**
     * 対象:removeメソッド
     * ケースNo: 001
     * 概要: 空のツリーからデータを削除する
     */
    @Test
    void testRemove001() {
        MyTree tree = new MyTree();
        tree.remove(5);
        assertEquals(null, tree.root);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 002
     * 概要: データが1件のツリーから存在するデータを削除する
     */
    @Test
    void testRemove002() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.remove(5);
        assertEquals(null, tree.root);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 003
     * 概要: データが1件のツリーから存在しないデータを削除する
     */
    @Test
    void testRemove003() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.remove(10);
        assertEquals(5, tree.root.data);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 004
     * 概要: ツリーに存在する葉を削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove004() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(9);

        tree.remove(4);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trlr = tree.root.right.left.right;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,tl.right);

        TreeNode[] nodes = {t,tl,tll,tr,trl,trlr,trr};
        int[] ansNode = {5,3,1,10,8,9,12};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 005
     * 概要: ツリーに存在する右側のみ枝があるデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove005() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(9);

        tree.remove(8);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trlr = tree.root.right.left.right;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,trlr);

        TreeNode[] nodes = {t,tl,tll,tlr, tr,trl,trr};
        int[] ansNode = {5,3,1,4,10,9,12};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 006
     * 概要: ツリーに存在する左側のみ枝があるデータを削除する
     *       ツリーの中身はtestAdd004の9を6に修正したもの
     */
    @Test
    void testRemove006() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(6);

        tree.remove(8);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trll = tree.root.right.left.left;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,trll);

        TreeNode[] nodes = {t,tl,tll,tlr, tr,trl,trr};
        int[] ansNode = {5,3,1,4,10,6,12};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 007
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove007() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(9);

        tree.remove(5);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trlr = tree.root.right.left.right;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,trlr);

        TreeNode[] nodes = {t,tl,tll,tlr, tr,trl,trr};
        int[] ansNode = {8,3,1,4,10,9,12};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 008
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove008() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(9);

        tree.remove(3);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trlr = tree.root.right.left.right;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,tlr);

        TreeNode[] nodes = {t,tl,tll,tr,trl,trlr, trr};
        int[] ansNode = {5,4,1,10,8,9,12};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 009
     * 概要: ツリーに存在する2つ枝をもつデータを削除する
     *       ツリーの中身はtestAdd004と同じ
     */
    @Test
    void testRemove009() {
        MyTree tree = new MyTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(9);

        tree.remove(10);

        TreeNode t = tree.root;
        TreeNode tl = tree.root.left;
        TreeNode tll = tree.root.left.left;
        TreeNode tlr = tree.root.left.right;
        TreeNode tr = tree.root.right;
        TreeNode trl = tree.root.right.left;
        TreeNode trlr = tree.root.right.left.right;
        TreeNode trr = tree.root.right.right;

        assertEquals(null,trr);

        TreeNode[] nodes = {t,tl,tll,tlr,tr,trl,trlr};
        int[] ansNode = {5,3,1,4,12,8,9};
        for(int i=0; i<nodes.length; i++) {
            assertEquals(ansNode[i], nodes[i].data);
        }
    }
}
