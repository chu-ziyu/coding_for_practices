package MinimumRemoval1208;

import java.util.*;

public class Solution {
  public static int minimumRemoval(int[] arr, int k) {
    HashMap<Integer, Integer> categoryFreq = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      categoryFreq.put(arr[i], categoryFreq.getOrDefault(arr[i], 0) + 1);
    }
    ArrayList<Integer> sortList = new ArrayList<>(categoryFreq.values());
    Collections.sort(sortList);
    int res = 0;
    if (sortList.size() > k) {
      for (int i = sortList.size() - 1; i > sortList.size() - 1 - k; i--) {
        res += sortList.get(i);
      }
    }

    return res;
  }
//  public static int minimumRemoval(int[] arr, int k) {
//    // 统计每种类别的频率
//    HashMap<Integer, Integer> categoryFreq = new HashMap<>();
//    for (int num : arr) {
//      categoryFreq.put(num, categoryFreq.getOrDefault(num, 0) + 1);
//    }
//
//    // 将频率放入列表并排序（升序）
//    ArrayList<Integer> frequencies = new ArrayList<>(categoryFreq.values());
//    Collections.sort(frequencies);
//
//    int toRemove = 0; // 需要移除的产品数量
//    int distinctCategories = frequencies.size();
//
//    // 移除频率最小的类别，直到类别数量 <= k
//    for (int freq : frequencies) {
//      if (distinctCategories <= k) {
//        break;
//      }
//      toRemove += freq; // 移除当前类别的所有产品
//      distinctCategories--; // 减少一个类别
//    }
//
//    return toRemove;
//  }
  public static void main(String[] args) {
    int[] arr1 = {3,3,5,7};
    int k1 = 1;
    System.out.println(minimumRemoval(arr1, k1));
  }
}
