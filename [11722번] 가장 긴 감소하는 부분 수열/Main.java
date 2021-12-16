import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(str," ");
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        dp[0]=1;
        for(int i=1;i<N;i++){
            dp[i]=1;
           for(int j=0;j<i;j++){
                if(arr[j]>arr[i] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
           }
        }
        int max=-1;
        for(int i=0;i<N;i++){
            max= Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}

