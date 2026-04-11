import java.util.*;
class DecodeWays{
    public static void main(String args[]){
        String up="12120";
        String p="";
        String pup="";
        decode(p,pup,up);
        
    }
    static void decode(String p,String pup,String up){
        if(up.length()==0 && pup.length()==0){
            System.out.println(p);
            return;
        }else if(up.length()==0 && pup.length()>0){
            return;
        }
        //check does it previous unprocessed string
        if(pup.length()==1){
             int digit=Integer.parseInt(pup+up.charAt(0));
             char c=(char)(64+digit);
             pup="";
             if(digit>=1 && digit <=26){
                 decode(p+c,pup,up.substring(1));  
             }else{
                return;
             }
             
        }else{
            //process normally
            int digit=Integer.parseInt(up.charAt(0)+"");
             char c=(char)(64+digit);
             if(digit==0){
                return;
             }else{
                //call for next digit by considering current digit
                decode(p+c,pup,up.substring(1));
                //call for next digit by ignoring current to form a larger character
                decode(p,pup+Integer.toString(digit),up.substring(1));
             }
        }
    }
}