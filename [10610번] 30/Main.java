import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] arr = new int[10];
        long sum=0;
        for(int i=0;i<N.length();i++){
            int num = N.charAt(i)-'0';
            arr[num]++;
            sum +=num;
        }
        if(arr[0]==0 || sum%3!=0 ){
            System.out.println("-1");
        }
        else{
            String res="";
            for(int i=9;i>=0;i--){
                for(int j=0;j<arr[i];j++){
                    res=res+i;
                }
            }
            System.out.println(res);
        }
    }
}
