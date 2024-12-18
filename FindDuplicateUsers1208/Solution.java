package FindDuplicateUsers1208;

import java.util.*;

public class Solution {
  public static String[] findDuplicate(String[] realUsernames, String[] allUsernames) {
    HashMap<String, Integer> usernameCount = new HashMap<>();
    for(String username : allUsernames) {
      String sorted = getSortedUsernames(username);
      usernameCount.put(sorted, usernameCount.getOrDefault(sorted, 0) + 1);
    }
    List<String> result = new ArrayList<>();
    for(String username : realUsernames) {
      String sorted = getSortedUsernames(username);
      if(usernameCount.getOrDefault(sorted, 0) > 1){
        result.add(username);
      }
    }
    Collections.sort(result);
    if(result.isEmpty()) {
      result.add("None");
    }
    return result.toArray(new String[0]);
  }
  private static String getSortedUsernames(String username) {
    char[] charArray = username.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }
  public static void main(String[] args) {
    String[] realUsernames1 = {"abc", "def"};
    String[] allUsernames1 = {"bca", "abc", "cba", "def"};
    System.out.println(Arrays.toString(findDuplicate(realUsernames1,allUsernames1)));
  }
}
