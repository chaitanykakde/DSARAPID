class Divisors{
    public static void main(String[] args) {
        //  for (int i = 0; i < 20; i++) {
             
        //      System.out.println("Number :"+i+" & Divisors Count:"+getDivisorsCount(i));
        //  }
        int n=100;
        int[] div=new int[n+1];
          getAllDivisorsCount(div, n);
        for(int i=1;i<=n;i++){
            System.out.println("No:"+i+" & Divisors Count:"+div[i]); 
        }
         
         
         }
    

    static int getDivisorsCount(int n){
        int count=0;
         for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    count++;
                    if(i!=n/i){
                        count++;
                    }
                }
         }
         return count;
    }

    static void getAllDivisorsCount(int[] div,int n){
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j+=i){
                div[j]++;
            }
        }
    }
}