package optimizeIdentifiers;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;

public class YourClass {
//  public static int optimizeIdentifiers(String s) {
//    int n = s.length();
//    ArrayList<Integer> sta = new ArrayList<>();
//    ArrayList<Integer> end = new ArrayList<>();
//    char starter = s.charAt(0), ending = s.charAt(n - 1);
//
//    // Collect the indices of the starter and ending characters
//    for (int i = 0; i < n; i++) {
//      char c = s.charAt(i);
//      if (c == starter) {
//        sta.add(i);
//      }
//      if (c == ending) {
//        end.add(i);
//      }
//    }
//    int maxOperation = 0;
//    int i = 0, j = 0;
//    /// Use two pointers to find the maximum operation
//    while (i < sta.size() && j < end.size()) {
//      if (sta.get(i) < end.get(j)) { // Ensure the starter comes before the ending
//        maxOperation = Math.max(maxOperation, (sta.get(i)) + (n - 1 - end.get(j)));
//        i++; // Move the `sta` pointer to check the next starter
//      } else {
//        j++; // Move the `end` pointer to check the next ending
//      }
//    }
//    return maxOperation;
//  }
  public static int optimizeIdentifiers(String s) {
    int n = s.length();
    ArrayList<Integer> start = new ArrayList<>();
    ArrayList<Integer> end = new ArrayList<>();
    char first = s.charAt(0);
    char last = s.charAt(n - 1);

    for(int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if(c == first) {
        start.add(i);
      }
      if(c == last) {
        end.add(i);
      }
    }

    int maxOperations = 0;
    int i = 0, j = 0;

    while(i < start.size() && j < end.size()) {
      if(start.get(i) < end.get(j)) {
        maxOperations = Math.max(maxOperations, start.get(i) + (n - 1 - end.get(j)));
        i++;
      } else {
        j++;
      }
    }
    return maxOperations;
  }
  // 测试用例
  public static void main(String[] args) {
    // Test case 1
    String s1 = "babdcaac";
    int result1 = optimizeIdentifiers(s1);
    System.out.println("Test case 1 result: " + result1);  // Expected: 5

    // Test case 2
    String s2 = "hchc";
    int result2 = optimizeIdentifiers(s2);
    System.out.println("Test case 2 result: " + result2);  // Expected: 2

    // Test case 3
    String s3 = "abcdef";
    int result3 = optimizeIdentifiers(s3);
    System.out.println("Test case 3 result: " + result3);  // Expected: 0

    // Test case 4
    String s4 = "aaa";
    int result4 = optimizeIdentifiers(s4);
    System.out.println("Test case 4 result: " + result4);  // Expected: 1

    // Test case 5
    String s5 = "abcdeedcba";
    int result5 = optimizeIdentifiers(s5);
    System.out.println("Test case 5 result: " + result5);  // Expected: 5
  }
}
