/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    ReadAndWriteStudent readAndWriteStudent = new ReadAndWriteStudent();
    public List<SinhVien> ls = readAndWriteStudent.readFile("src/data/SinhVien.txt");
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd");

    public int add(SinhVien sv) {
        ls.add(sv);
        return 1;
    }

    public List<SinhVien> getAllStudent() {
        return ls;
    }

    public void saveStudent(){
        readAndWriteStudent.writeFile(this.ls, "src/data/SinhVien.txt");
    }

    public int delStudentByID(String id) {
        for (SinhVien sv : ls) {
            if (sv.getMaSV().equalsIgnoreCase(id)) {
                ls.remove(sv);
                return 1;
            }
        }
        return -1;
    }

    public SinhVien getStudentByID(String id) {
        for (SinhVien sv : ls) {
            if (sv.getMaSV().equalsIgnoreCase(id)) {
                return sv;
            }
        }
        return null;
    }

    public int updateStudentByID(SinhVien svNew) {
        for (SinhVien sv : ls) {
            if (sv.getMaSV().equalsIgnoreCase(svNew.getMaSV())) {
                sv.setTenSV(svNew.getTenSV());
                sv.setEmail(svNew.getEmail());
                sv.setCCCD(svNew.getCCCD());
                sv.setSDT(svNew.getSDT());
                sv.setGioiTinh(svNew.isGioiTinh());
                sv.setNgaySinh(svNew.getNgaySinh());
                sv.setQueQuan(svNew.getQueQuan());
                sv.setDiaChi(svNew.getDiaChi());
                return 1;
            }
        }
        return -1;
    }
}
