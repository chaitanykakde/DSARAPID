
class SuperDigit{
    public static void main(String[] args) {
        System.out.println(superDigit("9875", 4));
    }
    public static int superDigit(String n, int k) {
    // Write your code here
       

        //find sum
        int sum=0;
        for(int i=0;i<n.length();i++){
              sum+=n.charAt(i)-'0';
        }
        
        //multiply the sum with k
        sum=sum*k;
        
        return getDigit(Integer.toString(sum));
    }

    public static int getDigit(String n){
          if(n.length()==1){
            return Integer.parseInt(n);
          }
        //find sum
        long sum=0;
        for(int i=0;i<n.length();i++){
              sum+=n.charAt(i)-'0';
        }
        return getDigit(Long.toString(sum));
    }
}