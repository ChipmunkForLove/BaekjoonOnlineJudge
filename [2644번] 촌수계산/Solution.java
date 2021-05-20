import java.util.*;
public class Solution{
    static LinkedList<Integer>[] adj;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int E = sc.nextInt();
        adj = new LinkedList[N + 1];
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < E; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            adj[p].add(c);
            adj[c].add(p);
        }
        dfs(visited,a,b,0);
        if(ans==0) ans=-1;
        System.out.println(ans);
    }
        public static void dfs(boolean[] visited,int start,int target,int cnt){
            LinkedList<Integer> cur = adj[start];
            visited[start]=true;
            //System.out.println("start:"+start);
            if(start==target){
                ans=cnt;
                return;
            }
            for(int i=0;i<cur.size();i++){
                if(!visited[cur.get(i)]) {
                    dfs(visited, cur.get(i), target,cnt+1);
                }
            }
      }
}
