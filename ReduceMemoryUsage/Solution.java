package ReduceMemoryUsage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static int reduceMemoryUsage(int[] processes, int m) {
    // write your code here
    Arrays.sort(processes);
//    List<Integer> removal = new ArrayList<>();
    int totalRemoval = 0;
    int totalMemory = 0;
    int res = 0;
    for (int i = 0; i < processes.length; i++) {
      totalMemory += processes[i];
    }
    for (int j = processes.length - 1; j > processes.length - 1 - m; j--) {
//      removal.add(processes[j]);
      totalRemoval += processes[j];
    }
    res = totalMemory - totalRemoval;
    return res;
  }
  public static void main(String[] args) {
    int[] process1 = {10, 4, 8, 13, 20};
    int m1 = 2;
    System.out.println(reduceMemoryUsage(process1, m1));

    int[] process2 = {10, 4, 8, 13, 20};
    int m2 = 3;
    System.out.println(reduceMemoryUsage(process2, m2));
  }
}
