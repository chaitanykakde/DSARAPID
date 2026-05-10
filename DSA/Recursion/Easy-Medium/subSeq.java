import java.util.*;
class subSeq{
    public static void main(String args[]){
        String s="abc";
       ArrayList<String> ans= sequenceArrayList("",s);
       System.out.println(ans);
    }

static void sequence(String p,String up){
    if(up.isEmpty()){
        System.out.println(p);
        return;
    }
    sequence(p+up.charAt(0),up.substring(1));
    sequence(p,up.substring(1));
}

static ArrayList<String> sequenceArrayList(String p,String up){
    ArrayList<String> ans=new ArrayList<>();
    if(up.isEmpty()){
        if(!p.isEmpty())  ans.add(p);
        
        return ans;
        
    }
   ArrayList<String> ignore= sequenceArrayList(p+up.charAt(0),up.substring(1));
    ArrayList<String> notIgnore=sequenceArrayList(p,up.substring(1));

    ignore.addAll(notIgnore);
    return ignore;
}
}