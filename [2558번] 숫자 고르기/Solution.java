import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        boolean[] visited = new boolean[len+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<len;i++){
            nums[i]=sc.nextInt();
        }
        for(int i=1;i<len+1;i++){
            visited[i] = true;
            cycle(nums,visited,nums[i-1],i,list);
            visited[i] = false;
        }

        Collections.sort(list);
        LinkedList<Integer> ans = new LinkedList<>();
        int prev = -1;
        for(int i=0;i<list.size();i++){
            if(prev == list.get(i)) continue;
            prev = list.get(i);
            ans.add(prev);
        }
        System.out.println(ans.size());
        for(int i : ans){
            System.out.println(i);
        }
    }
    public static void cycle(int[]nums,boolean[] visited,int start,int last,LinkedList<Integer> list){
        if(!visited[start]){
            visited[start]=true;
            cycle(nums,visited,nums[start-1],last,list);
            visited[start]=false;
        }
        if(start==last){
            list.add(last);
        }
    }
}
