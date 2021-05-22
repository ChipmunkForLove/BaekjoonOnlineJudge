import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(N);
        int cnt=-1;
        int cur=-1;
        while(cur!=K){
            int s = q.size();
            cnt++;
            while(--s>=0){
                cur = q.poll();
                visited[cur]=true;
                if(cur==K) break;
                int a= cur-1;
                int b = cur+1;
                int c= cur*2;
                if(a>=0 && a<=100000 && !visited[a]){
                    q.add(a);
                }
                if(b>=0 && b<=100000 && !visited[b]){
                    q.add(b);
                }
                if(c>=0 && c<=100000 && !visited[c]){
                    q.add(c);
                }
            }
        }
        System.out.println(cnt);
    }
}
