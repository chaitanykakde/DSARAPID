import java.util.*;

class TooLongWords{
    public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  int t=sc.nextInt();
  while(t-->0){
    String s=sc.next();
    if(s.length()<11){
      System.out.println(s);
    }else{
      String ans=s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
      System.out.println(ans);
    }
  }
}
}