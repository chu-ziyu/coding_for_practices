import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaximumSkills1209 {
  public static long getMaxSkillSum(List<Integer> expertise, List<Integer> skill) {
    long res = 0;
    HashMap<Integer, Long> map = new HashMap<>();
    map.put(0, 0L);
    int curr = 0;
    long sum = 0;
    int i = 0;
    for(int e : expertise) {
      sum += skill.get(i);
      curr += (e == 0 ? -1 : 1);
      if(map.containsKey(curr)) {
        res = Math.max(res, sum - map.get(curr));
        map.put(curr, Math.min(map.get(curr), sum));
      } else {
        map.put(curr, sum);
      }
      i++;
    }
    return res;
  }
  public static long getMaxSkillSum2(List<Integer> expertise, List<Integer> skill) {
    int n = expertise.size();

    // Map to store the first occurrence of (marketingCount - developerCount)
    HashMap<Integer, Integer> diffIndexMap = new HashMap<>();
    diffIndexMap.put(0, -1); // Base case for prefix sum difference

    int marketingCount = 0;
    int developerCount = 0;
    long maxSkillSum = 0;
    long currentSkillSum = 0;

    for (int i = 0; i < n; i++) {
      // Update counts based on expertise
      if (expertise.get(i) == 0) {
        marketingCount++;
      } else {
        developerCount++;
      }

      // Update the current skill sum
      currentSkillSum += skill.get(i);

      // Calculate the difference between marketing and developer counts
      int diff = marketingCount - developerCount;

      // Check if this difference has been seen before
      if (diffIndexMap.containsKey(diff)) {
        // Calculate the skill sum for the subarray
        int prevIndex = diffIndexMap.get(diff);
        long subArraySkillSum = currentSkillSum;
        if (prevIndex != -1) {
          subArraySkillSum -= skillSumUpTo(skill, prevIndex);
        }

        // Update the maximum skill sum
        maxSkillSum = Math.max(maxSkillSum, subArraySkillSum);
      } else {
        // Store the first occurrence of this difference
        diffIndexMap.put(diff, i);
      }
    }

    return maxSkillSum;
  }

  private static long skillSumUpTo(List<Integer> skill, int index) {
    long sum = 0;
    for (int i = 0; i <= index; i++) {
      sum += skill.get(i);
    }
    return sum;
  }
  public static void main(String[] args) {
    List<Integer> expertise = Arrays.asList(0,0,0,1);
    List<Integer> skill = Arrays.asList(10,2,3,4);
    System.out.println(getMaxSkillSum2(expertise, skill));
  }
}
