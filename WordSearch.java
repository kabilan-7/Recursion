package recursion;
class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,visited,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char board[][],String word,boolean visited[][],int i,int j,int index){
        if(index==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]|| board[i][j]!=word.charAt(index)) return false;
        visited[i][j]=true;
        if(backtrack(board,word,visited,i+1,j,index+1) ||
                backtrack(board,word,visited,i-1,j,index+1) ||
                backtrack(board,word,visited,i,j+1,index+1) ||
                backtrack(board,word,visited,i,j-1,index+1)) return true;
        visited[i][j]=false;
        return false;

    }
}
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char c[][]={{
            'A','B','C','E'
        },{
            'S','F','C','S'
        },{
            'A','D','E','E'
        }};
        System.out.println(solution.exist(c,"ABCCED"));
    }
}
