package lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// {know=1, do=1, said=1, him=1, you=1, Ali=1}
public class InterviewQuestion03review {
    public static void main(String[] args) {
        String s="Ali, do you know Ali? Ali said you know him. Yaz buraya bir kelime!!!";
        List<String> wordsList= new ArrayList<>();
        HashMap<String,Integer> counterMap= new HashMap<>();
        String[] wordsArr = s.split(" ");

        Arrays.stream(wordsArr).forEach(t->wordsList.add(t.replaceAll("\\W", "")));
        System.out.println(wordsList);
        countWords(counterMap, wordsList);
    }

    public static void countWords(HashMap<String, Integer> counterMap, List<String> wordsList) {
        wordsList.forEach(t->putElIntoMap(counterMap,t));
        System.out.println(counterMap);
    }

    public static void putElIntoMap(HashMap<String, Integer> counterMap, String str) {
        if (counterMap.containsKey(str)){
            int numberOfWord=counterMap.get(str);
            numberOfWord++;
            counterMap.put(str,numberOfWord);
        }else {
            counterMap.put(str,1);
        }
    }


}
