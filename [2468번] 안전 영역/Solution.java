import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[] px={1,0,-1,0};
        int[] py={0,1,0,-1};
        boolean[][] visited;
        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=sc.nextInt();
                max = Math.max(max,map[i][j]);
            }
        }
        Queue<Pos> q = new LinkedList<>();
        int cnt=0;
        int maxisland=0;
        for(int i=0;i<=max-1;i++){
            visited = new boolean[N][N];
            cnt=0;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(visited[j][k]) continue;
                    if(map[j][k]>i && !visited[j][k]) {
                        q.add(new Pos(j,k));
                        visited[j][k]=true;
                        cnt++;
                    }
                    while(!q.isEmpty()){
                        Pos cur = q.poll();
                        int r=cur.r;
                        int c=cur.c;
                        for(int m=0;m<4;m++){
                            int nr=r+px[m];
                            int nc=c+py[m];
                            if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){
                                visited[nr][nc]=true;
                                if(map[nr][nc]>i){
                                    q.add(new Pos(nr,nc));
                                }

                            }
                        }
                    }
                }
            }
            maxisland=Math.max(maxisland,cnt);
        }
        System.out.println(maxisland);
    }
}
class Pos{
    int r;
    int c;
    Pos(int r,int c){
        this.r=r;
        this.c=c;

    }
}
