import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] w, dp;
    static final int INF = 16000000;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N][(1 << N) - 1];
        w = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0,1));
    }

    public static int dfs(int node, int visit) {

        if (visit == (1 << N) - 1) { // base case
            if (w[node][0] == 0)
                return INF;
            return w[node][0];
        }

        if (dp[node][visit] != INF) {
            return dp[node][visit];
        }

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && w[node][i] != 0) {
                dp[node][visit] = Math.min(dp[node][visit], dfs(i, visit | (1 << i)) + w[node][i]);
            }
        }
        return dp[node][visit];
    }

}
