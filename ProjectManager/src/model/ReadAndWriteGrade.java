package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadAndWriteGrade {
    SinhVienDAO sinhVienDAO = new SinhVienDAO();
    public List<Grade> readGrades(String path){
        List<Grade> grades = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = null;
        if(file.exists()){
            try {
                scanner = new Scanner(file);
                while (scanner.hasNext()){
                    String[] strings = scanner.nextLine().split(" ");
                    SinhVien temp = null;
                    for(SinhVien sinhVien : sinhVienDAO.ls){
                        if(sinhVien.getMaSV().equals(strings[0])){
                            temp = sinhVien;
                        }
                    }
                    grades.add(new Grade(grades.size(),temp,Double.parseDouble(strings[1]),Double.parseDouble(strings[2]),Double.parseDouble(strings[3])));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }finally {
                scanner.close();
            }
        }else{
            System.out.println("File not found");
        }
        return grades;
    }

    public static void main(String[] args) {
        ReadAndWriteGrade readAndWriteGrade = new ReadAndWriteGrade();
        System.out.println(readAndWriteGrade.readGrades("src/data/Diem.txt"));
    }
}
