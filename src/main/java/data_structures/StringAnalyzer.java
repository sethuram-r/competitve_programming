package data_structures;

import java.util.Stack;

public class StringAnalyzer {

  String reverse(String s) {

    var stack = new Stack<Character>();
    StringBuilder builder = new StringBuilder();
    for (var c : s.toCharArray()) {
      stack.push(c);
    }

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.toString();
  }

  boolean isBalanced(String s) {
    var stack = new Stack<Character>();
    var braces = "{[(<";
    var closed = "}])>";

    for (char c : s.toCharArray()) {
      if (braces.contains(String.valueOf(c))) stack.push(c);

      if (closed.contains(String.valueOf(c))) {
        if(stack.isEmpty()) return false;
        var previousBrace = stack.pop();
        return braces.indexOf(previousBrace) == closed.indexOf(c);
      }
    }
    return stack.empty();
  }
}
