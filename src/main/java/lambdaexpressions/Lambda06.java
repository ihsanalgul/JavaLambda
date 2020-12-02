package lambdaexpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda06 {
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
        lenOfEveryEl(list);
    }
    // Create a method to print the length of the every element and initials and the next characters in following format
    //  Abi: 3	Ali: 3	Dark: 4	Mark: 4	Amanda: 6	Christ: 6	Tucker: 6	Alberto: 7	Jackson: 7	Mariano: 7
    public static void lenOfEveryEl(List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(String::length).
                        thenComparing(t->t.charAt(0)).
                    thenComparing(t->t.charAt(1))).
                forEach(t->System.out.print(t+": "+t.length()+"\t"));
    }
}
