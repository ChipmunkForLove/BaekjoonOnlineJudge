import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            classes[i][0]= Integer.parseInt(st.nextToken());
            classes[i][1]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<classes.length;i++){
            if (pq.isEmpty()) {
                pq.add(classes[i][1]);
            }
            else{
                if(classes[i][0]<pq.peek()){
                    pq.add(classes[i][1]);
                }
                else{
                    pq.poll();
                    pq.add(classes[i][1]);
                }
            }
        }
        System.out.println(pq.size());
    }
}
