import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r=sc.nextInt();
        int c=sc.nextInt();
        int[] pr={-1,0,1,0}; // north, east, south, west
        int[] pc={0,1,0,-1};
        int[][] map = new int[r][c];
        boolean[][] cleaned = new boolean[r][c];
        int curR = sc.nextInt(); // which r robot is located now
        int curC = sc.nextInt(); // which c robot is located now
        int curD = sc.nextInt();//robot current direction
        int cleanCount=1;
        //d : 0-north,1-east,2-south,3-west
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j]=sc.nextInt();
            }
        }
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(curR,curC,curD));
        cleaned[curR][curC]=true;
        boolean flag=false; //네 방향이 벽이거나 청소가 되어있으면 false
        while(!q.isEmpty()){
            Pos robot = q.poll();
           // System.out.println("r:"+robot.r+"/c:"+robot.c+"/d:"+robot.d);
            int nextDir=robot.d;
            flag=false;
            for(int k=0;k<4;k++){
                nextDir = turnLeft(nextDir);
                int nr=robot.r+pr[nextDir];
                int nc=robot.c+pc[nextDir];
                if(nr<r && nr>=0 && nc<c && nc>=0){
                    if(map[nr][nc]!=1 && !cleaned[nr][nc]){
                        q.add(new Pos(nr,nc,nextDir));
                        cleaned[nr][nc]=true;
                        cleanCount++;
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag){
                int backdir = stepBack(robot.d);
                int nr=robot.r+pr[backdir];
                int nc=robot.c+pc[backdir];
                if(nr>=0 && nr<r && nc>=0 && nc<c){
                    if(map[nr][nc]!=1){
                        q.add(new Pos(nr,nc,robot.d));
                    }
                }
            }
        }
        System.out.println(cleanCount);
    }
    public static int turnLeft(int D){
        return (D+3)%4;
    }
    public static int stepBack(int D){
        return (D+2)%4;
    }
}
class Pos{
    int r;
    int c;
    int d;
    Pos(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
