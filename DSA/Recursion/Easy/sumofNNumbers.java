class Main{
    public static void main(String[] args) {
        
       System.err.println("Sum:"+sum(50));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }else{
            return n+sum(n-1);
            
        }
    }
}