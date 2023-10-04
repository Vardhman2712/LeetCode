class MyHashMap {
    private static final int SIZE = 10000;
    private Node[] buckets;

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);

        // Check if the key already exists
        Node node = findNode(index, key);
        if (node == null) {
            // Key not found, insert a new node
            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
        } else {
            // Key found, update the value
            node.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        Node node = findNode(index, key);

        return (node != null) ? node.value : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    /** Hash function to map keys to an index */
    private int hash(int key) {
        return key % SIZE;
    }

    /** Helper method to find a node with the given key in a specific bucket */
    private Node findNode(int index, int key) {
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
