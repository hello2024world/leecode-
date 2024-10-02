public class leecode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (target > matrix[row-1][col-1] || target < matrix[0][0]){
            return false;
        }
        int x = row/2;
        int y = col/2;
        boolean isExist = dfs(matrix,x,y,target);
        if (isExist){
            return true;
        }
        return false;
    }
    public boolean dfs(int[][] matrix,int x,int y,int target){
        //超出边界都是false
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0){
            return false;
        }
        //不足点：一增一减，导致无限迭代
        if (matrix[x][y] == target){
            return true;
        }else if (matrix[x][y] < target){
            if (dfs(matrix, x, y-1, target) || dfs(matrix, x-1, y, target)){
                return true;
            }
            return false;
        }else{
            if (dfs(matrix, x+1, y, target) || dfs(matrix, x, y+1, target)){
                return true;
            }
            return false;
        }
    }

}
