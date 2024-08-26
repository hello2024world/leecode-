class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        //左指针指向开始
        //右指针指向后面的数
        int left = 0;
        int right = 0;
        int max_length = 0;
        HashMap<Character,Integer> hashMap = new HashMap();
        //右指针不断的遍历，将每次不同的字符存储到map中（字符和对应的位置）
        while (right < s.length()){
            //遇到相同字符时，将左指针更新到出现过的位置+1
            if (hashMap.containsKey(s.charAt(right))){
                //更新前将计数器更新为右指针减去左指针，比较字符串是否为最长
                max_length = Math.max(max_length,right - left );
                if (left < hashMap.get(s.charAt(right)) + 1){
                    left = hashMap.get(s.charAt(right)) + 1;
                }

            }
            //并将新的字符存储在map中，
            hashMap.put(s.charAt(right), right);
            right++;

        }
        max_length = Math.max(max_length,right - left);
        //直到右指针遍历完整个字符串，结束循环，返回长度
        return max_length;
    }
}
