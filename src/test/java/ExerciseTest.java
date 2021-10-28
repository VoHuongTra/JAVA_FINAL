import model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExerciseTest {

    @Test
    void createListStudent_01() {
        List<Student> student = new ArrayList<>();
        try{
            student = Exercise.createListStudent();
        }catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(student!= null);
    }
    @Test
    void createListStudent_02() {
        List<Student> student = new ArrayList<>();
        try{
            student = Exercise.createListStudent();
        }catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(student.size() >= 10);
    }
    @Test
    void listTopTenStudentHighScore(){
        List<Student> students = Exercise.createListStudent();
        List<Student> result = new ArrayList<>();
        try{
            result = Exercise.listTopTenStudentHighScore(students);
        }catch (Exception ex) {
            Assert.fail();
        }

        Assert.assertTrue(result.size() == 10);
    }
    @Test
    void finalPoint(){
        List<Student> students = Exercise.createListStudent();
        Map<Student,Double> result = new HashMap<>();
        try{
            result = Exercise.finalPoint(students);
        }catch (Exception ex) {
            Assert.fail();
        }

        Assert.assertTrue(result.size() == 18);
    }
    @Test
    void top10LowestFinalPoint() throws Exception {
        List<Student> students = Exercise.createListStudent();
        Map<Student,Double> result = Exercise.finalPoint(students);
        try{
            Map<Student,Double> top10= Exercise.top10LowestFinalPoint(result);
            Assert.assertTrue(top10.size() == 10);
        }catch (Exception ex) {
            Assert.fail();
        }
    }
}