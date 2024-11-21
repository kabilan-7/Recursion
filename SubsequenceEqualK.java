package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceEqualK {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int k = 2;
        List<Integer> list = new ArrayList<>();
        func(0,arr,list,0,k);
        for(List<Integer> list1 : res){
            System.out.print("[");
            System.out.print(" ");
            for (int ele : list1){

                System.out.print(ele + " ");

            }
            System.out.print("]");
            System.out.println();
        }
    }
    static void func(int idx, int arr[],List<Integer> list, int sum, int k){
        if(idx == arr.length) {
            if(sum == k){
                res.add(new ArrayList<>(list));
                return;
            }
             return;
        }
        list.add(arr[idx]);
        sum += arr[idx];
        func(idx+1,arr,list,sum,k);
        list.remove(list.size()-1);
        sum -= arr[idx];
        func(idx+1,arr,list,sum,k);
    }
}
