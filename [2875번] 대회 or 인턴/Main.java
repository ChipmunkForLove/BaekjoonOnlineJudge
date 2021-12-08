import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = N+M;
        for(int i=M;i>=0;i--){
          if(N < i*2) continue;
          if(T-(i*3)-K>=0) {
              System.out.println(i);
              break;
          }
        }
    }
}
