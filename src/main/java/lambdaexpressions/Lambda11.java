package lambdaexpressions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lambda11 {
    public static void main(String[] args) throws IOException {
//        File file = new File("src/main/java/lambdaexpressions/LambdaFile01.txt");
//        try {
//            file.createNewFile();
//            System.out.println("File creation successful ! ...");
//        } catch (IOException e) {
//            System.out.println("File creation failed !");
//            e.printStackTrace();
//        }
        //Read the file by using "functional programming"
        Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).forEach(System.out::println);
        System.out.println("=====================");
        //Read the file by using "functional programming" and convert just first line to Uppercase
        Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).
                map(t->t.toUpperCase()).forEach(System.out::println);
        System.out.println("=====================");
        //Read  just first line of the file by using "functional programming"
        //1st Way
        Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).
                limit(1).forEach(System.out::println);
        //2nd Way
        System.out.println(Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).
                findFirst());
        System.out.println("\n//Read the file like just second row in lower case by using \"FP\"");
        //Read the file like just second row in lower case by using "FP"
        Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).
                skip(1).limit(1).map(t->t.toUpperCase()).forEach(System.out::println);
        //2nd Way
        System.out.println("\n  //2nd Way");
        System.out.println(Files.lines(Paths.get("src/main/java/lambdaexpressions/LambdaFile01.txt")).
                skip(1).limit(1).map(t->t.toUpperCase()).findFirst());

    }
}
