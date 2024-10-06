public class leecode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        //方式一，没通过最后的一个测试用例（超时）
        //估计是使用list进行查找的性能比不上使用hash查询速度的原因
//        List<String> res = new ArrayList<>();
//        int length = s.length();
//        if (length < 10){
//            return res;
//        }
//        for (int i = 0;i < length-10;i++){
//            String subStr = s.substring(i,i+10);
//            String lastStr = s.substring(i+1);
//            if (lastStr.contains(subStr) && !res.contains(subStr)){
//                res.add(subStr);
//            }
//        }
//
//        return res;

        //方式二
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int length = s.length();
        if (length < 10){
            return res;
        }
        for (int i = 0;i <= length-10;i++){
            String s1 = s.substring(i,i+10);
            if (!map.containsKey(s1)){
                map.put(s1,map.getOrDefault(s1,0) +1);
            }else if(map.get(s1) == 1){
                res.add(s1);
                map.put(s1,map.getOrDefault(s1,0) +1);
            }

        }
        return res;
    }
}
