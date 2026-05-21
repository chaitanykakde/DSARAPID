import java.util.*;
class PrimeNumbers1TON{
    public static void main(String[] args) {
        int n=100;
        boolean prime[]=new boolean[n+1];
        Arrays.fill(prime,true);

        //0 and 1 is not prime
        //so mark them alreay non prime
        prime[0]=false;
        prime[1]=false;

        //now iterate form 2 to 100 
        for(int i=2;i<=n;i++){
            //skip if already marked 
            if(!prime[i]){
                continue;
            }
            //mark the multiples false as for ex: multiples of 3  like 6,9,12,27. can never be prime

            for(int j=i*i;j<=n;j+=i){
                prime[j]=false;
            }
        }

        //print the prime numebrs
        for(int i=0;i<=n;i++){
            if(prime[i]){
                System.out.println("Number: "+i+ ":"+prime[i]);
            }
        }
    }
}