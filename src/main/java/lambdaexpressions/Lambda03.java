package lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(9);
        list.add(13);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(12);
        list.add(15);

        System.out.println( "Maximum element is "+findMaxValue(list));
        System.out.println();
        System.out.println("The maximum value with Lambda expression: "+findMaxValueFunc1(list));
        System.out.println("The maximum value with method reference: "+findMaxValueFunc2(list));
        System.out.println("The maximum value with own method reference: "+findMaxValueFunc3(list));

        System.out.println();
        System.out.println("The minimum value with Lambda expression: "+minValue1(list));
        System.out.println("The minimum value with method reference: "+minValue2(list));
        System.out.println("The minimum value with own method reference: "+minValue3(list));
        System.out.println();
        System.out.println("Sıralanmış liste");
        sortedListEl(list);
    }

    private static Integer findMaxValue(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public static Integer findMaxValueFunc1(List<Integer> list){
        return list.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x : y);
    }

    public static Integer findMaxValueFunc2(List<Integer> list){
        return list.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }
    public static Integer findMaxValueFunc3(List<Integer> list){
        return list.stream().reduce(Integer.MIN_VALUE, Lambda03::findMaxEl);
    }
    private static Integer findMaxEl(int x, int y) {
        return x>y ? x : y ;
    }

    public static Integer minValue1(List<Integer> list){
        return list.stream().reduce(Integer.MAX_VALUE, (x,y)-> x<y ? x : y);
    }
    public static Integer minValue2(List<Integer> list){
        return list.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }
    public static Integer minValue3(List<Integer> list){
       return list.stream().reduce(Integer.MAX_VALUE, Lambda03::findMinEl);
    }
    private static Integer findMinEl(int x, int y) {
        return x<y ? x : y ;
    }

    public static void sortedListEl(List<Integer> list){
         list.stream().sorted().forEach(t-> System.out.print(t+" "));
    }
}
