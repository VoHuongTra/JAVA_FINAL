import model.Student;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        //Cau 1
        List<Student> listNewStudent =  Exercise.createListStudent();

        //Cau2
        List<Student> top10HighestScrore = Exercise.listTopTenStudentHighScore(listNewStudent);
        top10HighestScrore.stream().forEach(System.out::println);

        System.out.println("============================================================");
        System.out.println("============================================================");
        //Cau 3
        Map<Student,Double> studentsWithFinalMark = Exercise.finalPoint(listNewStudent);

        //Cau4
        Map<Student,Double> top10LowestFinalMark = Exercise.top10LowestFinalPoint(studentsWithFinalMark);
        for (Map.Entry<Student,Double> item: top10LowestFinalMark.entrySet()) {
            System.out.println(item.getKey().toString() + " ,final mark: " + item.getValue());
        }
        System.out.println("============================================================");
        System.out.println("============================================================");

        //cau 5
        for (Map.Entry<Student,Double> item: studentsWithFinalMark.entrySet()) {
            System.out.println(item.getKey().toString() + " ,final mark: " + item.getValue());
        }
        System.out.println("============================================================");
        System.out.println("============================================================");

        //cau 6
        Exercise.classStatistic(studentsWithFinalMark);
    }
}
