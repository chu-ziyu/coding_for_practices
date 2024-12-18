package CustomSortString;

import java.util.*;

//public class Solution {
//  public static List<String> customSortString(String order, String[] arr) {
//    // Step 1: Build priority map for custom order
//    Map<Character, Integer> priorityMap = new HashMap<>();
//    for (int i = 0; i < order.length(); i++) {
//      priorityMap.put(order.charAt(i), i);
//    }
//
//    // Step 2: Define custom comparator
//    Comparator<String> customComparator = (s1, s2) -> {
//      int len1 = s1.length(), len2 = s2.length();
//      int minLength = Math.min(len1, len2);
//      for (int i = 0; i < minLength; i++) {
//        char c1 = s1.charAt(i);
//        char c2 = s2.charAt(i);
//        if (c1 != c2) {
//          return Integer.compare(priorityMap.get(c1), priorityMap.get(c2));
//        }
//      }
//      return Integer.compare(len1, len2); // Compare by length if prefixes match
//    };
//
//    // Step 3: Sort the array using the comparator
//    Arrays.sort(arr, customComparator);
//
//    // Return the sorted list
//    return Arrays.asList(arr);
//  }
//
//  public static void main(String[] args) {
//    // Example 1
//    String order1 = "9AacB";
//    String[] arr1 = {"BBBBa", "BBBB9", "B9ca", "Aa999", "B9A", "B", "B9A"};
//    System.out.println(customSortString(order1, arr1));
//
//    // Example 2
//    String order2 = "yYaAbBl";
//    String[] arr2 = {"Yay", "yaY", "lyab", "lyab", "b", "bay"};
//    System.out.println(customSortString(order2, arr2));
//
//    // Example 3
//    String order3 = "7BbAz";
//    String[] arr3 = {"Abb", "A7z", "z7AAAA", "BbbABB"};
//    System.out.println(customSortString(order3, arr3));
//  }
//}

import java.util.*;

//public class Solution {
//  public static List<String> customSortString(String order, String[] arr) {
//    // Step 1: 构建字符优先级的哈希表
//    Map<Character, Integer> priorityMap = new HashMap<>();
//    for (int i = 0; i < order.length(); i++) {
//      priorityMap.put(order.charAt(i), i);
//    }
//
//    // Step 2: 手动实现排序算法（冒泡排序为例）
//    List<String> result = Arrays.asList(arr);
//    for (int i = 0; i < result.size(); i++) {
//      for (int j = 0; j < result.size() - i - 1; j++) {
//        if (compareStrings(result.get(j), result.get(j + 1), priorityMap) > 0) {
//          // 交换
//          String temp = result.get(j);
//          result.set(j, result.get(j + 1));
//          result.set(j + 1, temp);
//        }
//      }
//    }
//
//    return result;
//  }
//
//  // 自定义比较函数，比较两个字符串的顺序
//  private static int compareStrings(String s1, String s2, Map<Character, Integer> priorityMap) {
//    int len1 = s1.length(), len2 = s2.length();
//    int minLen = Math.min(len1, len2);
//
//    for (int i = 0; i < minLen; i++) {
//      char c1 = s1.charAt(i);
//      char c2 = s2.charAt(i);
//      if (c1 != c2) {
//        // 比较字符优先级
//        return priorityMap.get(c1) - priorityMap.get(c2);
//      }
//    }
//    // 如果前面部分都相等，短的字符串优先
//    return len1 - len2;
//  }
//
//  public static void main(String[] args) {
//    String order = "9AacB";
//    String[] arr = {"BBBBa", "BBBB9", "B9ca", "Aa999", "B9A", "B", "B9A"};
//
//    List<String> sortedStrings = customSortString(order, arr);
//    System.out.println(sortedStrings);
//  }
//}

import java.util.*;

public class Solution {
  public static List<String> customSortString(String order, String[] arr) {
    // Step 1: 构建优先级映射表
    Map<Character, Integer> priorityMap = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      priorityMap.put(order.charAt(i), i);
    }

    // Step 2: 创建优先队列并定义排序规则
    PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> compareStrings(s1, s2, priorityMap));
    pq.addAll(Arrays.asList(arr)); // 将所有字符串加入队列

    // Step 3: 从队列中取出排序后的结果
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    return result;
  }

  private static int compareStrings(String s1, String s2, Map<Character, Integer> priorityMap) {
    int len1 = s1.length(), len2 = s2.length();
    int minLen = Math.min(len1, len2);

    for (int i = 0; i < minLen; i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 != c2) {
        return priorityMap.get(c1) - priorityMap.get(c2);
      }
    }
    return len1 - len2;
  }

  public static void main(String[] args) {
    String order = "yYaAbBl";
    String[] arr = {"Yay", "yaY", "lyab", "lyab", "b", "bay"};

    List<String> sortedStrings = customSortString(order, arr);
    System.out.println(sortedStrings);
  }
}
