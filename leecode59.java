public class leecode59 {
    public int[][] generateMatrix(int n) {
        int[][] dic = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        int x = 0;
        int y = 0;
        int[][] result = new int[n][n];
        for (int i = 1;i <= n*n;i++){
            //到达边界条件,或者已经填写，换向
            if(x + dic[index%4][0] >= n || x + dic[index%4][0] < 0
              || y + dic[index%4][1] >= n || y + dic[index%4][1] < 0
              || result[x + dic[index%4][0]][y + dic[index%4][1]] != 0){
                index++;
            }
            result[x][y] = i;
            x = x + dic[index%4][0];
            y = y + dic[index%4][1];
        }
        return result;
    }
}
