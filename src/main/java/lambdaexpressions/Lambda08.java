package lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda08 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Ali");
        list.add("Abi");
        list.add("Mark");
        list.add("Dark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");

        int charNumber = 8;
        checkLength(list, charNumber);
        checkInitial(list);
        checkEndingChar(list);
        getFirstAfterSorted(list);
        getLastAfterSorting(list);

    }
    //Create a method to check if the lengths of all  elements are less than 8
    public static void checkLength(List<String> list, int num){
        boolean result = list.stream().allMatch(t->t.length()<num);
        System.out.println("All elements in the list less than "+num+" characters: "+result);
    }
    //Create a method to check if the initials of none element is not 'X'
    public static void checkInitial(List<String> list){
        boolean result= list.stream().noneMatch(t->t.startsWith("X"));
        System.out.println("None of the elements in the list starts with "+"X"+" character: "+result);
    }
    //Create a method to check if none of the element ends with "r"
    public static void checkEndingChar(List<String> list){
        boolean result= list.stream().anyMatch(t->t.endsWith("r"));
        System.out.println("Any of the elements in the list ends with "+"r"+" character: "+result);
    }
    //Create a method to get the first element after sorting the elements by using their second last character
    public static void getFirstAfterSorted(List<String> list){
        String result = String.valueOf(list.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-2))).findFirst());
        System.out.println("Get of the last second element in the list after sorting "+result);
    }
    //Create a method to get the last element after sorting the elements by using their length
    public static void getLastAfterSorting(List<String> list){
        //Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        //System.out.println(max);
        String res= String.valueOf(list.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst());
        System.out.println(res);
    }
}
