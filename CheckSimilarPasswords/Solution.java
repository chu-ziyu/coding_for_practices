package CheckSimilarPasswords;

import java.util.ArrayList;
import java.util.List;
//解法思路
//
//	1.	双指针法：
//  •	一个指针遍历旧密码，一个指针遍历新密码。
//  •	对于新密码中的每个字符：
//  •	如果它与旧密码字符匹配，旧密码指针前进。
//  •	如果经过一次循环替换后与旧密码字符匹配，旧密码指针也前进。
//  •	如果成功遍历完整个旧密码，则旧密码是子序列，返回 "YES"；否则返回 "NO"。
//  2.	实现步骤：
//  •	遍历每一对新旧密码。
//  •	对于每对密码，使用上述双指针方法判断是否满足条件。

public class Solution {
  public static List<String> checkSimilarPasswords(String[] newPasswords, String[] oldPasswords) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < newPasswords.length; i++) {
      String newPassword = newPasswords[i];
      String oldPassword = oldPasswords[i];

      // Check if oldPassword is a subsequence of newPassword (considering cyclic shift)
      if (isSimilar(newPassword, oldPassword)) {
        result.add("YES");
      } else {
        result.add("NO");
      }
    }

    return result;
  }

  // Method to check if oldPassword is a subsequence of newPassword
  private static boolean isSimilar(String newPassword, String oldPassword) {
    int i = 0; // Pointer for oldPassword
    int j = 0; // Pointer for newPassword

    while (i < oldPassword.length() && j < newPassword.length()) {
      char oldChar = oldPassword.charAt(i);
      char newChar = newPassword.charAt(j);

      // Check if characters match (directly or through cyclic shift)
      if (newChar == oldChar || nextCyclicChar(newChar) == oldChar) {
        i++; // Move oldPassword pointer if there's a match
      }

      j++; // Always move newPassword pointer
    }

    // If we've matched all characters in oldPassword, it's a subsequence
    return i == oldPassword.length();
  }

  // Method to compute the next cyclic character
  private static char nextCyclicChar(char c) {
    return (char) ((c - 'a' + 1) % 26 + 'a');
  }

  public static void main(String[] args) {
    String[] newPasswords1 = {"baacbab", "accdb", "baacba"};
    String[] oldPasswords1 = {"abdbc", "ach", "abb"};
    System.out.println(checkSimilarPasswords(newPasswords1, oldPasswords1)); // Output: [YES, NO, YES]

    String[] newPasswords2 = {"aaccbbee", "aab"};
    String[] oldPasswords2 = {"bdbf", "aee"};
    System.out.println(checkSimilarPasswords(newPasswords2, oldPasswords2)); // Output: [YES, NO]
  }
}
