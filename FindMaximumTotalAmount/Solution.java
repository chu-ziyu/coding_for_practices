package FindMaximumTotalAmount;

public class Solution {
  public static int maxTotalAmount(int[][] segment, int k) {
    int MOD = 1_000_000_007;

    // Step 1: Find the maximum bag index
    int maxBag = 0;
    for (int[] seg : segment) {
      maxBag = Math.max(maxBag, seg[1]);
    }

    // Step 2: Build the "money" array
    int[] money = new int[maxBag + 1];
    for (int[] seg : segment) {
      for (int j = seg[0]; j <= seg[1]; j++) {
        money[j] += seg[2];
      }
    }

    // Step 3: Sliding window to find the maximum sum of k consecutive bags
    int total = 0, maxTotal = 0;

    // Compute initial window sum
    for (int i = 1; i <= k; i++) {
      total += money[i];
    }
    maxTotal = total;

    // Slide the window
    for (int i = k + 1; i <= maxBag; i++) {
      total += money[i] - money[i - k];
      maxTotal = Math.max(maxTotal, total);
    }

    // Return the result modulo MOD
    return maxTotal % MOD;
  }

  public static void main(String[] args) {
    int[][] segment1 = new int[][]{{1, 4, 2}, {6, 6, 5}, {7, 7, 7}, {9, 10, 1}};
    int k1 = 5;
    System.out.println(maxTotalAmount(segment1, k1)); // Output: 16
  }
}
