package lambdaexpressions;
/*
Type a program to count the number of every word in a String
For example; if the String is "Ali, do you know Ali? Ali said you know him."
the output should be like {Ali=3, do=1, you=2, know=2, said=1, him=1}
 */

import java.util.*;
import java.util.stream.Collectors;

public class InterviewQuestion03 {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        String s = "Ali, do you know Ali? Ali said you know him.";
        HashMap<String, Integer> hashMap= new HashMap<>();
         System.out.println(s);
        String ar[]=s.split(" ");
        Arrays.stream(ar).forEach(t-> list.add(t.replaceAll("\\W", "")));
        System.out.println(list);
        countEl(hashMap,list);
    }

    public static void countEl(HashMap<String,Integer> hashMap, List<String> list){
        list.stream().forEach(t->putElIntoMap(hashMap,t));
        System.out.print(hashMap);
    }
    public static void putElIntoMap(HashMap<String,Integer> hashMap, String str){
        if (hashMap.containsKey(str)){
            int numberOfWords=hashMap.get(str);
            hashMap.put(str,numberOfWords++);
        }else {
            hashMap.put(str,1);
        }
    }
}
