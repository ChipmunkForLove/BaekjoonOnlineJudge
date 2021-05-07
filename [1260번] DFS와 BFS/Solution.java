
import java.util.*;
import java.io.IOException;
public class Solution{
    public static void main(String[] args) throws IOException {
        int answer=0;
        //input
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int V=scanner.nextInt();
        LinkedList<Integer>[] adj = new LinkedList[N+1];
        for(int i=0;i<N+1;i++){
            adj[i]=new LinkedList<>();
        }
        for(int i=0;i<M;i++){
            int s=scanner.nextInt();
            int e=scanner.nextInt();
            adj[s].add(e);
            adj[e].add(s);
        }
        dfs(new boolean[N+1],V,adj);
        System.out.println();
         bfs(V,adj);
        //output
    }
    public static void dfs(boolean[] visited,int start,LinkedList<Integer>[] adj){
        System.out.print(start+" ");
        visited[start]=true;
        LinkedList<Integer> des = adj[start];
        Collections.sort(des);
        for(Integer i : des){
            if(!visited[i]){
                dfs(visited,i,adj);
            }
        }
    }
    public static void bfs(int start,LinkedList<Integer>[] adj){
        boolean[] visited = new boolean[adj.length+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(q.size()>0){
            int v = q.poll();
            System.out.print(v+" ");
            LinkedList<Integer> cur = adj[v];
            Collections.sort(cur);
            for(int i=0;i<cur.size();i++){
                if(!visited[cur.get(i)]) {
                    q.add(cur.get(i));
                    visited[cur.get(i)]=true;
                }
            }
        }
    }
}
