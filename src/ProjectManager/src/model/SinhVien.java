/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class SinhVien {

    private String maSV, tenSV, Email, SDT, CCCD;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
    }

    public SinhVien(
            String maSV,
            String tenSV,
            String email,
            String sDT,
            String cCCD,
            boolean gioiTinh,
            Date ngaySinh,
            String queQuan,
            String diaChi
    ) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        Email = email;
        SDT = sDT;
        CCCD = cCCD;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getEmail() {
        return Email;
    }

    public String getSDT() {
        return SDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public void setCCCD(String cCCD) {
        CCCD = cCCD;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
