
class PowerSum{

    public static void main(String[] args) {
         System.out.println(powerSum(100, 2));
    }
    public static int powerSum(int X, int N) {
    // Write your code here
        return getCount(0,X,N,1);
    }
    public static int getCount(int cur_Sum,int x,int power, int cur_Num){
        int powerSum=(int)Math.pow(cur_Num, power);
        int count=0;
        if(cur_Sum + powerSum > x){
            return 0;
         }
         if(cur_Sum + powerSum == x){
            return 1;
         }

        //calling getCount ignoring current num 
        count+= getCount(cur_Sum, x, power, cur_Num+1);

        //calling getCount taking current num 
        count+=getCount( cur_Sum + powerSum, x, power, cur_Num+1);

        return count;

    }
}