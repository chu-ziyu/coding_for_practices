package CalculateBeautyValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
  public static int calculateBeautyValues(int[] arr, int[][] pairs) {
    // write your code here
    ArrayList<Integer>  beauty_array = new ArrayList<>();
    HashSet<Integer> index_used = new HashSet<>();
    // 遍历每个 pair，构造美丽数组并记录使用的索引
    for (int[] pair : pairs) {
      for (int i = pair[0]; i <= pair[1]; i++) { // 添加整个范围
        beauty_array.add(arr[i]);
        index_used.add(i);
      }
    }
    ArrayList<Integer> unused_values = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if(!index_used.contains(i)){
        unused_values.add(arr[i]);
      }
    }
//    int count = 0;
//    for (int unused : unused_values) {
//      for (int val : beauty_array) {
//        if (val < unused) {
//          count++;
//        }
//      }
//    }

    // 排序美丽数组
    Collections.sort(beauty_array);

    // 计算未使用值的美丽值
    int count = 0;
    for (int value : unused_values) {
      // 找到比当前值小的值的个数
      count += countSmaller(beauty_array, value);
    }

    return count;
  }
  // 使用二分搜索统计比目标值小的数的个数
  private static int countSmaller(ArrayList<Integer> sortedArray, int target) {
    int low = 0, high = sortedArray.size();
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (sortedArray.get(mid) < target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low; // 此时 low 指向比 target 小的数的个数
  }
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 2, 4, 5};
    int[][] pairs1 = {{0, 1}, {3, 4}, {0, 0}, {3, 4}};
    System.out.println(calculateBeautyValues(arr1, pairs1));
  }
}
