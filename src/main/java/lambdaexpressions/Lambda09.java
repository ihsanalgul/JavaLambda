package lambdaexpressions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda09 {
    public static void main(String[] args) {
        Course courseTurkishDay = new Course("Summer", "Turkish Daytime", 97,128);
        Course courseTurkishNight = new Course("Winter", "Turkish Nighttime", 98,154);
        Course courseEnglishDay = new Course("Spring", "English Daytime", 95,132);
        Course courseEnglishNight = new Course("Winter", "Turkish Nighttime", 93,144);

        List<Course> courseList = new ArrayList<>();
        courseList.add(courseTurkishDay);
        courseList.add(courseTurkishNight);
        courseList.add(courseEnglishDay);
        courseList.add(courseEnglishNight);

        System.out.println(courseList);
        System.out.println("All average scores greater than 91 is "+checkAvrScore(courseList));
        System.out.println("Is there any number of students equals to 154 => "+numberOfStudents(courseList));
        System.out.println("No season contains Spring => "+checkSeasonSpring(courseList)+"\n at least one of them is equal to Spring");
        System.out.println(Arrays.toString(sortNumOfStudents1(courseList).toArray()));
        System.out.println(sortNumOfStudents2(courseList));
        System.out.println(sortElSeasonAverageScore(courseList));
        System.out.println(sortElNumOfStdLimitByTwo(courseList));
        System.out.println("===================================");
        System.out.println(sortElAvrScrSkipFirstThree(courseList));
        System.out.println("===================================");
        System.out.println(sortElNumOfStdSkipFirstLimitByTwo(courseList));
        System.out.println("===================================");
        System.out.println(getCourseMaxAvrScr1(courseList));
        System.out.println(getCourseMaxAvrScr2(courseList));
        System.out.println(getCourseMaxAvrScr3(courseList));
        System.out.println(getCourseNumOfStdMin(courseList));
    }
    //Create a method to check if all average scores greater than 91
    public static boolean checkAvrScore(List<Course> courseList){
        return courseList.stream().allMatch(t->t.getAverageScore()>91);
    }

    // Check if any number of students equals to 154
    public static boolean numberOfStudents(List<Course> courseList){
        return courseList.stream().anyMatch(t->t.getNumberOfStudents()==154);
    }

    // Check if no season contains Spring
    public static boolean checkSeasonSpring(List<Course> courseList){
        return courseList.stream().noneMatch(t->t.getSeason().equals("Spring"));
    }

    //Sort the list elements according to the number of the students
    public static Stream<Course> sortNumOfStudents1(List<Course> courseList){
        return courseList.stream().sorted(Comparator.comparing(Course::getNumberOfStudents));
    }
    //2nd way
    public static List<Course> sortNumOfStudents2(List<Course> courseList){
        return courseList.stream().
                sorted(Comparator.comparing(Course::getNumberOfStudents)).
                collect(Collectors.toList());
    }
    //Sort the list elements according to the season and average score
    public static List<Course> sortElSeasonAverageScore(List<Course> courseList){
        return courseList.stream().
                sorted(Comparator.comparing(Course::getSeason).
                        thenComparing(Course::getAverageScore)).
                collect(Collectors.toList());
    }
    //Sort the list elements according to the season and average score
    public static List<Course> sortElNumOfStdLimitByTwo(List<Course> courseList){
        return courseList.stream().
                sorted(Comparator.comparing(Course::getNumberOfStudents)).
                limit(2).
                collect(Collectors.toList());
    }
    //Sort the list elements according to the average score and skip first 3 elements
    public static List<Course> sortElAvrScrSkipFirstThree(List<Course> courseList){
        return courseList.stream().
                sorted(Comparator.comparing(Course::getAverageScore)).
                skip(3).
                collect(Collectors.toList());
    }
    //Sort the list elements according to the number of the students and skip the first element and limit by 2
    public static List<Course> sortElNumOfStdSkipFirstLimitByTwo(List<Course> courseList){
        return courseList.
                stream().
                sorted(Comparator.comparing(Course::getNumberOfStudents)).
                skip(1).
                limit(2).
                collect(Collectors.toList());
    }

    //Get the course whose average score is maximum
    public static List<Course> getCourseMaxAvrScr1(List<Course> courseList){
        return courseList.
                stream().
                sorted(Comparator.comparing(Course::getAverageScore).
                        reversed()).limit(1).collect(Collectors.toList());
    }
    //2nd way
    public static Optional<Course> getCourseMaxAvrScr2(List<Course> courseList){
        return courseList.
                stream().
                sorted(Comparator.comparing(Course::getAverageScore).
                        reversed()).findFirst();
    }
    //3rd way
    public static Optional<Course> getCourseMaxAvrScr3(List<Course> courseList){
        return courseList.
                stream().
                max(Comparator.comparing(Course::getAverageScore));
    }

/*    public static List<Course> getCourseMaxAvrScr4(List<Course> courseList){
        return courseList.
                stream().
                max(Comparator.comparing(Course::getAverageScore)).
                stream().collect(Collectors.toList());// This is working by updating the api level 1.9
    }*/
    //Get the course whose number of students is minimum
    public static Optional<Course> getCourseNumOfStdMin(List<Course> courseList){
        return courseList.
                stream().
                min(Comparator.comparing(Course::getNumberOfStudents));
    }
}
