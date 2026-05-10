import java.util.*;
class IncreasingNumbers{
    public static void main(String[] args) {
         System.out.println(increasingNumbers(2));
    }
     public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(n==1){
            for (int i = 0; i <= 9; i++) {
                list.add(i);
            }
            return list;
        }
        dfs(1,0,n,list);
        return list;
    }

    private static void dfs(int start, int num, int len, ArrayList<Integer> list) {
        if(len==0){
            list.add(num);
            return;
        }
        for(int i=start;i<=9;i++){
            int curr=10*num+i; // --1 , --12 , --13
            dfs(i+1, curr, len-1, list);
        }
    }
}