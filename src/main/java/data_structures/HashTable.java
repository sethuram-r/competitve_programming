package data_structures;

import java.util.Collections;
import java.util.LinkedList;

public class HashTable {

  private final LinkedList<HashTable.Entry>[] arr;

  public HashTable() {
    this.arr = new LinkedList[3];
  }

  void put(int key, String value) {

    var hashKey = hash(key);
    var storedList = arr[hashKey];
    var entry = new Entry(key, value);
    if (storedList == null) {
      var ll = new LinkedList<>(Collections.singletonList(entry));
      arr[hashKey] = ll;
    } else {
      storedList.add(entry);
    }
  }

  String get(int key){
      var hashKey = hash(key);
      for (var entry : arr[hashKey]) {
          if(entry.key == key) return entry.value;
      }
      return null;
  }

    void remove(int key){
        var hashKey = hash(key);
        var ll = arr[hashKey];
        ll.removeIf( entry -> entry.key == key );
    }

  private int hash(int key) {
    return key % arr.length;
  }

  private static class Entry {
    int key;
    String value;

    public Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }
}
