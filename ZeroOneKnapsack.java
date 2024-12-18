public class ZeroOneKnapsack {
  public static int zeroOneKnapsack(int capacity, int[] w, int[] v) {
    int n = w.length;
    int[][] dp = new int[n][capacity + 1]; // dp[i][c] 表示在前 i 个物品中，容量为 c 的最大价值
    for (int i = 0; i < n; i++) {
      for (int c = 0; c <= capacity; c++) {
        dp[i][c] = -1; // 初始化为 -1，表示未计算
      }
    }
    // 从最后一个物品开始递归
    return dfs(n-1, capacity,w,v,dp);
  }
  // 递归函数
  private static int dfs(int i, int c, int[] w, int[] v, int[][] dp) {
    if(i < 0 || c <= 0) {
      return 0; //没有更多的物品
    }
    if(dp[i][c] != -1) {
      return dp[i][c]; // 如果已经计算过，直接返回
    }
    // 如果当前物品不能装入背包
    if(c < w[i]) {
      dp[i][c] = dfs(i-1,c,w,v,dp);
      return dp[i][c];
    }
    // 选择不装入和装入当前物品的最大值
    dp[i][c] = Math.max(dfs(i-1,c,w,v,dp), dfs(i-1,c-w[i],w, v, dp) + v[i]);
    return dp[i][c];
  }
  public static void main(String[] args) {
    int capacity = 50;
    int[] w = {10, 20, 30}; // 物品重量
    int[] v = {60, 100, 120}; // 物品价值

    System.out.println("最大价值: " + zeroOneKnapsack(capacity, w, v));
  }
}
