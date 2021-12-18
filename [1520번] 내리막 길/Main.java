import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int  M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N+1][M+1];
        boolean[][] visited = new boolean[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer tempst = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(tempst.nextToken());
                dp[i][j] =-1;
            }
        }

        dfs(dp,map,1,1);
        System.out.println(dp[1][1]);
    }
    public static int dfs(int[][] dp,int[][] map,int c,int r){
        int[] pc = {-1,0,1,0};
        int[] pr = {0,1,0,-1};
        if(c==N && r==M){
            return 1;
        }
        if(dp[c][r]!=-1){
            return dp[c][r];
        }
        dp[c][r]=0;
        for(int i=0;i<4;i++){
            int newc=c+pc[i];
            int newr=r+pr[i];
            if(newc>0 && newr>0 && newc<=N && newr<=M){
                if(map[newc][newr]<map[c][r]){
                    dp[c][r]+=dfs(dp,map,newc,newr);
                }
            }
        }
        return dp[c][r];
    }
}
