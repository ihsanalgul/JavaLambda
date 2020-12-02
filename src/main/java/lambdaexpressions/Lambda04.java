package lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lambda04 {
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

        distinctEl(l1);
        System.out.println();
        squareOfDistinctEven(l1);
        System.out.println();
        sqrtOfDistinctOdd(l1);
        System.out.println();
        System.out.println(halfOfDistinctGT5(l1));
        System.out.println(halfOfDistinctGT5set(l1));

    }
    //"List elements sorted in natural order and all elements are shown just once "
    public static void distinctEl(List<Integer> list) {
        list.stream().sorted().distinct().forEach(Lambda01::printNum);
    }
    // Create a method to print the square of distinct, even elements in natural order.
    public static void squareOfDistinctEven(List<Integer> list){
        list.stream().sorted().distinct().filter(Lambda02::isEven).map(Lambda02::findSquare).forEach(Lambda01::printNum);
    }
    // Create a method to print the square root of distinct, odd elements in reverse order.
    public static void sqrtOfDistinctOdd(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).
                distinct().
                filter(Lambda02::isOdd).
                map(Math::sqrt).
                forEach(t->System.out.print(t+" "));
    }
    // Create a method to print the half of distinct, greater than 5 elements in reverse order in a list.
    public static List<Double> halfOfDistinctGT5(List<Integer> list){
       return list.
                stream().
                filter(t->t>5).
                distinct().
                map(t->t/2.0).
                sorted(Comparator.reverseOrder ()).
                collect(Collectors.toList());
    }
    // Create a method to print the half of distinct, greater than 5 elements in reverse order in a SET.
    public static Set halfOfDistinctGT5set(List<Integer> list){
        return list.
                stream().
                filter(t->t>5).
                distinct().
                map(t->t/2.0).
                collect(Collectors.toSet());
    }

}