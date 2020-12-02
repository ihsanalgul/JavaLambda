package lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
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

        squares(list);
        System.out.println();

        squaresOfEl(list);
        System.out.println();

        squaresOfOdd(list);
        System.out.println();
        System.out.println("=======Cube=========");
        cubeOfEvenEl(list);
        System.out.println("The sum of all elements: "+sumOfAllEl(list));
        System.out.println("The multiplication1 of all elements: "+multiplicationOfAll1(list));
        System.out.println("The multiplication2 of all elements: "+multiplicationOfAll2(list));
        System.out.println("The multiplication3 of all elements: "+multiplicationOfAll3(list));
        System.out.println();
        System.out.println(sumOfSquareOfAllEvenEl1(list));
        System.out.println(sumOfSquareOfAllEvenEl2(list));

        }

    public static void squares(List<Integer> list){
        list.stream().map(t->t*t).forEach(t -> System.out.print(t+" "));
    }

    public static void squaresOfEl(List<Integer> list){
        list.stream().map(t->Math.pow(t,2)).forEach(t -> System.out.print(t+" "));
    }

    public static void squaresOfOdd(List<Integer> list){
        list.stream().filter(Lambda02::isOdd).map(t->Math.pow(t,2)).forEach(t -> System.out.print(t+" "));
    }

    public static boolean isOdd(Integer w){
        if (w%2!=0) { return true; }

        return false;
    }
    public static boolean isEven(Integer w){
        if (w%2==0) {
            return true;
        }

        return false;
    }

    public static void cubeOfEvenEl(List<Integer> list){
       // list.stream().filter(lambdaexpressions.Lambda02::isEven).map(t->Math.pow(t,3)).forEach(t-> System.out.print(" is "+t+"\n"));
        list.stream().filter(t->t%2==0).map(Lambda02::findCube).forEach(System.out::println);
    }

    public static int findCube(int t){
        return t*t*t;
    }

    public static int findSquare(int t){
        return t*t;
    }
    public static Integer sumOfAllEl(List<Integer> list){
        return list.stream().reduce(0,Integer::sum);
    }

    public static Integer multiplicationOfAll1(List<Integer> list){
      return  list.stream().reduce(1,(x,y)->x*y);
    }

    public static Integer multiplicationOfAll2(List<Integer> list){
        return  list.stream().reduce(1,Lambda02::multiplication);
    }

    public static Integer multiplication(int x, int y){
        return x*y;
    }

    public static Integer multiplicationOfAll3(List<Integer> list){
        return  list.stream().reduce(1,Math::multiplyExact);
    }

    public static Optional<Double> sumOfSquareOfAllEvenEl1(List<Integer> list){
        return list.stream().filter(Lambda02::isEven).map(t->Math.pow(t,2)).reduce((x,y)->x+y);
    }
    public static int sumOfSquareOfAllEvenEl2(List<Integer> list){
        return list.stream().filter(t->t%2==0).map(Lambda02::findSquare).reduce(0,Math::addExact);
    }
}
