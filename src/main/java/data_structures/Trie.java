package data_structures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private final Node root = new Node();

    void insert(String word) {
        insert( this.root, word, 0 );
    }

    private void insert(Node node, String word, int index) {

        if (index == word.length()) {
            node.isEnd = true;
            return;
        }

        node.children.putIfAbsent( word.charAt( index ), new Node( word.charAt( index ) ) );
        node = node.children.get( word.charAt( index ) );
        insert( node, word, ++index );
    }

    void print() {
        print( this.root, "" );
    }

    private void print(Node node, String prefix) {
        if (node.isEnd) {
            System.out.println( prefix.concat( String.valueOf( node.value ) ).replace( "null", "" ) );
        }
        for (var n : node.children.values()) {
            print( n, prefix.concat( String.valueOf( node.value ) ) );
        }
    }

    void contains(String word) {
        System.out.println( "Contains : " + word + " " + contains( this.root, word, 0 ) );
    }

    private boolean contains(Node node, String word, int index) {

        if (index == word.length()) return (node.isEnd);

        if (!node.children.containsKey( word.charAt( index ) )) {
            return false;
        } else {
            node = node.children.get( word.charAt( index ) );
        }

        return contains( node, word, ++index );
    }

    void remove(String word) {
        remove( this.root, word, 0 );
    }

    private void remove(Node node, String word, int index) {

        if (index == word.length()) {
            node.isEnd = false;
            return;
        }

        Node child = null;
        if (node.children.containsKey( word.charAt( index ) )) {
            child = node.children.get( word.charAt( index ) );
            remove( child, word, index + 1 );
        }

        if (child.children.size() == 0 && !child.isEnd) {
            node.children.remove( word.charAt( index ) );
        }
    }

    void autoComplete(String word) {
        autoComplete( root, word, 0 );
    }

    void getAutoCompleteSuggestions(Node n, String prefix) {
        if (n.isEnd) System.out.println( prefix.concat( String.valueOf( n.value ) ) );

        var newPrefix = prefix.concat( String.valueOf( n.value ) );

        for (var i : n.children.values()) {
            getAutoCompleteSuggestions( i, newPrefix );
        }
    }

    private void autoComplete(Node node, String word, int index) {

        if (index == word.length()) {
            for (var n : node.children.values()) {
                getAutoCompleteSuggestions( n, word );
            }
            return;
        }

        if (node.children.containsKey( word.charAt( index ) )) {
            autoComplete( node.children.get( word.charAt( index ) ), word, index + 1 );
        }
    }

    void countWords() {
        System.out.println( "No. of words: " + countWords( root, 0 ) );
    }

    private int countWords(Node node, int count) {

        if (node.isEnd) count++;

        for (var n : node.children.values()) {
            count = countWords( n, count );
        }
        return count;
    }

    public void longestCommonPrefix() {
        //   getCommonPrefix(root,"");
        System.out.println( "Common prefix : " + getCommonPrefix( root, "" ) );

    }

    private String getCommonPrefix(Node node, String prefix) {

        if (node.value != null) prefix = prefix + node.value;

        if (node.children.size() != 1 || node.isEnd) {
            return prefix;
        }

        Node node1 = node.children.values().toArray( new Node[0] )[0];
        return getCommonPrefix( node1, prefix );

    }

    static class Node {
        private final Map<Character, Node> children = new HashMap<>( 26 );
        private Character value;
        private boolean isEnd;

        public Node() {
        }

        public Node(char aChar) {
            this.value = aChar;
        }
    }
}
