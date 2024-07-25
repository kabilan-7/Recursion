package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
        String string = "abc";
        helper(string,"");
        for (String s:list){
            System.out.println(s);
        }
    }
    static void helper(String s,String ans){
        if(s.length()==0){
            list.add(ans);
            return;
        }
        helper(s.substring(1),ans+s.charAt(0));
        helper(s.substring(1),ans);
    }
}
