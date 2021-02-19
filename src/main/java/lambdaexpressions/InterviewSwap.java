package lambdaexpressions;

import java.util.Arrays;
import java.util.Scanner;

public class InterviewSwap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter string");
        char[] s1 = scan.next().toCharArray();

        System.out.println("Enter string");
        char[] s2 = scan.next().toCharArray();

        int result =0;
        while(!Arrays.equals(s1,s2))
            result += test(s1,s2);

        System.out.println(result);
        scan.close();
    }



    public  static  int test(char[] s1, char[] s2){
        int result = 0;
        for (int i = 0;i<s1.length;i++){
            char c = s1[i];
            if(s2[i]== c)
                continue;

            for (int j = i+1;j<s1.length;j++){
                if(s1[j] == c){
                    s1[j] = s2[i];
                    s2[i] = c;
                    System.out.println("s2 - "+ i + " ile s1 - " + j + " swapped\n" + String.valueOf(s1) + "\n" + String.valueOf(s2)  );
                    result++;
                 break;
                }
            }
        }
        return  result;
    }

    public static int swap(char[] s1, char[] s2) {
        int counter=0;
         /*
          System.out.println("s1 - "+countXY(s1));
          System.out.println("s2 - "+countXY(s2));
         */
        if (countXY(s1)&&countXY(s2)){
            for(int i=0;i<s1.length;i++){
                if(s1[i]!=s2[i]){

                    for (int j=i+1;j<s1.length;j++){
                        if(s1[i]==s1[j]){
                            counter++;
                         char temp=s2[i];
                            s2[i]=s1[j];
                            s1[j]=temp;
                            System.out.println("s1de arama..i-> "+i);
                            System.out.println("s1 "+Arrays.toString(s1));
                            System.out.println("s2 "+Arrays.toString(s2));
                        }else if (s2[i]==s2[j]){
                            System.out.println("s2 de arama..i-> "+i);
                            System.out.println("s1 "+Arrays.toString(s1));
                            System.out.println("s2 "+Arrays.toString(s2));
                            counter++;
                            char temp = s1[i];
                            s1[i]=s2[j];
                            s2[j]=temp;
                        }
                    }
                }
            }
            return counter;
        }
        return -1;
    }

    public static boolean countXY(char[] s){

        int countX=0;
        int countY=0;

        for (int i=0;i<s.length;i++) {
            if (s[i] == 'x'){
                countX++;
            }
            else if (s[i] == 'y'){
                countY++;
            }
        }
        /*System.out.println("countX: "+countX);
        System.out.println("countY: "+countY);*/
            if (countX==countY||(countX==s.length)||(countY==s.length)) {
                return true;
            }
            return false;
    }
}
