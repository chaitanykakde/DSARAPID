import java.util.*;

class SubsetsLeetcode78{
    public static void main(String args[]){
       int arr[]={5,5,5,5,2,3};
       List<List<Integer>> ans=new ArrayList<>();
      ans.add(new ArrayList<>());
       subsetsDuplicated(arr,0,ans);
       System.out.println(ans);
    }
    static void subsets(int arr[],int index,List<List<Integer>> ans){
        if(index==arr.length){
            return;
        }
        int size=ans.size();
       for(int i=0;i<size;i++){
           List<Integer> temp=new ArrayList<>(ans.get(i));
            temp.add(arr[index]);
            ans.add(temp);
        }
        subsets(arr, index+1, ans);
    }

    static void subsetsBacktraking(int arr[],int index,List<List<Integer>> ans,List<Integer> temp){
        ans.add(new ArrayList<>(temp));
       for(int i=index;i<arr.length;i++){
              temp.add(arr[i]);
              subsetsBacktraking(arr, i+1, ans, temp);
              temp.remove(temp.size()-1);
       }
    }        

    static void subsetsDuplicated(int arr[],int index,List<List<Integer>> ans){
        if(index==arr.length){
            return;
        }
        int size=ans.size();
        
       for(int i=index;i<size;i++){
            if(i > index && arr[i] == arr[i-1]) continue;


           List<Integer> temp=new ArrayList<>(ans.get(i));
            temp.add(arr[index]);
            ans.add(temp);
        }
        subsetsDuplicated(arr, index+1, ans);
    } 

}


    

