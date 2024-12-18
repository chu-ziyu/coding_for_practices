package BuyVolume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<List<Integer>> buyVolumes(int[] volumes) {
      int n = volumes.length;
      List<List<Integer>> result = new ArrayList<>();
      boolean[] owned = new boolean[n + 1]; // Tracks whether a volume is owned (1-indexed).
      int maxOwned = 0; // Tracks the highest volume number we own.

      for (int day = 0; day < n; day++) {
        int currentVolume = volumes[day];
        owned[currentVolume] = true;

        // Check if we can buy a sequence of volumes starting from `maxOwned + 1`.
        List<Integer> purchasedToday = new ArrayList<>();
        while (maxOwned + 1 <= n && owned[maxOwned + 1]) {
          maxOwned++;
          purchasedToday.add(maxOwned);
        }

        if (purchasedToday.isEmpty()) {
          result.add(Collections.singletonList(-1));
        } else {
          result.add(purchasedToday);
        }
      }

      return result;
    }

    public static void main(String[] args) {
      int[] volumes1 = {2, 1, 4, 3};
      System.out.println(buyVolumes(volumes1));
      // Expected Output: [[-1], [1, 2], [-1], [3, 4]]

      int[] volumes2 = {1, 4, 3, 2, 5};
      System.out.println(buyVolumes(volumes2));
      // Expected Output: [[1], [-1], [-1], [2, 3, 4], [5]]
    }
  }

