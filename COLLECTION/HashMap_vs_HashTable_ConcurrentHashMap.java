/*
╔═════════╗
║ HashMap ║
╚═════════╝
- HashMap is non synchronized. It is not-thread safe and can't be shared between many threads without proper synchronization code.
- HashMap allows one null key and multiple null values.
- HashMap is a new class introduced in JDK 1.2.
- HashMap is fast.
- We can make the HashMap as synchronized by calling this code
- Map m = Collections.synchronizedMap(hashMap);
- HashMap is traversed by Iterator.
- Iterator in HashMap is fail-fast.
- HashMap inherits AbstractMap class.
╔═══════════╗
║ HashTable ║
╚═══════════╝
-Hashtable is synchronized. It is thread-safe and can be shared with many threads.
- Hashtable doesn't allow any null key or value.
- Hashtable is a legacy class.
- Hashtable is slow.
- Hashtable is internally synchronized and can't be unsynchronized.
- Hashtable is traversed by Enumerator and Iterator.
- Enumerator in Hashtable is not fail-fast.
- Hashtable inherits Dictionary class.

╔═══════════════════╗
║ concurrentHashMap ║
╚═══════════════════╝
concurrentHashMap is synchronized
concurrentHashMap is Thread-safe
It is fail-safe and performs iteration by multiple threads
It does not allow to store null key/values.


A sample Java program to demonstrate HashMap and HashTable 
*/
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Example 
{ 
    public static void main(String args[]) { 
        // HashTable  
        Hashtable<Integer,String> ht = new Hashtable<Integer,String>(); 
        ht.put(101,"One"); 
        ht.put(101,"Two"); 
        ht.put(102,"Three");  
        System.out.println("Hash Table Values"); 
        for (Map.Entry m:ht.entrySet()) { 
            System.out.println(m.getKey() + " " + m.getValue()); 
        } 
  
        // HashMap
        HashMap<Integer,String> hm = new HashMap<Integer,String>(); 
        hm.put(100,"Four"); 
        hm.put(104,"Four");  // hash map allows duplicate values 
        hm.put(101,"Five");
        System.out.println("Hash Map Values"); 
        for (Map.Entry m:hm.entrySet()) { 
            System.out.println(m.getKey() + " " + m.getValue()); 
        } 
    } 
} 


/*Output:

Hash Table Values
102 Three
101 One

Hash Map Values
100 Four
101 Five
104 Four
*/