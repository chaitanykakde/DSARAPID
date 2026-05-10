class countGoodNumbers{

    public static int M=1000000007;
    public static void main(String[] args) {
        System.out.println(countGoodNumbers1(1));
    }

    private static int countGoodNumbers1(long n) {
        
        return (int)(findPower(5,(n+1)/2) * findPower(4,(n/2)) % M);
    }

    private static long findPower(long a, long b) {
        if(b==0){
            return 1;
        }
        long result=findPower(a, b/2);
        result=result*result %M;
        if(b%2==1){
            result=result*a %M;
        }
       return result;
    }
}