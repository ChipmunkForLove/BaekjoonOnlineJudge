import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        boolean[] visited = new boolean[F+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S]=true;
        int cnt=-1;
        int cur=-1;
        visited[S]=true;
        while(cur!=G && !q.isEmpty()){
            int size = q.size();
            cnt++;
            while(--size>=0){
                cur=q.poll();
                if(cur==G) break;
                if(cur+U<=F && !visited[cur+U]){
                    visited[cur+U]=true;
                    q.add(cur+U);
                }
                if(cur-D>=1 && !visited[cur-D]){
                    visited[cur-D]=true;
                    q.add(cur-D);
                }
            }
        }
        if(cur!=G) System.out.println("use the stairs");
        else{
            System.out.println(cnt);
        }
    }
}
