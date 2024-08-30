public class leecode66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1;i >= 0;i--){
            if (digits[i] != 9){
                digits[i] += 1;
                //给原数字是9的位置上变成0
                for (int j = i+1;j < length;j++){
                    digits[j] = 0;
                }
                //找到对应相加的位置
                //但不是全为9的情况
                return digits;
            }
        }
        //如果全部都是9，特殊考虑
        int[] res = new int[length+1];
        res[0] = 1;
        return res;
    }
}
