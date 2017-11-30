import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.function.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        //Function<String,BigDecimal> f=s->new BigDecimal(s);
        Comparator<String> c=(x,y)->{
            if(x.length()!=y.length())
                return x.length()-y.length();
            else{
            int ans=new BigDecimal(x).compareTo(new BigDecimal(y));
            return ans; 
            }
        };
        List<String> l=Arrays.asList(unsorted);
        l.stream().sorted(c).forEach(x->System.out.println(x));
    }//end of main
}//end of class
