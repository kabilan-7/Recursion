package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<Integer> subset=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,0,subset,ans);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    static void helper(int arr[],int i,List<Integer> subset,List<List<Integer>> ans){
        if(i>=arr.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[i]);
        helper(arr,i+1,subset,ans);
        subset.remove(subset.size()-1);
        helper(arr,i+1,subset,ans);
    }
}
