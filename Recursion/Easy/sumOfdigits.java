class Main{
    public static void main(String[] args) {
        System.err.println("Sum of digits:"+sumOfDigits(3437));
        
        System.err.println("Sum of digits:"+prodOfDigits(3437));
    }

    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return (n%10) +sumOfDigits(n/10);
    }
    static int prodOfDigits(int n){
        if(n%10==n){
            return n;
        }
        return (n%10) *prodOfDigits(n/10);
    }
}