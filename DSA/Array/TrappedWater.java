class TrappedWater {

    public static void main(String[] args) {
        int[] arr={1,2,3,9,0,0,0,7};
        System.out.println(maxWater2(arr));
            }
    public static int maxWater1(int arr[]) {
        // code here
      int t=0;
      int[] prefix=new int[arr.length];
      int[] suffix=new int[arr.length];
      prefix[0]=arr[0];
      suffix[arr.length-1]=arr[arr.length-1];
      for(int i=1;i<arr.length;i++){
        prefix[i]=Math.max(arr[i],prefix[i-1]);
      }
      for(int i=arr.length-2;i>=0;i--){
          suffix[i]=Math.max(arr[i],suffix[i+1]);
      }
      
      for(int i=0;i<arr.length;i++){
          t+=Math.min(prefix[i],suffix[i])-arr[i];
      }
      return t;
    }

    public static int maxWater2(int arr[]) {
     int t=0;
     int leftMax=0,rightMax=0;
     int l=0;
     int r=arr.length-1;
        // code here
        while(l<r){
            if(arr[l]<=arr[r]){
                if(leftMax>arr[l]){
                    t+=leftMax-arr[l];
                }else{
                    leftMax=arr[l];
                }
                l+=1;
            }else{
                if(rightMax>arr[r]){
                    t+=rightMax-arr[r];
                    
                }else{
                    rightMax=arr[r];
                }
                r--;
            }
        }
      return t;
    }
}