import java.util.*;
class MergeSort{
    public static void main(String[] args) {
       int[] arr={5,4,3,2,1};
       devide(arr, 0, arr.length);
       System.out.println(Arrays.toString(arr));
    }
    static void devide(int arr[], int s,int e){
        if(s==e){
            return;
        }
        int mid=(s+e)/2;
        devide(arr,s,mid);
        devide(arr,mid+1,e);
        merge(arr,s,mid+1,e);
    }
    static void merge(int arr[],int s,int mid,int e){
        int i=s;
        int j=mid;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<mid && j<=e){
            if(arr[j]<=arr[i]){
                list.add(arr[j]);
                j++;
            }else if(arr[i]<=arr[j]){
                list.add(arr[i]);
                i++;
            }
        }
        
        //remaining elelemts in 1st half
        while(i<mid){
           list.add(arr[i]);
           i++;
        }
        
        //reaming elemets in 2nd half 
        while(j<=e){
            list.add(arr[j]);
            j++;
        }
        
        for(int k=0;k<list.size();k++){
            arr[s+k]=list.get(k);
        }  
        
    }
}