package lambdaexpressions;

public class InterviewQ1 {
    /*
                                 *
                                 * *
                                 *   *
                                 *     *
                                 * * * * *
                 Type the code to create the given image....
    */
    public static void main(String[] args) {
        int line=1;
        int count = 0;
        int side = 10;
        System.out.println("*");
        for(int i=1; i<side; i++){
            line=2*i-1;
            if(i<=line){
                System.out.print("*");
                for(int k=0; k<line; k++){
                    if(i<side-1){
                        System.out.print(" ");
                    }else if(i==side-1){
                        System.out.print(" *");
                        count++;
                        if(count==side-1){
                            break;
                        }
                    }
                }
                if(count<side-1){
                    System.out.println("*");
                }
            }
        }
        System.out.println();
    }
}