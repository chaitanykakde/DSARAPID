import java.util.*;

class StoneDivision{

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>(Arrays.asList(2L, 3L, 4L));

        System.out.println(stoneDivision(2, list));
    }
    public static int stoneDivision(long n, List<Long> s) {
    // Write your code here
       int[] ans=new int[2];
       
        getMoves(n,1,s,ans);
        return ans[1];
    }

    private static void getMoves(long n, long noOfPiles, List<Long> s, int[] ans) {
        for(long l:s){
             ans[0]+=1;
             System.out.println(l);
            if(l!=n &&  n%l==0 ){
                long result=n/l;
                System.out.println("Piles:"+n+"  "+"noofpiles:"+noOfPiles);
                getMoves(l, result, s, ans);
               

            }
            if(ans[0]>ans[1]){
                ans[1]=ans[0];
            }
             ans[0]-=1;
              
        }
    }
}
