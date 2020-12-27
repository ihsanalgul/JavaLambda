package lambdaexpressions;

public class Factorial {
    public static void main(String[] args) {
        int number = 6;

        String err="You have to provide positive number";

        System.out.println(factorial(number)==0? err:factorial(number));
    }
    public static int factorial(int n){
        int result;
        if(n<=1){
            if(n<0){

                return 0;
            }else{
                return 1;
            }

        }else{
            result = factorial(n-1)*(n);
        }
        return result;
    }
}
