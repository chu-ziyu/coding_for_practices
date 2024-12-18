package FindSmallestAppealing;

public class Solution {
//  public static String findSmallestAppealing(String old_code, int k) {
//    // write your code here
//    int length = old_code.length();
//    if(length < k) return old_code;
//    int[] arr = new int[length];
//    int old_value = 0;
//    int new_value = 0;
//
//    for(int i = 0; i < length; i++){
//      arr[i] = old_code.charAt(i) - '0';
//    }
//    for (int i = 0; i < length - k; i++) {
//      old_value = old_value*10 + arr[i];
//      arr[i] = arr[i + k];
//      new_value = new_value*10 + arr[i];
//      if(new_value >= old_value){
//        return arr.toString();
//      }
//    }
//  }
//  public static void main(String[] args) {
//    // Test case 1
//    String s1 = "41242";
//    int k1 = 4;
//    String result1 = findSmallestAppealing(s1, k1);
//    System.out.println("Test case 1 result: " + result1);  // Expected: 5
//
//    // Test case 2
//    String s2 = "353";
//    int k2 = 2;
//    String result2 = findSmallestAppealing(s2, k2);
//    System.out.println("Test case 2 result: " + result2);  // Expected: 2
//
//    // Test case 3
//    String s3 = "1234";
//    int k3 = 2;
//    String result3 = findSmallestAppealing(s3, k3);
//    System.out.println("Test case 3 result: " + result3);  // Expected: 0
//  }
  // 正确解法
//public static String findSmallestAppealing(String oldCode, int k) {
//  // 提取前 k 位
//  String prefix = oldCode.substring(0, k);
//
//  // 使用前 k 位生成初始 attractive code
//  String candidate = buildAttractiveCode(prefix, oldCode.length(), k);
//
//  // 如果生成的 attractive code 小于 oldCode，增加前 k 位
//  if (candidate.compareTo(oldCode) < 0) {
//    // 增加前 k 位
//    prefix = incrementPrefix(prefix);
//    candidate = buildAttractiveCode(prefix, oldCode.length(), k);
//  }
//
//  return candidate;
//}
//
//  // 根据 prefix 构造 attractive code
//  private static String buildAttractiveCode(String prefix, int n, int k) {
//    StringBuilder result = new StringBuilder();
//    for (int i = 0; i < n; i++) {
//      result.append(prefix.charAt(i % k));  // 根据模运算重复构造
//    }
//    return result.toString();
//  }
//
//  // 增加前 k 位的数字
//  private static String incrementPrefix(String prefix) {
//    char[] chars = prefix.toCharArray();
//    for (int i = chars.length - 1; i >= 0; i--) {
//      if (chars[i] < '9') {
//        chars[i]++;
//        return new String(chars);  // 增加完成后返回
//      }
//      chars[i] = '0';  // 处理进位
//    }
//    // 如果全部是 '9'，需要增加一位
//    return "1" + new String(chars);
//  }
//
//  // 测试代码
//  public static void main(String[] args) {
//    System.out.println(findSmallestAppealing("41242", 4)); // 输出: 41244
//    System.out.println(findSmallestAppealing("353", 2));   // 输出: 353
//    System.out.println(findSmallestAppealing("1234", 2));  // 输出: 1313
//    System.out.println(findSmallestAppealing("999", 1));   // 输出: 999
//    System.out.println(findSmallestAppealing("10000", 2)); // 输出: 10101
//  }
  public static String findSmallestAppealing(String old_code, int k) {
    int n = old_code.length();
    String prefix = old_code.substring(0, k);
    String candidate = buildAttractiveCode(prefix, n, k);
    if(candidate.compareTo(old_code) < 0) {
      prefix = incrementPrefix(prefix);
      candidate = buildAttractiveCode(prefix, n , k);
    }
    return candidate;
  }
  private static String buildAttractiveCode(String prefix, int n, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(prefix.charAt(i % k));
    }
    return sb.toString();
  }
  private static String incrementPrefix(String prefix) {
    char[] chars = prefix.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      if(chars[i] < '9') {
        chars[i]++;
        return new String(chars);
      }
      chars[i] = '0';
    }
    return "1" + new String(chars);
  }
    // 测试代码
  public static void main(String[] args) {
    System.out.println(findSmallestAppealing("41242", 4)); // 输出: 41244
    System.out.println(findSmallestAppealing("353", 2));   // 输出: 353
    System.out.println(findSmallestAppealing("1234", 2));  // 输出: 1313
    System.out.println(findSmallestAppealing("999", 1));   // 输出: 999
    System.out.println(findSmallestAppealing("10000", 2)); // 输出: 10101
    }
}

