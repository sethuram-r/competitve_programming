package book;

import java.util.HashSet;
import java.util.Set;

public class ChapterOne {

    public static void main(String[] args) {
        ChapterOne chapterOne = new ChapterOne();

//    System.out.println(chapterOne.isUniqueString("sethuram"));
//    System.out.println(chapterOne.urlify("Mr john Smith", 13));
//    System.out.println(chapterOne.urlifyInPLace("Mr john Smith    ", 13));
//    System.out.println(chapterOne.oneAway("ple", "pale"));
//    System.out.println(chapterOne.oneAway("pale", "pales"));
//    System.out.println(chapterOne.oneAway("bale", "pale"));
//    System.out.println(chapterOne.oneAway("pale", "bake"));
//    System.out.println(chapterOne.oneAway("pale", "pale"));
//    System.out.println(chapterOne.compress("aabcccccaaa"));
//    System.out.println(chapterOne.compress("abcd"));
//
//    int[][] matrix = {{1,2},{3,4}};
//    int[][] matrix2 = {{1,0,0},{4,5,6},{7,8,9}};
////    chapterOne.rotate( matrix,2 );
////    chapterOne.rotate( matrix2,3 );
//    chapterOne.zeroMatrix( matrix2,3,3 );
//
//    chapterOne.isSubString( "waterbottle","erbottlewat" );
//    chapterOne.isSubString( "abcd","bcda" );

        var chars = new char[]{'h', 'm', 'f', 'd', 'o', 'z', 't', 'f', 'f', 'y'};
        chapterOne.compress( chars );
    }

    public int compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
                count++;
                builder.append( chars[i] );
                if (count != 1) {
                    builder.append( count );
                }

                count = 0;
            } else {
                count++;
            }
        }

        String res = builder.toString();


        for (int i = 0; i < res.length(); i++) {
            chars[i] = res.charAt( i );
        }

        return res.length();
    }

    boolean isUniqueString(String s) {
        StringBuilder existing = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (existing.toString().contains( String.valueOf( c ) )) {
                return false;
            } // o(n)
            existing.append( c ); //
        }
        return true;
    }

    String urlify(String input, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (Character.isSpaceChar( input.charAt( i ) )) {
                builder.append( "%20" );
            } else {
                builder.append( input.charAt( i ) );
            }
        }
        return builder.toString();
    }

    String urlifyInPLace(String input, int trueLength) {

        int spaces = 0;
        int extra;

        for (int i = 0; i < trueLength; i++) {
            if (Character.isSpaceChar( input.charAt( i ) )) {
                spaces++;
            }
        }
        extra = (spaces * 3) - spaces;
        var inputArray = input.toCharArray();
        for (int i = trueLength - 1; i >= 0; i--) {
            if (!Character.isSpaceChar( inputArray[i] )) {
                inputArray[i + extra] = inputArray[i];
            } else {
                inputArray[i + extra] = '0';
                inputArray[i + extra - 1] = '2';
                inputArray[i + extra - 2] = '%';
                extra = extra - 2;
            }
        }
        return String.valueOf( inputArray );
    }

    boolean oneAway(String source, String result) {

        for (var a : source.toCharArray()) {
            result = result.replace( String.valueOf( a ), "" );
        }
        return result.length() <= 1;
    }


    String compress(String source) {

        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (i + 1 == source.length() || source.charAt( i + 1 ) != source.charAt( i )) {
                builder.append( source.charAt( i ) );
                builder.append( ++count );
                count = 0;
            } else {
                count++;
            }
        }
        boolean notCompressed = true;
        for (var a : builder.toString().replace( "1", "" ).toCharArray()) {
          if (!String.valueOf( a ).matches( "[a-z]" )) {
            notCompressed = false;
            break;
          }
        }
        return notCompressed ? source : builder.toString();

    }

    void rotate(int[][] matrix, int n) {

        int previous = 0;
        int roation = 0;
        while (roation < n - 1) {
            // top
            for (int i = 0; i < n; i++) {
                var temp = matrix[0][i];
                matrix[0][i] = previous;
                previous = temp;
            }
            //right
            for (int i = 1; i < n; i++) {
                var temp = matrix[i][n - 1];
                matrix[i][n - 1] = previous;
                previous = temp;
            }
            //bottom

            for (int i = n - 1 - 1; i >= 0; i--) {
                var temp = matrix[n - 1][i];
                matrix[n - 1][i] = previous;
                previous = temp;
            }

            //left

            for (int i = n - 1 - 1; i >= 0; i--) {
                var temp = matrix[i][0];
                matrix[i][0] = previous;
                previous = temp;
            }
            roation++;
        }


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append( "[" );
            for (int j = 0; j < n; j++) {
                builder.append( matrix[i][j] );
            }
            builder.append( "]" );
        }
        System.out.println( builder );

    }

    void zeroMatrix(int[][] matrix, int m, int n) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add( i );
                    column.add( j );
                }
            }
        }

        for (var r : row) {
            for (int i = 0; i < n; i++) {
                matrix[r][i] = 0;
            }
        }
        for (var c : column) {
            for (int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            builder.append( "[" );
            for (int j = 0; j < n; j++) {
                builder.append( matrix[i][j] );
            }
            builder.append( "]" );
        }
        System.out.println( builder );

    }

    void isSubString(String s1, String s2) {
        var result = false;
        var s = s1 + s1;
        var right = s1.length();
        var left = 0;

        while (right < s.length()) {
            System.out.println( s.substring( left, right ) );
            if (s.substring( left, right ).equals( s2 )) {
                result = true;
                break;
            }
            right++;
            left++;
        }
        System.out.println( "Result " + result );
    }

}
