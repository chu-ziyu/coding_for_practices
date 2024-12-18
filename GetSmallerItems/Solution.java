package GetSmallerItems;

import java.util.*;

public class Solution {
  public static long[] getSmallerItems(int[] items, int[] start, int[] end, int[] query) {
    // 提取所有选定的值
    List<Integer> allPickedItems = new ArrayList<>();
    for (int i = 0; i < start.length; i++) {
      for (int j = start[i]; j <= end[i]; j++) {
        allPickedItems.add(items[j]);
      }
    }

    // 排序所有值
    Collections.sort(allPickedItems);

    // 将列表转换为数组，便于二分查找
    int[] sortedPickedItems = allPickedItems.stream().mapToInt(Integer::intValue).toArray();

    // 对每个查询值使用二分查找
    long[] result = new long[query.length];
    for (int i = 0; i < query.length; i++) {
      int count = binarySearch(sortedPickedItems, query[i]);
      result[i] = count;
    }
    return result;
  }

  // 二分查找，找到小于目标值的元素个数
  private static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < target) {
        left = mid + 1; // 查找右边界
      } else {
        right = mid - 1; // 查找左边界
      }
    }
    return left; // 返回小于 target 的元素个数
  }

  public static void main(String[] args) {
    int[] items1 = {1, 2, 5, 4, 5};
    int[] start1 = {0, 0, 1};
    int[] end1 = {1, 2, 2};
    int[] query1 = {2, 4};
    System.out.println(Arrays.toString(getSmallerItems(items1, start1, end1, query1))); // [2, 5]

    int[] items2 = {1, 2, 3, 2, 4, 1};
    int[] start2 = {2, 0};
    int[] end2 = {4, 0};
    int[] query2 = {5, 3};
    System.out.println(Arrays.toString(getSmallerItems(items2, start2, end2, query2))); // [4, 2]
  }
}
