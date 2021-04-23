import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] T =new int[N];
        int[] P =new int[N];
        int[] max = new int[N+1];
        for(int i=0;i<N;i++){
            T[i]=scanner.nextInt();
            P[i]=scanner.nextInt();
        }
        for(int i=0;i<N;i++){
            if(i+T[i]<=N){
                max[i+T[i]]= Math.max(max[i+T[i]],max[i]+P[i]);
            }
            max[i+1]=Math.max(max[i],max[i+1]);
        }
        //output
        System.out.println(max[N]);
    }
}
