import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution{
    static char[][] map;
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        map = new char[N][M];
        visited= new boolean[N][M];
        for(int i=0;i<N;i++){
            String line = scanner.next();
           for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j);
            }
        }
        int answer=0;
        Queue<Point> q = new LinkedList<>();
        visited[0][0]=true;
        q.add(new Point(0,0,1));
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x==N-1 && cur.y == M-1){
                answer= cur.d;
                break;
            }
            for(int i=0;i<4;i++) {
                int newx = cur.x + dx[i];
                int newy = cur.y + dy[i];
                if(newx<0 || newx >N-1 || newy<0 || newy>M-1) continue;
                if(visited[newx][newy]) continue;
                if(map[newx][newy]=='0') continue;
                visited[newx][newy]=true;
                q.add(new Point(newx,newy,cur.d+1));
            }
        }
        System.out.println(answer);
    }
}
class Point{
    int x;
    int y;
    int d;
    Point(int x,int y,int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
}
