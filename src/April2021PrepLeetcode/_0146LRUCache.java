package April2021PrepLeetcode;

import java.util.HashMap;

public class _0146LRUCache {

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1)); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1)); // return -1 (not found)
		System.out.println(lRUCache.get(3)); // return 3
		System.out.println(lRUCache.get(4)); // return 4

		lRUCache = new LRUCache(1);
		lRUCache.put(2, 1); // cache is {1=1}
		System.out.println(lRUCache.get(2)); // return 1 (found)
	}

	static class Node {
		Node prev, next;
		int key, value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static class LRUCache {
		int capacity;
		Node dummyHead, dummyTail;
		HashMap<Integer, Node> nodeMap;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
			nodeMap = new HashMap<Integer, Node>();
		}

		public void addNode(int key, int value) {
			Node newNode = new Node(key, value);
			Node prev = dummyHead;
			Node next = dummyHead.next;
			prev.next = newNode;
			newNode.next = next;
			next.prev = newNode;
			newNode.prev = prev;
			nodeMap.put(key, newNode);
		}

		public void deleteNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			nodeMap.remove(node.key);
		}

		public void moveNodeToHead(Node node) {
			deleteNode(node);
			addNode(node.key, node.value);
		}

		public int get(int key) {
			if (!nodeMap.containsKey(key))
				return -1;
			Node node = nodeMap.get(key);
			moveNodeToHead(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (nodeMap.containsKey(key)) {
				Node node = nodeMap.get(key);
				node.value = value;
				moveNodeToHead(node);
			} else {
				if (nodeMap.size() < capacity) {
					addNode(key, value);
				} else {
					deleteNode(dummyTail.prev);
					addNode(key, value);
				}
			}
		}
	}
}
