public class leecode73 {
    public void setZeroes(int[][] matrix) {
        //记录出现0元素位置的坐标
        //然后对x、y分别置零
        HashSet<Integer> hashSet_x = new HashSet<>();
        HashSet<Integer> hashSet_y = new HashSet<>();
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    hashSet_x.add(i);
                    hashSet_y.add(j);
                }
            }
        }
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (hashSet_x.contains(i)){
                    matrix[i][j] = 0;
                }else if(hashSet_y.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
