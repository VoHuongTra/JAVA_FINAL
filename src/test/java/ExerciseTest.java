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
    void listTopTenStudentHighScore_01(){
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
    void listTopTenStudentHighScore_02(){
        List<Student> students = Exercise.createListStudent();
        List<Student> result = new ArrayList<>();
        try{
            result = Exercise.listTopTenStudentHighScore(students);
            var expected = prepareData();
            Assert.assertEquals(expected.size(),result.size());
            for (Student item: result) {
                Assert.assertTrue(expected.contains(item.getStudentID()));
            }
        }catch (Exception ex) {
            Assert.fail();
        }

    }

    public List<Integer> prepareData() {
        List<Integer> students = new ArrayList<>();
        students.add(18424103);
        students.add(18424017);
        students.add(18424013);
        students.add(18424014);
        students.add(18424005);
        students.add(18424015);
        students.add(18424018);
        students.add(18424102);
        students.add(18424100);
        students.add(18424019);
        return students;
    }
}