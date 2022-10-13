/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dương Tiến
 */
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    ReadAndWriteGrade readAndWriteGrade = new ReadAndWriteGrade();

    List<Grade> ls = readAndWriteGrade.readGrades("src/data/Diem.txt");

    public int add(Grade g) {
        ls.add(g);
        return 1;
    }



    public List<Grade> getAllGrade() {
        return ls;
    }

    public Grade getOneGradeByMaSV(String masv) {
        for (Grade g : ls) {
            if (g.getSv().getMaSV().equals(masv)) {
                return g;
            }
        }
        return null;
    }

    public int updateByMaSV(Grade gNew) {
        for (Grade g : ls) {
            if (g.getSv().getMaSV().equalsIgnoreCase(gNew.getSv().getMaSV())) {
                g.setAnhVan(gNew.getAnhVan());
                g.setTinHoc(gNew.getTinHoc());
                g.setGDTC(gNew.getTinHoc());
                return 1;
            }
        }
        return -1;
    }

    public int delGrade(String masv) {
        Grade g = getOneGradeByMaSV(masv);
        if (g != null) {
            ls.remove(g);
            return 1;
        }
        return -1;
    }

    public Grade getAtPosition(int pos) {
        return ls.get(pos);
    }
}
