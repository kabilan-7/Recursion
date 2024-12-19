package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean board[][]=new boolean[n][n];
        queens(board,0,ans);
        return ans;
    }
    private static void queens(boolean[][] board,int row,List<List<String>> ans){
        if(row==board.length){
            addtoList(board,ans);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(safe(board,row,col)){
                board[row][col]=true;
                queens(board,row+1,ans);
                board[row][col]=false;
            }
        }
    }
    private static boolean safe(boolean[][] board,int row,int col){
        //check for vertical
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        // diagonal left check
        int MAXleft=Math.min(row,col);
        for(int i=1;i<=MAXleft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        //diagonal right check
        int MAXright=Math.min(row,board.length-col-1);
        for(int i=1;i<=MAXright;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    private static void addtoList(boolean board[][],List<List<String>> ans){
        List<String> list=new ArrayList<>();
        for(boolean b[]:board){
            StringBuilder str=new StringBuilder();

            for(boolean bool:b){
                if(bool){
                    str.append('Q');
                }else{
                    str.append('.');
                }
            }
            list.add(str.toString());

        }
        ans.add(list);

    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }
}
