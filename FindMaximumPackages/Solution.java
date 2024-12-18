package FindMaximumPackages;

import java.util.*;

public class Solution {
    public static int findMaximumPackages(int[] cost) {
      int n = cost.length;
      Map<Integer, List<int[]>> costToPackages = new HashMap<>();
      boolean[] used = new boolean[n];

      for (int i = 0; i < n; i++) {
        int totalCost = cost[i];
        if (!costToPackages.containsKey(totalCost)) {
          costToPackages.put(totalCost, new ArrayList<>());
        }
        costToPackages.get(totalCost).add(new int[]{i});
      }

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          int totalCost = cost[i] + cost[j];
          if (!costToPackages.containsKey(totalCost)) {
            costToPackages.put(totalCost, new ArrayList<>());
          }
          costToPackages.get(totalCost).add(new int[]{i, j});
        }
      }

      int maxPackages = 0;
      for (Map.Entry<Integer, List<int[]>> entry : costToPackages.entrySet()) {
        Arrays.fill(used, false);
        int count = 0;
        for (int[] pack : entry.getValue()) {
          boolean canUse = true;
          for (int idx : pack) {
            if (used[idx]) {
              canUse = false;
              break;
            }
          }
          if (canUse) {
            count++;
            for (int idx : pack) {
              used[idx] = true;
            }
          }
        }
        maxPackages = Math.max(maxPackages, count);
      }

      return maxPackages;
    }
  public static void main(String[] args) {
    // Example test cases
    int[] cost1 = {4, 5, 10, 3, 1, 2, 2, 2, 3};
    int[] cost2 = {1, 1, 2, 2, 1, 4};
    int[] cost3 = {10, 2, 1};
    int[] cost4 = {2, 2, 2, 2};
    int[] cost5 = {2, 1, 3};
    int[] cost6 = {4, 6, 7, 8, 9, 10};

    System.out.println(findMaximumPackages(cost1)); // Expected Output: 4
    System.out.println(findMaximumPackages(cost2)); // Expected Output: 3
    System.out.println(findMaximumPackages(cost3)); // Expected Output: 1
    System.out.println(findMaximumPackages(cost4)); // Expected Output: 4
    System.out.println(findMaximumPackages(cost5));// Expected Output: 2
    System.out.println(findMaximumPackages(cost6));// Expected Output: 2
  }
}
