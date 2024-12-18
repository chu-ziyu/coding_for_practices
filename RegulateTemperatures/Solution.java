package RegulateTemperatures;

public class Solution {
  public static long regulateTemperatures(int[] temperature) {
    long operations = 0; // 记录总操作数
    int n = temperature.length; // 温度数组长度

    int i = 0;
    while (i < n) {
      if (temperature[i] != 0) { // 找到非零段
        int minAbs = Math.abs(temperature[i]);
        int j = i;

        // 找到连续非零段，并计算该段的最小绝对值
        while (j < n && temperature[j] * temperature[i] > 0) { // 同号段
          minAbs = Math.min(minAbs, Math.abs(temperature[j]));
          j++;
        }

        // 减少该段的温度
        for (int k = i; k < j; k++) {
          if (temperature[k] > 0) {
            temperature[k] -= minAbs; // 减少正值
          } else {
            temperature[k] += minAbs; // 增加负值
          }
        }

        operations += minAbs; // 记录操作数
      } else {
        i++; // 跳过零值
      }
    }

    return operations;
  }




  public static void main(String[] args) {
    int[] temperature1 = {2, 4, 4};
    int[] temperature2 = {2, -2, -3, -1};

    System.out.println(regulateTemperatures(temperature1)); // 输出: 4
    System.out.println(regulateTemperatures(temperature2)); // 输出: 10
  }
}
