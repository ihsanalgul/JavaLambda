package lambdaexpressions;

import java.util.Arrays;
import java.util.Scanner;

public class InterviewQuestion01 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter first string");
        String s1 = scanner.nextLine().toLowerCase();
        System.out.println("Enter second string");
        String s2 = scanner.nextLine().toLowerCase();
//        String[] a1 = s1.split("");Arrays.sort(a1);
//        String[] a2 = s2.split("");Arrays.sort(a2);
//        System.out.println(Arrays.equals(a1,a2) ? "Anagram" : "Not!");
        System.out.println( isAnagram(s1,s2) ? "These are Anagram" : "not Anagram");
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) return false;
        char arr1[] = s1.toCharArray();
                Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        char arr2[] = s2.toCharArray();
                 Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        if (arr1.length==arr2.length && Arrays.equals(arr1,arr2))
        { return true;  }
        else { return false; }
    }
}
