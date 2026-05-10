import java.util.*;
class subSetArray{
    public static void main(String args[]){
        int arr[]={1,2,2};
        List<List<Integer>> ans=subSetDuplicate(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
        
    }

    static List<List<Integer>> subSet(int [] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList());
       
        for(int num:arr){
             int n=outer.size();
            for(int i=0;i<n;i++){
                 ArrayList<Integer> inner=new ArrayList<>(outer.get(i));
                 inner.add(num);
                 outer.add(inner);
                 
            }

        }
        return outer;

    }

     static List<List<Integer>> subSetDuplicate(int [] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList());
        int end=0;
        for(int i=0;i<arr.length;i++){
             int n=outer.size();
             int start=0;
             if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
             }
             end=outer.size()-1;
            for(int j=start;j<n;j++){
                 ArrayList<Integer> inner=new ArrayList<>(outer.get(j));
                 inner.add(arr[i]);
                 outer.add(inner);
                 
            }

        }
        return outer;

    }
}