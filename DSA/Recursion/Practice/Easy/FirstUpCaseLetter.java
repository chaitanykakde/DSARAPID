// First uppercase letter in a string (Iterative and Recursive)
// Last Updated : 9 Dec, 2022
// Given a string find its first uppercase letter
// Examples : 

// Input : geeksforgeeKs
// Output : K

// Input  : geekS
// Output : S

import java.util.*;

class FirstUpCaseLetter{
    public static void main(String args[]){
         String s="Geeksforgeess";
         System.out.println(findUpperCaseLetter(s));

    }
    static char findUpperCaseLetter(String s){
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)>=65 && s.charAt(0)<=90){
            return s.charAt(0);
        }
        return findUpperCaseLetter(s.substring(1));
    }
}