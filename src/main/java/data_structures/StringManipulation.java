package data_structures;

import java.util.*;
import java.util.PriorityQueue;

public class StringManipulation {

  static void findNumberOfVowels(String s) {
    int count = 0;
    var vowels = Set.of('a', 'e', 'i', 'o', 'u');
    for (var l : s.toLowerCase().toCharArray()) {
      if (vowels.contains(l)) {
        count++;
      }
    }
    System.out.println("Number of vowels " + count);
  }

  static void reverse(String s) {

    StringBuilder builder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      builder.append(s.charAt(i));
    }
    System.out.println("Reverse " + builder);
  }

  static void reverseWords(String s) {

    var split = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (int i = split.length - 1; i >= 0; i--) {
      builder.append(split[i]);
      builder.append(" ");
    }
    System.out.println("Reverse words " + builder);
  }

  static boolean rotateWords(String s, String rotated) {

    String previous = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      var temp = String.valueOf(s.charAt(i)).concat(previous).concat(s.substring(0, i));
      System.out.println(temp);
      if (Objects.equals(temp, rotated)) return true;
      previous = String.valueOf(s.charAt(i)).concat( previous);
    }
    return false;
  }

  static void removeDuplicates(String s) {
    var set = new LinkedHashSet<String>();
    for (var c : s.toCharArray()) {
        set.add( String.valueOf(  c) );
    }
    System.out.println("Removed Duplicates " + String.join( "", set ));
  }

  static void capitalizeFirstLetter(String s) {
    var set = s.trim().split( "\\s+" );
    StringBuilder builder = new StringBuilder();
    for (var w : set) {
     w =  String.valueOf(  w.charAt( 0 )).toUpperCase() + w.substring( 1 ).concat( " " );
        builder.append( w );
    }
    System.out.println("Capitalize First letter: " + builder);
  }

  static void mostRepeatedCharacter(String s) {
    var map = new LinkedHashMap<Character,Integer>();
    for (var w : s.toCharArray()) {
    map.putIfAbsent( w,0 );
    map.computeIfPresent(w, (character, integer) -> ++integer);
    }

    PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>( (o1, o2) -> Integer.compare( o2.getValue(), o1.getValue() ) );

    pq.addAll( map.entrySet() );

    System.out.println("Max occurrence: " + pq.poll());
    System.out.println("Max occurrence: " + pq.poll());

  }

  static void anagram(String s1, String s2) {

    var result = true;

    for (var c  : s1.toCharArray()) {
      if (!s2.contains( String.valueOf( c ) ) || s1.length() != s2.length()) {
        result = false;
        break;
      }
    }

    System.out.println("Is Anagram : " + result);
  }
  static void palindrome(String s) {

    var result = true;
    for (int i = 0; i < s.length()-1; i++) {
      if (!Objects.equals( String.valueOf(s.charAt(i)), String.valueOf(s.charAt(s.length() - 1 - i)))) result = false;
    }

    System.out.println("Is Palindrome : " + result);
  }

  public static void main(String[] args) {
    StringManipulation.mostRepeatedCharacter( "Hellooo!!" );
  }
}
