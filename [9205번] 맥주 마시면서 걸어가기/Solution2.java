import java.util.*;
public class Solution{
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
            int[][] map = new int[c+2][c+2];
            for(int j=0;j<c+2;j++){
                for(int k=0;k<c+2;k++){
                    if(j!=k) {
                        map[j][k]=10000;
                        map[k][j]=10000;
                    }
                }
            }
            //정점을 바탕으로 인접 그래프생성
            for(int j=0;j<list.size();j++){
                for(int k=0;k<list.size();k++){
                    if(j==k) continue;
                    int distance = dist(list.get(j),list.get(k));
                    if(distance<=1000){
                        map[j][k]=1;
                        map[k][j]=1;
                    }
                }
            }
            String res="sad";
            if(map[0][c+1]==1){
                res="happy";
            }
            else {
                //플로이드 와샬, 시작점은 0, 페스티벌은 c+1, 편의점은 1~c
                map = floyd(map, c + 2);
                if(map[0][c+1]<10000) res="happy";
            }
            System.out.println(res);
        }
    }
    public static int dist(Pos a,Pos b){
        int dx=Math.abs(a.x-b.x);
        int dy=Math.abs(a.y-b.y);
        return dx+dy;
    }
    public static int[][] floyd(int[][] map,int len){
        for(int k=0;k<len;k++){//중간지점
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    if(i==j) continue;
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }
        return map;
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
