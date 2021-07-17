import java.util.*;
public class Solution{
    static Long[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int N= sc.nextInt();
            arr=new Long[N+1][2];
            fibonacci(N);
            System.out.print(arr[N][0]+" ");
            System.out.println(arr[N][1]);
        }
    }
    public static Long[] fibonacci(int n){
        if(arr[n][0]!=null) return arr[n];
        if(n==0){
            arr[0][0]=1L;//0일 때 0호출 횟수
            arr[0][1]=0L;//0일 떄 1호출 횟수
        }
        else if(n==1){
            arr[1][0]=0L;//1일 때 0호출 횟수
            arr[1][1]=1L;//1일 때 1호출 횟수
        }
        else{
            arr[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
            arr[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
        }
        return arr[n];
    }
}
