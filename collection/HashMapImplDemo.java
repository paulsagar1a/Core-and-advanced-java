package collection;

import java.util.ArrayList;
import java.util.List;

public class HashMapImplDemo<K, V> {

	protected static class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	private List<HashNode<K, V>> list;
	int capacity;
	int size;
	protected HashMapImplDemo() {
		 this.list = new ArrayList<>();
		 this.capacity = 10;
		 size = 0;
		 for(int i=0; i<capacity; i++) {
			 list.add(null);
		 }
	 }
	
	//size method
	public int size() {
		return this.size;
	}
	
	//put method
	public V put(K key, V value) {
		//get the index of the list
		int index = getIndex(key);
		HashNode<K, V> indexHead = list.get(index);
		if(indexHead == null) size++;
		//check if key already present in the bucket
		HashNode<K, V> temp = indexHead;
		while(temp != null) {
			if(temp.key.equals(key)) {
				temp.value = value;
				return value;
			}
			temp = temp.next;
		}
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = indexHead;
		list.set(index, newNode);
		
		//if load factory goes beyond threshold then double HashMap size
		if(size/capacity >= 0.7) {
			List<HashNode<K, V>> tempList = list;
			capacity = capacity*2;
			size = 0;
			for(int i=0; i<capacity; i++) {
				list.add(null);
			}
			for(HashNode<K, V> node : tempList) {
				while(node != null) {
					put(node.key, node.value);
					node = node.next;
				}
			}
		}
		return value;
	}
	
	//get method
	public V get(K key) {
		int index = getIndex(key);
		HashNode<K, V> indexHead = list.get(index);
		while(indexHead != null) {
			if(indexHead.key.equals(key)) {
				return indexHead.value;
			}
			indexHead = indexHead.next;
		}
		return null;
	}
	
	//delete method
	public V remove(K key) {
		int index = getIndex(key);
		HashNode<K, V> headIndex = list.get(index);
		HashNode<K, V> previous = null;
		while(headIndex != null) {
			if(headIndex.key.equals(key)) {
				break;
			}
			previous = headIndex;
			headIndex = headIndex.next;
		}
		if(previous == null) {
			list.set(index, null);
			size--;
			return null;
		} else {
			previous.next = headIndex.next;
			list.set(index, previous);
			return previous.value;
		}
	}
	
	//get list index for the bucket
	private int getIndex(K key) {
		int hash = key.hashCode();
		return hash % capacity;
	}
	
	@Override
	public String toString(){
		String str="";
		for(HashNode<K,V> hashNode: list){
			if(hashNode!=null){
				HashNode<K,V> temp = hashNode;
				while(temp!=null){
					str = str + "{K="+temp.key+", V="+temp.value+"}, ";
					temp = temp.next;
				}
			}
		}
		return "["+str+"]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapImplDemo<String, Integer> map = new HashMapImplDemo<>();
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		map.put("key4", 5);
		System.out.println(map.put("key4", 4));
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("key2"));
		map.remove("key3");
		System.out.println(map);
	}

}
