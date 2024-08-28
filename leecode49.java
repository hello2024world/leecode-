import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class leecode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> words = new HashMap<>();
        //遍历数组，每次取出一个单词进行检查
        for (String word:strs){
            char[] array = word.toCharArray();
            //对单词从小到大进行排序
            Arrays.sort(array);
            String privaryWord = new String(array);
            //查找是否在hashmap中含有相同的数组
            if (words.containsKey(privaryWord)){
                //有相同的单词-----满足字母异位词的条件
                List<String> temp = words.get(privaryWord);
                temp.add(word);
                words.put(privaryWord,temp);
            }else{
                //第一次出现该类单词
                List<String> temp = new ArrayList<>();
                temp.add(word);
                words.put(privaryWord,temp);
            }
        }
        return new ArrayList<List<String>>(words.values());
    }
}
