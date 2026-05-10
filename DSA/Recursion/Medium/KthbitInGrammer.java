
class KthbitInGrammer{
    public static void main(String ar[]){
        System.out.println("res:"+kthGrammar(2,1));
    }

    public  static int kthGrammar(int n, int k) {
        int len=(int)Math.pow(2,n-1);
        if(k==1){
            return 0;
        }else if(k<=len/2){
            return kthGrammar(n-1,k);
        }else {
            int res=kthGrammar(n-1,k-(len/2));
            System.out.println(res);
            return (res==0)?1:0;
        }
    }
}