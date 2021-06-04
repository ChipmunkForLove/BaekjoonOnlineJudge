import java.util.*;
public class Solution{
    static LinkedList<Integer>[] adj;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        LinkedList<Pos> list;
        for(int i=0;i<T;i++){

            list = new LinkedList<>();
            int c = sc.nextInt();
            int hx = sc.nextInt();
            int hy = sc.nextInt();
            list.add(new Pos(hx,hy));
            for(int j=0;j<c;j++){
                int cx=sc.nextInt();
                int cy=sc.nextInt();
                list.add(new Pos(cx,cy));
            }
            int fx=sc.nextInt();
            int fy=sc.nextInt();
            list.add(new Pos(fx,fy));
            adj = new LinkedList[c+2];
            for(int j=0;j<c+2;j++){
                adj[j]= new LinkedList<>();
            }
            makegraph(list);
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            String res="sad";
            boolean[] visited = new boolean[c+2];
            while(!q.isEmpty()){
                int cur = q.poll();
                visited[cur]=true;
                if(cur==c+1){
                    res="happy";
                    break;
                }
                LinkedList<Integer> ends=adj[cur];
                for(int k=0;k<ends.size();k++){
                    if(!visited[ends.get(k)]) {
                        q.add(ends.get(k));
                    }
                }
            }
            System.out.println(res);
        }
    }
    public static void makegraph(LinkedList<Pos> list){
        LinkedList<Pos> l = list;
        for(int i=0;i<l.size()-1;i++){
            for(int j=i+1;j<l.size();j++){
                Pos p1=l.get(i);
                Pos p2=l.get(j);
                if(dist(p1,p2)<=1000){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

    }
    public static int dist(Pos p1,Pos p2){
        int dx=Math.abs(p1.x-p2.x);
        int dy=Math.abs(p1.y-p2.y);
        return dx+dy;
    }
}
class Pos{
    int x;
    int y;
    Pos(int x,int y){
        this.x=x;
        this.y=y;
    }
}
