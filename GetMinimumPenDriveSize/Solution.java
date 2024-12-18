package GetMinimumPenDriveSize;

import java.util.Arrays;

import java.util.Arrays;

public class Solution {
  public static int getMinSize(int[] gameSize, int k) {
    // 排序游戏尺寸以便用双指针策略
    Arrays.sort(gameSize);
    int left = gameSize[gameSize.length - 1]; // 最小容量起点是最大游戏的大小
    int right = gameSize[gameSize.length - 1] + gameSize[0]; // 最大容量是最大游戏与最小游戏之和

    int result = right; // 用于存储最小容量结果

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (canDistribute(gameSize, k, mid)) {
        result = mid; // 尝试更小的容量
        right = mid - 1;
      } else {
        left = mid + 1; // 增大容量
      }
    }

    return result;
  }

  private static boolean canDistribute(int[] gameSize, int k, int maxCapacity) {
    int i = 0, j = gameSize.length - 1;
    int count = 0; // U盘数量

    while (i <= j) {
      // 尝试将最小的和最大的游戏一起放入一个U盘
      if (i < j && gameSize[i] + gameSize[j] <= maxCapacity) {
        i++; // 最小的游戏被配对
      }
      j--; // 最大的游戏被分配
      count++; // 用掉一个U盘

      // 如果U盘数量超过k，返回false
      if (count > k) {
        return false;
      }
    }
    return count <= k;
  }

  public static void main(String[] args) {
    // 测试用例
    int[] gameSize1 = {9, 2, 4, 6};
    int k1 = 3;
    System.out.println(getMinSize(gameSize1, k1)); // 输出: 9

    int[] gameSize2 = {1, 2, 3, 4, 5, 6};
    int k2 = 3;
    System.out.println(getMinSize(gameSize2, k2)); // 输出: 6

    int[] gameSize3 = {8, 5, 7, 10, 1};
    int k3 = 4;
    System.out.println(getMinSize(gameSize3, k3)); // 输出: 10

    int[] gameSize4 = {5, 8, 12, 15, 2, 3};
    int k4 = 3;
    System.out.println(getMinSize(gameSize4, k4));
  }
}
