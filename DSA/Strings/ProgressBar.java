import java.util.*;
class ProgressBar{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int no=sc.nextInt();
        while(no-->0){
           int n=sc.nextInt();
           int s=sc.nextInt();
           int t=sc.nextInt();

           int arr[]=new int[n];
           int result=(n*s*t)/100;
           for(int i=0;i<n;i++){
            if(result>=s){
               arr[i]=s;
               result-=s;
            }else if(result < s && result >0){
                arr[i]=result;
                result=0;
            }else{
                arr[i]=result;
            }
             
           }

           for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
           }
        }

    }
}