public class leecode5 {
    public static void main(String[] args) {
        leecode5 leecode5 = new leecode5();
        String s = "cbbd";
        System.out.println(leecode5.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        //双指针
        //从定位点向两侧进行寻找
        int length = s.length();
        int resLength = 0;
        String res = "";
        int maxStart = 0;
        int maxEnd = 0;
        for(int i = 0;i < length;i++){
            //对两种情况进行判断
            //可能是奇数串
            int length1 = MaxStrLength(i,i,s);

            //也可能是偶数串
            int length2 = MaxStrLength(i,i+1,s);

            resLength = Math.max(length1,length2);
            //如果当前的字符串长度更长
            if (resLength>maxEnd-maxStart){
                //替换为当前字符串的初始结束位置
                maxStart = i - (resLength-1)/2;
                maxEnd = i + resLength/2;
            }

        }
        res = s.substring(maxStart,maxEnd+1);
        return res;
    }
    public static int MaxStrLength(int left,int right,String s){
        while (left>=0 && right<s.length()&&s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
