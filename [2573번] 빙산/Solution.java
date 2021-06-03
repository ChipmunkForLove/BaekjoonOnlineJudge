import java.util.*;
public class Solution{
    static int[][] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();//map height
        int c=sc.nextInt();//map width
        map = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j]=sc.nextInt();
            }
        }
        int year=0;
        while(true){
            int icebergnumber = icebergnum(r,c);
            if(icebergnumber==0){
                year=0;
                break;
            }
            else if(icebergnumber>=2){
                break;
            }
            year++;
        }
        System.out.println(year);
    }
    public static int icebergnum(int r,int c){
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        int[][] temp = new int[r][c];
        int icebergnum=0;
        int[] pr={1,0,-1,0};
        int[] pc={0,-1,0,1};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]==0) continue;
                if(map[i][j]>0 && !visited[i][j]){
                    q.add(new Pos(i,j));
                    visited[i][j]=true;
                    icebergnum++;
                }
                while(!q.isEmpty()){
                    Pos cur = q.poll();
                    int nr;
                    int nc;
                    int zeronum=0;
                    for(int k=0;k<4;k++){
                        nr=cur.r+pr[k];
                        nc=cur.c+pc[k];
                        if(nr>=0 && nr<r && nc>=0 && nc<c){
                            if(map[nr][nc]==0) zeronum++;
                            if(map[nr][nc]>0 && !visited[nr][nc]){
                                q.add(new Pos(nr,nc));
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    if(map[cur.r][cur.c]-zeronum<0){
                        temp[cur.r][cur.c]=0;
                    }
                    else{
                        temp[cur.r][cur.c]=map[cur.r][cur.c]-zeronum;
                    }
                }
            }
        }
        map=temp;
        return icebergnum;
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
