package FindMinimumTime;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
//  Approach
//  1. Sort the Positions:
//
//  First, sort the array of apple positions.
//  This will allow us to systematically explore potential sequences in which
//  the snake can eat the apples.
//
//  2. Sliding Window Technique:
//
//  Use a sliding window to find the minimum distance to eat k apples in a contiguous subarray.
//
//  3. Calculate the Time:
//
//  Calculate the time for each possible subarray of length k and track the minimum time required.

    public static int findMinimumTimeForSnake(int n, int k, int[] position) {
      // Step 1: Sort the array of positions
      Arrays.sort(position);

      // Step 2: Initialize the minimum time with a large value
      int minTime = Integer.MAX_VALUE;

      // Step 3: Use a sliding window to find the minimum time
      for (int i = 0; i <= n - k; i++) {
        // Calculate the time taken to eat k apples from position[i] to position[i + k - 1]
        int time = Math.abs(position[i + k - 1] - position[i]) + Math.min(Math.abs(position[i + k - 1]), Math.abs(position[i]));
        minTime = Math.min(minTime, time);
      }

      return minTime;
    }

  public static void main(String[] args) {
    int n1 = 3;
    int k1 = 3;
    int[] position1 = {-20, 5, 10};
    System.out.println(findMinimumTimeForSnake(n1, k1, position1));

    int n2 = 3;
    int k2 = 3;
    int[] position2 = {-20, 1, 39};
    System.out.println(findMinimumTimeForSnake(n2, k2, position2));

    int n3 = 3;
    int k3 = 2;
    int[] position3 = {-1, 1, 5};
    System.out.println(findMinimumTimeForSnake(n3, k3, position3));

    int n4 = 3;
    int k4 = 2;
    int[] position4 = {-3, -2, 1};
    System.out.println(findMinimumTimeForSnake(n4, k4, position4));
  }
}

