import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        for(int i=0;i<N;i++){
            people[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        int res=0;
        for(int i=0;i<N;i++){
            if(i==0){
                res=people[i];
            }
            else{
                people[i]+=people[i-1];
                res+=people[i];
            }
        }
        System.out.println(res);
    }
}
