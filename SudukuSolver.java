package recursion;

public class SudukuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(solve(board)){
            display(board);
        }else{
            System.out.println("Cannot solve");
        }
    }
    static boolean solve(int[][] board){
        int n=board.length;
        int col=-1;
        int row=-1;
        boolean emptyLeft=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            //if you found empty element in a row just break it.
            if(emptyLeft==false){
                break;
            }
        }
        //if you cannot found any empty element in an board just return true
        if(emptyLeft==true){
            display(board);
            return true;
            //sudoku is solved
        }
        //backtrack
        for(int i=1;i<=n;i++){
            if(isSafe(board,row,col,i)){
                board[row][col]=i;
                if(solve(board)){
                    return true; //found the answer
                }else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    static void display(int board[][]){
        for(int nums[]:board){
            for(int num:nums){
                System.out.print(num+" | ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        //check the row
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        //check the column
        for(int[] nums:board){
            if(nums[col]==num) return false;
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-(row%sqrt);
        int colStart=col-(col%sqrt);
        for(int i=rowStart;i<rowStart+sqrt;i++){
            for (int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
}
