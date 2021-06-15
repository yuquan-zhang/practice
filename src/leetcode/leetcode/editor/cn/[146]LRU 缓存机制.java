package leetcode.leetcode.editor.cn;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1443 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, Node> data = null;
    private Node head;
    private Node tail;
    private final int cap;

    public LRUCache(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity is less than 1");
        data = new HashMap<>(capacity);
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = data.get(key);
        if (node != null) {
            if (node.equals(head) && node.equals(tail)) {
                // 什么都不用做
            } else if (node.equals(head)){
                head = node.next;
                head.pre = null;
                tail.next = node;
                node.pre = tail;
                tail = node;
            } else if (node.equals(tail)) {
                // 什么都不用做
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }
        return node == null ? -1 : node.getVal();
    }
    
    public void put(int key, int value) {
        Node node = data.get(key);
        if (node == null) {
            while (data.size() >= cap) {
                if (head == null) break;
                data.remove(head.getKey());
                if (head.equals(tail)) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.pre = null;
                }
            }
            node = new Node(key,value);
            if (head == null) {
                head = node;
            }
            if (tail != null) {
                tail.next = node;
                node.pre = tail;
            }
            tail = node;
            data.put(key,node);
        } else {
            if (node.equals(head) && node.equals(tail)) {
                // 什么都不用做
            } else if (node.equals(head)){
                head = node.next;
                head.pre = null;
                tail.next = node;
                node.pre = tail;
                tail = node;
            } else if (node.equals(tail)) {
                // 什么都不用做
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
            node.setVal(value);
        }
    }

    public static class Node {
        private final int key;
        private int val;
        private Node next;
        private Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
