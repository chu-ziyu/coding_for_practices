import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class EncryptedNumber1209 {
    public static String findNumber(List<Integer> numbers) {
      // 模拟加密过程
      while (numbers.size() > 2) {
        List<Integer> nextNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
          // 计算相邻数字的和，取个位
          nextNumbers.add((numbers.get(i) + numbers.get(i + 1)) % 10);
        }
        numbers = nextNumbers; // 更新列表为下一轮结果
      }

      // 将最终两个数字转化为字符串并返回
      return "" + numbers.get(0) + numbers.get(1);
    }
    // method 2
  public static String findNumber2(List<Integer> numbers) {
      int M = numbers.size();
    // 外层循环：控制“压缩”过程的轮次
    for (int i = 0; i < M - 2; i++) {
      // 内层循环：对当前轮次的数组执行逐位相加并取个位数
        for (int j = 0; j < M - i - 1; j++) {
          numbers.set(j, (numbers.get(j) + numbers.get(j + 1)) % 10);
        }
      }
      return String.valueOf(numbers.get(0) % 10) + String.valueOf(numbers.get(1) % 10);
  }

    public static void main(String[] args) {
      // 测试用例
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
      System.out.println(findNumber2(numbers)); // 输出: 82
      List<Integer> numbers1 = Arrays.asList(4, 5, 6, 7);
      System.out.println(findNumber2(numbers1));
    }
}
