/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectManager.src.model;

/**
 *
 * @author Dương Tiến
 */
public class Grade {

    private int id;
    private SinhVien sv;
    private double anhVan, tinHoc, GDTC;

    public Grade() {
    }

    public Grade(int id, SinhVien sv, double anhVan, double tinHoc, double gDTC) {
        this.id = id;
        this.sv = sv;
        this.anhVan = anhVan;
        this.tinHoc = tinHoc;
        GDTC = gDTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public double getAnhVan() {
        return anhVan;
    }

    public void setAnhVan(double anhVan) {
        this.anhVan = anhVan;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double gDTC) {
        GDTC = gDTC;
    }

    public double getTBC() {
        return (getAnhVan() + getGDTC() + getTinHoc()) / 3;
    }

    public String getXepLoai() {
        String xl = "";
        if (getTBC() > 8.0) {
            xl = "Giỏi";
        } else if (getTBC() >= 7.0) {
            xl = "Khá";
        } else if (getTBC() >= 5.0) {
            xl = "Trung Bình";
        } else {
            xl = "Yếu";
        }
        return xl;
    }
}
