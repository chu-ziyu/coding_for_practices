package GetMaximumThroughput;

import java.util.Arrays;

public class Solution {
  public static long amazonGetMaxThroughput(int[] host_throughput) {
    Arrays.sort(host_throughput);
    long system_throughput = 0;
    int n = host_throughput.length;

    for(int i = n - 2; i >= 1; i -= 3) {
      system_throughput += host_throughput[i];
    }

    return system_throughput;
  }
  public static void main(String[] args) {
    int[] host_throughput1 = {4, 6, 3, 5, 4, 5};
    System.out.println(amazonGetMaxThroughput(host_throughput1)); // 输出: 9

    int[] host_throughput2 = {2, 3, 4, 3, 4};
    System.out.println(amazonGetMaxThroughput(host_throughput2)); // 输出: 4

    int[] host_throughput3 = {2, 3, 4, 3, 4, 9 ,7, 12, 11, 6};
    System.out.println(amazonGetMaxThroughput(host_throughput3)); // 输出: 20
  }
}
