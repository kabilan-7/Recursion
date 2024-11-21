package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceEqualK {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int k = 2;
        List<Integer> list = new ArrayList<>();

        int count = func2(0,arr,list,0,k,0);
        System.out.println(count);
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
    //if we want to print any one subsequence
    static boolean func1(int idx, int arr[],List<Integer> list, int sum, int k){
        if(idx == arr.length) {
            if(sum == k){
                res.add(new ArrayList<>(list));
                return true;
            }
            return false;
        }
        list.add(arr[idx]);
        sum += arr[idx];
        if(func1(idx+1,arr,list,sum,k) == true) return true;
        list.remove(list.size()-1);
        sum -= arr[idx];
        if(func1(idx+1,arr,list,sum,k) == true) return true;
        return false;
    }
    //if we want to print the count of subsequence
    static int func2(int idx, int arr[],List<Integer> list, int sum, int k,int count){
        if(idx == arr.length) {
            if(sum == k){
                res.add(new ArrayList<>(list));
                return 1;
            }
            return 0;
        }
        list.add(arr[idx]);
        sum += arr[idx];
        int left = func2(idx+1,arr,list,sum,k,count);
        list.remove(list.size()-1);
        sum -= arr[idx];
        int right  = func2(idx+1,arr,list,sum,k,count);
        return left + right;
    }
}
