import java.util.*;
public class Main{
    static int N;
    static int[][] w;
    static int[][] dp;
    static int INF;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        INF = 10000000;
        N = sc.nextInt();
        w= new int[N][N];
        dp = new int[N][(1<<N)];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],INF);
            for(int j=0;j<N;j++){
                w[i][j]= sc.nextInt();
            }
        }
        System.out.println(dfs(0,1));
    }
    public static int dfs(int node,int visit){
        if(visit == (1<<N)-1){   //base
            if(w[node][0]==0){
                return INF;
            }
            return w[node][0];
        }
        if(dp[node][visit]!=INF) return dp[node][visit];

        for(int i=0;i<N;i++){
            if(w[node][i]!=0 && (visit & (1<<i))==0 ) {
                dp[node][visit] = Math.min(dp[node][visit], dfs(i, (visit | (1 << i))) + w[node][i]);
            }
        }
        return dp[node][visit];
    }
}
