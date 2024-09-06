package map;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class MyHashMapTest extends MyHashMap {


    /**
     * 対象:putメソッド
     * ケースNo: 001
     * 概要: 空のHashMapにデータを1件追加する
     */
    @Test
    void testPut001() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);
        assertEquals(1, map.size);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(5, node.value);
        assertEquals(null, node.next);
    }

    /**
     * 対象:putメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapのデータを置き換える
     */
    @Test
    void testPut002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"abc" -> 54
        map.put("abc", 15);
        assertEquals(1, map.size);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(15, node.value);
        assertEquals(null, node.next);
    }

    /**
     * 対象:putメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapにデータを追加する(衝突なし)
     */
    @Test
    void testPut003() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xyz" -> 93
        map.put("xyz", 15);
        assertEquals(2, map.size);
        HashNode node = map.hashTable[93];
        assertEquals("xyz", node.key);
        assertEquals(15, node.value);
        assertEquals(null, node.next);
    }

    /**
     * 対象:putメソッド
     * ケースNo: 004
     * 概要: サイズ1のHashMapにデータを追加する(衝突あり)
     */
    @Test
    void testPut004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);
        assertEquals(2, map.size);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(5, node.value);
        assertEquals("xtn0", node.next.key);
        assertEquals(15, node.next.value);
        assertEquals(null, node.next.next);
    }


	/**
	 * 対象:getメソッド
	 * ケースNo: 001
	 * 概要: 空のHashMapからデータを取得する
	 */
	@Test
	void testGet001() {
		MyHashMap map = new MyHashMap();
		int result = map.get("abc");
		assertEquals(-1, result);
	}

	/**
     * 対象:getメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapから存在するKeyのデータを取得する
     */
    @Test
    void testGet002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        int result = map.get("abc");
        assertEquals(5, result);
    }

    /**
     * 対象:getメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapから存在しないKeyのデータを取得する
     */
    @Test
    void testGet003() {
        MyHashMap map = new MyHashMap();
     // key:"abc" -> 54
        map.put("abc", 5);

        int result = map.get("xyz");
        assertEquals(-1, result);
    }

    /**
     * 対象:getメソッド
     * ケースNo: 004
     * 概要: サイズ1のHashMapから存在するKeyのデータを取得する
     * (衝突後のデータ)
     */
    @Test
    void testGet004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        int result = map.get("xtz00");
        assertEquals(-1, result);
    }

    /**
     * 対象:containsKeyメソッド
     * ケースNo: 001
     * 概要: 空のHashMapからキーの存在を確認する
     */
    @Test
    void testContainsKey001() {
        MyHashMap map = new MyHashMap();
        boolean result = map.containsKey("abc");
        assertEquals(false, result);
    }

    /**
     * 対象:containsKeyメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapから存在するキーの存在を確認する
     */
    @Test
    void testContainsKey002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        boolean result = map.containsKey("abc");
        assertEquals(true, result);
    }

    /**
     * 対象:containsKeyメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapから存在しないキーの存在を確認する
     */
    @Test
    void testContainsKey003() {
        MyHashMap map = new MyHashMap();
     // key:"abc" -> 54
        map.put("abc", 5);

        boolean result = map.containsKey("xyz");
        assertEquals(false, result);
    }

    /**
     * 対象:containsKeyメソッド
     * ケースNo: 004
     * 概要: サイズ2のHashMapから存在しないキーの存在を確認する
     * (衝突後のデータ)
     */
    @Test
    void testContainsKey004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        boolean result = map.containsKey("xtz00");
        assertEquals(false, result);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 001
     * 概要: 空のHashMapでreplaceを実行する
     */
    @Test
    void testReplace001() {
        MyHashMap map = new MyHashMap();
        boolean result = map.replace("abc", 5, 10);
        assertEquals(false, result);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapでReplaceを実行する(Key:あり、oldVal:あり)
     */
    @Test
    void testReplace002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        boolean result = map.replace("abc", 5, 15);
        assertEquals(true, result);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(15, node.value);
        assertEquals(1, map.size);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapでReplaceを実行する(Key:なし)
     */
    @Test
    void testReplace003() {
        MyHashMap map = new MyHashMap();
     // key:"abc" -> 54
        map.put("abc", 5);

        boolean result = map.replace("xyz", 5, 15);
        assertEquals(false, result);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 004
     * 概要: サイズ1のHashMapでReplaceを実行する(Key:あり、oldVal:なし)
     */
    @Test
    void testReplace004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        boolean result = map.replace("abc", 6, 15);
        assertEquals(false, result);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(5, node.value);
        assertEquals(1, map.size);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 005
     * 概要: サイズ2のHashMapでReplaceを実行する(Key:あり、oldVal:あり)
     * (衝突後のデータ)
     */
    @Test
    void testReplace005() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        boolean result = map.replace("xtn0", 15, 20);
        assertEquals(true, result);
        HashNode node = map.hashTable[54].next;
        assertEquals("xtn0", node.key);
        assertEquals(20, node.value);
        assertEquals(2, map.size);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 006
     * 概要: サイズ2のHashMapでReplaceを実行する(Key:なし)
     * (衝突後のデータ)
     */
    @Test
    void testReplace006() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        boolean result = map.replace("xyz", 15, 20);
        assertEquals(false, result);
        HashNode node = map.hashTable[54].next;
        assertEquals("xtn0", node.key);
        assertEquals(15, node.value);
        assertEquals(2, map.size);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 007
     * 概要: サイズ2のHashMapでReplaceを実行する(Key:あり、oldVal:なし)
     * (衝突後のデータ)
     */
    @Test
    void testReplace007() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        boolean result = map.replace("xtn0", 16, 20);
        assertEquals(false, result);
        HashNode node = map.hashTable[54].next;
        assertEquals("xtn0", node.key);
        assertEquals(15, node.value);
        assertEquals(2, map.size);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 001
     * 概要: 空のHashMapでremoveを実行する
     */
    @Test
    void testRemove001() {
        MyHashMap map = new MyHashMap();
        int result = map.remove("abc");
        assertEquals(-1, result);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapでremoveを実行する(Key:あり)
     */
    @Test
    void testRemove002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        int result = map.remove("abc");
        assertEquals(5, result);
        HashNode node = map.hashTable[54];
        assertEquals(null, node);
        assertEquals(0, map.size);
    }

    /**
     * 対象:replaceメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapでremoveを実行する(Key:なし)
     */
    @Test
    void testRemove003() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        int result = map.remove("xyz");
        assertEquals(-1, result);
        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals(5, node.value);
        assertEquals(1, map.size);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 004
     * 概要: サイズ3のHashMapでremoveを実行する(チェインの1番目)
     * (衝突後のデータ)
     */
    @Test
    void testRemove004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        map.put("xtz00", 20);

        int result = map.remove("abc");
        assertEquals(5, result);

        HashNode node = map.hashTable[54];
        assertEquals("xtn0", node.key);
        assertEquals("xtz00", node.next.key);
        assertEquals(2, map.size);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 005
     * 概要: サイズ3のHashMapでremoveを実行する(チェインの2番目)
     * (衝突後のデータ)
     */
    @Test
    void testRemove005() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        map.put("xtz00", 20);

        int result = map.remove("xtn0");
        assertEquals(15, result);

        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals("xtz00", node.next.key);
        assertEquals(2, map.size);
    }

    /**
     * 対象:removeメソッド
     * ケースNo: 006
     * 概要: サイズ3のHashMapでremoveを実行する(チェインの3番目)
     * (衝突後のデータ)
     */
    @Test
    void testRemove006() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        map.put("xtz00", 20);

        int result = map.remove("xtz00");
        assertEquals(20, result);

        HashNode node = map.hashTable[54];
        assertEquals("abc", node.key);
        assertEquals("xtn0", node.next.key);
        assertEquals(2, map.size);
    }

    /**
     * 対象:clearメソッド
     * ケースNo: 001
     * 概要: 空のHashMapでclearを実行する
     */
    @Test
    void testClear001() {
        MyHashMap map = new MyHashMap();
        map.clear();
        assertEquals(0, map.size);
        for(int i=0; i<map.hashTable.length; i++) {
            assertEquals(null, map.hashTable[i]);
        }
    }

    /**
     * 対象:clearメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapでclearを実行する
     */
    @Test
    void testClear002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        map.clear();
        assertEquals(0, map.size);
        for(int i=0; i<map.hashTable.length; i++) {
            assertEquals(null, map.hashTable[i]);
        }
    }

    /**
     * 対象:clearメソッド
     * ケースNo: 003
     * 概要: サイズ2のHashMapでclearを実行する(衝突無し)
     */
    @Test
    void testClear003() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xyz" -> 93
        map.put("xyz", 15);

        map.clear();
        assertEquals(0, map.size);
        for(int i=0; i<map.hashTable.length; i++) {
            assertEquals(null, map.hashTable[i]);
        }
    }

    /**
     * 対象:clearメソッド
     * ケースNo: 004
     * 概要: サイズ2のHashMapでclearを実行する(衝突あり)
     */
    @Test
    void testClear004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        map.clear();
        assertEquals(0, map.size);
        for(int i=0; i<map.hashTable.length; i++) {
            assertEquals(null, map.hashTable[i]);
        }
    }

    /**
     * 対象:isEmptyメソッド
     * ケースNo: 001
     * 概要: サイズ2のHashMapでisEmptyを実行する(衝突あり)
     */
    @Test
    void testIsEmpty001() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        assertEquals(false, map.isEmpty());
    }

    /**
     * 対象:isEmptyメソッド
     * ケースNo: 002
     * 概要: サイズ0のHashMapでisEmptyを実行する
     */
    @Test
    void testIsEmpty002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);
        map.remove("abc");
        map.remove("xtn0");

        assertEquals(true, map.isEmpty());
    }

    /**
     * 対象:sizeメソッド
     * ケースNo: 001
     * 概要: サイズ2のHashMapでsizeを実行する(衝突あり)
     */
    @Test
    void testSize001() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        assertEquals(2, map.size());
    }

    /**
     * 対象:sizeメソッド
     * ケースNo: 002
     * 概要: サイズ0のHashMapでsizeを実行する
     */
    @Test
    void testSize002() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);
        map.remove("abc");
        map.remove("xtn0");

        assertEquals(0, map.size());
    }

    /**
     * 対象:containsValueメソッド
     * ケースNo: 001
     * 概要: 空のHashMapでcontainsValueを実行する
     */
    @Test
    void testContainsValue001() {
        MyHashMap map = new MyHashMap();
        assertEquals(false, map.containsValue(5));
    }

    /**
     * 対象:containsValueメソッド
     * ケースNo: 002
     * 概要: サイズ1のHashMapでcontainsValueを実行する(存在する値)
     */
    @Test
    void testContainsValue002() {
        MyHashMap map = new MyHashMap();
     // key:"abc" -> 54
        map.put("abc", 5);
        assertEquals(true, map.containsValue(5));
    }

    /**
     * 対象:containsValueメソッド
     * ケースNo: 003
     * 概要: サイズ1のHashMapでcontainsValueを実行する(存在しない値)
     */
    @Test
    void testContainsValue003() {
        MyHashMap map = new MyHashMap();
     // key:"abc" -> 54
        map.put("abc", 5);
        assertEquals(false, map.containsValue(15));
    }

    /**
     * 対象:containsValueメソッド
     * ケースNo: 004
     * 概要: サイズ3のHashMapでcontainsValueを実行する(存在する値)
     */
    @Test
    void testContainsValue004() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        // key:"xtz00" -> 54
        map.put("xyz", 15);
        assertEquals(true, map.containsValue(15));
    }

    /**
     * 対象:containsValueメソッド
     * ケースNo: 005
     * 概要: サイズ3のHashMapでcontainsValueを実行する(存在しない値)
     */
    @Test
    void testContainsValue005() {
        MyHashMap map = new MyHashMap();
        // key:"abc" -> 54
        map.put("abc", 5);

        // key:"xtn0" -> 54
        map.put("xtn0", 15);

        map.put("xyz", 20);
        assertEquals(false, map.containsValue(16));
    }
}
