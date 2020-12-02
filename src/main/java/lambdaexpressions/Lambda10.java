package lambdaexpressions;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.IntStream;

public class Lambda10 {
    public static void main(String[] args) {
        sum1(10);
        System.out.println("Sum2: "+sum2(100));
        System.out.println("Sum3: "+sum3(1000));
        System.out.println("Sum of even integers: "+sumOfEven(10,100));
        System.out.println("Sum of even integers: "+sumOfEven(100,-100));
        System.out.println("Sum5: "+sum5(50));
        System.out.println("1 den n 'ye kadar olan tek sayıların toplamı n2 'dir");
        System.out.println(sum6(10));
        System.out.println(sum6(11));
        System.out.println(sum6(12));
        System.out.println(sum6(13));
        System.out.println(sum6(14));
        System.out.println(sum6(15));
        powOfTwo1(9);
        powOfTwo2(9);
        powOfAnyNum(3,4);
        System.out.println("factorial of "+6+" => "+factorialOfAnyNumber(6));
        System.out.println("factorial of "+6+" => "+factorialOfAnyNumber2(6));
    }

    // Create a method to find the sum of integers from 1 to x using "structured programming"
    public static void sum1(int x){
        int sum =0;
        for (int i = 0; i <= x; i++) {
            sum = sum + i;
        }
        System.out.println("Sum1: "+sum);
    }
    // Create a method to find the sum of integers from 1 to x using "functional programming"
    public static int sum2(int x){
        int sum = 0 ;
        sum = IntStream.range(1,x+1).sum();
        return sum;
    }

    public static int sum3(int x){
        int sum = 0 ;
       sum = IntStream.rangeClosed(1,x).sum();
       return sum;
    }
    //Create a method to find the sum of even integers from x to y by using "functional programming"
    public static int sumOfEven(int x, int y){
      return IntStream.rangeClosed(x,y).filter(t->t%2==0).sum();
    }

    //Create a method to find the sum of first 50 odd positive integers by using "functional programming"
    //1st Way
    public static int sum5(int numOfIntegers){
        IntStream.rangeClosed(0,2*numOfIntegers).filter(t->t%2==1).forEach(t->System.out.print(t+" "));
        return IntStream.rangeClosed(0,2*numOfIntegers).filter(t->t%2==1).sum();
    }
    //2nd Way
    public static int sum6(int numOfIntegers){
        IntStream.iterate(1, t->t+2).limit(numOfIntegers).forEach(t->System.out.print(t+" "));
        return IntStream.iterate(1, t->t+2).limit(numOfIntegers).sum();
    }
    //Create a method to find the any power of 2 by using lambda
    public  static void powOfTwo1(int pow){
          IntStream.rangeClosed(1,pow).forEach(t->System.out.println(Math.pow(2,t)));
    }
    //2nd Way
    public  static void powOfTwo2(int pow){
        IntStream.iterate(1,t->t*2).limit(pow).forEach(System.out::println);
    }
    //Create a method to find the any power of any number by using lambda
    public  static void powOfAnyNum(int x, int powOfx){
        IntStream.iterate(1,t->t*x).limit(powOfx).forEach(System.out::println);
    }

    //Create a method to calculate the factorial of any number
    public static int factorialOfAnyNumber(int x){
        return IntStream.
                rangeClosed(1,x).
                reduce(1,Math::multiplyExact);
    }
    //2nd Way
    public static BigInteger factorialOfAnyNumber2(int x){
        return IntStream.
                rangeClosed(1,x).
                mapToObj(BigInteger::valueOf).
                reduce(BigInteger.ONE,BigInteger::multiply);
    }









}
