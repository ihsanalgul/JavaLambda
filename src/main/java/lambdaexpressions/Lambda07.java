package lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda07 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(12);
        l1.add(9);
        l1.add(13);
        l1.add(4);
        l1.add(6);
        l1.add(2);
        l1.add(4);
        l1.add(12);
        l1.add(15);
        squareOfEvenDistinctReverseSorted(l1);
    }
    // Create a method to calculate the square of every elements, print them on the console reversed and distinctly
    public static void squareOfEvenDistinctReverseSorted(List<Integer> list){
        list.stream().
                filter(t->t%2==0).
                distinct().
                sorted(Comparator.reverseOrder()).
                map(t->t*t).
                forEach(System.out::println);
    }
}
