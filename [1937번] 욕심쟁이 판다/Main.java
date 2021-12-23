import java.io.*;
import java.util.*;

class Main {
    public static int[] dc = {-1,0,1,0};
    public static int[] dr = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int ans = -1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans = Math.max(ans,dfs(dp,map,N,i,j));
            }
        }
        System.out.println(ans);
    }
    public static int dfs(int[][] dp,int[][] map,int N,int c,int r){
        if(dp[c][r]!=0){
            return dp[c][r];
        }
        dp[c][r]=1;
        int max=0;
        for(int i=0;i<4;i++){
            int nc = c+dc[i];
            int nr = r+dr[i];
            if(nc>=0 && nc<N && nr>=0 && nr<N){
                if(map[c][r]<map[nc][nr]){
                        dp[c][r] = Math.max(dp[c][r],dfs(dp,map,N,nc,nr)+1);
                }
            }
        }
        return dp[c][r];
    }
}
