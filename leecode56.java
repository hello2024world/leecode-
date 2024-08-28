import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leecode56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2){
            return intervals;
        }
        //对二维数组按照第一个元素进行从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] pre = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1;i < n;i++){
            //如果当前数组的前一个数小于前一个数组的后一个数
            //说明区间存在重复
            if (pre[1] >= intervals[i][0]){
                //取前一个数组的第一个元素为开头
                //取两个数组末尾元素更大的作为结尾
                int[] temp = new int[2];
                temp[0] = pre[0];
                temp[1] = Math.max(pre[1],intervals[i][1]);
                pre = temp;
            }else {
                //加入到结果集中
                res.add(pre);
                //不是存在重复部分，替换pre数组
                pre = intervals[i];
            }
        }
        //将最后一个数组加入结果集
        res.add(pre);
        int[][] ints = res.toArray(new int[res.size()][]);

        return ints;
    }
}
