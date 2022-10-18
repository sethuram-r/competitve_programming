package data_structures;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    //
    //
    //    SethuArray  array = new SethuArray( 3 );
    //    array.insert(10);
    //    array.insert(20);
    //    array.insert(30);
    //    array.insert(40);
    //
    ////    array.removeAt( 3);
    ////
    ////    System.out.println("Max : " + array.max());
    ////
    ////    array.print();
    ////
    ////    System.out.println("Intersect ");
    ////    array.intersect( 20,30,40,50 );
    ////
    ////    System.out.println("Reverse ");
    ////
    ////    array.reverse();
    //
    //    array.insertAt( 50,2 );
    //    array.swap( 0,3 );
    //    array.print();

    //   var sentence = "thequickbrownfoxjumpsoverthelazydog";
    //    final int size = sentence.chars().mapToObj( i->(char)i )
    //            .collect( Collectors.toUnmodifiableSet() )
    //            .size();

    //    System.out.println(size);

    //    LinkedList  linkedList = new LinkedList();
    //    linkedList.addFirst( 10 );
    //
    //      System.out.println(linkedList.size);
    //      linkedList.print();
    //      linkedList.addFirst( 20 );
    //      System.out.println(linkedList.size);
    //
    //      linkedList.addFirst( 30 );
    //      linkedList.addFirst( 40 );
    //      linkedList.addFirst( 50 );
    //
    //      linkedList.print();
    //
    //      linkedList.addLast( 200 );
    //      System.out.println(linkedList.size);
    //      linkedList.print();

    //      linkedList.addLast( 300 );
    //      System.out.println(linkedList.size);
    //      linkedList.print();
    //
    //      linkedList.deleteFirst();
    //      System.out.println(linkedList.size);
    //      linkedList.print();
    //
    //      linkedList.deleteFirst();
    //      System.out.println(linkedList.size);
    //      linkedList.print();
    //
    //      linkedList.deleteLast();
    //      System.out.println(linkedList.size);
    //      linkedList.print();
    //
    //      linkedList.deleteLast();
    //      System.out.println(linkedList.size);
    //      linkedList.print();

    //    System.out.println(linkedList.contains( 30 ));
    //    System.out.println(linkedList.contains( 300));
    //
    //      System.out.println(linkedList.indexOf( 10 ));
    //      System.out.println(linkedList.indexOf( 300));

    //      linkedList.reverse();
    //      linkedList.print();
    //
    //    System.out.println(linkedList.getKthNodeFromEnd(1));
    //    System.out.println(linkedList.getKthNodeFromEnd(6));
    //    System.out.println(linkedList.getKFromEnd(1));
    //    System.out.println(linkedList.getKFromEnd(6));
    //
    //    System.out.println(linkedList.getMiddle());

    //    var list = LinkedList.createWithLoop();
    //    System.out.println(list.hasLoop());

    //    StringAnalyzer stringAnalyzer = new StringAnalyzer();
    //    System.out.println(stringAnalyzer.reverse( "sethu" ));
    //    System.out.println(stringAnalyzer.isBalanced( "(1+2>" ));

    //    SethuStack sethuStack = new SethuStack();
    //    sethuStack.push( 1 );
    //    sethuStack.push( 2 );
    //    sethuStack.push( 3 );
    //    sethuStack.push( 4 );
    //    sethuStack.push( 5 );
    //
    //    sethuStack.print();
    //
    //    System.out.println( sethuStack.peek(  ));
    //    System.out.println( sethuStack.pop(  ));
    //    System.out.println( sethuStack.isEmpty());
    //
    //    sethuStack.push( 2 );
    //    sethuStack.push( 3 );
    //    sethuStack.push( 4 );
    //    sethuStack.push( 5 );
    //    sethuStack.push( 6 );
    //    sethuStack.push( 7 );
    //
    //    sethuStack.print();
    //    System.out.println( sethuStack.pop(  ));
    //    sethuStack.print();
    //    System.out.println( sethuStack.pop(  ));
    //    System.out.println( sethuStack.pop(  ));
    //    sethuStack.print();
    //    System.out.println( sethuStack.pop(  ));

    //    MinStack minStack = new MinStack();
    //
    //    minStack.push( 7 );
    //    minStack.push( 8 );
    //    minStack.push( 1);
    //
    //    System.out.println(minStack.min());
    //    minStack.pop( );
    //    System.out.println(minStack.min());

    //    var queue = new ArrayDeque<Integer>();
    //    queue.add( 1 );
    //    queue.add( 2 );
    //    queue.add( 3 );
    //    queue.add( 4 );
    //    queue.add( 5 );
    //    queue.add( 6 );
    //
    //    System.out.println(reverse( queue ));

    //    ArrayQueue queue = new ArrayQueue(  );
    //     queue.enqueue( 1 );
    //    queue.enqueue( 2 );
    //    queue.enqueue( 3 );
    //
    //
    //    System.out.println(queue.dequeue());
    //    System.out.println(queue.dequeue());
    //    System.out.println(queue.dequeue());
    //
    //    queue.enqueue( 4 );
    //   System.out.println(queue.dequeue());

    //   QueueWithStacks queueWithStacks = new QueueWithStacks();
    //   queueWithStacks.enqueue( 5 );
    //    System.out.println(queueWithStacks.dequeue());
    //    queueWithStacks.enqueue( 6 );
    //    queueWithStacks.enqueue( 7 );
    //    queueWithStacks.enqueue( 8 );
    //    queueWithStacks.enqueue( 9 );
    //    System.out.println(queueWithStacks.dequeue());
    //    System.out.println(queueWithStacks.dequeue());
    //    System.out.println(queueWithStacks.dequeue());
    //    System.out.println(queueWithStacks.dequeue());
    //    System.out.println(queueWithStacks.dequeue());

    //
    //      PriorityQueue queue = new PriorityQueue();
    //      queue.enqueue( 5 );
    //      queue.enqueue( 4 );
    //      queue.enqueue( 3 );
    //      queue.enqueue( 2 );
    //      queue.enqueue( 1 );
    //      queue.enqueue( 6 );
    //      queue.enqueue( 7 );
    //      queue.enqueue( 0 );
    //
    //    System.out.println(queue.dequeue());
    //    System.out.println(queue.dequeue());
    //    System.out.println(queue.dequeue());
    //    System.out.println(queue.dequeue());
    //
    //      queue.enqueue( 3 );
    //
    //    queue.print();

    //      ArrayQueue queue = new ArrayQueue();
    //      queue.enqueue( 10 );
    //      queue.enqueue( 20 );
    //      queue.enqueue( 30 );
    //      queue.enqueue( 40 );
    //      queue.enqueue( 50 );
    // QueueReverser  queueReverser = new QueueReverser(queue  );
    //      queueReverser.reverse( 5 ).print();

    //      StackWithTwoQueue stackWithTwoQueue = new StackWithTwoQueue();
    //      stackWithTwoQueue.push( 10 );
    //      stackWithTwoQueue.push( 20 );
    //      stackWithTwoQueue.push( 30 );
    //      stackWithTwoQueue.push( 40 );
    //      stackWithTwoQueue.push( 50 );
    //
    //    System.out.println(   stackWithTwoQueue.pop());
    //    System.out.println(   stackWithTwoQueue.pop());
    //    System.out.println(   stackWithTwoQueue.pop());
    //    System.out.println(   stackWithTwoQueue.pop());
    //    System.out.println(   stackWithTwoQueue.pop());

    //    String test = "green apple";
    //
    //    Map<Character, Integer> map = new LinkedHashMap<>();
    //
    //    for (Character c : test.toCharArray()) {
    //
    //      map.putIfAbsent(c, 0);
    //      map.computeIfPresent(c, (character, integer) -> integer + 1);
    //    }
    //
    //    for (var i : map.entrySet()) {
    //      if (i.getValue() == 1) {
    //        System.out.println("first non  repeated character : " + i.getKey());
    //        break;
    //      }
    //    }
    //
    //      for (var i : map.entrySet()) {
    //          if (i.getValue() > 1) {
    //              System.out.println("first repeated character : " + i.getKey());
    //              break;
    //          }
    //      }
    //
    //    System.out.println(map);

    //    HashTable hashTable = new HashTable();
    //    hashTable.put( 1,"sethu" );
    //    hashTable.put( 2,"ram" );
    //    hashTable.put( 3,"reddy" );
    //    hashTable.put( 4,"john" );
    //    System.out.println( hashTable.get( 1 ));
    //    System.out.println( hashTable.get( 2 ));
    //    System.out.println( hashTable.get( 3 ));
    //    System.out.println( hashTable.get( 4 ));
    //    System.out.println( hashTable.get( 1 ));
    //
    //    hashTable.remove( 1 );
    //    System.out.println( hashTable.get( 1 ));
    //
    //    Map<Integer,Integer> numsMap = new HashMap<>();
    //    int[] nums = {1, 2, 2, 3, 3, 3, 4};
    //    for (var num : nums) {
    //      numsMap.putIfAbsent( num,0 );
    //      numsMap.computeIfPresent( num, (k, v) -> v+1 );
    //    }
    //
    //    int key = 0;
    //    int max = 0;
    //    for (var num : numsMap.entrySet()) {
    //      if(num.getValue() > max) {
    //        max = num.getValue();
    //        key = num.getKey();
    //      }
    //    }
    //    System.out.println("Max occurance "+key);
    // int[] arr = {1, 7, 5, 9, 2, 12, 3};
    // int k =2;
    //    System.out.println(uniquePairs( k,arr ));
    //  }
    //
    //  private static int uniquePairs(int k, int[] arr){
    // int count = 0;
    //    Set<Integer> set = new HashSet<>();
    //    for (var i  : arr) {
    //        set.add( i );
    //    }
    //
    //    for (var j : set) {
    //
    //      var x= j-k;
    //      if(set.contains( x )){
    //        count++;
    //      }
    //
    //    }
    //    return count;
    //  }

    //    private static Queue<Integer> reverse(Queue<Integer> queue){
    //    var stack = new Stack<Integer>();
    //    while(!queue.isEmpty()){
    //      stack.push( queue.remove() );
    //    }
    //    while(!stack.isEmpty()){
    //      queue.add( stack.pop() );
    //    }
    //    return queue;
    //  }10, 5, 15, 6, 1, 8, 12, 18, 17


//    LinkedList  linkedList = new LinkedList();
//    linkedList.addLast( 10 );
//    linkedList.addLast( 20 );
//    linkedList.addLast( 30 );
//    linkedList.addLast( 40 );
//    linkedList.addLast( 50 );
//    linkedList.addLast( 60 );
//    linkedList.addLast( 70 );
//    linkedList.addLast( 80 );
//    //
//    //    System.out.println(linkedList.getkfromlast( 1 ));
//    //    System.out.println(linkedList.getkfromlast( 3 ));
//    //    System.out.println(linkedList.getkfromlast( 5 ));
//
//    System.out.println( Arrays.toString(  linkedList.getmiddle()));
//
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(10);
    tree.insert(22);
    tree.insert(21);
    tree.insert(23);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);
    tree.insert(14);
//    tree.insert( 15);


    tree.print();

    Tree subTree = new Tree();
    subTree.insert( 10 );
    subTree.insert( 5 );
    subTree.insert( 1 );
    subTree.insert( 4);
    subTree.insert( 11);
//    subTree.insert( 15);
    System.out.println("======================xxx=====================");
    subTree.print();

    tree.checkSubTree( subTree );


//    tree.getCommonAncestor(5,13);


    //tree.levelOrderTraversal();
//    tree.listOfDepths();
//    tree.isBalanced();

//    tree.print();
//
//    tree.next(10);
//
//    Tree tree2 = new Tree();
//    tree2.insert(20);
//    tree2.insert(10);
//    tree2.insert(22);
//    tree2.insert(3);
//    tree2.insert(11);
//    tree2.insert(24);
//    tree2.insert(21);
//    tree2.insert(2);

    //    System.out.println(tree.find( 5 ));
    //    System.out.println(tree.find( 57 ));
    //    System.out.println(tree.find( 17 ));
    //    System.out.println(tree.find( 1 ));

    // tree.traversePreOrder();
    // tree.traverseInOrder();
    // tree.traversePostOrder();

//     tree.height();
    // tree.min();

  // tree.equals( tree2 );

  // tree.validate();

   //tree.getNodesK( 0 );

   // tree.levelOrderTraversal();

   // tree.size();
   // tree.countLeaves();

   // tree.max();

   // tree.contains( 50 );

   // tree.siblings( 3,8 );

//    tree.getAncestors( 3 );

//    AvlTree  tree = new AvlTree();
//    tree.insert( 10 );
//    tree.insert( 20 );
//    tree.insert( 15 );
//  //  tree.insert( 30 );
//
//
//    tree.print();
//    tree.height();
//    tree.bf();
//
//    tree.isBalanced();
//    tree.isPerfect();
//15, 10, 3, 8, 12, 9, 4, 1, 24
//    Heap heap = new Heap();
    //    heap.insert( 15 );
    //    heap.insert( 10 );
    //    heap.insert( 3 );
    //    heap.insert( 8 );
    //    heap.insert( 12 );
    //    heap.insert( 9 );
    //    heap.insert( 4 );
    //    heap.insert( 1 );
    //    heap.insert( 24 );
    //
    //    heap.print();
    //    System.out.println("Removed :"+ heap.remove(  ));
    //    heap.print();
    //    System.out.println("Removed :"+ heap.remove(  ));
    //    heap.print();

//    int[] arr = new int[] {5,3,8,4,1,2};
//    System.out.println(Arrays.toString(heap.heapify( arr )  ));




   // heap.insert( 24 );

//    Trie  trie = new Trie();
//    trie.insert( "boy" );
//    trie.insert( "book" );
//    trie.insert( "border" );
//    trie.insert( "fine" );
//    trie.insert( "finest" );
//    trie.insert( "finger" );
//    trie.insert( "canada" );
//    trie.insert( "can" );

  //  trie.print();

//    trie.contains( "book" );
//
//    trie.remove( "book"  );
//
//    trie.contains( "book" );
//    trie.print();

   // trie.autoComplete( "fin" );
//    trie.countWords();

//    String[] test = new String[]{"car", "care"};
//    for (var s : test) {
//      trie.insert( s );
//    }
//
//    trie.print();
//    trie.longestCommonPrefix();

//    Graph graph = new Graph();
//
//    graph.addNode( "A" );
//    graph.addNode( "B" );
//    graph.addNode( "C" );
//    graph.addNode( "D" );
//    graph.addNode( "E" );
//    graph.addNode( "F" );
//
//    graph.addEdge( "D","A" );
//    graph.addEdge( "B","F" );
//    graph.addEdge( "D","B" );
//    graph.addEdge( "A","F" );
//    graph.addEdge( "C","D" );
//
//    graph.print();
//
//    graph.buildfirst();
//
//    graph.hasRoute( "A","D" );
//    graph.hasRoute( "A","E" );
//    graph.hasRoute( "C","D" );

//    graph.removeNode( "B" );
//
//    graph.print();
//
//    graph.removeEdge( "C","D" );
//
//    graph.print();
//
//    graph.addNode( "E");
//    graph.addEdge( "E","D" );
//    graph.addEdge( "A","E" );
//
//    graph.print();
//
//    graph.depthFirstRec();
//    graph.depthFirst();
//    graph.breadthFirst();

//    graph.addNode( "X" );
//    graph.addNode( "A" );
//    graph.addNode( "B" );
//    graph.addNode( "P" );
//
//    graph.addEdge( "X","A" );
//    graph.addEdge( "X","B" );
//    graph.addEdge( "A","P" );
//    graph.addEdge( "B","P" );
//
//    graph.print();
//
//    graph.topologicalSort();

//    graph.addNode( "A" );
//    graph.addNode( "B" );
//    graph.addNode( "C" );
//    graph.addNode( "D" );
//
//    graph.addEdge( "A","B" );
//    graph.addEdge( "B","C" );
//    graph.addEdge( "A","C" );
//    graph.addEdge( "D","A" );
//
//    graph.print();
//
//    graph.hasCycle();

//    WeightedGraph  weightedGraph = new WeightedGraph();
//    weightedGraph.addNode( "A" );
//    weightedGraph.addNode( "B" );
//    weightedGraph.addNode( "C" );
//    weightedGraph.addNode( "D" );
//    weightedGraph.addNode( "E" );
//
//    weightedGraph.addEdge( "A","B",3 );
//    weightedGraph.addEdge( "A","D",2 );
//    weightedGraph.addEdge( "A","C",4 );
//    weightedGraph.addEdge( "B","E",1 );
//    weightedGraph.addEdge( "B","D",6 );
//    weightedGraph.addEdge( "D","E",5 );
//    weightedGraph.addEdge( "C","D",1 );
//
//    weightedGraph.print();
//
//    weightedGraph.getShortestPath("E");
   // weightedGraph.getShortestPath("D");

//    weightedGraph.addEdge( "A","B",0 );
//    weightedGraph.addEdge( "A","C",0 );
//    weightedGraph.addEdge( "B","C",0 );
//
//    weightedGraph.hasCycle();


//    WeightedGraph  weightedGraph = new WeightedGraph();
//    weightedGraph.addNode( "A" );
//    weightedGraph.addNode( "B" );
//    weightedGraph.addNode( "C" );
//    weightedGraph.addNode( "D" );
//    weightedGraph.addNode( "E" );
//    weightedGraph.addNode( "F" );
//
//    weightedGraph.addEdge( "A","B",7 );
//    weightedGraph.addEdge( "A","C",8 );
//    weightedGraph.addEdge( "B","C",3 );
//    weightedGraph.addEdge( "B","D",6 );
//    weightedGraph.addEdge( "C","D",4 );
//    weightedGraph.addEdge( "C","E",3 );
//    weightedGraph.addEdge( "D","E",2 );
//    weightedGraph.addEdge( "D","F",5 );
//    weightedGraph.addEdge( "F","E",2 );
//
//    weightedGraph.getMinimumSpanningTree();

//    BubbleSort  bubbleSort = new BubbleSort();
//
//    bubbleSort.sort( 9,7,8,4,3,10 );
//
//    SelectionSort  selectionSort = new SelectionSort();
//    selectionSort.sort( 9,7,8,4,3,10 );
//
//    InsertionSort  insertionSort = new InsertionSort();
//    insertionSort.sort( 9,7,8,4,3,10 );
//
//    MergeSort   mergeSort = new MergeSort();
//    System.out.println(Arrays.toString( mergeSort.sort( 11,9,7,8,4,3,10 )));
//
//
//    QuickSort   quickSort = new QuickSort();
//    quickSort.sort( 4,6,1,9 );
//
//    CountingSort   countingSort = new CountingSort();
//    countingSort.sort( 8,7,6,5,5 );
//
//    Bucketsort   bucketsort = new Bucketsort();
//    bucketsort.sort( 9,7,8,4,3,10 );

//    Search search = new Search();
  //  System.out.println(search.linear( 50 ));
   // search.binary( 7);
//    search.ternary( 70);

//    StringManipulation.findNumberOfVowels( "hello" );
//    StringManipulation.reverse( "hello" );
//    StringManipulation.reverseWords( "Trees are beautiful" );
//    System.out.println("Matches " + StringManipulation.rotateWords( "ABCD","CDAB" ) );
//
//    StringManipulation.removeDuplicates( "Hellooo!!" );
//    StringManipulation.capitalizeFirstLetter( "  trees    are        beautiful  " );
//    StringManipulation.mostRepeatedCharacter( "Hellooo!!" );
//    StringManipulation.anagram( "abcd" ,"adbc");
//    StringManipulation.anagram( "abcd" ,"cadb");
//    StringManipulation.anagram( "abcd" ,"abcd");
//    StringManipulation.anagram( "abcd" ,"abce");
//    StringManipulation.palindrome( "abba");
//    StringManipulation.palindrome( "abcba");
//    StringManipulation.palindrome( "abca");
  }
}
