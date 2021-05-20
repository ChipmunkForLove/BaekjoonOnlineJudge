import java.util.*;
public class Solution{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] px={0,1,0,-1};
        int[] py={1,0,-1,0};
        LinkedList<Integer> list = new LinkedList<>();
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String row = sc.next();
            for(int j=0;j<N;j++){
                map[i][j]=row.charAt(j)-'0';
            }
        }
        Stack<Pos> stack = new Stack<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                if(map[i][j]==0) continue;

                if(map[i][j]==1){
                    int cnt=0;
                    stack.push(new Pos(i,j));
                    visited[i][j]=true;
                    cnt++;
                    while(!stack.isEmpty()) {
                        Pos cur = stack.pop();
                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + py[k];
                            int nx = cur.x + px[k];
                            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                if (visited[ny][nx]) continue;
                                if (map[ny][nx] == 0) continue;
                                if(map[ny][nx]==1){
                                    visited[ny][nx]=true;
                                    stack.push(new Pos(ny,nx));
                                    cnt++;
                                }
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
class Pos{
    int y;
    int x;
    Pos(int y,int x){
        this.y=y;
        this.x=x;
    }
}
