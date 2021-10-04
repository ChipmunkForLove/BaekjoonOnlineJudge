import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static LinkedList<Node>[] adj;
    public static boolean[] visited;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new LinkedList[N+1];
        for(int i=1;i<N+1;i++){
            adj[i] = new LinkedList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[p].add(new Node(c,w));
            adj[c].add(new Node(p,w));
        }
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N+1];
        q.add(new Node(1,0));
        visited[1]=true;
        Node startNode = findMax(q);

        visited=new boolean[N+1];
        q.add(new Node(startNode.idx,0));
        visited[startNode.idx]=true;
        Node maxLength = findMax(q);

        System.out.println(maxLength.w);
    }
    public static Node findMax(Queue<Node> queue){
        Queue<Node> q = queue;
        int nodeNum=0;
        int max=0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(adj[cur.idx]==null) continue;
            LinkedList<Node> list = adj[cur.idx];
            if(list.size()==1){
                if(max<cur.w){
                    max=cur.w;
                    nodeNum=cur.idx;
                }
            }
            for(int i=0;i<list.size();i++){
                Node des = list.get(i);
                if(visited[des.idx]) continue;
                visited[des.idx]=true;
                q.add(new Node(des.idx,cur.w+des.w));
            }
        }
        return new Node(nodeNum,max);
    }
}
class Node {
    int idx;
    int w;
    Node(int idx,int w){
        this.idx=idx;
        this.w=w;
    }
}
