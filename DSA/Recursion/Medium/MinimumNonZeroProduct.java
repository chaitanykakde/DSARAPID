class MinimumNonZeroProduct {

    public static long MOD=1000000007;
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(6));
    }
    public static int minNonZeroProduct(int p) {
          long max=(1L<<p)-1;
          long secondMax=max-1;
          long power=(1L<<(p-1))-1;
          return (int)((myPow(secondMax % MOD, power) %MOD * (max % MOD)) % MOD);
    }
   public static long myPow(long x, long n) {
        if(n==0){
            return  1;
        }
        if(n<0){
            return myPow(1/x, -n);
        }
        if(n%2==0){
            return myPow(((x % MOD) * (x% MOD)) %MOD , n/2) % MOD;
        }
        return ((x % MOD) *myPow(((x % MOD )*  (x % MOD)) % MOD, (n-1)/2)) % MOD;
    }
}
