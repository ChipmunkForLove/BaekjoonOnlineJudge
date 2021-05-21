import java.util.*;
public class Solution{
    static LinkedList<Integer>[] adj;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Pair> q = new LinkedList<>();
        int[] px={0,1,0,-1,0,0};
        int[] py={1,0,-1,0,0,0};
        int[] pz={0,0,0,0,1,-1};
        int C=sc.nextInt();
        int R=sc.nextInt();
        int H=sc.nextInt();
        int numtomato=0;
        int[][][] map = new int[H][R][C];
        for(int i=0;i<H;i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        q.add(new Pair(i, j, k));
                    }
                }
            }
        }
        int day=-1;
        while (!q.isEmpty()) {
            int size = q.size();
            day++;
            while (--size >= 0) {
                Pair cur = q.poll();
                int x = cur.c;
                int y = cur.r;
                int z = cur.h;
                int nx = 0;
                int ny = 0;
                int nz = 0;
                for (int i = 0; i < 6; i++) {
                    nx =x+ px[i];
                    ny =y+ py[i];
                    nz =z+ pz[i];
                    if (nx >= 0 && nx < C && ny >= 0 && ny < R && nz >= 0 && nz < H) {
                        if (map[nz][ny][nx] == 0) {
                            map[nz][ny][nx] = 1;
                            q.add(new Pair(nz, ny, nx));
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<R;j++){
                for(int k=0;k<C;k++){
                    if(map[i][j][k]==0){
                        day=-1;
                        break;
                    }
                }
            }
        }
        System.out.println(day);
    }
}
class Pair{
    int r;
    int c;
    int h;
    Pair(int h,int r,int c){
        this.r=r;
        this.c=c;
        this.h=h;
    }

}
