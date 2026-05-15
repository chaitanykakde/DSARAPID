
class HandShakes{

    public static void main(String[] args) {
        System.out.println(getCount(8));
    }

        private static int getCount(int N) {
            int[] dp=new int[N+1];
            dp[0]=1;// we already know this anwser
            dp[2]=1;// this is waht we already know

            // this loop will moving from smallest iterations to the bigger iterations like form 4 to N. and 
            // it will ensure that we have the previous answers so we can calcaultat the biiger N dp Anwers
            for(int people=4;people<=N;people+=2){
                //now we are moving in the higher N
                // totalal ways wil be 0 at initially for Ex: N=4
                int totalWays=0; 
                //this loop simulates the 1st element can pair handshake with all possoible partners 
                //  for ex 1 to 2 ,  1 to 4 ,  1 to 6  so we can lock them and check the inside outside reamianing poeple and find anwers from them 
                for(int partner=2;partner<=people;partner+=2){
                    
                    int leftways= partner -2;
                    int rightways= people - partner;

                    totalWays+=dp[leftways] * dp[rightways];
                }
                dp[people]=totalWays;
            }

            return dp[N];
        }
}