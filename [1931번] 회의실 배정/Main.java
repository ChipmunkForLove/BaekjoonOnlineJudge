import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp," ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int cnt=0;
        int prev_time=0;
        for(int i=0;i<N;i++){
            if(prev_time<=times[i][0]){
                cnt++;
                prev_time=times[i][1];
            }
        }
        System.out.println(cnt);
    }
}

