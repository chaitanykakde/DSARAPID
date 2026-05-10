class Main{
    public static void main(String[] args) {
        
        int r=4;
        int c=0;
        helperStars(r,c);
        helperStarsReverse(r, c);
    }

    
     static void helperStars(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("* ");
            c++;
            helperStars(r, c);
        }else{
            System.out.println();
            helperStars(r-1, 0);
        }
     
     }


     static void helperStarsReverse(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            
            c++;
            helperStarsReverse(r, c);
            System.out.print("* ");
        }else{
           
            helperStarsReverse(r-1, 0);
             System.out.println();
        }
     
     }
}