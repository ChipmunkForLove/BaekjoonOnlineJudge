import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firLine = br.readLine().split(" ");
        int N = Integer.parseInt(firLine[0]);
        int K = Integer.parseInt(firLine[1]);
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
           arr[i]=Integer.parseInt(br.readLine());
        }
        int cnt=0;
        for(int i=N-1;i>=0;i--){
            if(K>=arr[i]){
                cnt+=(K/arr[i]);
                K= K%arr[i];
            }
        }
        System.out.println(cnt);
    }
}

