import model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise {
    public static List<Student> createListStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(18424005, "Đặng Văn Thường","dvthuong@gmail.com",0,0,0,4.5));
        students.add(new Student(18424013, "Nguyễn Ngọc Châu","nnchau@outlook.com",2,8,8,5.5));
        students.add(new Student(18424014, "Nguyễn Văn A","nva@gmail.com",4,3,7,5));
        students.add(new Student(18424015, "Nguyễn Văn B","nvb@gmail.com",1,2,2,4));
        students.add(new Student(18424016, "Nguyễn Văn C","nvc@gmail.com",2,4,1,2.5));
        students.add(new Student(18424017, "Nguyễn Văn D","nvd@gmail.com",0,7,0,7));
        students.add(new Student(18424018, "Nguyễn Văn E","nve@gmail.com",5,4,6,4));
        students.add(new Student(18424019, "Nguyễn Văn F","nvf@gmail.com",1,1,3,3));
        students.add(new Student(18424010, "Nguyễn Văn G","nvg@gmail.com",3,0,2,1.5));
        students.add(new Student(18424011, "Nguyễn Văn H","nvh@gmail.com",2,3,4,2.5));
        students.add(new Student(18424100, "Nguyễn Văn J","nvj@gmail.com",1,4,4,3.5));
        students.add(new Student(18424102, "Nguyễn Văn K","nvk@gmail.com",2,2,2,4));
        students.add(new Student(18424103, "Nguyễn Văn L","nvl@gmail.com",0,7,1,7.5));
        students.add(new Student(18424104, "Nguyễn Văn M","nvm@gmail.com",5,1,9,1));
        students.add(new Student(18424105, "Nguyễn Văn N","nvn@gmail.com",7,3,2,0));
        students.add(new Student(18424106, "Nguyễn Văn O","nvo@gmail.com",6,2,4,3));
        students.add(new Student(18424107, "Nguyễn Văn U","nvu@gmail.com",8,1,0,1.5));
        students.add(new Student(18424108, "Nguyễn Văn T","nvt@gmail.com",0,3,4,2));
        return students;
    }
    public static List<Student> listTopTenStudentHighScore(List<Student> students) throws Exception {
        if(students == null || students.size() < 10) {
            throw new Exception("Invalid size of list student");
        }
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getLt).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
    public static Map<Student,Double> finalPoint(List<Student> students) throws Exception {
        if(students == null || students.size() == 0) {
            throw new Exception("Invalid size of list student");
        }
        Map<Student,Double> result = new HashMap<>();
        try{
            for (Student student: students){
                double mark = student.getBonus()*0.1 + student.getReport()*0.3 + student.getApp()*0.15 + student.getLt()*0.45;
                result.put(student,Math.round(mark*10)/10.0d);
            }
        }catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return result;
    }

    public static Map<Student,Double> top10LowestFinalPoint(Map<Student,Double> finalPoint) throws Exception {
        if(finalPoint == null || finalPoint.isEmpty()) {
            throw new Exception("Invalid size of list student");
        }
        return finalPoint.entrySet().stream().
                sorted(Map.Entry.comparingByValue())
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public static void classStatistic(Map<Student,Double> students) throws Exception {
        if(students == null || students.isEmpty()) {
            throw new Exception("Invalid size of list student");
        }
        System.out.println("Số lượng sinh viên: " + students.size());

        long pass = students.entrySet().stream().filter(x -> x.getValue() > 4.5).count();
        System.out.println("Đạt: " + pass + " Tỉ lệ: " + (double) pass/students.size()*100 + "%" );
        int notPass = (int) (students.size() - pass);
        System.out.println("Không đạt: " + notPass + " Tỉ lệ: " + (double) notPass/students.size()*100 + "%" );

        int excellence = (int)students.entrySet().stream().filter(x -> x.getValue() >=8 && x.getValue() <=10 ).count();
        int middle = (int)students.entrySet().stream().filter(x -> x.getValue() >=6.5 && x.getValue() <8 ).count();
        int normal = (int)students.entrySet().stream().filter(x -> x.getValue() >=5 && x.getValue() <6.5 ).count();

        System.out.println("Giỏi (điểm tổng kết 8 - 10) " + excellence + " Tỉ lệ: " + (double) excellence/students.size()*100 + "%" );
        System.out.println("Khá (điểm tổng kết 6.5 - 8) " + middle + " Tỉ lệ: " + (double) middle/students.size()*100 + "%" );
        System.out.println("Trung bình (điểm tổng kết 5 - 6.5) " + normal + " Tỉ lệ: " + (double) normal/students.size()*100 + "%" );
    }
}
