package lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");
        toUppercaseEl1(list);
        System.out.println();
        toUppercaseEl2(list);
        System.out.println();
        toLowercaseEl3(list);
        System.out.println();
        //lenGreaterThan5(list);
        //System.out.println();
        //System.out.println(lenGreaterThanFive(list));
        //System.out.println();
        //removeStartAEndN(list);
        orderingLen(list);
        System.out.println();
        sortByLastCharOfEl(list);
        System.out.println("=============================");
        sortLengthInitial(list);
    }

    // Create a method to print all list elements in uppercase
    //with Lambda Expression
    public static void toUppercaseEl1(List<String> list){
        list.stream().map(t->t.toUpperCase()).forEach(System.out::println);
    }

    //with Method Reference
    public static void toUppercaseEl2(List<String> list){
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    //Another way
    public static void toLowercaseEl3(List<String> list){
        list.replaceAll(t -> t.toLowerCase());
        System.out.println(list);
    }
    // My way (another way)
    public static List lenGreaterThanFive(List<String> list){
        return list.stream().filter(t->t.length()<5).collect(Collectors.toList());
    }

    //Remove the elements if the length of the element is greater than 5
    //removeIf() updates the list permanently
    public static void lenGreaterThan5(List<String> list){
        list.removeIf(t->t.length()>5);
        System.out.println(list);
    }

    public static void removeStartAEndN(List<String> list){
        list.removeIf(t->t.startsWith("A")||t.endsWith("N"));
        System.out.println(list);
    }
    // Create a method to print the elements after ordering according to their lengths
    public  static void orderingLen(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

    }

    // Create a method to sort the distinct elements by using their last characters
    public  static void sortByLastCharOfEl(List<String> list){
        list.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).forEach(System.out::println);
    }

    // Create a method to sort the elements according to their lengths and first character
    public static void sortLengthInitial(List<String> list){
        list.stream().
                sorted(Comparator.comparing(String::length).
                        thenComparing(t->t.charAt(0))).
                forEach(System.out::println);
    }

}
