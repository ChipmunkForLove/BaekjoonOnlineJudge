import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        LinkedList<Integer>[] adj = new LinkedList[N+1];
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N+1;i++){
            adj[i]=new LinkedList<>();
        }
        for(int i=0;i<E;i++){
            int s= sc.nextInt();
            int d= sc.nextInt();
            adj[s].add(d);
            adj[d].add(s);
        }
        int cnt=0;
        stack.push(1);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(visited[cur-1]) continue;
            visited[cur-1]=true;
            cnt++;
            for(int i=0;i<adj[cur].size();i++){
                stack.push(adj[cur].get(i));
            }
        }
        System.out.println(cnt-1);
    }
}
