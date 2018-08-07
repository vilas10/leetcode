/*
https://leetcode.com/problems/lru-cache/description/
*/
public class LRUCache {
    
    private HashMap<Integer, ListNode> cache;
    ListNode lruHead;
    ListNode lruTail;
    int capacity;
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, ListNode>();
        lruHead = null;
        lruTail = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode temp = cache.get(key);
        
        if(temp == null) {
            return -1;
        } 
        
        moveUp(temp);
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        
        ListNode exist = cache.get(key);
        
        if(exist == null) {
            
            ListNode temp = new ListNode(key, value);
            
            if(cache.size() >= capacity) {
                cache.remove(lruTail.key);
                removeLRU();
            }
            
            insertNew(temp);
            cache.put(key, temp);
        } 
        else {
            
            if(exist.value != value) {
                exist.value = value;
                moveUp(exist);
            }
        }
    }
    
    private void insertNew(ListNode newnode) {
        if(lruHead == null) {
            lruHead = newnode;
            lruTail = newnode;
            return;
        }
        
        newnode.next = lruHead;
        lruHead.prev = newnode;
        lruHead = newnode;
    }
    
    private void moveUp(ListNode node) {
        if(node == lruHead) {
            return;
        }
        
        ListNode temp = node;
        node.prev.next = node.next;
        
        if(node != lruTail) {
            node.next.prev = node.prev;
        } else {
            lruTail = node.prev;
        }
        
        insertNew(node);
    }
    
    private void removeLRU() {
        if(lruHead == lruTail) {
            lruHead = null;
            lruTail = null;
            return;
        } 
        
        ListNode newtail = lruTail.prev;
        
        newtail.next = null;
        lruTail.prev = null;
        lruTail = newtail;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
