package lambdaexpressions;

import java.util.ArrayList;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(12);
        l1.add(9);
        l1.add(13);
        l1.add(4);
        l1.add(6);
        l1.add(2);
        l1.add(4);
        l1.add(12);
        l1.add(15);

        print(l1);
        System.out.println();
        System.out.println("====================================");
        printListElLambda(l1);
        System.out.println("====================================");
        printEven(l1);
        System.out.println();
        System.out.println("====================================");
        System.out.println("Elements of the list which are less than 10");
        printLess10(l1);
    }

    private static void printLess10(List<Integer> l1) {
        l1.stream().filter(t->t<10).forEach(Lambda01::printNum);
    }

    private static void printListElLambda(List<Integer> l1) {
        l1.stream().forEach(t-> System.out.print(t+" "));
    }

    public static void print(List<Integer> l1) {
        for (Integer w: l1) {
            System.out.print(w+" ");
        }
    }
    public static  void printEven(List<Integer> l1){
        l1.stream().filter(t->t%2==0).forEach(Lambda01::printNum);
    }

    public static void printNum(Integer n) {

            System.out.print(n+" ");

    }
}
