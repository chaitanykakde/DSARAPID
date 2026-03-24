class Main{
    public static void main(String args[]){
        //rev(123);
        System.out.println(rev1(55554444));
    }
    static int sum =0;
    // reverse normal
    static void rev(int n){
        if(n==0){
            return ;
        }

            int rem=n%10;
            sum=sum*10+rem;
            rev(n/10); 
    
    }

    //reverse usign uheloper function 
    static int rev1(int n){
        int a=(int)Math.log10(n)+1;
        return helper(n,a);
    }

    static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return rem*(int)Math.pow(10,digits-1)+helper(n/10,digits-1);
    }
        
}